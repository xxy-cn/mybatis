package com.xxy.mybatis.po;

import java.util.List;

/**
 * @author xxy
 * @Date 2020/3/10 8:37
 * @Description:包装类型
 * @Version 1.0
 */
public class UserQueryVo {
    //传入多个id
    private List<Integer> ids;
    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
    //在这里包装所需要的查询条件

    //用户查询条件
    private UserCustom userCustom;
    public UserCustom getUserCustom() {
        return userCustom;
    }
    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    //可以包装其他查询条件
}
