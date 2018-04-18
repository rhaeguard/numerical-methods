package com.owary.faora.test;


public class Main {
    public static void main(String[] args) {
//        Complex[] p1 = new Complex[2];
//        p1[0] = new Complex(3, 0);
//        p1[1] = new Complex(2, 0);
//        p1[2] = new Complex(1, 0);
//        p1[3] = new Complex(2, 0);

//        Complex[] p2 = new Complex[4];
//        p2[0] = new Complex(4, 0);
//        p2[1] = new Complex(3, 0);
//        p2[2] = new Complex(2, 0);
//        p2[3] = new Complex(4, 0);
//
//        Complex[] re = Fourier.add(p1, p2);
//
//        Fourier.show(re, "MULT");
        double[][] inp = new double[][]{{1,0},{2,2},{3,6}};
        Fourier.show(Lagrange.lagra(inp), "Lagrange");
    }
}
