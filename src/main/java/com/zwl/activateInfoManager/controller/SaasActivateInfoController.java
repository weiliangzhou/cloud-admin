package com.zwl.activateInfoManager.controller;

import com.zwl.activateInfoManager.domain.SaasActivateInfoDO;
import com.zwl.activateInfoManager.service.SaasActivateInfoService;
import com.zwl.common.config.PayNotifyProperties;
import com.zwl.common.service.MsgSenderService;
import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.Query;
import com.zwl.common.utils.R;
import com.zwl.common.utils.ShiroUtils;
import com.zwl.offlineActivityManager.domain.OfflineActivityDO;
import com.zwl.offlineActivityManager.service.OfflineActivityService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;


/**
 * 
 * 
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-11-13 18:10:09
 */
@Controller
@RequestMapping("/saasActivateInfo")
public class SaasActivateInfoController {
	@Autowired
	private SaasActivateInfoService saasActivateInfoService;
	@Autowired
	private MsgSenderService msgSenderService;
	@Autowired
	private PayNotifyProperties payNotifyProperties;
    @Autowired
    private OfflineActivityService offlineActivityService;
	
	@GetMapping()
	@RequiresPermissions("saasActivateInfo:saasActivateInfo")
	String SaasActivateInfo(){
	    return "saasActivateInfoManager/saasActivateInfo";
	}
	

	
	@GetMapping("/add")
	//@RequiresPermissions("blog:bComments")
	String add(){
	    return "demo/saasActivateInfo/add";
	}
	@GetMapping("/edit")
	//@RequiresPermissions("blog:bComments")
	String edit(Integer id){
	    return "demo/saasActivateInfo/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("saasActivateInfo:info")
	public R info(@PathVariable("id") Integer id){
		SaasActivateInfoDO saasActivateInfo = saasActivateInfoService.get(id);
		return R.ok().put("saasActivateInfo",saasActivateInfo);
	}
	
	/**
	 * 查询
	 */
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("saasActivateInfo:list")
	public PageUtils list(@RequestParam Map<String, Object> params){

		String merchantId = ShiroUtils.getMerchantId();
		params.put("merchantId","1365616402");
		Query query = new Query(params);
		List<SaasActivateInfoDO> activateInfoDO = saasActivateInfoService.list(query);
		int total = saasActivateInfoService.count(query);
		PageUtils pageUtils = new PageUtils(activateInfoDO, total);
		return pageUtils;
	}
	
	/**
	 * 上传excle
	 */
	@RequestMapping(value = "/uploadExcel")
	@ResponseBody
	public R uploadExcel(@RequestParam MultipartFile file) throws IOException {
		return saasActivateInfoService.insertExcelToDB(file);
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("saasActivateInfo:remove")
	public R remove(Integer id) {
		if (saasActivateInfoService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}


	/**
	 * 批量删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("saasActivateInfo:remove")
	public R remove(@RequestParam("ids[]") Integer[] ids) {
		saasActivateInfoService.batchRemove(ids);
		//同步刷新或者删除对应的rediskey  getClassSetList  getClassSetDetailByClassSetId
		/*RedisUtil.del("getClassSetList");
		RedisUtil.del("getClassSetDetailByClassSetId");*/
		return R.ok();
	}

	/**
	 * 批量发送短信
	 */
	@PostMapping("/batchSendMsg")
	@ResponseBody
	@RequiresPermissions("saasActivateInfo:batchSendMsg")
	public R batchSendMsg(@RequestParam("phones[]") String[] phones,@RequestParam("qrCodeUrls[]") String[] qrCodeUrls,
                          @RequestParam("ids[]")Integer[] ids, @RequestParam("realNames[]")String[] realNames,
                          @RequestParam("activityIds[]")Integer[] activityIds) {

		for(int i= 0;i<ids.length;i++) {
            OfflineActivityDO offlineActivity = offlineActivityService.get(activityIds[i]);
            if(null ==offlineActivity ){
                return R.error("未查询到该活动！活动id:"+activityIds[i]);
            }
            SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
            String date = sdf.format(offlineActivity.getActivityStartTime());
            String msg = realNames[i]+ ":"+ date + "杭州渠道革命,入场验证:"+qrCodeUrls[i]+" 妥善保管,请勿泄露";
			R result = msgSenderService.sendMsg(phones[i], msg);
			String code = result.get((Object) "code").toString();
			if ("0" .equals(code)) {
				saasActivateInfoService.updateSendMsg(ids[i], 2, result.get((Object) "msg").toString());
			} else if ("1".equals(code)) {
				saasActivateInfoService.updateSendMsg(ids[i], 1, result.get((Object) "msg").toString());
			} else {
				saasActivateInfoService.updateSendMsg(ids[i], 0, result.get((Object) "msg").toString());
			}
		}
		return  R.ok();
	}

	/**
	 * 发送短信
	 */
	@PostMapping("/sendMsg")
	@ResponseBody
	@RequiresPermissions("saasActivateInfo:sendMsg")
	public R sendMsg(String phone) {
		String[] params = phone.split(",");
		phone = params[0];
		Integer id = Integer.parseInt(params[1]);
		String realName =params[2];
        Integer activityId = Integer.parseInt(params[3]);
        String qrCodeUrl = params[4];
        OfflineActivityDO offlineActivity = offlineActivityService.get(activityId);
        if(null ==offlineActivity ){
            return R.error("未查询到该活动！");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
		String date = sdf.format(offlineActivity.getActivityStartTime());
		//短信内容
		String msg = realName+ ":"+ date + "杭州渠道革命,入场验证:"+qrCodeUrl+" 妥善保管,请勿泄露";
		R result = msgSenderService.sendMsg(phone,msg);
		String code = result.get((Object)"code").toString();
		if("0".equals(code)){
			saasActivateInfoService.updateSendMsg(id, 2, result.get((Object)"msg").toString());
			return R.ok();
		}else if( "1".equals(code)){
			saasActivateInfoService.updateSendMsg(id, 1, result.get((Object)"msg").toString());
			return R.error(result.get((Object)"msg").toString());
		}else{
			saasActivateInfoService.updateSendMsg(id, 0, result.get((Object)"msg").toString());
			return R.error(result.get((Object)"msg").toString());
		}

	}

}
