import com.seauf.proxy.MyInvocationHandler;
import com.seauf.user.interfs.StudentService;
import com.seauf.user.interfs.UserService;
import com.seauf.util.LogAdvice;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

    //动态代理
    @Test
    public void jdkProxy(){
        ApplicationContext applicationContex = new ClassPathXmlApplicationContext("spring-beans.xml");
        System.out.println(applicationContex.getBean("myInvocationHandler"));
        UserService proxy = myInvocationHandler.getProxyObject(userService);
        proxy.getUserInfo();
        System.out.println("----------"+studentService.getStudentInfo());
        System.out.println("----------"+applicationContex.getBean("studentService"));
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
        userService.throwE();
        System.out.println(userService.getClass());
    }



}
