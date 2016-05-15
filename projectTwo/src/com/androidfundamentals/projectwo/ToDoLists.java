package com.androidfundamentals.projectwo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by staddesse on 5/15/2016.
 */
public class ToDoLists {
    //Holds all the ToDos
    private static ArrayList<ToDo> ToDoContainer = new ArrayList<ToDo>();
    //private static Scanner scanner = new Scanner(System.in);
    private static String userInput = " ";


    public static void main(String[] args){
        do{
            displayTheMainMenuAtStartScreen();

            switch (userInput){
                case "1":
                    addTask();
                    break;
                case "2":
                    removeTask();
                    break;
                case "3":
                    updateTask();
                    break;
                case "4":
                    listAllTasks();
                    break;
                case "5":
                    listAllTasksOfCertainPriority();
                    break;
            }
            // Exit code
        }while(!userInput.equals("0"));
    }//End of Main


    private static void listAllTasksOfCertainPriority() {
        Scanner scanner = new Scanner(System.in);

        boolean userEnteredWrongInput = true;

        while(userEnteredWrongInput){
            try {
                System.out.println(" Enter a priority");
                int theTaskByPriority = scanner.nextInt();



                for(ToDo item: ToDoContainer){
                    int theIndex = item.getPriority();
                    if (theIndex == theTaskByPriority){
                        userEnteredWrongInput = false;
                        System.out.println("Task Index: "+ ToDoContainer.indexOf(item) + " Name: "+ item.getTitle()
                                + ", Description: "+item.getDescription()
                                + ", Priority: " + item.getPriority());
                    }
                    else{
                        throw new Exception();
                    }
                }

            }
            catch(Exception e){
                System.out.println(" ");
                System.out.println("Error: Priority not found!");
                System.out.println("Please check the value entered for priority.");

            }
        }


    }//End of listAllTasksOfCertainPriority


    private static void listAllTasks() {

        for(ToDo item : ToDoContainer){

            System.out.println("Task Index: "+ ToDoContainer.indexOf(item) + " Name: "+ item.getTitle() + ", Description: "
                    +item.getDescription() + ", Priority: " + item.getPriority());

        }

    }//End of listAllTasks


    private static void updateTask() {
        Scanner scanner = new Scanner(System.in);

        boolean userEnteredWrongInput = true;

        while(userEnteredWrongInput){
            try {

                System.out.println(" Enter the index of the task to update");
                int theIndexOfTheToDoToUpdate = Integer.parseInt(scanner.nextLine());


                int eachIndex = ToDoContainer.size();
                if ((theIndexOfTheToDoToUpdate < (eachIndex-1))||(theIndexOfTheToDoToUpdate > (eachIndex-1))){
                    throw new ArrayIndexOutOfBoundsException();
                }

                System.out.println(" Enter the updated task name: ");
                String newTitle = scanner.nextLine();
                System.out.println(" Enter 3" +
                        "new description: ");
                String newDescription = scanner.nextLine();
                System.out.println("Enter new priority: ");
                int newPriority =scanner.nextInt();
                ToDo updatedOne = new ToDo(newTitle, newDescription, newPriority);
                ToDoContainer.set(theIndexOfTheToDoToUpdate, updatedOne);
                userEnteredWrongInput = false;
                System.out.println(" ToDo has been updated!");
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("The index does not exist");
                System.out.println("Please check the values entered.");

            }
            catch(IllegalArgumentException e){
                System.out.println("Please check the values entered.");
                System.out.println("Enter String for name and description, and int for priority");
            }
        }



    }//End of updateTask


    private static void removeTask() {
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        boolean userEnteredWrongInput = true;

        while(userEnteredWrongInput){
            try {

                System.out.println(" Enter the index of the task to remove");
                index = scanner.nextInt();
                ToDoContainer.remove(index);
                System.out.println("Success!! ToDo has been removed!");
                userEnteredWrongInput = false;
            }

            catch(Exception e){
                System.out.println("Oops! Seems like you entered a wrong value.");
                System.out.println(" Please make sure index in within range.");
                System.out.println("  Enter the index of the task to remove");
                index = scanner.nextInt();
            }
        }

    }//End of removeTask

    private static void addTask() {
        Scanner scanner = new Scanner(System.in);
        String title = " ", description = " ";
        int priority;


        boolean userEnteredWrongInput = true;

        while(userEnteredWrongInput){
            try {

                System.out.println(" Enter the new task's name");
                title = scanner.nextLine();
                System.out.println(" Enter the new task's description");
                description = scanner.nextLine();
                System.out.println(" Enter the new task's priority");
                priority = scanner.nextInt();

                //Add the ToDo to the ToDoContianer
                ToDoContainer.add(new ToDo(title, description, priority));

                userEnteredWrongInput = false;
                System.out.println(" Success!.. new task has been added.");
            }

            catch(Exception e){
                System.out.println("Oops! Seems like you entered a wrong value.");
                System.out.println("Please checck the values entered.");
                System.out.println("Enter String for name and description, and int for priority");
                System.out.println(" Enter a new ToDo");
                priority = scanner.nextInt();
            }
        }// End While


    }//End of addTask

    public static void displayTheMainMenuAtStartScreen(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("	 Android App: ToDostagramV2");
        System.out.println(" ");
        System.out.println("Welcome! Choose from the Menu");
        System.out.println("1. Add a task");
        System.out.println("2. Remove a task");
        System.out.println("3. Update a task");
        System.out.println("4. List tasks");
        System.out.println("5. List tasks of a certain priority");
        System.out.println("0. Exit");
        System.out.println(" ");
        userInput = scanner.nextLine();
        System.out.println("");

    }
}
