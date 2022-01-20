package com.KomSoft.lection12;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
public class HeavyBox implements Comparable<HeavyBox>{
    private int length;
    private int width;
    private int depth;
    private int weight;

    public HeavyBox(int length, int width, int depth, int weight) {
        this.length = length;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
    }

    public HeavyBox(int size, int weight) {
        length = width = depth = size;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(HeavyBox other) {
        return this.weight - other.weight;
    }

    @Override
    public String toString() {
        return "HeavyBox{size:" + length + "x" + width + "x" + depth + ", weight=" + weight +'}';
    }
}
