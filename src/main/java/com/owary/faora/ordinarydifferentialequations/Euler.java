package com.owary.faora.ordinarydifferentialequations;

import java.util.function.BiFunction;

public class Euler {

    public double[] solve(BiFunction<Double, Double, Double> function, double x0, double xBound, double y0, double h){
        int size = (int)((xBound-x0)/h);
        double[] result = new double[size+1];
        result[0]=y0;int j=1;
        for (double i = x0; i <= xBound; i+=h) {
            y0 = findNextY(function, x0, y0, h);
            result[j] = y0;
            j++;
        }
        return result;
    }

    public static double findNextY(BiFunction<Double, Double, Double> function, double x0, double y0, double h){
        return y0+h*function.apply(x0, y0);
    }


}
