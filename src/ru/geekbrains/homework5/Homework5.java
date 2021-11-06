package ru.geekbrains.homework5;

import java.util.Arrays;

public class Homework5 {
    public static void main(String[] args) {
        addArray1();
    }

    public static void addArray1() {
        int size = 10000000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время работы метода1: " + (System.currentTimeMillis() - start));

    }
}


