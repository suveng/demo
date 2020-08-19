package com.my.qs.esdemo.service;

public class Suggest {
    private String input;
    private int weight = 10;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Suggest{" + "input='" + input + '\'' + ", weight=" + weight + '}';
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
