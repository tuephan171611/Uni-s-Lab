package Interface;


import Controller.Manager;
import Controller.Validation;



public class Main {

    public static void main(String[] args) {
        String filename = "student.txt";
        Validation v = new Validation();
        Manager m = new Manager();
        int choice;
        while(true){
            System.out.println("======== WELCOME TO STUDENT MANAGEMENT ========");
            System.out.println("\t1. Create");
            System.out.println("\t2. Find and Sort");
            System.out.println("\t3. Update/Delete");
            System.out.println("\t4. Report");
            System.out.println("\t5. Load File");
            System.out.println("\t6. Save File");
            System.out.println("\t7. Exit");
            System.out.println("");
            System.out.println("(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program)");
            choice = v.getChoice("Your choice: ", 1, 7);
            switch(choice){
                case 1:
                    m.createStudent();
                    break;
                case 2:
                    m.findAndSort();
                    break;
                case 3:
                    m.updateOrDeleteStudent();
                    break;
                case 4:
                    m.report();
                    break;
                case 5:
                    m.readFile(filename);
                    break;
                case 6:
                    m.writeToFile(filename);
                    break;
                case 7:
                    System.out.println("Thanks for using the program!");
                    return;
            }
        }
    }
    
}
