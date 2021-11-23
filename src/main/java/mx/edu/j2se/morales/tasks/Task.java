package mx.edu.j2se.morales.tasks;
import com.sun.javafx.binding.StringFormatter;
import com.sun.org.apache.xpath.internal.objects.XObject;

/**
 * Class Task
 * @author Daniel
 * @version 17.11.2021
 */

public class Task {

    private String title;
    private int time;
    private int start;
    private int end;
    private int interval;
    private boolean active;
    private boolean repeat;

    public Task() {
        super();
    }

    /**
     * Constructor non-repetitive Task
     * @param title must be a string
     * @param time must be a int
     */

    public Task(String title, int time) {
        this.title = title;
        this.time = time;
        this.repeat = false;
        this.active = false;
        this.start = 0;
        this.end = 0;
        this.interval = 0;
    }

    /**
     * Constructor repetitive Task
     * @param title must be a string
     * @param start must be an int
     * @param end must be an int
     * @param interval must be an int
     */
    public Task(String title, int start, int end, int interval) {
        this.title = title;
        this.time = 0;
        this.repeat = true;
        this.active = false;
        this.start = start;
        this.end = end;
        this.interval = interval;
    }

    /**
     * Function that returns the title as a String
     * @return String title
     */
    public String getTitle() {return title;}

    /**
     * Setter for title parameter
     * @param title must be a String
     */
    public void setTitle(String title) {this.title = title;}

    /**
     * Function that returns the parameter star if is a repetitive Task.
     * or return the parameter time if is a non-repetitive Task.
     *
     */
    public int getTime() {return isRepeat() ? this.start : this.time ;}

    /**
     * Function that sets the time parameter of non-repetitive tasks,
     * in case of a repetitive task, changes the task to non-repetitive.
     * @param time must be an int
     */
    public void setTime(int time) {
        if (isRepeat()) {
            this.time = time;
            this.repeat = true;
        } else {
            this.time = time;
        }
    }

    /**
     * Function that sets the start, end and interval parameters of a repetitive task,
     * in case of a non-repetitive task, changes the task to repetitive.
     * @param start must be an int
     * @param end must be an int
     * @param interval must be an int
     */
    public void setTime(int start, int end, int interval) {
        if (isRepeat()) {
            this.start = start;
            this.end = end;
            this.interval = interval;
        } else {
            this.start = start;
            this.end = end;
            this.interval = interval;
            setRepeat(true);
        }

    }

    /**
     * Function that returns the start parameter
     * @return returns the start parameter if the task is repetitive or returns the time parameter if it is not.
     */
    public int getStart() {return isRepeat() ? this.start : getTime();}

    /**
     * Setter for start parameter
     * @param start must be an int
     */
    public void setStart(int start) {this.start = start;}

    /**
     * function that returns the end parameter
     * @return returns the end parameter if the task is repetitive or returns the time parameter if it is not.
     */
    public int getEnd() {return isRepeat() ? this.end : getTime() ;}

    /**
     * setter for end parameter
     * @param end must be an int
     */
    public void setEnd(int end) {this.end = end;}

    /**
     * Getter for the interval parameter
     * @return returns the interval parameter if the task is repetitive or returns the 0  if it is not.
     */
    public int getRepeatInterval() {return isRepeat() ? this.interval : 0;}

    /**
     * Setter for interval parameter
     * @param interval must be an int
     */
    public void setInterval(int interval) {
        this.interval = interval;
    }

    /**
     * Getter for active parameter
     * @return a boolean
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Setter for active parameter
     * @param active must be a boolean
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Getter for repeat parameter
     * @return a boolean
     */
    public boolean isRepeat() {
        return repeat;
    }

    /**
     * Setter for repeat parameter
     * @param repeat must be a Boolean.
     */
    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    /**
     * Funtion that indicates you which is the next time for the task,
     * taking as reference the current parameter that you indicate.
     * @param current must be an int
     * @return the next start time of the task execution after the current time,
     * If after the specified time the task is not executed
     * anymore, the method returns -1.
     */
    public int nextTimeAfter(int current) {
        int nexTime = 0;

        if (isActive()){

            if(isRepeat()){

                nexTime=getStart();

                while (getStart()<current && current<getEnd()){

                    nexTime += getRepeatInterval();

                    if(current<nexTime && nexTime<getEnd()){
                        return nexTime;
                    }

                }
                return nexTime;

            }else{
                if(getTime()>current) {
                    return getTime();
                }
            }
    }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task that = (Task) o;
        return title.equals(that.title);
    }
}