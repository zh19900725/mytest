/**
 * Bestpay.com.cn Inc.
 * Copyright (c) 2011-2018 All Rights Reserved.
 */
package processstream.object;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhanghui
 * @version Id: Dog.java, v 0.1 2018/9/26 0026 17:17 zhanghui Exp $$
 */
@Data
public class Dog implements Serializable {
    private static final long serialVersionUID = 7787943177552791746L;
    private String name;
    private String color;
}
