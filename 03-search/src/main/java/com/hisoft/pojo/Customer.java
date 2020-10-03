package com.hisoft.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: springcloud
 * @description:
 * @author: wlg
 * @create: 2020-10-03 17:41:15
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Integer id;
    private String name;
    private Integer age;
}
