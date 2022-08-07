package org.gb.less.lesson4;

public class FunctionAreaOfTriangle {
    public static double areaOfTriangle(double a, double b, double c) throws TriangleSitesIsErrorException{
        if( a <=0 || b <= 0 || c<= 0 || a + b <= c ||
            a + c <= b || b + c <= a){
            throw new TriangleSitesIsErrorException();
        }
        else {
            double p =(a + b + c)/2;
            return Math.sqrt(p *(p - a) * (p - b) * (p - c));
        }
    }
}
