package com.ming.demo.design.pattern.closeopen;

import com.ming.demo.design.pattern.closeopen.bean.AlertRule;
import com.ming.demo.design.pattern.closeopen.bean.ApiStatInfo;
import com.ming.demo.design.pattern.closeopen.bean.Notification;

/**
 * 抽象类
 */
public abstract class AlertHandler {
    protected AlertRule rule;
    protected Notification notification;

    public AlertHandler() {
    }

    public AlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public abstract void check(ApiStatInfo apiStatInfo);
}