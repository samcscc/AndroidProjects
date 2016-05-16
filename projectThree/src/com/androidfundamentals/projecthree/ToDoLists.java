package com.androidfundamentals.projecthree;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by staddesse on 5/15/2016.
 */
public class ToDoLists {
    //Holds all the ToDos
    private static ArrayList<ToDo> ToDoContainer = new ArrayList<ToDo>();
    private static ToDoCollectionsSorted<ToDo> ToDoContainer2 = new ToDoCollectionsSorted<ToDo>();
    //private static Scanner scanner = new Scanner(System.in);
    private static String userInput = " ";




    /**
     * Entry point of the program
     *
     * @param args not used by the program
     */
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
                case "6":
                    listAllTasksByPriority();
                    break;
            }

        }while(!userInput.equals("0"));
    }//End of Main



    // LIST ALL TASK BY PRIORITY
    private static void listAllTasksByPriority() {

        for(ToDo item: ToDoContainer2 ){
            System.out.println("Priority: " + item.getPriority() + " Title: "+ item.getTitle()+ " Decription: " + item.getDescription());
        }

    }


    // listAllTasksOfCertainPriority
    private static void listAllTasksOfCertainPriority() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        boolean userEnteredWrongInput = true;

        while(userEnteredWrongInput){
            try {
                System.out.println(" Enter a priority");
                int theTaskByPriority = scanner.nextInt();


                for(ToDo item: ToDoContainer){
                    if (item.getPriority() == theTaskByPriority){
                        System.out.println("Task Index: "+ ToDoContainer.indexOf(item) + " Name: "+ item.getTitle()
                                + ", Description: "+item.getDescription()
                                + ", Priority: " + item.getPriority());
                        userEnteredWrongInput = false;
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
                System.out.println(" ");

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
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        boolean userEnteredWrongInput = true;

        while(userEnteredWrongInput){
            try {

                System.out.println(" Enter the index of the task to update");
                int index = Integer.parseInt(scanner.nextLine());

                ToDo removed = ToDoContainer.get(index);
                ToDoContainer2.remove(removed);

                int eachIndex = ToDoContainer.size();
                if (!(index >= 0 && index <= eachIndex-1)){
                    throw new ArrayIndexOutOfBoundsException();
                }

                System.out.println(" Enter new name: ");
                String newTitle = scanner.nextLine();
                System.out.println(" Enter new description: ");
                String newDescription = scanner.nextLine();
                System.out.println("Enter new priority: ");
                int newPriority =scanner.nextInt();

                ToDoContainer.set(index, new ToDo(newTitle, newDescription, newPriority));

                //Add and update new ToDo to TreeSet
                ToDoContainer2.addToDo(new ToDo(newTitle, newDescription, newPriority));


                userEnteredWrongInput = false;
                System.out.println(" ToDo has been updated!");
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("The index does not exist");
                System.out.println("Please check the values entered.");
                System.out.println(" ");

            }
            catch(IndexOutOfBoundsException e){
                System.out.println("The index does not exist");
                System.out.println("Please check the value entered for index. Ensure it is within index range.");
                System.out.println(" ");
            }
            catch(IllegalArgumentException e){
                System.out.println("Please check the values entered.");
                System.out.println("Enter String for name and description, and int for priority");
                System.out.println(" ");
            }
        }



    }//End of updateTask


    private static void removeTask() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        boolean userEnteredWrongInput = true;

        while(userEnteredWrongInput){
            try {

                System.out.println(" Enter the index of the task to remove");
                index = scanner.nextInt();

                ToDo removed = ToDoContainer.get(index);
                ToDoContainer2.remove(removed);
                ToDoContainer.remove(index);



                System.out.println("Success!! ToDo has been removed!");
                userEnteredWrongInput = false;
            }

            catch(Exception e){
                System.out.println("Oops! Seems like you entered a wrong value.");
                System.out.println(" Please make sure index in within range.");
                System.out.println(" ");
                System.out.println("  Enter the index of the task to remove");
                index = scanner.nextInt();
            }
        }

    }//End of removeTask




    private static void addTask() {
        @SuppressWarnings("resource")
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
                priority = Integer.parseInt(scanner.nextLine());


                //Add the ToDo to the ToDoContianer
                ToDoContainer.add(new ToDo(title, description, priority));
                ToDoContainer2.addToDo(new ToDo(title, description, priority));

                userEnteredWrongInput = false;
                System.out.println(" Success!.. new task has been added.");
            }

            catch(InputMismatchException e) {
                System.out.println("Error! Please enter only numbers for priority");
                System.out.println(" ");
                System.out.println("Enter new values... ");
                System.out.println(" ");
            }
            catch(NumberFormatException e) {
                System.out.println("Error! Please enter only numbers for priority");
                System.out.println(" ");
                System.out.println("Enter new values... ");
                System.out.println(" ");
            }

        }// End While


    }//End of addTask


    /**
     * The start of the program
     *
     */
    public static void displayTheMainMenuAtStartScreen(){
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("	 Android App: ToDostagramV4  Build: 1.4.4.14.2016");
        System.out.println(" ");
        System.out.println("please, Choose from the Menu");
        System.out.println("1. Add a task");
        System.out.println("2. Remove a task");
        System.out.println("3. Update a task");
        System.out.println("4. List tasks");
        System.out.println("5. List tasks of a certain priority");
        System.out.println("6. List all tasks by priority   (NEW*)");
        System.out.println("0. Exit");
        System.out.println(" ");
        userInput = scanner.nextLine();
        System.out.println("");

    }//
}
