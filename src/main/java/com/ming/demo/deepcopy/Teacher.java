package com.ming.demo.deepcopy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ming
 * @date 23/12/2021-下午 4:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher implements Cloneable {

    private String name;
    private int age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
