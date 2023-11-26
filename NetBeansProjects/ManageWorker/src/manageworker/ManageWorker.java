/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageworker;

import java.io.File;
import java.util.*;

/**
 *
 * @author lenovo
 */
public class ManageWorker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WorkerList list=new WorkerList();
        File f=new File("WorkerID.txt");
        ArrayList<Worker> workerList=new ArrayList();
        ArrayList<SalaryHistory> historyList=new ArrayList();
        do{
            //Step 1:Display menu
            displayMenu();
            //Step 2:Allow user to select an option
            int choice=inputChoice();
            switch(choice){
                //Opt 1:Add worker
                case 1:list.addWorker(workerList,f);break;
                //Opt 2:increase salary
                case 2:list.increaseSalary(workerList,historyList,f);break;
                //Opt 3:decrease salary
                case 3:list.decreaseSalary(workerList,historyList,f);break;
                //Opt 4:display adjusted worker
                case 4:list.displayWorker(historyList);break;
                //Opt 4:Exit the program
                case 5:System.exit(0);
            }
        }while(true);
    }

    private static void displayMenu() {
        System.out.println("========= Task program =========");
        System.out.println("1. Add Worker");
        System.out.println("2. Up salary");
        System.out.println("3. Down salary");
        System.out.println("4. Display Information salary");
        System.out.println("5. Exit");
    }

    private static int inputChoice() {
        do{
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter your choice: ");
            String choice=sc.nextLine();
            if(choice.isEmpty()){
                System.out.println("Please enter your choice!");
            }
            else{
                if(choice.matches("[1-5]"))return Integer.parseInt(choice);
                System.out.println("Please choose 1-5!");
            }
        }while(true);
    }
    
}
