/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package network;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;

/**
 *
 * @author yinShiPeng
 * @version Id: ClientImpl.java, v 0.1 2018/10/2 23:40 yinShiPeng Exp $$
 */
public class ClientImpl {
    private static String ip;
    private static int    port;    private static int    timeOut;
    private        Socket client1;

    static {
        ip = "127.0.0.1";
        port = 20006;
        timeOut = 3000;
    }

    public ClientImpl() {
        try {
            client1 = new Socket(ip, port);
            client1.setSoTimeout(timeOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void postData() {
        OutputStream outputStream = null;
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        try {
            //获取键盘输入
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            //获取socket的输出流用来传送给服务器
            outputStream = client1.getOutputStream();
            //获取socket的输入流用来存储服务器的返回
            inputStream = client1.getInputStream();
            Byte [] bytes = new Byte[2048];
            int temp = 0;
            int count= 0;
            while((temp = inputStream.read())!=-1){
                bytes[count++] = (byte) temp;
            }
            System.out.println("服务器返回"+Arrays.toString(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
