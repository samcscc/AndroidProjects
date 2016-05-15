package com.androidfundamentals.projectwo;

/**
 * Created by samson on 5/13/2016.
 */
public class ToDo {
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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ToDo other = (ToDo) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return  title;
    }

}
