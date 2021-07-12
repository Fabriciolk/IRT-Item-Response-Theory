package Statistic.Functions;

public class DxLnICCFunction extends TRIFunction implements Function
{
    /*
    *
    *   Letting f(x) be the Item Characteristic Curve, this class
    *   represents the derivative of ln[f(x)], where ln is the
    *   natural logarithm
    *
    */

    public DxLnICCFunction(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getFunctionValue(double variableValue)
    {
        double eExp = Math.exp(getA() * (variableValue - getB()));
        return ((1.0 - getC()) * getA() * eExp) / ((getC() + eExp) * (1.0 + eExp));
    }
}
