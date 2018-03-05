package com.owary.faora.test;

import com.owary.faora.numericalmethods.Exponential;
import com.owary.faora.numericalmethods.Logarithmic;

public class Main {
    public static void main(String[] args) {
//        double res = Exponential.exponential(5, .1);
        double res = Logarithmic.naturalLogarithm(2,10e-5);
        System.out.println(res);
    }
}
