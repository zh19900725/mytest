/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package notestream;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * java IO 节点流学习
 *
 * @author zhanghui
 * @version Id: NodeStreamTest.java, v 0.1 2018/9/25 0025 9:56 zhanghui Exp $$
 */
public class NodeStreamTest {

    private static final String filePath = "F:" + File.separator + "desktop" + File.separator + "test.txt";
    private static final String mkDirPath = "F:" + File.separator + "desktop" + File.separator+"MkDirTest";


    /**
     * 创建文件
     */
    @Test
    public void createFile() {
        File file = new File(filePath);
        try {
            boolean result = file.createNewFile();
            System.out.println("创建结果："+result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 1.判断文件是否存在
     * 2.删除file文件
     */
    @Test
    public void deleteFile(){
        File file = new File(filePath);
        boolean flag = file.exists();
        System.out.println("文件是否存在："+flag);
        boolean deleteFlag = file.delete();
        System.out.println("删除结果："+deleteFlag);
    }

    /**
     * 创建文件夹
     */
    public void createMkDir(){
        File file = new File(mkDirPath);
        boolean mkDir = file.mkdir();
        System.out.println("创建文件夹结果：mkDir");
    }
}
