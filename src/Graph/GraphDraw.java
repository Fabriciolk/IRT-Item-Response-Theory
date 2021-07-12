package Graph;

import Graph.Image;

public class GraphDraw
{
    /*
    *
    *   This class draw a graphic 2D and all its attributes on a image,
    *   such as axis, axis's range, points (x, y).
    *
    */

    private int factorDivision;   // Number of pixels for 1 unity in graph
    private final int[] position; // Upper left point of the rectangle containing the graphic
    private int lineUnitLength;   // Length of each line that represents an unity
    private final int width;      // Width of the rectangle containing the graphic
    private final int height;     // Height of the rectangle containing the graphic
    private int heightX_Axis;     // Height of X axis in rectangle containing the graphic
    private int widthY_Axis;      // Width of Y axis in rectangle containing the graphic
    private double[] xRange;      // Minimum and maximum values of axis X that will be drawn on image
    private double[] yRange;      // Minimum and maximum values of axis Y that will be drawn on image

    public GraphDraw(int[] position, int width, int height)
    {
        this.position = new int[]{Math.max(position[0], 0), Math.max(position[1], 0)};
        this.width = width <= 0 ? 100 : width;
        this.height = height <= 0 ? 100 : height;
    }

    private void drawXAxis(double axisHeight, Image img)
    {
        if (axisHeight < 0) axisHeight = 0;
        if (axisHeight > height) axisHeight = height;
        heightX_Axis = (int)(axisHeight);
        img.drawLine(position[0], position[1] + height - (int)(axisHeight), position[0] + width, position[1] + height - (int)(axisHeight));
    }

    private void drawYAxis(double axisWidth, Image img)
    {
        if (axisWidth < 0) axisWidth = 0;
        if (axisWidth > width) axisWidth = width;
        widthY_Axis = (int)(axisWidth);
        img.drawLine(position[0] + (int)(axisWidth), position[1], position[0] + (int)(axisWidth), position[1] + height);
    }

    public void drawAxis(double axisX_Height, double axisY_Width, double[] xRange, double[] yRange, Image img)
    {
        this.xRange = xRange;
        this.yRange = yRange;
        drawXAxis(axisX_Height, img);
        drawYAxis(axisY_Width, img);
    }

    /*
    *   This method draws each line that represent a unity on both axis.
    * */

    public void drawUnitsAxis(int facDivision, Image img)
    {
        int lineUnitLength = (int)(Math.min(width, height) * 0.02);
        this.lineUnitLength = lineUnitLength;
        factorDivision = Math.min(width, height)/facDivision;

        // Draw units on X axis
        for (int i = position[0]; i <= position[0] + width; i += factorDivision)
        {
            img.drawLine(i, position[1] + height - heightX_Axis - lineUnitLength/2, i, position[1] + height - heightX_Axis + lineUnitLength/2);
        }

        // Draw units on Y axis
        for (int i = position[1]; i <= position[1] + height; i += factorDivision)
        {
            img.drawLine(position[0] + widthY_Axis - lineUnitLength/2, i, position[0] + widthY_Axis + lineUnitLength/2, i);
        }
    }

    /*
    *   This method draws a point (filled circle) in graphic
    */

    public void drawPoint(double x, double y, int pointLength, Image img)
    {
        if (x < xRange[0] || x > xRange[1] || y < yRange[0] || y > yRange[1]) return;
        int xInImg = (int)(position[0] + width * (x - xRange[0]) / (xRange[1] - xRange[0]));
        int yInImg = (int)(position[1] + height + ((height * (yRange[0] - y)) / (yRange[1] - yRange[0])));

        img.drawPoint(xInImg, yInImg, pointLength);
    }

    /*
    *   This method returns the number of digits of a integer.
    */

    private int numberOfDigits(int x)
    {
        int digits = 0;

        while (x > 0)
        {
            digits++;
            x = x/10;
        }

        return digits;
    }

    /*
     *   This method writes the limit values at the ends of the axes.
     */

    public void drawRangesOnAxis(Image img)
    {
        img.drawString(String.valueOf(xRange[0]), position[0] - (int)(2.5 * numberOfDigits((int)(xRange[0]))) - factorDivision, position[1] + height - heightX_Axis - lineUnitLength);
        img.drawString(String.valueOf(xRange[1]), position[0] + width - (int)(2.5 * numberOfDigits((int)(xRange[0]))) - factorDivision, position[1] + height - heightX_Axis - lineUnitLength);

        img.drawString(String.valueOf(yRange[0]), position[0] + widthY_Axis + factorDivision, position[1] + height);
        img.drawString(String.valueOf(yRange[1]), position[0] + widthY_Axis + factorDivision, position[1]);
    }
}
