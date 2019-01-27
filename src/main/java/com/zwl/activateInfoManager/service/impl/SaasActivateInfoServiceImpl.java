package com.zwl.activateInfoManager.service.impl;

import com.zwl.activateInfoManager.dao.SaasActivateInfoMapper;
import com.zwl.activateInfoManager.domain.SaasActivateInfoDO;
import com.zwl.activateInfoManager.service.SaasActivateInfoService;
import com.zwl.common.config.PayNotifyProperties;
import com.zwl.common.service.MsgSenderService;
import com.zwl.common.utils.*;
import com.zwl.offlineActivityManager.service.OfflineActivityThemeService;
import com.zwl.system.service.UserService;
import com.zwl.user.vo.ActivateInfoVo;
import com.zwl.user.vo.ActivateInfoVvo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class SaasActivateInfoServiceImpl implements SaasActivateInfoService {
    @Autowired
    private SaasActivateInfoMapper saasActivateInfoMapper;
    @Autowired
    private PayNotifyProperties payNotifyProperties;
    @Autowired
    private MsgSenderService msgSenderService;
    @Autowired
    private OfflineActivityThemeService offlineActivityThemeService;
    @Autowired
    UserService userService;

    @Override
    public SaasActivateInfoDO get(Integer id) {
        return saasActivateInfoMapper.get(id);
    }

    @Override
    public List<SaasActivateInfoDO> list(Map<String, Object> map) {
        return saasActivateInfoMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return saasActivateInfoMapper.count(map);
    }

    @Override
    public int save(SaasActivateInfoDO saasActivateInfo) {
        return saasActivateInfoMapper.save(saasActivateInfo);
    }

    @Override
    public int update(SaasActivateInfoDO saasActivateInfo) {
        return saasActivateInfoMapper.update(saasActivateInfo);
    }

    @Override
    public int remove(Integer id) {
        return saasActivateInfoMapper.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return saasActivateInfoMapper.batchRemove(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R insertExcelToDB(MultipartFile file){
        try {
            List<ArrayList<String>> list = new ExcelRead().readExcel(file);
            //list中存的就是excel中的数据，可以根据excel中每一列的值转换成你所需要的值（从0开始）
            ActivateInfoVo activateInfoVo = new ActivateInfoVo();
            List<ActivateInfoVo> liseStudent = new ArrayList<ActivateInfoVo>();
            if(null == liseStudent){
                return R.error(0, "表格为空！");
            }
            for (ArrayList<String> arr : list) {
                //按照表格的规则循环添加
                //fixme 目前导入没有做防重，看以后业务需求而定
                String activityCode = UUIDUtil.getUUID32();
                String qrCodeUrl = QRCodeUtil.createQrCode(payNotifyProperties.getQrCodeUrl() + activityCode, null, null);
                //          发送短信:短链接
                String shortUrl = ShortUrlUtil.generateShortUrl(qrCodeUrl);
//                msgSenderService.sendMsg(arr.get(2), shortUrl);
                //发送短信 shortUrl
                if (arr.get(0) != null && !arr.get(0).equals("")) {
                    activateInfoVo = new ActivateInfoVo();
                    activateInfoVo.setIsUsed(0);
                    activateInfoVo.setMerchantId("1365616402");
                    activateInfoVo.setRealName(arr.get(0));
                    activateInfoVo.setPhone(arr.get(1));
                    String phone = arr.get(3);
                    if (phone != null && phone.trim().length()>0) {
                        String userId = userService.getUserIdByPhone(phone.trim());
                        if(null != userId){
                            activateInfoVo.setReferrer(userId);
                        }
                    }
                    activateInfoVo.setReferrerName(arr.get(2));
                    activateInfoVo.setReferrerPhone(arr.get(3));
                    String themeName = arr.get(4);
                    activateInfoVo.setIdCardNum(arr.get(5));
                    ActivateInfoVvo activateInfoVvo = offlineActivityThemeService.getThemeIdThemePriceAndActivityIdByThemeName(themeName);
                    if(null == activateInfoVvo){
                        return R.error(0, "请检查课程名称是否正确！");
                    }
                    activateInfoVo.setThemeId(activateInfoVvo.getThemeId());
                    activateInfoVo.setActivityId(activateInfoVvo.getActivityId());
                    activateInfoVo.setThemePrice(activateInfoVvo.getThemePrice());
                    activateInfoVo.setThemeName(themeName);
                    activateInfoVo.setCreateTime(new Date());
                    activateInfoVo.setQrCodeUrl(shortUrl);
                    activateInfoVo.setActivityCode(activityCode);
                    liseStudent.add(activateInfoVo);
                }
            }
            int i = saasActivateInfoMapper.insertStudentList(liseStudent);
            if (i > 0) {
                return R.ok("导入成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(0, "请查看Excel格式是否正确！");
        }
        return R.ok();
    }

    @Override
    public int updateSendMsg(Integer id, Integer code, String remark) {
        return saasActivateInfoMapper.updateSendMsg(id, code, remark);
    }


}
