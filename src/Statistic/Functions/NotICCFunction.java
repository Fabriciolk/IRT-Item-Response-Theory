package Statistic.Functions;

public class NotICCFunction extends TRIFunction implements Function
{
    /*
    *
    *   This class is for the Item Characteristic Curve that represents
    *   the probability to a student doesn't get a question
    *
    */

    public NotICCFunction(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getFunctionValue(double variableValue)
    {
        ICCFunction func = new ICCFunction(getA(), getB(), getC());
        return 1 - func.getFunctionValue(variableValue);
    }
}
