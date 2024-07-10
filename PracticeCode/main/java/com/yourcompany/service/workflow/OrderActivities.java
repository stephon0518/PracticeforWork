package com.yourcompany.service.workflow;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface OrderActivities {
    void validateOrder(String orderId);
    void processPayment(String orderId);
    void shipOrder(String orderId);
    void cancelOrder(String orderId);
}
