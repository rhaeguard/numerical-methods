package com.owary.faora.interpolations.lagrange;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class Lagrange {

    public static double[] lagrange(double[][] input){
        double[] sum = new double[input.length];
        for (int i = 0; i < input.length; i++) {
            double[] multterm = new double[1];
            multterm[0] = 1;
            for (int j = 0; j < input.length; j++) {
                if(i!=j){
                    double[] term = new double[2];
                    term[0] = -input[j][0];
                    term[1] = 1;
                    double constNum = input[i][0]-input[j][0];
                    term = multiplyByConstant(term, 1/constNum);
                    multterm = polynomialMultiply(multterm, term);
                }
            }
            sum = polynomialSum(sum, multiplyByConstant(multterm, input[i][1]));
        }
        return sum;
    }

    public static double[] polynomialMultiply(double[] p1, double[] p2){
        int degree = p1.length+p2.length-1;
        double[] res = new double[degree];
        double x;
        int y;
        for (int i = p1.length-1; i >= 0; i--) {
            for (int j = p2.length-1; j >= 0; j--) {
                x = p1[i]*p2[j];
                y = i+j;
                res[y] += x;
            }
        }
        return res;
    }

    public static double[] multiplyByConstant(double[] p, double constant){
        return DoubleStream.of(p).map(d->d*constant).toArray();
    }

    public static double[] polynomialSum(double[] p1, double[] p2){
        boolean p1IsBigger = p1.length>p2.length;
        double[] a, b;
        if(p1IsBigger){
            a = p1;
            b = p2;
        }else{
            a = p2;
            b = p1;
        }

        for(int i=0;i<b.length;i++){
            a[i]+=b[i];
        }

        return a;
    }

    public static void main(String[] args) {
        double[][] arr = new double[][]{{1,0},{2,2},{3,6}};
        System.out.println(Arrays.toString(lagrange(arr)));
    }

}
