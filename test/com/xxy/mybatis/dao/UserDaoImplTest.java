package com.xxy.mybatis.dao;

import com.xxy.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author xxy
 * @Date 2020/3/8 10:28
 * @Description:
 * @Version 1.0
 */
public class UserDaoImplTest {
    private SqlSessionFactory sqlSessionFactory ;
    @Before
    public void setUp() throws Exception{
        //mybatis配置文件
        String resource = "SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂,传入mybatis配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void testFindUserById() throws Exception{
        //创建UseDao对象
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        //实现UseDao方法
        User user = userDao.findUserById(1);
        System.out.println(user);
    }
}
