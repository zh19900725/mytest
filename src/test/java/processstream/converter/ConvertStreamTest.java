/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package processstream.converter;

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
 * =================================转换流===================================
 * 该类型是字节流和字符流之间的桥梁，该流对象中可以对读取到的字节数据进行指定编码的编码转换。
 * InputStreamReader(InputStream);        //通过构造函数初始化，使用的是本系统默认的编码表GBK。   
 * InputStreamWriter(InputStream,String charSet);   //通过该构造函数初始化，可以指定编码表。   
 * OutputStreamWriter(OutputStream);      //通过该构造函数初始化，使用的是本系统默认的编码表GBK。   
 * OutputStreamwriter(OutputStream,String charSet);   //通过该构造函数初始化，可以指定编码表。 
 * =========================================================================
 * @author zhanghui
 * @version Id: ConvertStreamTest.java, v 0.1 2018/9/26 0026 9:02 zhanghui Exp $$
 */
public class ConvertStreamTest {
    /**
     * 字节流转化为字符流
     */
    @Test
    public void convertByteToString() {
        File file = new File(BaseConstant.filePath);
        try {
            InputStream in = new FileInputStream(file);
            Reader reader = new InputStreamReader(in);
            char[] chars = new char[(int) file.length()];
            int len = reader.read(chars);
            System.out.println(String.valueOf(chars).substring(0, len));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
