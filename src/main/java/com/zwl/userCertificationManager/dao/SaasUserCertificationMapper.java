package com.zwl.userCertificationManager.dao;

import com.zwl.userCertificationManager.domain.SaasUserCertificationDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-10-19 11:26:46
 */
@Mapper
public interface SaasUserCertificationMapper {

    @Select("select `id`, `real_name`, `id_card_num`, `user_id`, `merchant_id`, `sex`, `city`, `profession`, `create_time`, `modify_time`, `available` from saas_user_certification where id = #{id}")
    SaasUserCertificationDO get(Long id);

    @Select("<script>" +
            "select * from saas_user_certification " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"realName != null and realName != ''\">" + "and real_name = #{realName} " + "</if>" +
            "<if test=\"idCardNum != null and idCardNum != ''\">" + "and id_card_num = #{idCardNum} " + "</if>" +
            "<if test=\"phone != null and phone != ''\">" + "and phone = #{phone} " + "</if>" +
            "<if test=\"userId != null and userId != ''\">" + "and user_id = #{userId} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"sex != null and sex != ''\">" + "and sex = #{sex} " + "</if>" +
            "<if test=\"city != null and city != ''\">" + "and city = #{city} " + "</if>" +
            "<if test=\"profession != null and profession != ''\">" + "and profession = #{profession} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "<if test=\"minTime != null and minTime != ''\">" + "and  <![CDATA[ register_time>= #{minTime} ]]>" + "</if>" +
            "<if test=\"maxTime != null and maxTime != ''\">" + "and  <![CDATA[ register_time<= #{maxTime} ]]>" + "</if>" +
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
    List<SaasUserCertificationDO> list(Map<String, Object> map);

    @Select("<script>" +
            "select count(*) from saas_user_certification " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"realName != null and realName != ''\">" + "and real_name = #{realName} " + "</if>" +
            "<if test=\"idCardNum != null and idCardNum != ''\">" + "and id_card_num = #{idCardNum} " + "</if>" +
            "<if test=\"phone != null and phone != ''\">" + "and phone = #{phone} " + "</if>" +
            "<if test=\"userId != null and userId != ''\">" + "and user_id = #{userId} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"sex != null and sex != ''\">" + "and sex = #{sex} " + "</if>" +
            "<if test=\"city != null and city != ''\">" + "and city = #{city} " + "</if>" +
            "<if test=\"profession != null and profession != ''\">" + "and profession = #{profession} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "</where>" +
            "</script>")
    int count(Map<String, Object> map);

    @Insert("insert into saas_user_certification (`real_name`, `id_card_num`, `phone`, `user_id`, `merchant_id`, `sex`, `city`, `profession`, `create_time`, `modify_time`, `available`)"
            + "values (#{realName}, #{idCardNum}, #{phone}, #{userId}, #{merchantId}, #{sex}, #{city}, #{profession}, #{createTime}, #{modifyTime}, #{available})")
    int save(SaasUserCertificationDO saasUserCertification);

    @Update("<script>" +
            "update saas_user_certification " +
            "<set>" +
            "<if test=\"id != null\">`id` = #{id}, </if>" +
            "<if test=\"realName != null\">`real_name` = #{realName}, </if>" +
            "<if test=\"idCardNum != null\">`id_card_num` = #{idCardNum}, </if>" +
            "<if test=\"phone != null\">`phone` = #{phone}, </if>" +
            "<if test=\"userId != null\">`user_id` = #{userId}, </if>" +
            "<if test=\"merchantId != null\">`merchant_id` = #{merchantId}, </if>" +
            "<if test=\"sex != null\">`sex` = #{sex}, </if>" +
            "<if test=\"city != null\">`city` = #{city}, </if>" +
            "<if test=\"profession != null\">`profession` = #{profession}, </if>" +
            "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" +
            "<if test=\"modifyTime != null\">`modify_time` = #{modifyTime}, </if>" +
            "<if test=\"available != null\">`available` = #{available}, </if>" +
            "</set>" +
            "where id = #{id}" +
            "</script>")
    int update(SaasUserCertificationDO saasUserCertification);

    @Delete("delete from saas_user_certification where id =#{id}")
    int remove(Long id);

    @Delete("<script>" +
            "delete from saas_user_certification where id in " +
            "<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    int batchRemove(Long[] ids);
}
