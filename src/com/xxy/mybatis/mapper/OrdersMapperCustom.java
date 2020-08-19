package com.xxy.mybatis.mapper;

import com.xxy.mybatis.po.Orders;
import com.xxy.mybatis.po.OrdersCustom;
import com.xxy.mybatis.po.User;

import java.util.List;

/**
 * @author xxy
 * @Date 2020/3/11 20:57
 * @Description: 订单mapper
 * @Version 1.0
 */
public interface OrdersMapperCustom {
    //查询订单关联查询用户信息
    public List<OrdersCustom> findOrdersUser()throws Exception;
    //查询订单关联查询用户使用resultMap
    public List<Orders> findOrdersUserResultMap()throws Exception;
    //查询订单及订单明细
    public List<Orders> findOrdersAndOrderDetailResultMap()throws Exception;
    //查询用户购买的商品信息
    public List<User> findUserAndItemsResultMap()throws Exception;
    //查询订单关联查询用户，用户信息一个延迟加载
    public List<Orders> findOrdersUserLazyLoading()throws Exception;
}
