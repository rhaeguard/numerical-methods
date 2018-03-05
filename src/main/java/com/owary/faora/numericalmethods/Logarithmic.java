package com.owary.faora.numericalmethods;

public class Logarithmic {

    public static final double LN2 = 0.69314718055994530941723212145818;

    /**
     *  A method for finding the natural logarithm of a given number with the indicated accuracy <br/>
     *  Formula : ln(x) = m*ln2 - 2 (u1 + u2 +...+un+...)
     *  where <br>
     *       <ul>
     *           <li>x = 2<sup>m</sup> * z, where  (/2 <= z < 1 )</li>
     *           <li>ksi = (1(z)/(1+z)</li>
     *           <li>u1 = ksi</li>
     *           <li>Formula for uk = u(k-1) * ksi<sup>2</sup>* (2k-3)/(2k-1)</li>
     *       </ul>
     * @param number    number must be greater than or equal to 0.5, otherwise Exception is thrown
     * @param accuracy
     * @return Double
     */

    public static Double naturalLogarithm(double  number, double accuracy){
        if(number<0.5){
            throw new RuntimeException("Number must be greater than or equal to 0.5");
        }
        Double x = new Double(number);   // for the prevention of Java Convention for Default Integer Division
        // variable declaration
        Double m,z,p2,ksi,term,multiplier,sum,result;

        // find m and z
        p2=1D;
        for(m=0D;true;m++){
            z = x/p2;
            if(z>=0.5D && z < 1D){
                break;
            }else {
                p2 = 2 * p2;
            }
        }
        // find ksi
        ksi = (1-z)/(1+z);
        // find intermediate terms
        term= ksi;
        multiplier = ksi*ksi;
        sum = term;
        for(int k=2;true;k++){
            term *= (multiplier*(2*k-3))/(2*k-1);
            sum+=term;
            if(term<accuracy){
                break;
            }
        }
        // constructing the result
        result = m*LN2 - 2*sum;
        return result;
    }


}
