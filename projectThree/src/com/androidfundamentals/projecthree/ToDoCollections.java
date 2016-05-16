package com.androidfundamentals.projecthree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by staddesse on 5/15/2016.
 */
public class ToDoCollections<ToDo> implements Iterable<ToDo>  {
    private TreeSet<ToDo> storage;
    private ArrayList<ToDo> storage2;

    /**
     *  The Constructor: Initializes two storage
     */
    public ToDoCollections() {
        storage = new TreeSet<ToDo>();
        storage2 = new ArrayList<ToDo>();
    }


    /**
     * Constructor Overload
     * @param ToDoContainer takes an ArrayList of ToDos
     */
    public ToDoCollections(ArrayList<ToDo> ToDoContainer) {
        storage2 = ToDoContainer;
        storage = new TreeSet<ToDo>();
    }


    /**
     * @param item add item to both ArrayList and TreeSet
     */
    public void addToDo(ToDo item){
        storage.add(item);
        storage2.add(item);
    }
    /**
     * @param toRemove removes item form both storages
     */
    public void remove(ToDo toRemove){
        storage2.remove(toRemove);
        storage.remove(toRemove);
    }

    /**
     * @return returns an ArrayList Collection of ToDos
     */
    public ArrayList<ToDo> getTheCollectionArrayList(){
        return storage2;
    }

    /**
     * @return returns a TreeSet collection of ToDos
     */
    public TreeSet<ToDo> getTheCollectionTreeSet(){
        return storage;
    }


    @Override
    public Iterator<ToDo> iterator() {
        return new ToDoIterator<ToDo>(this);
    }
}


@SuppressWarnings("hiding")
class ToDoIterator<ToDo> implements Iterator<ToDo>{

    private ArrayList<ToDo> store;
    private int position;

    public ToDoIterator(ToDoCollections<ToDo> ToDoCollections) {
        this.store = (ArrayList<ToDo>) ToDoCollections.getTheCollectionArrayList();
    }

    @Override
    public boolean hasNext() {

        if(position < store.size()){
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public ToDo next() {
        ToDo singleToDo = store.get(position);
        position++;
        return singleToDo;

    }

    public void remove(int position){
        store.remove(position);
    }
}
