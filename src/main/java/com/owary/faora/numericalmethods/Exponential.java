package com.owary.faora.numericalmethods;

public class Exponential {

    /*
        Formula for calculation

        f(x) = u0 + u1 + u2 + ... + un + Rn(x)
        where, u0 = 1
                    uk = (x/k)*u(k-1)
         f(x) = e^x;
     */

    public static Double exponential(double power, double eps){
        Double x = new Double(power);   // for the prevention of Java Convention for Default Integer Division
        Double u0 = 1D;                             // initial value
        Double term = u0;                        // initial term is equal to the u0 (zeroth term)
        Double sum=u0;                           // initial sum is equal to the initial term

        for (Double k=1D;true;k++){
            term = (x/k)*term;                     // calculate the next term
            sum+=term;                               // sum the terms
            if(term<eps){                              // if term is less than the error, break and return the result
                break;
            }
        }
        return sum;
    }

}
