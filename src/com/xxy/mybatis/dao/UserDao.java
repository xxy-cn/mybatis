package com.xxy.mybatis.dao;

import com.xxy.mybatis.po.User;

/**
 * @author xxy
 * @Date 2020/3/8 10:03
 * @Description: 原始开发dao的方法
 * @Version 1.0
 */
public interface UserDao {
    //根据id查询用户信息
    public User findUserById(int id) throws Exception;
    //添加用户信息
    public void insertUser(User user) throws Exception;
    //删除用户信息
    public void deleteUser(int id) throws Exception;
}
