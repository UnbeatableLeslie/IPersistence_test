package com.pengheng.test;

import com.pengheng.IUserDao;
import com.pengheng.io.Resource;
import com.pengheng.pojo.User;
import com.pengheng.sqlSession.SqlSession;
import com.pengheng.sqlSession.SqlSessionFactory;
import com.pengheng.sqlSession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @project IPersistence_test
 * @remark
 * @Author Administrator
 * @date 2020/10/24
 */
public class IPersistenceTest {

    @Test
    public void test() throws Exception {

        InputStream resourceAsStream = Resource.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().builder(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
//        User user1 = sqlSession.selectOne("user.selectOne", user);
//        System.out.println(user1.toString());

//        List<User> list = sqlSession.selectList("user.selectList", user);
//        for (User user1 : list) {
//            System.out.println(user1.toString());
//        }
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        for (User user1 : userDao.findAll()) {
            System.out.println(user1.toString());
        }
    }
}
