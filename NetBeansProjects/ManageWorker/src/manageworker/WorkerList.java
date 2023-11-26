/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageworker;
import java.util.*;
import java.io.*;
import java.text.*;
/**
 *
 * @author lenovo
 */
public class WorkerList {
    
    void addWorker(ArrayList<Worker> workerList,File f) {
        String ID=inputID(f);
        String name=inputName();
        int age=inputAge();
        double salary=inputSalary();
        String workLocation=inputLocation();
        Worker worker=new Worker(ID, name, age, salary, workLocation);
        workerList.add(worker);
        writeFile(workerList,f);
    }
    Scanner sc=new Scanner(System.in);
    private String inputID(File f) {
        do{
            System.out.print("Enter Code: ");
            String ID=sc.nextLine();
            if(!ID.isEmpty()){
                if(findWorker(ID,f)==null)return ID;
                else System.out.println("ID is duplicated!");
            }
            System.out.println("Please enter code!");
        }while(true);
    }
    private String inputName() {
        //Allow user enter till correct format of Name
        do{
            System.out.print("Enter Name: ");
            String Name=sc.nextLine();
            //Case: user input nothing
            if(Name.isEmpty()){
                System.out.println("Please enter name!");
            }
            //Case: user input string that not have word only
            else{ 
                if(Name.matches("[a-zA-Z\\s]+")) return Name;
                else System.out.println("Name contain letters only!");
            }
        }while(true);
    }

    private int inputAge() {
        do{
            System.out.print("Enter Age: ");
            String age=sc.nextLine();
            if(age.isEmpty())System.out.println("Please enter age!");
            else{
                if(age.matches("[1-9][0-9]*")){
                    int num=Integer.parseInt(age);
                    if(num>=18&&num<=50)return num;
                    else System.out.println("Age must be in range 18 to 50!");
                }
                else System.out.println("Age must be positive number");
            }
        }while(true);
    }

    private double inputSalary() {
        do{
            System.out.print("Enter Salary: ");
            String age=sc.nextLine();
            if(age.isEmpty())System.out.println("Please enter salary!");
            else{
                if(age.matches("[-]?[1-9][0-9]*||[0]")){
                    int num=Integer.parseInt(age);
                    if(num>0)return num;
                    else System.out.println("Salary must be greater than 0!");
                }
                else System.out.println("Salary must be digit!");
            }
        }while(true);
    }

    private String inputLocation() {
        do{
            System.out.print("Enter work locaion: ");
            String location=sc.nextLine();
            if(!location.isEmpty()){
                return location;
            }
            System.out.println("Please enter work location!");
        }while(true);
    }

    private void writeFile(ArrayList<Worker> workerList,File f) {
        try {
            OutputStream os= new FileOutputStream(f);
            ObjectOutputStream oos=new ObjectOutputStream(os);
            for(Worker worker:workerList){
                oos.writeObject(worker);
            }
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private Worker findWorker(String ID,File f) {
        if(f.length()==0)return null;         
        try{
            InputStream is=new FileInputStream(f);
            ObjectInputStream ois=new ObjectInputStream(is);
            while(is.available()>0){
                Worker oldWorker=(Worker) ois.readObject();
                if(oldWorker.ID.equals(ID)){
                    ois.close();
                    return oldWorker;
                }
            }
            ois.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    void increaseSalary(ArrayList<Worker> workerList,ArrayList<SalaryHistory> historyList,File f) {
        System.out.println("------- Up Salary -------");
        //Allow user to enter valid ID
        Worker worker=null;
        do{
            System.out.print("Enter Code: ");
            String ID=sc.nextLine();
            if(!ID.isEmpty()){
                worker=findWorker(ID,f);
                if(worker!=null)break;
                else System.out.println("ID not exist!");
            }
            else System.out.println("Please enter code!");
        }while(true);
        do{
            System.out.print("Enter Salary: ");
            String num=sc.nextLine();
            if(num.isEmpty())System.out.println("Please enter salary!");
            else{
                if(num.matches("[-]?[1-9][0-9]*||[0]")){
                    int salary=Integer.parseInt(num);
                    if(salary>0){
                        worker.salary=worker.salary+salary;
                        writeFile(workerList,f);
                        String date=getCurDate();
                        SalaryHistory history=new SalaryHistory(worker, "UP", date);
                        historyList.add(history);
                        break;
                    }
                    else System.out.println("Salary must be greater than 0!");
                }
                else System.out.println("Salary must be digit!");
            }
        }while(true);
    }
    void decreaseSalary(ArrayList<Worker> workerList,ArrayList<SalaryHistory> historyList,File f) {
        System.out.println("------- Down Salary -------");
        //Allow user to enter valid ID
        Worker worker=null;
        do{
            System.out.print("Enter Code: ");
            String ID=sc.nextLine();
            if(!ID.isEmpty()){
                worker=findWorker(ID,f);
                if(worker!=null)break;
                else System.out.println("ID not exist!");
            }
            System.out.println("Please enter code!");
        }while(true);
        do{
            System.out.print("Enter Salary: ");
            String num=sc.nextLine();
            if(num.isEmpty())System.out.println("Please enter salary!");
            else{
                if(num.matches("[1-9][0-9]*||[0]")){
                    int salary=Integer.parseInt(num);
                    if(salary>0){
                        if(salary<worker.salary) {
                            worker.salary=worker.salary-salary;
                            writeFile(workerList,f);
                            String date=getCurDate();
                            SalaryHistory history=new SalaryHistory(worker, "DOWN", date);
                            historyList.add(history);
                            break;
                        }
                        else System.out.println("New salary must be smaller than old one (<"+worker.salary+")!");
                    }
                    else System.out.println("Salary must be greater than 0!");
                }
                else System.out.println("Salary must be digit!");
            }
        }while(true);
    }
    private String getCurDate() {
        Date date=new Date();
        DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        return df.format(date);
    }

    void displayWorker(ArrayList<SalaryHistory> historyList) {
        System.out.println("---------------------Display Information Salary---------------------");
        System.out.printf("%-6s%-15s%-15s%-15s%-15s%s\n","Code","Name","Age","Salary","Status","Date");
        for(SalaryHistory history:historyList){
            System.out.println(history.toString());
        }
    }
    
}
