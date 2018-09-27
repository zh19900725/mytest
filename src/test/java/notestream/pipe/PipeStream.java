/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package notestream.pipe;

import notestream.BaseConstant;
import org.junit.Test;

import java.io.*;

/**
 * 节点流之管道流--实现进程通信
 *
 * @author zhanghui
 * @version Id: PipeStream.java, v 0.1 2018/9/25 0025 19:22 zhanghui Exp $$
 */
public class PipeStream {
    PrintStream printStream;

    {
        try {
            printStream = new PrintStream(new FileOutputStream(BaseConstant.filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 消息发送类
     */
    class Send implements Runnable {
        private OutputStream pipeOutputStream;
        private String message;

        public Send(OutputStream pipeOutputStream, String message) {
            this.pipeOutputStream = pipeOutputStream;
            this.message = message;
        }

        public void run() {
            try {
                if (message == null || message.trim().length() == 0) {
                    throw new RuntimeException("不能发送空消息");
                }
                byte[] bytes = message.trim().getBytes("UTF-8");
                for (byte dataStream : bytes) {
                    pipeOutputStream.write(dataStream);
                }
                pipeOutputStream.close();
                System.out.println("消息发送：" + new String(bytes, "UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 消息接收
     */
    class Receive implements Runnable {
        private InputStream pipeInputStream;

        public Receive(InputStream pipeInputStream) {
            this.pipeInputStream = pipeInputStream;
        }

        public void run() {
            byte[] bytes = new byte[1024];
            try {
                int temp;
                int count = 0;
                while ((temp = pipeInputStream.read()) != -1) {
                    bytes[count++] = (byte) temp;
                }
                printStream.print("接收消息：");
                printStream.write(bytes);
                System.out.println("接收消息：" + new String(bytes, "UTF-8").substring(0, count));
                pipeInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 进程通信--消息发送测试
     */
    @Test
    public void sendMessageTest() throws IOException, InterruptedException {
        PipedOutputStream pipeOut = new PipedOutputStream();
        PipedInputStream pipIn = new PipedInputStream();
        pipIn.connect(pipeOut);
        String message = "我的名字叫张辉";
        PipeStream.Send send = new Send(pipeOut, message);
        Thread threadSend = new Thread(send);
        PipeStream.Receive receive = new Receive(pipIn);
        Thread threadReceive = new Thread(receive);
        //启动读线程
        threadReceive.start();
        threadReceive.sleep(2000);
        //启动写线程
        threadSend.start();
    }

}
