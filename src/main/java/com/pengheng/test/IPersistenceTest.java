package com.pengheng.test;

import com.pengheng.IUserDao;
import com.pengheng.io.Resource;
import com.pengheng.pojo.User;
import com.pengheng.sqlSession.SqlSession;
import com.pengheng.sqlSession.SqlSessionFactory;
import com.pengheng.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;
import org.junit.Before;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;

/**
 * @project IPersistence_test
 * @remark
 * @Author Administrator
 * @date 2020/10/24
 */
public class IPersistenceTest {
    SqlSession sqlSession = null;

    @Before
    public void init() throws PropertyVetoException, DocumentException {
        InputStream resourceAsStream = Resource.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().builder(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void selectAll() throws Exception {
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        for (User user1 : userDao.findAll()) {
            System.out.println(user1.toString());
        }
    }

    @Test
    public void insert(){
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setId(100);
        user.setUsername("刘德华");
        int i = mapper.insertUser(user);
        assert i == 1;
    }

    @Test
    public void delete(){
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        int i = mapper.deleteById(new User(100));
        assert i == 1;
    }

    @Test
    public void update(){
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setId(1);
        user.setUsername("张国荣1");
        int i = mapper.updateUser(user);
        assert i == 1;
    }
}
