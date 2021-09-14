package com.hanson.ali.LoadBalance;

// 增加一个Weight类，用来保存ip, weight（固定不变的原始权重）, currentweight（当前会变化的权重）
public class Weight {
    private String ip;
    private Integer weight;
    private Integer currentWeight;
    public Weight(String ip, Integer weight, Integer currentWeight) {
        this.ip = ip;
        this.weight = weight;
        this.currentWeight = currentWeight;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public Integer getWeight() {
        return weight;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    public Integer getCurrentWeight() {
        return currentWeight;
    }
    public void setCurrentWeight(Integer currentWeight) {
        this.currentWeight = currentWeight;
    }
}