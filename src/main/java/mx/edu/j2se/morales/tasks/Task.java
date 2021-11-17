package mx.edu.j2se.morales.tasks;

import com.sun.javafx.binding.StringFormatter;

public class Task {
    //Atributos de la clase
    private String title;
    private int time;
    private int start;
    private int end;
    private int interval;
    private boolean active;
    private boolean repeat;


    //Constructor
    public Task(String title, int time) {
        this.title = title;
        this.time = time;
        this.repeat = false;
        this.active = false;
        this.start = 0;
        this.end = 0;
        this.interval = 0;
    }

    public Task(String title, int start, int end, int interval) {
        this.title = title;
        this.time = 0;
        this.repeat = true;
        this.active = false;
        this.start = start;
        this.end = end;
        this.interval = interval;
    }

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public int getTime() {return isRepeat() ? this.start : this.time ;}

    public void setTime(int time) {
        if (isRepeat()) {
            this.time = time;
            this.repeat = true;
        } else {
            this.time = time;
        }
    }

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

    public int getStart() {return isRepeat() ? this.start : getTime();}

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {return isRepeat() ? this.end : getTime() ;}

    public void setEnd(int end) {
        this.end = end;
    }

    public int getRepeatInterval() {return isRepeat() ? this.interval : 0;}

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isRepeat() {
        return repeat;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

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
}