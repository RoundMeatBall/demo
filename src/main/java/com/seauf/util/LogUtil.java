package com.seauf.util;

import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Mr.lynn
 * @create: 2018-12-31 16:32
 **/
@Component
public class LogUtil {

    public static void writeLog(String methodName){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd mm:HH:ss");
        System.out.println(sdf.format(new Date()) +"调用了"+methodName+"方法");
    }
}
