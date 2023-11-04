/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab071;

/**
 *
 * @author PC
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DataScanner getdata = new DataScanner();
        TaskManager manager = new TaskManager();
        int choice;

        do {
            //Display menu
            displayMenu();
            // get user choice
            choice = getdata.getInt("Your choice: ", "Choice must be in range [1-4]", 1, 4);
            switch (choice) {
                // 1. Add Task
                case 1:
                    manager.addTask();
                    break;
                // 2. Delete Task
                case 2:
                    manager.deleteTask();
                    break;
                // 3. Display task
                case 3:
                    manager.getDataTasks();
                    break;
                // 4. Exit
                case 4:
                    System.exit(0);
                    break;
            }
        } while (true);
    }

   public static void displayMenu() {
        System.out.println("========= Task Programm ==========");
        System.out.println("\t1. Add Task");
        System.out.println("\t2. Delete Task");
        System.out.println("\t3. Display Task");
        System.out.println("\t4. Exit");
    }
}
