package mx.edu.j2se.morales.evaluation;

import javax.sound.midi.Soundbank;

public class Evaluation1 {

    public static void main(String[] args) {

        Circle circle0 = new Circle(45);
        System.out.println("Circle's Radius: "+ circle0.getRadius());
        System.out.println("Circle's Area: "+circle0.getArea());

        try{
            Circle circleIllegal = new Circle(-2);
        }catch (IllegalArgumentException e){
            System.out.println("Error message ---->  " + e );
        }

        Circle circle1 = new Circle();
        Circle circle2 = new Circle(6);
        Circle[] circles = new Circle[] {circle0,circle1,circle2};
        int index = biggestCircle(circles);
        System.out.println("Index of the biggestCircle : " + index);
    }

    public static int biggestCircle(Circle[] circles){
        int biggest = circles[0].getRadius();
        int index = 0;

        for(int i=0;i < circles.length;i++){
            if(circles[i].getRadius() > biggest){
                biggest = circles[i].getRadius();
                index = i;
            }
        }
        return index;
    }
}
