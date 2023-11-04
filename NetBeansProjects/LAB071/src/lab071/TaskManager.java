/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab071;

import java.util.ArrayList;


/**
 *
 * @author PC
 */
public class TaskManager {

    ArrayList<Task> taskList = new ArrayList<>();
    final DataScanner getdata = new DataScanner();

    public void addTask() {
        System.out.println("--------------Add Task--------------");
        String requirementName = getdata.getStringOnly("Requirement Name: ");
        String taskType = getdata.getTaskType("Task Type: ");
        String date = getdata.getDate("Date: ");
        double planFrom = getdata.getDouble("From: ", "Plan From must be within 8h-17h00", 8.0, 17.0);
        double planTo = getdata.getDouble("To: ", "Plan To must be within From to 17h30", planFrom + 0.5, 17.5); //TODO: from phai <=17
        String assignee = getdata.getStringOnly("Assignee: ");
        String reviewer = getdata.getStringOnly("Reviewer: ");
        boolean isExist = checkDuplicate(date, assignee, planFrom, planTo);
        // check value of variable isExist
        if (isExist) {
            System.out.println("Duplicate!!");
        } else {
            int newTaskId = taskList.size() + 1;
            Task newTask = new Task(newTaskId, taskType, requirementName, date, planFrom, planTo, assignee, reviewer);
            taskList.add(newTask);
            System.out.println("Add successful!!");
        }
    }


    boolean checkDuplicate(String date, String assignee, double planFrom, double planTo) {
        boolean isExist = false;
        // loop use to access each element of arraylist from beggining to the end
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            // compare date in list with date input and assignee in list and assignee input 
            if (date.equals(task.getDate()) && assignee.equals(task.getAssignee())) {
                // compare planTo and planFrom with planFrom and planto in every task in list
                // have date and assignee same with date, assignee input
                /* planTo of object newtask must be less than planFrom in list or planFrom of 
            object newtask must be large tha planto in list */
                if ((planTo < task.getPlanFrom()) || (planFrom > task.getPlanTo())) {
                    isExist = false;
                } else {
                    isExist = true;
                    break;
                }
            }
        }
        return isExist;
    }

    void deleteTask() {
        if (taskList.isEmpty()) {
            System.out.println("Input could not be empty!");
        } else {
            System.out.println("-------Del Task-------");
            int indexInList = -1;
            int TaskId = getdata.getInt("ID: ", "Task id is out of range!", 1, Integer.MAX_VALUE);
            // loop use to access each element of arraylist from beginning to the end
            for (Task task : taskList) {
                //compare variable taskid with every taskId that has in the list
                if (TaskId == task.getTaskID()) {
                    indexInList = taskList.indexOf(task);
                }
            }
            // check indexInList not equal - 1 or not
            if (indexInList != -1) {
                taskList.remove(indexInList);
                System.out.println("Delete successful!");
            } else {
                System.out.println("Id is not equal!");
            }
        }
    }

    public void getDataTasks() {
        if (taskList.isEmpty()) {
            System.out.println("List task is empty!");
        } else {
            System.out.println("--------------------------------------------------Task---------------------------------------------------");
            System.out.format("%-7s%-20s%-12s%-15s%-7s%-15s%-15s\n", "Id", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
            // loop use to access each element of arraylist from begining to end
            for (Task task : taskList) {
                System.out.println(task);
            }
        }

    }
}
