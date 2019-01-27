import java.util.*;
import java.util.concurrent.Callable;

/**
 * @author: Mr.lynn
 * @create: 2018-12-28 20:43
 **/
public class Main implements Callable<Integer> {
    public static void main(String[] args) {

        Timer timer = new Timer();
        //TimerTask是一个抽象类，实现的是runnable接口
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行线程任务......");
            }
        }, 0, 1000);
    }

    @Override
    public Integer call() throws Exception {
        return null;
    }
}
