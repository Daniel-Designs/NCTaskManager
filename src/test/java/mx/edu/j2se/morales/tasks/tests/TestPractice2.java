package mx.edu.j2se.morales.tasks.tests;

import mx.edu.j2se.morales.tasks.*;
import org.junit.Test;

public class TestPractice2 {

    @Test
    public void test1(){
        Task[] hola = new Task[1];
        hola[0] = new Task("Hola task",2);
        Task correr = new Task ("Correr",12);
        Task caminar = new Task ("caminar",32);
        Task dormir = new Task ("dormir",12);

        //System.out.println(hola[0].getTitle());
        ArrayTaskList prueba = new ArrayTaskList();
        ArrayTaskList prueba2 = new ArrayTaskList(hola);
        System.out.println(prueba.getListOfTasks().length + prueba2.getListOfTasks()[0].getTitle());
        prueba2.add(correr);
        prueba2.add(correr);
        prueba2.add(correr);
        prueba2.add(caminar);
        prueba2.add(dormir);
        prueba2.add(dormir);
        prueba2.add(dormir);
        prueba2.add(dormir);
        System.out.println(prueba2.getListOfTasks().length);
        System.out.println(prueba2.remove(dormir));
        System.out.println(prueba2.getListOfTasks().length);
        prueba2.toPrint();
        System.out.println(prueba2.remove(caminar));
        System.out.println(prueba2.getListOfTasks().length);
        prueba2.toPrint();
        System.out.println(prueba2.remove(correr));
        System.out.println(prueba2.getListOfTasks().length);
        prueba2.toPrint();
        System.out.println(prueba2.remove(hola[0]));
        System.out.println(prueba2.getListOfTasks().length);
        prueba2.toPrint();
        prueba2.add(correr);
        System.out.println(prueba2.getListOfTasks().length);
        System.out.println(prueba2.remove(dormir));
        System.out.println(prueba2.getListOfTasks().length);
        prueba2.toPrint();

        System.out.println(prueba.size());
        System.out.println(prueba2.size());

        Task si = new Task();
        si = prueba2.getTask(0);

    }
    @Test
    public void testObjEqualObj(){
        Task task1 =new Task("Hola task",2);
        Task task2 =new Task("Hola task",5);
        Task task3 =new Task("Hola task1",2);
        Task task4 =new Task();
        if(task1.equals(task3)){
            System.out.println("Si se puede");
        }
        else{
            System.out.println("que pedo");
        }
    }
    @Test
    public void task2test () {

        /*
        Time INITIAL  MARCH 1 00:00
        Time Initial-to August 24, 16:00hrs 176 days = 176*24+16 =4240 hrs
        Time Initial-to sep 1 = 184 days = 184*24 = 4416 hrs
        Time Initial-to August 20, 172 days = 172*24 = 4128 hrs
        Time Initial-to Sep 28, 211 day = 211*24 = 5064 hrs.

        */
        Task task1 = new Task ("Lunch with a beautiful girl",4240);
        Task task2 = new Task ("Morning Runs",0,4416,24);
        Task task3 = new Task ("Taking Medication",4128,5064,12);
        Task task4 = new Task ("Meeting with friends",4434);
        task1.setActive(true);
        task2.setActive(true);
        task3.setActive(true);
        task4.setActive(true);

        ArrayTaskList arrayOfTask = new ArrayTaskList();

        System.out.println(arrayOfTask.getListOfTasks().length);
        arrayOfTask.add(task1);
        arrayOfTask.add(task2);
        arrayOfTask.add(task3);
        arrayOfTask.add(task4);

        System.out.println(arrayOfTask.getListOfTasks().length);
        arrayOfTask.toPrint();
        ArrayTaskList incoming = arrayOfTask.incoming(4260,4280);
        System.out.println("Tareas de la ultima funcion");
        incoming.toPrint();

    }
}
