/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package processstream.print;

import notestream.BaseConstant;
import org.junit.Test;

import java.io.*;

/**
 * 处理流：该类型是对一个已存在的流的连接和封装，通过所封装的流的功能调用实现数据读写，
 * 处理流的构造方法总是要带一个其他流对象作为参数，一个流对象进过其他流的多次包装，叫做流的链接
 *
 * 1.转换流
 * 2.数据流
 * 3.对象流
 * 4.打印流
 * 5.缓冲流
 *
 * =======================================打印流===============================================
 * PrintStream是一个字符打印流，它的构造函数可以接受四种类型的值：
 * 1.字符串路径。
 * 2.File对象
 * 3.OutputStream 
 * 4.Writer 
 * 对于1、2类型的数据，可以指定编码表，也就是字符集，
 * 对于3、4类型的数据，可以指定自动刷新，当该自动刷新为True时，
 * 只有3个方法可以用：println,printf,format。
 * ===========================================================================================
 * @author zhanghui
 * @version Id: ConvertStreamTest.java, v 0.1 2018/9/26 0026 9:02 zhanghui Exp $$
 */
public class printStreamTest {
    PrintStream printStream;

    {
        try {
            printStream = new PrintStream(new FileOutputStream(BaseConstant.filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 管道流处理结合
     */
    @Test
    public void outFile() {
        try {

            /*******************使用管道流输出********************/
            printStream.println(true);
            printStream.println("zh-test");
            printStream.close();
            /********************格式化输出**********************/
            int age = 28;
            String name = "zhanghui";
            printStream.printf("性名：%s,年龄：%d", name, age);
            printStream.close();
            /************使用outputStream向屏幕输出内容***********/
            OutputStream out = System.out;
            out.write("hello".getBytes());
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印流重定向输出
     */
}
