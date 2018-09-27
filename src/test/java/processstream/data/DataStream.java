/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package processstream.data;

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
 * =================================数据流===================================
 *  该数据流可以方便地对一些基本类型数据进行直接的存储和读取，不需要再进一步进行转换，
 *  通常只要操作基本数据类型的数据，就需要通过DataStream进行包装。 
 * =========================================================================
 * @author zhanghui
 * @version Id: ConvertStreamTest.java, v 0.1 2018/9/26 0026 9:02 zhanghui Exp $$
 */
public class DataStream {
    @Test
    public void dataOutputStream(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(BaseConstant.filePath);
            DataOutputStream out = new DataOutputStream(fileOutputStream);
            out.writeUTF("i love you");
            out.close();

            DataInputStream in = new DataInputStream(new FileInputStream(BaseConstant.filePath));
            String str = in.readUTF();
            System.out.println("写入数据为:"+str);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
