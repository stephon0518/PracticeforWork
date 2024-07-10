package com.yourcompany.service.workflow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;
import io.temporal.workflow.SignalMethod;

@WorkflowInterface
public interface OrderWorkflow {
    @WorkflowMethod
    void processOrder(String orderId);

    @SignalMethod
    void cancelOrder();
}
