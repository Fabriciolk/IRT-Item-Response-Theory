package Statistic.Functions;

public class DxLnNotICCFunction extends TRIFunction implements Function
{
    /*
    *
    *   Letting f(x) be the Item Characteristic Curve, this class
    *   represents the derivative of ln[1 - f(x)], where ln is the
    *   natural logarithm
    *
    */

    public DxLnNotICCFunction(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getFunctionValue(double variableValue)
    {
        double eExp = Math.exp(getA() * (variableValue - getB()));
        return ((-1) * getA() * eExp) / (1 + eExp);
    }
}
