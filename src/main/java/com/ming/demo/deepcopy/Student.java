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
public class Student implements Cloneable {
    private String name;
    private int age;
    private Teacher teacher;

    @Override
    public Student clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            // 浅拷贝
            // return (Student) super.clone();

            // 深拷贝
            Student student = (Student) super.clone();
            student.setTeacher((Teacher) student.getTeacher().clone());
            return student;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
