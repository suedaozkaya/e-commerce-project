package com.mtco.domain.enums;

public enum PaymentProvider {
    VISA("Visa"),
    MASTERCARD("MasterCard"),
    PAYPAL("PayPal"),
    UNKNOWN("Unknown");

    private final String displayName;

    PaymentProvider(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
