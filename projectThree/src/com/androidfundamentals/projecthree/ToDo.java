package com.androidfundamentals.projecthree;

/**
 * Created by staddesse on 5/15/2016.
 */
public class ToDo implements Comparable<ToDo>{
    private String title;
    private String description;
    private int priority;


    /**
     * The constructor of the ToDo
     *
     * @param title	A string title of the ToDo
     * @param description A description of the ToDo created
     * @param priority	A number representing the priority of the ToDo
     */
    public ToDo(final String title, String description, int priority){

        this.title = title;
        this.description = description;
        this.priority = priority;
    }//End of Constructor

    /**
     * Default constructor
     */
    public ToDo(){

    }

    /**
     * Gets the Title
     *
     * @return the Title
     */
    public String getTitle() {return title;}
    /**
     * Gets the Description
     *
     * @return the Description
     */
    public String getDescription(){return description;}
    /**
     * Gets the Priority
     *
     * @return the priority
     */
    public int getPriority() {return priority;}


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }



    @Override
    public String toString() {
        return  title;
    }

    @Override
    public int compareTo(ToDo secondToDo) {
        if (this.getPriority() > secondToDo.getPriority())
            return 1;
        else if (this.getPriority() < secondToDo.getPriority())
            return -1;
        else
        {
            int isSecondSmaller = this.getTitle().compareToIgnoreCase(secondToDo.getTitle());

            if(isSecondSmaller < 0){
                return -1;
            }
            else if(isSecondSmaller > 1){
                return 1;
            }

            else
                return 0;
        }
    }

}
