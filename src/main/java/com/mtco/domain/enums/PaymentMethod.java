package com.mtco.domain.enums;

public enum PaymentMethod {
    CREDIT_CARD("Credit Card"),
    DEBIT_CARD("Debit Card"),
    PAYPAL("Paypal"),
    APPLE_PAY("Apple Pay"),
    GOOGLE_PAY("Google Pay"),
    GIFT_CARD("Gift Card");
    
    private final String displayName;

    PaymentMethod(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}
