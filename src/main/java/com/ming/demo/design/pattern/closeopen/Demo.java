package com.ming.demo.design.pattern.closeopen;

import com.ming.demo.design.pattern.closeopen.bean.ApiStatInfo;
import org.apache.kafka.common.protocol.types.Field;
import org.junit.Test;

/**
 * 针对开闭原则得一个demo
 */
public class Demo {
    public static void main(String[] args) {
        ApiStatInfo apiStatInfo = new ApiStatInfo();
        // ...省略设置apiStatInfo数据值的代码
        ApplicationContext.getInstance().getAlert().check(apiStatInfo);
    }

    @Test
    public void test(){
        String s = "|saleMallVersionC|trainHotelReturnCash|npaypass|notSelectSeat|bAccReg|zlRO|newJavaSys";
        if (s.contains("trainHotelReturnCah")){
            System.out.println("haha");
        }
    }

}