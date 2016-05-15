package com.androidfundamentals.projectone;

/**
 * Created by samson on 5/13/2016.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class TaskList {

    public static List<String> myList = new ArrayList<String>();
    public static int exitCode;

    public static int display(){
        System.out.println("Please choose an option:\n " +
                "(1) Add a task.\n (2) Remove a task.\n " +
                "(3) Update a task.\n " +
                "(4) List all tasks. " +
                "\n (0) Exit.");

        System.out.println("Enter the user input:" );
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());

    }

    public static boolean addTask(){
        System.out.println("Please enter a new task...");
        Scanner scanner = new Scanner(System.in);
        String newTask = scanner.nextLine();
        return  myList.add(newTask);

    }

    public static String  updateTask(){
        System.out.println("Enter the index number and the new value:");
        Scanner scanner = new Scanner(System.in);
        int updateTasksIndex = Integer.parseInt(scanner.nextLine());
        String updateNewTaskValue = scanner.nextLine();
        return myList.set(updateTasksIndex, updateNewTaskValue);

    }

    public static void getAllTask(){
        int listSize = myList.size();
        System.out.println("The size of the array list is " + listSize);
        // Foreach loop
        for (String allTasks : myList){
            System.out.println("Task list: " + allTasks);
        }

    }
    public static void removeTask(){
        System.out.println("Please remove the task/Enter the index of the task");
        Scanner scanner = new Scanner(System.in);
        int indexNumber = Integer.parseInt(scanner.nextLine());
        myList.remove(indexNumber);
    }

    public static void exit(int status){
        System.out.println("Enter the Exit code");
        Scanner scanner = new Scanner(System.in);
        status = Integer.parseInt(scanner.nextLine());
        exitCode = status;
        System.out.println("Exit from the process.");

    }

    public static void main(String[] args) {
        int userInput = display();

        if (userInput == 1){
            addTask();

        }else if (userInput == 2){

            // calling remove using index
            removeTask();

        }else if (userInput == 3){
            updateTask();


        }else if (userInput == 4){
            getAllTask();

        }else if (userInput == 0){
            exit( exitCode);
        }else{
            exit( exitCode);
        }

    }
}
