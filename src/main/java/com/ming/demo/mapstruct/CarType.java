package com.ming.demo.mapstruct;

/**
 * @author Ming
 * @date 23/12/2021-上午 11:29
 */
public enum CarType {
    SEDAN("测试");

    CarType(String message) {
        this.message = message;
    }

    String message;

    public String getMessage() {
        return message;
    }
}
