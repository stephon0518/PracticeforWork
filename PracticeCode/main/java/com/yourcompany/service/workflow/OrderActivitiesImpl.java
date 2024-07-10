package com.yourcompany.service.workflow;

public class OrderActivitiesImpl implements OrderActivities {

    @Override
    public void validateOrder(String orderId) {
        System.out.println("Validating order: " + orderId);
    }

    @Override
    public void processPayment(String orderId) {
        System.out.println("Processing payment for order: " + orderId);
    }

    @Override
    public void shipOrder(String orderId) {
        System.out.println("Shipping order: " + orderId);
    }

    @Override
    public void cancelOrder(String orderId) {
        System.out.println("Cancelling order: " + orderId);
    }
}
