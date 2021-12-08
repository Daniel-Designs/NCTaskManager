package mx.edu.j2se.morales.tasks.tests;

import mx.edu.j2se.morales.tasks.LinkedTaskList;
import mx.edu.j2se.morales.tasks.Task;
import org.junit.Test;

public class TestPractice4 {
    @Test
    public void incomingMethodsChecks(){

        LinkedTaskList linked1 = new LinkedTaskList();
        Task task1 = new Task ("Lunch with a beautiful girl",4240);
        Task task2 = new Task ("Morning Runs",0,4416,24);
        Task task3 = new Task ("Taking Medication",4128,5064,12);
        Task task4 = new Task ("Meeting with friends",4434);
        task1.setActive(true);
        task2.setActive(true);
        task3.setActive(true);
        task4.setActive(true);

        linked1.add(task1);
        linked1.add(task1);
        linked1.add(task3);
        linked1.add(task2);
        linked1.add(task3);
        linked1.add(task4);

        LinkedTaskList incoming = linked1.incoming(4260,4280);
        System.out.println("\n Tareas dentro del rango");
        incoming.toPrint();
    }
}
