package com.xxy.mybatis.mapper;

import com.xxy.mybatis.mapper.UserMapper;
import com.xxy.mybatis.po.User;
import com.xxy.mybatis.po.UserCustom;
import com.xxy.mybatis.po.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author xxy
 * @Date 2020/3/9 9:01
 * @Description:
 * @Version 1.0
 */
public class UserMapperTest {
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
//    public void findUserById() throws Exception {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建UserMapper对象
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        //调用UserMapper方法
//        User user = userMapper.findUserById(1);
//        System.out.println(user);
//    }
//    @Test
//    public void findUserByName() throws Exception{
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建UserMapper对象
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        //调用UserMapper方法
//        List<User> list= userMapper.findUserByName("夏新");
//        System.out.println(list);
//    }
    //用户信息的综合查询
    @Test
    public void testFindUserList() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //创建包装对象，设置查询条件
        UserQueryVo userQueryVo  = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        //由于这里使用动态sql，如果不设置某个值，条件是不会拼接在sql中
        //userCustom.setUsername("夏新勇");
        //userCustom.setSex("男");
        //传入多个id
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(6);
        ids.add(7);
        //将ids通过userQueryVo传入到statement中
        userQueryVo.setIds(ids);
        userQueryVo.setUserCustom(userCustom);
        //调用userMapper方法
        List<UserCustom> list = userMapper.findUserList(userQueryVo);
        System.out.println(list);
    }
//    @Test
//    public void testFindUserCount() throws Exception{
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建UserMapper对象
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        //创建包装对象，设置查询条件
//        UserQueryVo userQueryVo  = new UserQueryVo();
//        UserCustom userCustom = new UserCustom();
//        userCustom.setUsername("夏新勇");
//        userCustom.setSex("男");
//        userQueryVo.setUserCustom(userCustom);
//        //调用userMapper方法
//        int count = userMapper.findUserCount(userQueryVo);
//        System.out.println(count);
//    }
//    @Test
//    public void findUserByIdResultMap() throws Exception {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //创建UserMapper对象
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        //调用UserMapper方法
//        User user = userMapper.findUserByIdResultMap(1);
//        System.out.println(user);
//    }
}