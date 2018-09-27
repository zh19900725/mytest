/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package notestream.memory;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * java内存操作流
 * 1.字符流：CharArrayReader/CharArrayWriter
 * 2.字节流：ByteArrayInputStream/ByteArrayOutputSream
 * @author zhanghui
 * @version Id: MemoryArrayTest.java, v 0.1 2018/9/26 0026 16:20 zhanghui Exp $$
 */
public class MemoryArrayTest {

    /**
     * 内存操作流大小写转化
     */
    @Test
    public void byteArray(){
        String str = "HELLO WORLD";
        ByteArrayInputStream input = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int temp;
        while ((temp = input.read())!=-1){
            char c = (char) temp;
            output.write(Character.toLowerCase(c));
        }
        String lowerStr = output.toString();
        System.out.println(lowerStr);
    }
}
