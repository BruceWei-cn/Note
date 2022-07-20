package com.ming.demo.design.pattern.closeopen;

import com.ming.demo.design.pattern.closeopen.bean.AlertRule;
import com.ming.demo.design.pattern.closeopen.bean.Notification;
import com.ming.demo.design.pattern.closeopen.impl.ErrorAlertHandler;
import com.ming.demo.design.pattern.closeopen.impl.TpsAlertHandler;

/**
 * 组装上下文
 *
 * @author xiaomingwei
 */
public class ApplicationContext {
    private AlertRule alertRule;
    private Notification notification;
    private Alert alert;

    public void initializeBeans() {
        // 此处省略在 AlertRule & Notification 构造方法中赋值属性传递参数
        alertRule = new AlertRule();
        notification = new Notification();
        alert = new Alert();
        // 若是将来增加功能，此处可以扩展
        alert.addAlertHandler(new TpsAlertHandler(alertRule, notification));
        alert.addAlertHandler(new ErrorAlertHandler(alertRule, notification));
    }

    public Alert getAlert() {
        return alert;
    }

    /**
     * 饿汉式单例
     */
    private static final ApplicationContext INSTANCE = new ApplicationContext();

    private ApplicationContext() {
        initializeBeans();
    }

    public static ApplicationContext getInstance() {
        return INSTANCE;
    }
}