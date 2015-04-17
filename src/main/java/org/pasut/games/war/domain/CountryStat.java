package org.pasut.games.war.domain;

public class CountryStat {
    private final double amount;
    private double fixedCost;
    private double dynamicCost;

    public CountryStat(){
        amount = 0;
    }

    public CountryStat(double estimation, double fixedCost, double dynamicCost){
        this.amount = estimation;
        this.fixedCost = fixedCost;
        this.dynamicCost = dynamicCost;
    }

    public void addDynamicCost(double cost) {
        this.dynamicCost+=cost;
    }

    public void addFixedCost(double cost) {
        this.fixedCost+=cost;
    }


    public double getAmount() {
        return amount;
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