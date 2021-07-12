package Statistic.Functions;

public abstract class TRIFunction implements Function
{
    /*
    *
    *   This class refers to all function that is used to estimate a student's ability
    *
     */

    double a;
    double b;
    double c;

    public double getA()
    {
        return a;
    }

    public double getB()
    {
        return b;
    }

    public double getC()
    {
        return c;
    }

    @Override
    public String toString() {
        return "TRIFunction{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
