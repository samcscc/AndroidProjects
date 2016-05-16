package com.androidfundamentals.projecthree;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by staddesse on 5/15/2016.
 */
 public class ToDoCollectionsSorted<ToDo> implements Iterable<ToDo> {

    private TreeSet<ToDo> storage;

    /**
     * The constructor
     */
    public ToDoCollectionsSorted() {
        storage = new TreeSet<ToDo>();
    }


    /**
     * @param item adds a ToDo item
     */
    public void addToDo(ToDo item){
        storage.add(item);
    }

    /**
     * @param toRemove removes the item
     */
    public void remove(ToDo toRemove){
        storage.remove(toRemove);
    }


    /**
     * @return returns a TreeSet collection
     * 		of all the ToDos
     */
    public TreeSet<ToDo> getTheCollectionTreeSet(){
        return storage;
    }

    @Override
    public Iterator<ToDo> iterator() {
        return storage.iterator();
    }
}
