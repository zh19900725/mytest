/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package processstream.buffer;

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
 * =================================缓冲流===================================
 * 缓冲流是对文件流处理的一种流，它本身并不具备 IO 功能，只是在别的流上加上缓冲提高了效率，当对文件或其他目标频繁读写或操作效率低，效能差。
 * 这时使用缓冲流能够更高效的读写信息。因为缓冲流先将数据缓存起来，然后一起写入或读取出来。
 *
 * 1.缓冲区   基本字节流没有缓冲区    基本字符流有缓冲区（8K）
 * 2.对于基本字节流，Java后来提供了字节流的缓冲流和字符流的缓冲流
 * 3.缓冲流
 *      java.io.BufferedInputStream    字节缓冲流(读)
 *      java.io.BufferedOutputStream    字节缓冲流(写)
 *      java.io.BufferedReader   字符缓冲流(读)
 *      java.io.BufferedWriter   字符缓冲流(写)
 * =========================================================================
 * @author zhanghui
 * @version Id: ConvertStreamTest.java, v 0.1 2018/9/26 0026 9:02 zhanghui Exp $$
 */
public class BufferStream {

    /**
     * 缓存区io操作
     */
    @Test
    public void bufferWriteTest(){
        try {
            //============================================写入==============================================
            //建立缓冲流
            BufferedWriter bufferOut = new BufferedWriter(new FileWriter("buffer.txt"),32*1024);
            //写入数据
            bufferOut.write("全欣");
            bufferOut.write("\r\n全欣爱我");
            //flush的作用是将缓存区的数据强制刷出到目的地，close 也有这个作用，但是close后流就被关闭了
            bufferOut.flush();
            //============================================读出==============================================
            BufferedReader bufferedIn = new BufferedReader(new FileReader("buffer.txt"));
            char[] chars = new char[32*1024];
            int len = bufferedIn.read(chars);
            System.out.println(new String(chars).substring(0,len));
            bufferedIn.close();
            bufferOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从缓存区读数据
     */
    @Test
    public void bufferReadTest(){
        try {
            BufferedReader bufferedIn = new BufferedReader(new FileReader("buffer.txt"));
            char[] chars = new char[32*1024];
            int len = bufferedIn.read(chars);
            bufferedIn.close();
            System.out.println(new String(chars).substring(0,len));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
