package dev.decisionflow.core;

public class Request {
    private double amount;
    private boolean urgent;

    public Request (double amount, boolean urgent){
        if (amount < 0){
            throw new IllegalArgumentException("Amount can't be negative. Received: " + amount);
        }
        this.amount = amount;
        this.urgent = urgent;
    }

    public double getAmount(){
        return this.amount;
    }

    public boolean isUrgent(){
        return this.urgent;
    }
}
