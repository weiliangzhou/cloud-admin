package com.zwl.activateInfoManager.dao;

import com.zwl.activateInfoManager.domain.SaasActivateInfoDO;
import com.zwl.user.vo.ActivateInfoVo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-11-13 18:10:09
 */
@Mapper
public interface SaasActivateInfoMapper {

	@Select("select `id`, `merchant_id`, `phone`, `real_name`, `theme_id`, `theme_name`, `theme_price`, `referrer`, `referrer_name`, `referrer_phone`, `activity_id`, `is_used`, `create_time` from saas_activate_info where id = #{id}")
	SaasActivateInfoDO get(Integer id);

	@Select("<script>" +
			"select * from saas_activate_info " +
			"<where>" +
			"<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" +
			"<if test=\"merchantId != null and merchantId != ''\">"+ "and merchant_id = #{merchantId} " + "</if>" +
			"<if test=\"phone != null and phone != ''\">"+ "and phone = #{phone} " + "</if>" +
			"<if test=\"realName != null and realName != ''\">"+ "and real_name like concat('%',#{realName} " + "</if>" +
			"<if test=\"themeId != null and themeId != ''\">"+ "and theme_id = #{themeId} " + "</if>" +
			"<if test=\"themeName != null and themeName != ''\">"+ "and theme_name = #{themeName} " + "</if>" +
			"<if test=\"themePrice != null and themePrice != ''\">"+ "and theme_price = #{themePrice} " + "</if>" +
			"<if test=\"referrer != null and referrer != ''\">"+ "and referrer = #{referrer} " + "</if>" +
			"<if test=\"referrerName != null and referrerName != ''\">"+ "and referrer_name = #{referrerName} " + "</if>" +
			"<if test=\"referrerPhone != null and referrerPhone != ''\">"+ "and referrer_phone = #{referrerPhone} " + "</if>" +
			"<if test=\"activityId != null and activityId != ''\">"+ "and activity_id = #{activityId} " + "</if>" +
			"<if test=\"isUsed != null and isUsed != ''\">"+ "and is_used = #{isUsed} " + "</if>" +
			"<if test=\"sendMsg != null and sendMsg != ''\">"+ "and send_msg = #{sendMsg} " + "</if>" +
			"<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" +
			"</where>"+
			" <choose>" +
			"<when test=\"sort != null and sort.trim() != ''\">" +
			"order by ${sort} ${order}" +
			"</when>" +
			"<otherwise>" +
			"order by send_msg,create_time desc" +
			"</otherwise>" +
			"</choose>"+
			"<if test=\"offset != null and limit != null\">"+
			"limit #{offset}, #{limit}" +
			"</if>"+
			"</script>")
	List<SaasActivateInfoDO> list(Map<String,Object> map);

	@Select("<script>" +
			"select count(*) from saas_activate_info " +
			"<where>" +
			"<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" +
			"<if test=\"merchantId != null and merchantId != ''\">"+ "and merchant_id = #{merchantId} " + "</if>" +
			"<if test=\"phone != null and phone != ''\">"+ "and phone = #{phone} " + "</if>" +
			"<if test=\"realName != null and realName != ''\">"+ "and real_name = #{realName} " + "</if>" +
			"<if test=\"themeId != null and themeId != ''\">"+ "and theme_id = #{themeId} " + "</if>" +
			"<if test=\"themeName != null and themeName != ''\">"+ "and theme_name = #{themeName} " + "</if>" +
			"<if test=\"themePrice != null and themePrice != ''\">"+ "and theme_price = #{themePrice} " + "</if>" +
			"<if test=\"referrer != null and referrer != ''\">"+ "and referrer = #{referrer} " + "</if>" +
			"<if test=\"referrerName != null and referrerName != ''\">"+ "and referrer_name = #{referrerName} " + "</if>" +
			"<if test=\"referrerPhone != null and referrerPhone != ''\">"+ "and referrer_phone = #{referrerPhone} " + "</if>" +
			"<if test=\"activityId != null and activityId != ''\">"+ "and activity_id = #{activityId} " + "</if>" +
			"<if test=\"isUsed != null and isUsed != ''\">"+ "and is_used = #{isUsed} " + "</if>" +
			"<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" +
			"</where>"+
			"</script>")
	int count(Map<String,Object> map);

	@Insert("insert into saas_activate_info (`id`, `merchant_id`, `phone`, `real_name`, `theme_id`, `theme_name`, `theme_price`, `referrer`, `referrer_name`, `referrer_phone`, `activity_id`, `is_used`, `create_time`)"
			+ "values (#{id}, #{merchantId}, #{phone}, #{realName}, #{themeId}, #{themeName}, #{themePrice}, #{referrer}, #{referrerName}, #{referrerPhone}, #{activityId}, #{isUsed}, #{createTime})")
	int save(SaasActivateInfoDO saasActivateInfo);

	@Update("<script>"+
			"update saas_activate_info " +
			"<set>" +
			"<if test=\"id != null\">`id` = #{id}, </if>" +
			"<if test=\"merchantId != null\">`merchant_id` = #{merchantId}, </if>" +
			"<if test=\"phone != null\">`phone` = #{phone}, </if>" +
			"<if test=\"realName != null\">`real_name` = #{realName}, </if>" +
			"<if test=\"themeId != null\">`theme_id` = #{themeId}, </if>" +
			"<if test=\"themeName != null\">`theme_name` = #{themeName}, </if>" +
			"<if test=\"themePrice != null\">`theme_price` = #{themePrice}, </if>" +
			"<if test=\"referrer != null\">`referrer` = #{referrer}, </if>" +
			"<if test=\"referrerName != null\">`referrer_name` = #{referrerName}, </if>" +
			"<if test=\"referrerPhone != null\">`referrer_phone` = #{referrerPhone}, </if>" +
			"<if test=\"activityId != null\">`activity_id` = #{activityId}, </if>" +
			"<if test=\"isUsed != null\">`is_used` = #{isUsed}, </if>" +
			"<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" +
			"</set>" +
			"where id = #{id}"+
			"</script>")
	int update(SaasActivateInfoDO saasActivateInfo);

	@Delete("delete from saas_activate_info where id =#{id}")
	int remove(Integer id);

	@Delete("<script>"+
			"delete from saas_activate_info where id in " +
			"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" +
			"#{id}" +
			"</foreach>"+
			"</script>")
	int batchRemove(Integer[] ids);

	int insertStudentList(List<ActivateInfoVo> liseStudent);

	@Delete({"update saas_activate_info set remark =#{remark}, send_msg = #{code} where id = #{id}"})
	int updateSendMsg(@Param("id") Integer id,@Param("code") Integer code,@Param("remark") String remark);
}
