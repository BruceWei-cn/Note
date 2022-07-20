package com.ming.demo.design.pattern.closeopen;

import com.ming.demo.design.pattern.closeopen.bean.ApiStatInfo;

/**
 * 针对开闭原则得一个demo
 */
public class Demo {
    public static void main(String[] args) {
        ApiStatInfo apiStatInfo = new ApiStatInfo();
        // ...省略设置apiStatInfo数据值的代码
        ApplicationContext.getInstance().getAlert().check(apiStatInfo);
    }
}