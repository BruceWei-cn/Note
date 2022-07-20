package com.ming.demo.design.pattern.closeopen.impl;

import com.ming.demo.design.pattern.closeopen.AlertHandler;
import com.ming.demo.design.pattern.closeopen.bean.AlertRule;
import com.ming.demo.design.pattern.closeopen.bean.ApiStatInfo;
import com.ming.demo.design.pattern.closeopen.bean.Notification;

public class ErrorAlertHandler extends AlertHandler {
    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
//        if (apiStatInfo.getErrorCount() > rule.getMatchedRule(apiStatInfo.getApi()).getMaxErrorCount()) {
//            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
    }
}
