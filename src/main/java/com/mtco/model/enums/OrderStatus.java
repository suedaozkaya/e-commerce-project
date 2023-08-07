package com.mtco.model.enums;

public enum OrderStatus {
	
    PENDING_PAYMENT("Pending Payment"),
    PAYMENT_PROCESSED("Payment Processed"),
    PAYMENT_FAILED("Payment Failed"),
    PROCESSING("Processing"),
    SHIPPED("Shipped"),
    OUT_FOR_DELIVERY("Out for Delivery"),
    DELIVERED("Delivered"),
    CANCELED("Canceled"),
    REFUNDED("Refunded"),
    RETURNED("Returned"),
    ON_HOLD("On Hold"),
    BACKORDERED("Backordered"),
    PARTIALLY_SHIPPED("Partially Shipped"),
    COMPLETED("Completed"),
    FAILED("Failed"),
    REVIEW("Review");
    
    private final String displayName;

    OrderStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
