package mobile.cantusolutions.tasker;

import java.util.Date;

/**
 * Created by DCantu on 17/05/16.
 */
public class Task_element {
    private int ID;
    private String Name;
    private String Desc;
    private String date;
    private int Remind;
    private int Progress;
    private int Category;

    public Task_element(){}

    public Task_element(String name, String desc, String d, int remind, int progress, int category){
        this.Name = name;
        this.Desc = desc;
        this.date = d;
        this.Remind = remind;
        this.Progress = progress;
        this.Category = category;
    }

    public int getID(){
        return this.ID;
    }

    public String getName(){
        return this.Name;
    }

    public String getDesc(){
        return this.Desc;
    }

    public String getDate(){
        return this.date;
    }

    public int getRemind(){
        return this.Remind;
    }

    public int getProgress(){
        return this.Progress;
    }

    public int getCategory(){
        return this.Category;
    }

    public void setID(int id){
        this.ID = id;
    }

    public void setName(String name){
        this.Name = name;
    }

    public void setDesc(String desc){
        this.Desc = desc;
    }

    public void setDate(String d){
        this.date = d;
    }

    public void setRemind(int remind){
        this.Remind = remind;
    }

    public void setProgress(int progress){
        this.Progress = progress;
    }

    public void setCategory(int category){
        this.Category = category;
    }
}
