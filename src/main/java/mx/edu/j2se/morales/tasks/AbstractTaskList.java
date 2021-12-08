package mx.edu.j2se.morales.tasks;

import java.util.AbstractList;

public abstract class AbstractTaskList {

    public abstract void add(Task task)throws IllegalArgumentException;
    public abstract boolean remove(Task task)throws IllegalArgumentException;
    public abstract int size();
    public abstract Task getTask(int index) throws Exception;
    public abstract void toPrint();
    public abstract AbstractTaskList incoming (int from, int to);

    //public abstract ArrayTaskList incoming (int from,int to);
    //public abstract LinkedTaskList incoming (int from,int to);

}
