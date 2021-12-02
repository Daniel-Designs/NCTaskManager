package mx.edu.j2se.morales.tasks;


/**
 * Class ArrayTaskList
 * @author Daniel
 * @version 17.11.2021
 */

public class ArrayTaskList {
    private Task[] listOfTasks;

    /**
     * Empty constructor
     */
    public ArrayTaskList() {
        this.listOfTasks = new Task[0];
    }
    /**
     * Constructor not Empty
     */
    public ArrayTaskList(Task[] listOfTasks) {
        this.listOfTasks = listOfTasks;
    }

    /**
     * Getter for listOfTask array parameter
     *
     * @return Task[]
     */
    public Task[] getListOfTasks() {
        return listOfTasks;
    }

    /**
     * Setter for listOfTask array parameter
     * @param listOfTasks must be an array of Task objects
     */
    public void setListOfTasks(Task[] listOfTasks) {
        this.listOfTasks = listOfTasks;
    }

    /**
     * Function that print on console all objects titles from the array
     */
    public void toPrint(){
        for (int i = 0; i<getListOfTasks().length;i++){
            System.out.println(getListOfTasks()[i].getTitle());
        }
    }

    /**
     * Function that add a new Task object to the array.
     * Using the function System.arraycopy()
     * @param task must be a Task Object
     */
    public void add (Task task) throws IllegalArgumentException{
        if (task == null)
            throw new IllegalArgumentException("Parameter shoul not be null ");
        Task[] listOfTasksNew = new Task[getListOfTasks().length+1];
        listOfTasksNew[getListOfTasks().length] = task;
        System.arraycopy(getListOfTasks(),0,listOfTasksNew,0,getListOfTasks().length);
        setListOfTasks(listOfTasksNew);
        //System.out.println("added at the end");
    }

    /**
     * Funtion that removes from the array all matching task with the task
     * parameter and returns true, in case without matches returns false.
     * @param task must be an Task object
     * @return boolean
     */
    public boolean remove (Task task)throws IllegalArgumentException{
        if(task == null)
            throw new IllegalArgumentException("Parameter shuold not be null");
        Task[] listOfTasksNew;
        boolean removed = false;
       for (int i = 0; i<getListOfTasks().length;i++){
           if(getListOfTasks()[i].equals(task)){
               listOfTasksNew = new Task[getListOfTasks().length-1];
               System.arraycopy(getListOfTasks(),0,listOfTasksNew,0,i);
               System.arraycopy(getListOfTasks(),i+1,listOfTasksNew,i,getListOfTasks().length-(i+1));
               setListOfTasks(listOfTasksNew);
               i--;
               removed =true;
           }

       }
        if(removed) {
            return true;
        }
        return false;
    }

    /**
     * Function that returns the size of the array
     * @return int
     */
    public int size (){
      return getListOfTasks().length;
    }

    /**
     * Function that returns the Task Object selected by the index given
     * @param index
     * @return Task Object
     */
    public Task getTask(int index) throws IndexOutOfBoundsException{
        if(index >= size())
            throw new IndexOutOfBoundsException(Integer.toString(index)+":  exced the bounds");
        return getListOfTasks()[index];
    }

    /**
     * Funtion tha returns a subset of tasks that are scheduled
     * for execution at least once after the "from" time,
     * and not later than the "to" time.
     * @param from must be an int
     * @param to must be an int
     * @return ArrayTaskList Object
     */
    public ArrayTaskList incoming (int from,int to) throws IllegalArgumentException{
        if(from < 0 || to < 0 || from > to)
            throw new IllegalArgumentException("Parameter for calculation should not be negative");

        ArrayTaskList tasksIncoming = new ArrayTaskList();
        for (int i = 0; i<size();i++){

           if(getListOfTasks()[i].nextTimeAfter(from) != -1 && getListOfTasks()[i].nextTimeAfter(from) < to ){
                tasksIncoming.add(getListOfTasks()[i]);
           }
        }
        return tasksIncoming;
    }
}
