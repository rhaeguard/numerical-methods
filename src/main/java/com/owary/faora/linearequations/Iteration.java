package com.owary.faora.linearequations;

import java.util.Arrays;

public class Iteration {

    public static final int ITERATION_COUNT = 3;

    public static double[] jacobi(double[][] input){
        int len = input.length;
        double[] res = new double[len];
        double[] copy = new double[len];
        int inc = 0;
        do{
            for (int i = 0; i < len; i++) {
                double term = input[i][len];
                for (int k=0;k<len;k++){
                    if(k!=i){
                        term -= res[k]*input[i][k];
                    }
                }
                copy[i] = term/input[i][i];
            }
            res = copy.clone();
            inc++;
        }while(inc<=ITERATION_COUNT);
        return res;
    }

    public static void main(String[] args) {
//        double[][] input = {{5,-1,2,12},{3,8,-2,-25},{1,1,4,6}};
//        double[][] input = {{10,-1,-1,12},{3,10,1,13},{2,2,10,15}};
        double[][] input = {{1.02,-.25,-.3,.515},{-.41,1.13,-.15,1.555},{-.25,-.14,1.21,2.78}};
        System.out.println(Arrays.toString(jacobi(input)));
    }

}
