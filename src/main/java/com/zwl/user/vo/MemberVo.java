package com.zwl.user.vo;

import lombok.Data;

import java.util.List;

/**
 * 用户查询传参
 *
 * @author houyuhui
 */
@Data
public class MemberVo {
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 商户号
     */
    private String merchantId;
    /**
     * 每页显示几条
     */
    private Integer limit;
    /**
     * 显示的数量前面的条数 (offset/limit)+1 来计算第几页
     */
    private Integer offset;
    /**
     * 查询的用户类型
     */
    private List<Integer> memberType;
    /**
     * 这是姓名
     */
    private String realName;
    /**
     * 业务员标识
     */
    private String referrerId;
    /**
     * 排序字段名
     */
    private String sortName;
    /**
     * 排序方式
     */
    private String sortOrder;
}
