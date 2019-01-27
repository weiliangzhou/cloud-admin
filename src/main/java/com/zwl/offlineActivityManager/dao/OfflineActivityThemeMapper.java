package com.zwl.offlineActivityManager.dao;

import com.zwl.offlineActivityManager.domain.OfflineActivityThemeDO;
import com.zwl.offlineActivityManager.domain.OfflineActivityThemeItemVo;
import com.zwl.user.vo.ActivateInfoVvo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface OfflineActivityThemeMapper {
    @Select("select `id`, `theme_name`, `theme_href_url`, `theme_type`, `content`, `content_text`, `buy_count`, `is_recommend`, `is_show`, `img_url`, `activity_time`, `create_time`, `modify_time`, `available`, `merchant_id`, `qr_bg_img`, `price`, `limit_count`, `real_name_show`, `phone_show`, `id_card_num_show`, `address_show`, `pp_show`, `zy_show` from saas_offline_activity_theme where id = #{id}")
    OfflineActivityThemeDO get(Integer id);

    @Select("<script>" +
            "select * from saas_offline_activity_theme " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"themeName != null and themeName != ''\">" + "and theme_name = #{themeName} " + "</if>" +
            "<if test=\"themeHrefUrl != null and themeHrefUrl != ''\">" + "and theme_href_url = #{themeHrefUrl} " + "</if>" +
            "<if test=\"themeType != null and themeType != ''\">" + "and theme_type = #{themeType} " + "</if>" +
            "<if test=\"content != null and content != ''\">" + "and content = #{content} " + "</if>" +
            "<if test=\"contentText != null and contentText != ''\">" + "and content_text = #{contentText} " + "</if>" +
            "<if test=\"buyCount != null and buyCount != ''\">" + "and buy_count = #{buyCount} " + "</if>" +
            "<if test=\"isRecommend != null and isRecommend != ''\">" + "and is_recommend = #{isRecommend} " + "</if>" +
            "<if test=\"isShow != null and isShow != ''\">" + "and is_show = #{isShow} " + "</if>" +
            "<if test=\"imgUrl != null and imgUrl != ''\">" + "and img_url = #{imgUrl} " + "</if>" +
            "<if test=\"activityTime != null and activityTime != ''\">" + "and activity_time = #{activityTime} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"qrBgImg != null and qrBgImg != ''\">" + "and qr_bg_img = #{qrBgImg} " + "</if>" +
            "<if test=\"price != null and price != ''\">" + "and price = #{price} " + "</if>" +
            "<if test=\"limitCount != null and limitCount != ''\">" + "and limit_count = #{limitCount} " + "</if>" +
            "<if test=\"realNameShow != null and realNameShow != ''\">" + "and real_name_show = #{realNameShow} " + "</if>" +
            "<if test=\"phoneShow != null and phoneShow != ''\">" + "and phone_show = #{phoneShow} " + "</if>" +
            "<if test=\"idCardNumShow != null and idCardNumShow != ''\">" + "and id_card_num_show = #{idCardNumShow} " + "</if>" +
            "<if test=\"addressShow != null and addressShow != ''\">" + "and address_show = #{addressShow} " + "</if>" +
            "<if test=\"ppShow != null and ppShow != ''\">" + "and pp_show = #{ppShow} " + "</if>" +
            "<if test=\"zyShow != null and zyShow != ''\">" + "and zy_show = #{zyShow} " + "</if>" +
            "</where>" +
            " <choose>" +
            "<when test=\"sort != null and sort.trim() != ''\">" +
            "order by ${sort} ${order}" +
            "</when>" +
            "<otherwise>" +
            "order by id desc" +
            "</otherwise>" +
            "</choose>" +
            "<if test=\"offset != null and limit != null\">" +
            "limit #{offset}, #{limit}" +
            "</if>" +
            "</script>")
    List<OfflineActivityThemeDO> list(Map<String, Object> map);

    @Select("<script>" +
            "select count(*) from saas_offline_activity_theme " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"themeName != null and themeName != ''\">" + "and theme_name = #{themeName} " + "</if>" +
            "<if test=\"themeHrefUrl != null and themeHrefUrl != ''\">" + "and theme_href_url = #{themeHrefUrl} " + "</if>" +
            "<if test=\"themeType != null and themeType != ''\">" + "and theme_type = #{themeType} " + "</if>" +
            "<if test=\"content != null and content != ''\">" + "and content = #{content} " + "</if>" +
            "<if test=\"contentText != null and contentText != ''\">" + "and content_text = #{contentText} " + "</if>" +
            "<if test=\"buyCount != null and buyCount != ''\">" + "and buy_count = #{buyCount} " + "</if>" +
            "<if test=\"isRecommend != null and isRecommend != ''\">" + "and is_recommend = #{isRecommend} " + "</if>" +
            "<if test=\"isShow != null and isShow != ''\">" + "and is_show = #{isShow} " + "</if>" +
            "<if test=\"imgUrl != null and imgUrl != ''\">" + "and img_url = #{imgUrl} " + "</if>" +
            "<if test=\"activityTime != null and activityTime != ''\">" + "and activity_time = #{activityTime} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"qrBgImg != null and qrBgImg != ''\">" + "and qr_bg_img = #{qrBgImg} " + "</if>" +
            "<if test=\"price != null and price != ''\">" + "and price = #{price} " + "</if>" +
            "<if test=\"limitCount != null and limitCount != ''\">" + "and limit_count = #{limitCount} " + "</if>" +
            "<if test=\"realNameShow != null and realNameShow != ''\">" + "and real_name_show = #{realNameShow} " + "</if>" +
            "<if test=\"phoneShow != null and phoneShow != ''\">" + "and phone_show = #{phoneShow} " + "</if>" +
            "<if test=\"idCardNumShow != null and idCardNumShow != ''\">" + "and id_card_num_show = #{idCardNumShow} " + "</if>" +
            "<if test=\"addressShow != null and addressShow != ''\">" + "and address_show = #{addressShow} " + "</if>" +
            "<if test=\"ppShow != null and ppShow != ''\">" + "and pp_show = #{ppShow} " + "</if>" +
            "<if test=\"zyShow != null and zyShow != ''\">" + "and zy_show = #{zyShow} " + "</if>" +
            "</where>" +
            "</script>")
    int count(Map<String, Object> map);

    @Insert("insert into saas_offline_activity_theme (`theme_name`, `theme_href_url`, `theme_type`, `content`, `content_text`, `buy_count`, `is_recommend`, `is_show`, `img_url`, `activity_time`, `create_time`, `modify_time`, `available`, `merchant_id`, `qr_bg_img`, `price`, `limit_count`, `real_name_show`, `phone_show`, `id_card_num_show`, `address_show`, `pp_show`, `zy_show`)"
            + "values (#{themeName}, #{themeHrefUrl}, #{themeType}, #{content}, #{contentText}, #{buyCount}, #{isRecommend}, #{isShow}, #{imgUrl}, #{activityTime}, #{createTime}, #{modifyTime}, #{available}, #{merchantId}, #{qrBgImg}, #{price}, #{limitCount}, #{realNameShow}, #{phoneShow}, #{idCardNumShow}, #{addressShow}, #{ppShow}, #{zyShow})")
    int save(OfflineActivityThemeDO saasOfflineActivityTheme);

    @Update("<script>" +
            "update saas_offline_activity_theme " +
            "<set>" +
            "<if test=\"themeName != null\">`theme_name` = #{themeName}, </if>" +
            "<if test=\"themeHrefUrl != null\">`theme_href_url` = #{themeHrefUrl}, </if>" +
            "<if test=\"themeType != null\">`theme_type` = #{themeType}, </if>" +
            "<if test=\"content != null\">`content` = #{content}, </if>" +
            "<if test=\"contentText != null\">`content_text` = #{contentText}, </if>" +
            "<if test=\"limitCount != null\">`limit_count` = #{limitCount}, </if>" +
            "<if test=\"price != null\">`price` = #{price}, </if>" +
            "<if test=\"buyCount != null\">`buy_count` = #{buyCount}, </if>" +
            "<if test=\"isRecommend != null\">`is_recommend` = #{isRecommend}, </if>" +
            "<if test=\"isShow != null\">`is_show` = #{isShow}, </if>" +
            "<if test=\"imgUrl != null\">`img_url` = #{imgUrl}, </if>" +
            "<if test=\"activityTime != null\">`activity_time` = #{activityTime}, </if>" +
            "<if test=\"qrBgImg != null\">`qr_bg_img` = #{qrBgImg}, </if>" +
            "<if test=\"realNameShow != null\">`real_name_show` = #{realNameShow}, </if>" +
            "<if test=\"phoneShow != null\">`phone_show` = #{phoneShow}, </if>" +
            "<if test=\"idCardNumShow != null\">`id_card_num_show` = #{idCardNumShow}, </if>" +
            "<if test=\"addressShow != null\">`address_show` = #{addressShow}, </if>" +
            "<if test=\"ppShow != null\">`pp_show` = #{ppShow}, </if>" +
            "<if test=\"zyShow != null\">`zy_show` = #{zyShow}, </if>" +
            "</set>" +
            "where id = #{id}" +
            "</script>")
    int update(OfflineActivityThemeDO saasOfflineActivityTheme);

    @Update("update saas_offline_activity_theme set available = 0 where id =#{id}")
    int remove(Integer id);

    @Update("<script>" +
            "update saas_offline_activity_theme set available = 0 where id in " +
            "<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    int batchRemove(Integer[] ids);

    @Select("select id,theme_name from saas_offline_activity_theme where available = 1 and merchant_id = #{merchantId}")
    List<OfflineActivityThemeItemVo> getActivityThemeItemsList(@Param("merchantId") String merchantId);

    @Select("select t.id as themeId,t.price as themePrice,a.id as activityId from saas_offline_activity_theme t join  saas_offline_activity a on t.id = a.activity_theme_id where t.theme_name =#{themeName,} limit 0,1")
    ActivateInfoVvo getThemeIdThemePriceAndActivityIdByThemeName(String themeName);
}
