package Statistic.Functions;

public class ICCFunction extends TRIFunction implements Function
{
    /*
    *
    *   This class is for the Item Characteristic Curve that represents
    *   the probability to a student get a question
    *
    **/

    public ICCFunction(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getFunctionValue(double variableValue)
    {
        return getC() + (1 - getC()) * (Math.exp(getA() * (variableValue - getB()))) / (1 + Math.exp(getA() * (variableValue - getB())));
    }
}
