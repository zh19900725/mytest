/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package notestream.file;

import notestream.BaseConstant;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * java IO 节点流学习该类型可以从或者向一个特定的地点或者节点读写数据
 * A.文件流
 * @author zhanghui
 * @version Id: FileStreamTest.java, v 0.1 2018/9/25 0025 9:56 zhanghui Exp $$
 */
public class FileStreamTest {

    /**
     * 创建文件
     */
    @Test
    public void createFile() {
        File file = new File(BaseConstant.filePath);
        try {
            boolean result = file.createNewFile();
            System.out.println("创建结果：" + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 1.判断文件是否存在
     * 2.删除file文件
     */
    @Test
    public void deleteFile() {
        File file = new File(BaseConstant.filePath);
        boolean flag = file.exists();
        System.out.println("文件是否存在：" + flag);
        boolean deleteFlag = file.delete();
        System.out.println("删除结果：" + deleteFlag);
    }

    /**
     * 创建文件夹
     */
    @Test
    public void createMkDir() {
        File file = new File(BaseConstant.mkDirPath);
        boolean mkDir = file.mkdir();
        System.out.println("创建文件夹结果：" + mkDir);
    }

    /**
     * 指定目录下的全部文件
     */
    @Test
    public void getFileList() {
        String path = "F:" + File.separator + "desktop" + File.separator + "MyTest";
        File file = new File(path);
        String[] nameArray = file.list();
        System.out.println(Arrays.toString(nameArray));
    }

    /**
     * 使用RandomAccessFile写入文件
     *
     * @throws IOException
     */
    @Test
    public void InserNum() throws IOException {
        File file = new File(BaseConstant.filePath);
        RandomAccessFile demo = new RandomAccessFile(file, "rw");
        demo.writeBytes("我的天啊。。");
        demo.writeInt(12);
        demo.writeBoolean(true);
        demo.writeChar('A');
        demo.writeFloat(1.2f);
        demo.writeDouble(12.33);
        demo.close();
        // 如果你此时打开hello。txt查看的话，会发现那是乱码
    }

    /**
     * 向文件中写入字符串
     */
    @Test
    public void stringIn() {
        //创建节点
        File file = new File(BaseConstant.filePath);
        try {
            //创建输出流对象
            OutputStream out = new FileOutputStream(file);
            //编辑内容
            String demo = "hello world 你们好！！！";
            //字符串内容转化为字节流
            byte[] bytes = demo.getBytes();
            //写入节点
            out.write(bytes);
            //关闭流
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 一个字节一个字节写入
     */
    @Test
    public void byteIn() {
        File file = new File(BaseConstant.filePath);
        try {
            OutputStream out = new FileOutputStream(file);
            String demo = "hello 我的名字叫张辉 ";
            byte[] bytes = demo.getBytes();
            for (byte data : bytes) {
                out.write(data);
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向文件中追加新内容
     */
    @Test
    public void newByteIn() {
        File file = new File(BaseConstant.filePath);
        try {
            OutputStream out = new FileOutputStream(file, true);
            String str = " 我在甜橙金融工作 ";
            byte[] bytes = str.getBytes();
            for (byte data : bytes) {
                out.write(data);
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取文件大小
     */
    @Test
    public void getFileLength() {
        //实例化结点流
        File file = new File(BaseConstant.filePath);
        //获取节点大小
        System.out.println("文件大小:" + file.length());
        try {
            //实例化输入流
            InputStream in = new FileInputStream(file);
            //定义byte数组用于存储输入流读取的文件
            byte[] bytes = new byte[(int) file.length()];
            in.read(bytes);
            //关闭流
            in.close();
            System.out.println(Arrays.toString(bytes));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 一个一个读取
     */
    @Test
    public void OneSelectFile() {
        //实例化结点流
        File file = new File(BaseConstant.filePath);
        //获取节点大小
        System.out.println("文件大小:" + file.length());
        try {
            //实例化输入流
            InputStream in = new FileInputStream(file);
            //定义byte数组用于存储输入流读取的文件
            byte[] bytes = new byte[(int) file.length()];
            for (int i = 0; i < file.length(); i++) {
                bytes[i] = (byte) in.read();
            }
            //关闭流
            in.close();
            System.out.println(Arrays.toString(bytes));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 不知道文件有多大的情况下读取文件
     */
    @Test
    public void NotSelectFile() {
        File file = new File(BaseConstant.filePath);
        try {
            int temp;
            InputStream in = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int count = 0;
            while ((temp = in.read()) != (-1)) {
                bytes[count++] = (byte) temp;
            }
            in.close();
            System.out.println(Arrays.toString(bytes));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件复制
     */
    @Test
    public void fileCopy(){
        File file1 = new File(BaseConstant.filePath);
        File file2 = new File("F:" + File.separator + "desktop" + File.separator + "MyTest" +File.separator+"testCopy.txt");
        if(!file1.exists()){
            throw new RuntimeException("要复制的文件不存在");
        }
        try {
            //输入流
            InputStream in = new FileInputStream(file1);
            //输出流
            OutputStream out = new FileOutputStream(file2);
            //存储读取的内容
            int temp;
            int count = 0;
            while((temp = in.read())!=-1){
                out.write(temp);
            }
            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
