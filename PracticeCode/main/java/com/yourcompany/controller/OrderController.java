package com.yourcompany.controller;

import com.yourcompany.service.workflow.OrderWorkflow;
import io.temporal.client.WorkflowClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final WorkflowClient workflowClient;

    @Autowired
    public OrderController(WorkflowClient workflowClient) {
        this.workflowClient = workflowClient;
    }

    @PostMapping("/{orderId}/cancel")
    public ResponseEntity<String> cancelOrder(@PathVariable String orderId) {
        OrderWorkflow workflow = workflowClient.newWorkflowStub(OrderWorkflow.class, orderId);
        workflow.cancelOrder();
        return ResponseEntity.ok("Order cancelled successfully");
    }
}

