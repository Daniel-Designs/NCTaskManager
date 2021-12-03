package mx.edu.j2se.morales.evaluation;

/**
 * Class Cicle
 * @author Daniel
 * @version 2.12.2021
 */
public class Circle {

    private int radius;

    /**
     * Default constructor
     * Set automatically radius to 1
     */
    public Circle() {
        this.radius = 1;
    }

    /**
     * Constructor
     * @param radius must be an int
     * @throws IllegalArgumentException when the parameter radius is less or equal to 0
     */
    public Circle(int radius) throws IllegalArgumentException{
        if(radius <= 0)
            throw new IllegalArgumentException("The value of the radio must be bigger than 0");
        this.radius = radius;
    }

    /**
     * Getter for the parameter Radius
     * @return radius parameter
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Setter for the radius parameter
     * @param radius must be an Int
     * @throws IllegalArgumentException when the radius parameter is less or equal to 0
     */
    public void setRadio(int radius) throws IllegalArgumentException {
        if(radius <= 0)
            throw new IllegalArgumentException("The value of the radio must be bigger than 0");
        this.radius = radius;
    }

    /**
     * Calculate the area using the constant Math.PI
     * @return area in a double type
     */
    public double getArea(){
        double area;
        area = Math.PI * Math.pow(getRadius(),2);
        return  area;
    }

}
