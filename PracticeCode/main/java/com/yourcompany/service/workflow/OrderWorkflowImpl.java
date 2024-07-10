package com.yourcompany.service.workflow;

import io.temporal.workflow.Workflow;

public class OrderWorkflowImpl implements OrderWorkflow {
    private final OrderActivities activities = Workflow.newActivityStub(OrderActivities.class);
    private boolean cancelled = false;

    @Override
    public void processOrder(String orderId) {
        try {
            activities.validateOrder(orderId);
            activities.processPayment(orderId);
            if (cancelled) {
                activities.cancelOrder(orderId);
                Workflow.exit();
            }
            activities.shipOrder(orderId);
        } catch (Exception e) {
            if (cancelled) {
                activities.cancelOrder(orderId);
            } else {
                throw e;
            }
        }
    }

    @Override
    public void cancelOrder() {
        cancelled = true;
        Workflow.cancel("Order was cancelled.");
    }
}
