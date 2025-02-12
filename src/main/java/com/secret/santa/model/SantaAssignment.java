package com.secret.santa.model;

public class SantaAssignment {

    private Employee giver;
    private Employee receiver;

    public Employee getGiver() {
        return giver;
    }

    public void setGiver(Employee giver) {
        this.giver = giver;
    }

    public Employee getReceiver() {
        return receiver;
    }

    public void setReceiver(Employee receiver) {
        this.receiver = receiver;
    }

    public SantaAssignment(Employee giver, Employee receiver) {
        this.giver = giver;
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "SantaAssignment{" +
                "giver=" + giver +
                ", receiver=" + receiver +
                '}';
    }
}
