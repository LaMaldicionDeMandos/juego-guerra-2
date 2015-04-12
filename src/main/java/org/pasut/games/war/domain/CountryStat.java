package org.pasut.games.war.domain;

public class CountryStat {
    private double amount;
    private double estimatedAmount;
    private double fixedCost;
    private double dynamicCost;

    public CountryStat(){}

    public CountryStat(double estimation, double fixedCost, double dynamicCost){
        this.amount = estimation;
        this.estimatedAmount = estimation;
        this.fixedCost = fixedCost;
        this.dynamicCost = dynamicCost;
    }

    public void addDynamicCost(double cost){
        this.dynamicCost+=cost;
    }


    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public double getEstimatedAmount() {
        return estimatedAmount;
    }
    public void setEstimatedAmount(double estimatedAmount) {
        this.estimatedAmount = estimatedAmount;
    }
    public double getFixedCost() {
        return fixedCost;
    }
    public void setFixedCost(double fixedCost) {
        this.fixedCost = fixedCost;
    }
    public double getDynamicCost() {
        return dynamicCost;
    }
    public void setDynamicCost(double cost) {
        this.dynamicCost = cost;
    }
    public double getCost(){
        return this.fixedCost + this.dynamicCost;
    }
}