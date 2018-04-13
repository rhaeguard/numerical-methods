package com.owary.faora.numericalmethods;

public class Trigonometrical {

    // Accuracy of sine and cosine
    private static final double ACCURACY = 10e-15;

    /**
     * Sine function that calculates the value of the sin with given inputs
     * @param deg is degree
     * @param min is minute
     * @param sec is second
     * @return the result of the calculation based on the given input
     */
    public static double sin(double deg, double min, double sec){
        Property prop = getProperties(true, deg, min, sec);
        double degree = prop.degree;
        double sign = prop.sign;
        double radian = radian(degree);
        if (degree>45){
            return sign*trig(false, radian);
        }else{
            return sign*trig(true, radian);
        }
    }

    /**
     * Cosine function that calculates the value of the cosine with given inputs
     * @param deg is degree
     * @param min is minute
     * @param sec is second
     * @return the result of the calculation based on the given input
     */
    public static double cos(double deg, double min, double sec){
        Property prop = getProperties(false, deg, min, sec);
        double degree = prop.degree;
        double sign = prop.sign;
        double radian = degree>45?radian(90-degree):radian(degree);
        if (degree>45){
            return sign*trig(true, radian);
        }else{
            return sign*trig(false, radian);
        }
    }

    /**
     * Function to get the properties of the calculation that is, its angle(degree) and sign
     * @param isSine defines whether the calculation mode is sine or cosine
     * @param deg is degree
     * @param min is minute
     * @param sec is second
     * @return Property object that holds the sign and degree of the calculation
     */
    private static Property getProperties(boolean isSine, double deg, double min, double sec){
        double degree = (deg+min/60+sec/3600);
        double sign = 0;
        // check if it is negative
        if(degree<0){
            sign = isSine?-1:1;
            degree*=-1;
        }
        // check if it is more than or equal 360; convert into less
        while(degree>=360){
            degree-=360;
        }
        // check if it is in [0;90] then fine
        if(isBetween(degree, 0, 90)){
            // that's fine
            sign = 1;
        }
        // check if it is in (90;180]
        if(isBetween(degree, 90, 180)){
            sign = isSine?1:-1;
            degree = 180 - degree;
        }
        // sin = sin (180 - x)
        // cos = - cos (180 - x)

        // check if it is in (180;270]
        if(isBetween(degree, 180, 270)){
            sign = isSine?-1:-1;
            degree -= 180;
        }
        // sin = - sin (x - 180)
        // cos = - cos (x - 180)

        // check if it is in (270;360)
        if(isBetween(degree, 270, 360)){
            sign = isSine?-1:1;
            degree = 360 - degree;
        }
        // sin = - sin (360 - x)
        // cos = cos (360 - x)

        return new Property(sign, degree);
    }

    /**
     * Generic trig function that works with sine and cosine
     * @param isSine defines whether the mode is sine or cosine
     * @param radian is the radian value to calculate
     * @return the calculated value of sine/cosine
     */
    private static double trig(boolean isSine, double radian){
        double sign = isSine?1.0:-1.0;
        double term = isSine?radian:1.0;
        double sum = term;
        double squared = radian*radian;
        double multiplier;
        for(double k=1;true;k++){
            if(term<ACCURACY){
                break;
            }
            multiplier = squared/((2*k)*(2*k+sign));
            term *= -multiplier;
            sum += term;
        }
        return sum;
    }

    /**
     * Tangent function that calculates the value of the tangent with given inputs
     * @param deg is degree
     * @param min is minute
     * @param sec is second
     * @return the result of the calculation based on the given input
     */
    public static double tan(double deg, double min, double sec){
        Property prop = getProperties(deg, min, sec);

        double degree = prop.degree;
        double sign = prop.sign;

        double radian = radian(degree);
        double radianSquared = radian*radian;
        double y=15, k=13;
        for(int i=0;i<7;i++){
            y = k - radianSquared/y;
            k-=2;
        }
        return sign*radian/y;
    }

    /**
     * Cotangent function that calculates the value of the cotangent with given inputs
     * @param deg is degree
     * @param min is minute
     * @param sec is second
     * @return the result of the calculation based on the given input
     */
    public static double cotan(double deg, double min, double sec){
        return 1/tan(deg, min, sec);
    }

    /**
     * Function to get the properties of the calculation that is, its angle(degree) and sign
     * @param deg is degree
     * @param min is minute
     * @param sec is second
     * @return Property object that holds the sign and degree of the calculation
     */
    private static Trigonometrical.Property getProperties(double deg, double min, double sec){
        double degree = (deg+min/60+sec/3600);
        double sign = 0;
        // check if it is negative
        if(degree<0){
            sign = -1;
            degree*=-1;
        }
        // check if it is more than or equal 360; convert into less
        while(degree>=360){
            degree-=360;
        }
        // check if it is in [0;90] then fine
        if(isBetween(degree, 0, 90)){
            // that's fine
            sign = 1;
        }
        // check if it is in (90;180]
        if(isBetween(degree, 90, 180)){
            sign = -1;
            degree = 180 - degree;
        }

        // check if it is in (180;270]
        if(isBetween(degree, 180, 270)){
            sign = 1;
            degree -= 180;
        }

        // check if it is in (270;360)
        if(isBetween(degree, 270, 360)){
            sign = -1;
            degree = 360 - degree;
        }

        return new Property(sign, degree);
    }

    private static boolean isBetween(double num,double a, double b){
        return (num>=a)&&(num<=b);
    }

    private static double radian(double degree){
        return degree*Math.PI/180;
    }

    /**
     * Class of an object that holds sign and angle property of the calculation
     */
    static class Property{
        double sign;
        double degree;

        public Property(double sign, double degree) {
            this.sign = sign;
            this.degree = degree;
        }
    }

}
