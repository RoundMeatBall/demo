import com.seauf.proxy.MyInvocationHandler;
import com.seauf.user.interfs.UserService;
import com.seauf.user.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Mr.lynn
 * @create: 2018-12-30 16:52
 **/
public class ExampleTest<T> extends BaseTest{

    @Autowired
    private MyInvocationHandler myInvocationHandler;

    //动态代理
    @Test
    public void jdkProxy(){
//        myInvocationHandler.setTarget(new UserServiceImpl());
        UserService userService = myInvocationHandler.getProxyObject();
        System.out.println(userService.getUserInfo());
//        proxy.getUserInfo();
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



}
