package com.mtco.model.enums;

public enum PaymentProvider {
    VISA("Visa"),
    MASTERCARD("MasterCard"),
    PAYPAL("PayPal");

    private final String displayName;

    PaymentProvider(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
