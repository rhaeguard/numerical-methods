package com.owary.faora.test;

import com.owary.faora.numericalmethods.Exponential;

public class Main {
    public static void main(String[] args) {
        double res = Exponential.exponential(1/3D, .00000000000001);
        System.out.println(res);
    }
}
