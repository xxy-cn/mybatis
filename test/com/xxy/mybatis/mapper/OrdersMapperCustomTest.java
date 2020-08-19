package com.xxy.mybatis.mapper;

import com.xxy.mybatis.po.Orders;
import com.xxy.mybatis.po.OrdersCustom;
import com.xxy.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author xxy
 * @Date 2020/3/11 21:06
 * @Description:
 * @Version 1.0
 */
public class OrdersMapperCustomTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception {
        //mybatis配置文件
        String resource = "SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂,传入mybatis配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

//    @Test
//    public void findOrdersUser() throws Exception {
//        //从工厂当中取出session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建OrdersMapperCustom对象
//        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
//        List<OrdersCustom> list = ordersMapperCustom.findOrdersUser();
//        System.out.println(list);
//        sqlSession.close();
//    }
//    @Test
//    public void findOrdersUserResultMap() throws Exception {
//        //从工厂当中取出session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建OrdersMapperCustom对象
//        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
//        List<Orders> list = ordersMapperCustom.findOrdersUserResultMap();
//        System.out.println(list);
//        sqlSession.close();
//    }
//    @Test
//    public void testfindOrdersAndOrderDetailResultMap() throws Exception {
//        //从工厂当中取出session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建OrdersMapperCustom对象
//        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
//        List<Orders> list = ordersMapperCustom.findOrdersAndOrderDetailResultMap();
//        System.out.println(list);
//        sqlSession.close();
//    }
//    @Test
//    public void testFindUserAndItemsResultMap() throws Exception {
//        //从工厂当中取出session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建OrdersMapperCustom对象
//        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
//        List<User> list = ordersMapperCustom.findUserAndItemsResultMap();
//        System.out.println(list);
//        sqlSession.close();
//    }
    //查询订单关联查询用户信息，使用延迟加载
//    @Test
//    public void testfindOrdersUserLazyLoading()throws Exception{
//        //从工厂当中取出session
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建OrdersMapperCustom对象
//        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
//       //查询订单信息(单表)
//        List<Orders> list = ordersMapperCustom.findOrdersUserLazyLoading();
//        //遍历上边的订单列表
//        for(Orders orders: list){
//            //执行getUser()去查询用户信息，这里实现延迟加载
//            User user = orders.getUser();
//            System.out.println(user);
//        }
//        }
    //一级缓存测试
//    @Test
//    public void testCache1()throws Exception{
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        //下边查询使用第一个SqlSession
//        //第一次发起请求，查询id为1的用户
//        User user1 = userMapper.findUserById(1);
//        System.out.println(user1);
//        //更新user1信息
//        user1.setUsername("夏新勇1");
//        userMapper.updateUser(user1);
//        //执行commit操作
//        sqlSession.commit();
//        //第二次发起请求，查询id为1的用户
//        User user2 = userMapper.findUserById(1);
//        System.out.println(user2);
//        sqlSession.close();
//    }
    //二级缓存测试
    @Test
    public void testCache2()throws Exception{
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
        //第一次发起请求，查询id为1的用户
        User user1 = userMapper1.findUserById(1);
        System.out.println(user1);
        //执行关闭操作才能将sqlSession的数据写到二级缓存区域
        sqlSession1.close();
        //使用sqlSession3执行commit()操作
        User user = userMapper3.findUserById(1);
        user.setUsername("夏新勇1");
        userMapper3.updateUser(user);
        //执行提交，清空UserMapper下边的二级缓存
        sqlSession3.commit();
        sqlSession3.close();
        //第二次发起请求，查询id为1的用户
        User user2 = userMapper2.findUserById(1);
        System.out.println(user2);
        sqlSession2.close();
    }
}