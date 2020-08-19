package com.xxy.mybatis.first;

import com.xxy.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author xxy
 * @Date 2020/3/5 9:43
 * @Descriptio: 入门程序
 * @Version 1.0
 */
public class MybatisFirst {
    /**
     * 根据id查询用户信息，得到一条记录信息
     */
//    @Test
//    public void findUserByIdTest() throws IOException {
//        //mybatis配置文件
//        String resource = "SqlMapConfig.xml";
//        //得到配置文件流
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        //创建会话工厂,传入mybatis配置文件信息
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        //通过工厂得到SqlSession
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //通过SqlSession操作数据库
//        //第一个参数：映射文件中statement的id，等于namespace+statement的id
//        //第二个参数：指定和映射文件中所匹配的parameterType类型的参数
//        //sqlSession.selectOne结果是与映射文件中所匹配的resultType类型的对象
//        //selectOne表示查询出一条记录
//        User user = sqlSession.selectOne("test.findUserById",1);
//        System.out.println(user);
//        //释放资源
//        sqlSession.close();
//    }
    //根据用户名称模糊查找用户列表
//    @Test
//    public void findUserByNameTest() throws IOException {
//        //mybatis配置文件
//        String resource = "SqlMapConfig.xml";
//        //得到配置文件流
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        //创建会话工厂,传入mybatis配置文件信息
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        //通过工厂得到SqlSession
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //list中的user和映射文件中resultType所指定的类型一致
//        List<User> list = sqlSession.selectList("test.findUserByName","夏新");
//        System.out.println(list);
//        sqlSession.close();
//    }
    //添加用户信息
//
    //根据id删除用户信息
//    @Test
//    public void deleteUserTest() throws IOException {
//        //mybatis配置文件
//        String resource = "SqlMapConfig.xml";
//        //得到配置文件流
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        //创建会话工厂,传入mybatis配置文件信息
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        //通过工厂得到SqlSession
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //list中的user和映射文件中resultType所指定的类型一致
//        sqlSession.delete("test.deleteUser",7);
//        //提交事务
//        sqlSession.commit();
//        //关闭会话
//        sqlSession.close();
//    }
    @Test
    public void updateUserTest() throws IOException {
        //mybatis配置文件
        String resource = "SqlMapConfig.xml";
        //得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建会话工厂,传入mybatis配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //插入用户对象
        User user = new User();
        //必须设置id
        user.setId(6);
        user.setUsername("刘佳欣");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("河南信阳");
        //list中的user和映射文件中resultType所指定的类型一致
        sqlSession.update("test.updateUser",user);
        //提交事务
        sqlSession.commit();
        //关闭会话
        sqlSession.close();
    }
}
