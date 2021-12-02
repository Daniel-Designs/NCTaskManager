package mx.edu.j2se.morales.tasks.tests;

import mx.edu.j2se.morales.tasks.*;
import org.junit.Test;

public class TestPractice3 {

    @Test
    public void negativeTimes(){

        try {
           Task correr = new Task ("Correr",-12);
       }catch (IllegalArgumentException e){
           System.out.println(e);
       }

       try {
            Task correr2 = new Task ("Correr2",0,12,-3);
       }catch (IllegalArgumentException e){
            System.out.println(e);
        }

    }

    @Test
    public void execeIndexOutOf (){
        Task[] hola = new Task[1];
        hola[0] = new Task("Hola task",2);

        Task correr = new Task ("Correr",12);
        Task caminar = new Task ("caminar",32);
        Task dormir = new Task ("dormir",12);

        ArrayTaskList prueba = new ArrayTaskList();
        ArrayTaskList prueba2 = new ArrayTaskList(hola);

        prueba2.add(correr);
        prueba2.add(caminar);
        prueba2.add(dormir);
        prueba2.toPrint();

        System.out.println(prueba.getListOfTasks().length + prueba2.getListOfTasks().length);

        Task task1 = new Task();
        task1 = prueba2.getTask(2);

        try {
            Task task2 = new Task();
            task2 = prueba2.getTask(4);

        } catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }




    }

}
