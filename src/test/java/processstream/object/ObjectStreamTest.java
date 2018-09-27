/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package processstream.object;

import notestream.BaseConstant;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghui
 * @version Id: ObjectStreamTest.java, v 0.1 2018/9/26 0026 17:18 zhanghui Exp $$
 */
public class ObjectStreamTest {

    /**
     * 序列化
     */
    @Test
    public void test01(){
        Dog dog = new Dog();
        dog.setColor("yellow");
        dog.setName("大黄");
        Student student1 = new Student("张辉","28",dog,"2018");
        Student student2 = new Student("张美","28",dog,"2018");
        Student student3 = new Student("张爱","28",dog,"2018");
        List<Student> list = new ArrayList();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("student.txt"));
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 反序列化
     */
    @Test
    public void test02(){
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("student.txt"));
            List<Student> list = (List<Student>) objectInputStream.readObject();
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
