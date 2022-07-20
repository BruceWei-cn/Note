package com.ming.demo.design.pattern.closeopen.impl;

import com.ming.demo.design.pattern.closeopen.AlertHandler;
import com.ming.demo.design.pattern.closeopen.bean.AlertRule;
import com.ming.demo.design.pattern.closeopen.bean.ApiStatInfo;
import com.ming.demo.design.pattern.closeopen.bean.Notification;

public class TpsAlertHandler extends AlertHandler {
    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationOfSeconds();
//        if (tps > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTps()) {
//            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
//        }
    }
}