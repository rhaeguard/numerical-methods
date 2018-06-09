package com.owary.faora.ordinarydifferentialequations;

import java.util.function.BiFunction;
/*
    Fourth-order Runge-Kutta method for Solving Ordinary Differential Equations
 */
public class RungeKutta {

    private static BiFunction<Double, Double, Double> EQUATION = (x, y) -> x-2*y+1.5;

    public static void main(String[] args) {
        solve(EQUATION, 0, -1, 1, 0.2);
    }


    public static double[] solve(BiFunction<Double, Double, Double> equation, double x0, double y0, double xBound, double h){
        int size = (int)((xBound-x0)/h);
        double[] results = new double[size+1];
        results[0] = y0;int j = 1;
        for(double i=x0+h;i<=xBound;i+=h){
            y0 = findNextY(EQUATION, i, y0, h);
            results[j] = y0;
            j++;
            System.out.println("y( "+i+" ) = "+y0);
        }
        return results;
    }

    public static double findNextY(BiFunction<Double, Double, Double> equation, double x, double y, double h){
        double[] K = calculateKTerms(equation, x, y, h);
        return y + (K[0]+2*K[1]+2*K[2]+K[3])/6;
    }

    public static double[] calculateKTerms(BiFunction<Double, Double, Double> equation, double x, double y, double h){
        double[] Ks = new double[4];
        Ks[0] = h*equation.apply(x, y);
        Ks[1] = h*equation.apply(x+h/2, y+Ks[0]/2);
        Ks[2] = h*equation.apply(x+h/2, y+Ks[1]/2);
        Ks[3] = h*equation.apply(x+h, y+Ks[2]);
        return Ks;
    }

}
