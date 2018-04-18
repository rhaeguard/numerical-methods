package com.owary.faora.numericalmethods;

public class NthRoot {

    public static final double ACCURACY = 10e-15;

    /**
     * Method that calculates the value of nth-root
     * @param number is the value we want to find the nth-root of
     * @param nthroot is the nth-root
     * @return the calculated value of nth-root
     */
    public static double nthroot(double number, double nthroot){
        if(number<0 && nthroot%2==0){
            throw new RuntimeException("Even root of negative numbers are undefined");
        }
        double y = 1;//initial guess
        double prev = y;
        while(true){
            y = (1/nthroot)*((nthroot-1)*y+number/power(y, nthroot-1));
            if(abs(y-prev)<ACCURACY){
                break;
            }
            prev = y;
        }
        return y;
    }

    /**
     * Absolute value
     * @param num is the value to be converted into an absolute form
     * @return the absolute value
     */
    private static double abs(double num){
        return num<0?-num:num;
    }

    /**
     * Nth power
     * @param num is the value to be raised to the power
     * @param pow is the power value
     * @return the calculated value
     */
    private static double power(double num, double pow){
        double res = 1;
        for(int i=0;i<pow;i++){
            res = res*num;
        }
        return res;
    }

}
