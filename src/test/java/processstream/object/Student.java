/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package processstream.object;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhanghui
 * @version Id: Student.java, v 0.1 2018/9/26 0026 17:23 zhanghui Exp $$
 */
@Data
@AllArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = 5481461225440947183L;
    private String name;
    private String age;
    private Dog dog;
    private String stuNo;
    private String adb;

    public Student(String name, String age, Dog dog, String stuNo) {
        this.name = name;
        this.age = age;
        this.dog = dog;
        this.stuNo = stuNo;
    }
}
