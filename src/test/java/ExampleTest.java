import com.seauf.proxy.MyInvocationHandler;
import com.seauf.user.dao.UserMapper;
import com.seauf.user.interfs.StudentService;
import com.seauf.user.interfs.UserService;
import com.seauf.util.LogAdvice;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Mr.lynn
 * @create: 2018-12-30 16:52
 **/
public class ExampleTest<T> extends BaseTest{

    @Autowired
    private MyInvocationHandler myInvocationHandler;
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private LogAdvice logAdvice;
//    @Autowired
//    private UserMapper userMapper;

    //动态代理
    @Test
    public void jdkProxy(){
        ApplicationContext applicationContex = new ClassPathXmlApplicationContext("spring-beans.xml");
        System.out.println(applicationContex.getBean("myInvocationHandler"));
        UserService proxy = myInvocationHandler.getProxyObject(userService);
        proxy.getUserInfo();
        System.out.println("----------"+studentService.getStudentInfo());
        System.out.println("----------"+applicationContex.getBean("studentServiceImpl"));
    }

    @Test
    public void testLogAdvice(){
        UserService proxy = logAdvice.getProxyInstance(userService);
        System.out.println(proxy.getClass());
        proxy.getUserInfo();
    }

    @Test
    public void testGetlist(){
        List<String> array = new ArrayList<>();
        array.add("test");
        array.add("doub");
        String str = getList(array);
        System.out.println(str);
        ExampleTest<String> test = new ExampleTest<>();
        String str1 = test.getList1(array);
        System.out.println(str1);
    }

    private <T> T getList(List<T> list){
        return list.get(0);
    }

    private  T getList1(List<T> list){
        return list.get(0);
    }

    @Test
    public void testGetUserInfo(){
        userService.getUserInfo();
    }

    @Test
    public void testCreateUser(){
        userService.createUser();
    }

    @Test
    public void testSqlSession(){
        ApplicationContext applicationContex = new ClassPathXmlApplicationContext("spring-beans.xml","data-source.xml");
        System.out.println(applicationContex.getBean("userMapper"));
//        userService.createUser();
        //读取mybatis-config.xml文件
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("data-source.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //初始化mybatis,创建SqlSessionFactory类的实例
        SqlSessionFactory sqlSessionFactory =  new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建session实例
        SqlSession session = sqlSessionFactory.openSession();
        session.getMapper(UserMapper.class).getUser();
    }



}
