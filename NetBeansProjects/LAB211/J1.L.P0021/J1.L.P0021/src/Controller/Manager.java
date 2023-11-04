package Controller;

import Entity.Report;
import Entity.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Manager {

    Validation validation = new Validation();
    ArrayList<Student> list = new ArrayList<>();

    /**
     * This main create students to method
     */
    public void createStudent() {
        String id, course, semester, studentName = "";
        displayStudent(list);
        System.out.println("==========Create Student==============");
        //If the list has more than 10 to input
        while (true) {
            if (list.size() > 10) {
                //If don't return 
                if (!validation.checkInputYN("Do you want to continue (Y/N): ")) {
                    //Print the list of student
                    displayStudent(list);
                    return;
                }
            }
            //Input the student ID
            id = validation.checkInputString("Enter ID(HExxxxxx): ", "^[A-Za-z]{2}[0-9]{6}+$");
            //Get ID student on the list
            Student student = getStudentById(list, id);
            //If get information to get ID student
            while (student != null) {
                System.out.println("Student with id " + id + " existed");
                //Check if the user want to use
                if (!validation.checkInputYN("Do you want to use this Student (Y/N): ")) {
                    //If don't get the other ID
                    id = validation.checkInputString("Enter ID(HExxxxxx): ", "^[A-Za-z]{2}[0-9]{6}+$");
                    student = getStudentById(list, id);
                } else {
                    //Using the ID
                    studentName = student.getStudentName();
                    break;
                }
            }
            //If id don't have get the id
            if (student == null) {
                studentName = validation.checkInputString("Enter Name: ", "^[A-Za-z\\s]+$");
            }
            //Input the other information
            semester = validation.checkInputString("Enter Semester(0-9): ", "[0-9]");
            course = validation.checkInputCourse("Enter course(Java, .NET, C/C++): ");
            //Check the list if have that information
            if (!isDuplicate(list, id, studentName, semester, course)) {
                //If have fault check the information
                System.err.println("Duplicated!! Records arealdy have in database");
            } else {
                //If don't add the list
                list.add(new Student(id, studentName, semester, course));
                System.out.println("Successfully create student");
            }
        }
    }

    /**
     * The main display the list of student
     *
     * @param list the list of student
     */
    public void displayStudent(ArrayList<Student> list) {
        System.out.println("==============Student List================");
        System.out.printf("%-20s%-20s%-15s%-15s\n", "ID", "studentName", "Semester", "Course");
        for (Student student : list) {
            student.displayAll();
        }
    }

    /**
     * This main sort list the student name
     *
     * @param list the list student name
     */
    public void sortListStudent(ArrayList<Student> list) {
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student t, Student t1) {
                return t.getStudentName().compareTo(t1.getStudentName());
            }
        });
    }

    /**
     * This main displays to find and sort Prompts the user to enter a name to
     * search for in the list, then displays the sorted list of students
     * matching the search.
     */
    public void findAndSort() {
        //If empty return the screen to input
        if (list.isEmpty()) {
            System.err.println("List is empty, must create student");
            return;
        }
        displayStudent(list);
        //Input the id student to find
        String name;
        name = validation.checkInputString("Enter the name to find: ", "^[A-Za-z\\s]+$");
        //Create the new list to store the l
        ArrayList<Student> listStudentFindByName = new ArrayList<>();
        for (Student student : list) {
            //If the list has the name of student to add and print 
            if (student.getStudentName().toUpperCase().contains(name.toUpperCase())) {
                listStudentFindByName.add(student);
            }
        }
        //If it has the list of student then print and sort them
        if (!listStudentFindByName.isEmpty()) {
            System.out.println("--------List sorted by name----------");
            sortListStudent(listStudentFindByName);
            System.out.printf("%-20s%-15s%-15s\n", "StudentName", "Semester", "CourseName");
            for (Student student : listStudentFindByName) {
                student.displayFindAndSort();
            }
            //If don't find the student ID return the screen
        } else {
            System.err.println("Not exist student");
        }
    }

    /**
     * This main prints the ID of student and find the ID
     *
     * @param listStudentFindByID print and find the ID student
     */
    public void displayStudentWithSearchID(ArrayList<Student> listStudentFindByID) {
        System.out.println("---------List student found by ID--------------");
        System.out.printf("%-10s%-20s%-15s%-15s\n", "STT", "studentName", "Semester", "Course");
        for (int i = 0; i < listStudentFindByID.size(); i++) {

            System.out.printf("%-10s%-20s%-15s%-15s\n", i + 1, listStudentFindByID.get(i).getStudentName(),
                    listStudentFindByID.get(i).getSemester(), listStudentFindByID.get(i).getCourseName());
        }
    }

    /**
     * This main display update or delete student ID
     */
    public void updateOrDeleteStudent() {
        String updateID, updateName, updateSemester, updateCourse, searchID;
        int searchIndex;
        displayStudent(list);
        //If the list is null return the screen
        if (list.isEmpty()) {
            System.err.println("List is empty. Must create student ");
            return;
        }
        //Input the ID student to update or delete
        searchID = validation.checkInputString("Enter ID to update or delete: ", "^[A-Za-z]{2}[0-9]{6}+$");
        //If the ID has don't print and reinput
        while (!checkIDExist(list, searchID)) {
            System.err.println("Id not found, please enter again");
            searchID = validation.checkInputString("Enter ID to update or delete: ", "^[A-Za-z]{2}[0-9]{6}+$");
        }
        //Create a new list student ID to print
        ArrayList<Student> listStudentFindByID = new ArrayList<>();
        for (Student student : list) {
            //If ID is on database add and print
            if (student.getId().equalsIgnoreCase(searchID)) {
                listStudentFindByID.add(student);
            }
        }
        //If the ID is in the list then print and display the ID in a new list
        if (listStudentFindByID.isEmpty()) {
            System.err.println("Not found student to update or delete");
        } else {
            displayStudentWithSearchID(listStudentFindByID);
        }
        //Choose to update or delete
        System.out.println("===== Update or Delete Student ======");
        if (validation.checkInputUD("Do you want to update (U) or delete (D) student: ")) {
            //update student section
            System.out.println("=============Update================");
            searchIndex = validation.getChoice("Enter number of student you want to update [1, " + listStudentFindByID.size() + "]: ", 1, listStudentFindByID.size());
            Student s = listStudentFindByID.get(searchIndex - 1);
            updateID = validation.checkInputString("Enter ID to update: ", "^[A-Za-z0-9]+$");
            Student sUpdate = getStudentById(list, updateID);
            //Nếu the ID student has the list then use them
            if (sUpdate != null) {
                System.out.println("Student with id " + updateID + " existed");
                s.setStudentName(sUpdate.getStudentName());
                //If IDs dont'exist, update student ID in a new list
            } else {
                updateName = validation.checkInputString("Enter Name to update: ", "^[A-Za-z\\s]+$");
                s.setStudentName(updateName);
            }
            //Input the semester and course
            updateSemester = validation.checkInputString("Enter Semester(0-9): ", "[0-9]");
            updateCourse = validation.checkInputCourse("Enter course(Java, .NET, C/C++): ");
            //Check the list of student, if error then reinput
            while (!isDuplicate(list, updateID, updateSemester, updateCourse)) {
                System.err.println("Duplicated!! Records arealdy have in database");
                updateSemester = validation.checkInputString("Enter Semester(0-9): ", "[0-9]");
                updateCourse = validation.checkInputCourse("Enter course(Java, .NET, C/C++): ");
            }
            //If the lists don't exist, reinput
            s.setId(updateID);
            s.setSemester(updateSemester);
            s.setCourseName(updateCourse);
            System.out.println("Update successfully");
            //Delete student section
        } else {
            System.out.println("==============Delete=============");
            //Choose the new ID student to input from file 
            searchIndex = validation.getChoice("Enter number of student you want to delete [1, " + listStudentFindByID.size() + "]: ", 1, listStudentFindByID.size());
            //Get object
            Student s = listStudentFindByID.get(searchIndex - 1);
            //Remove object
            list.remove(s);
            System.out.println("Delete sucessfully");
        }
    }

    /**
     * This main displays the report of list student
     */
    public void displayReport() {
        String name, course;
        int totalCourse;
        ArrayList<Student> searchList = new ArrayList<>();
        ArrayList<Report> reportList = new ArrayList<>();
        System.out.printf("%-20s%-15s%-15s\n", "studentName", "Course", "Total Course");
        //Create an array list of student
        for (Student student : list) {
            searchList.add(student);
        }
        //Compare 2 list of student
        for (Student student : list) {
            totalCourse = 0;
            name = student.getStudentName();
            course = student.getCourseName();
            for (int i = 0; i < searchList.size(); i++) {
                //If the name and course are same, couses is upgraded
                if (searchList.get(i).getStudentName().equalsIgnoreCase(name) && searchList.get(i).getCourseName().equalsIgnoreCase(course)) {
                    totalCourse++;
                    searchList.remove(i);
                    i--;
                }
            }
            //After running, count the total courses of a student register
            //Add total course into report list
            reportList.add(new Report(name, course, totalCourse));
        }
        //If the report list has total couse to reinput them
        for (Report report : reportList) {
            if (report.getTotalCourse() != 0) {
                report.displayReport();
            }
        }
    }

    /**
     * This main displays the report of ID student
     */
    public void report() {
        //if the lists of student is empty, then exits and input the student
        if (list.isEmpty()) {
            System.err.println("List is empty, must create student");
            return;
        }
        //In ra report
        System.out.println("---------------Report---------------");
        displayReport();
    }

    /**
     * This main check the list of students
     *
     * @param list print the list of students
     * @param id print the ID students
     * @param studentName print the student name
     * @param semester print the number of semester
     * @param courseName print the course name
     * @return
     */
    public boolean isDuplicate(ArrayList<Student> list, String id, String studentName, String semester, String courseName) {
        for (Student student : list) {
            if (id.equalsIgnoreCase(student.getId())
                    && studentName.equalsIgnoreCase(student.getStudentName())
                    && semester.equalsIgnoreCase(student.getSemester())
                    && courseName.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }

    /**
     * This main displays the student ID
     *
     * @param list list of the student ID
     * @param id id of the student
     * @return
     */
    public Student getStudentById(ArrayList<Student> list, String id) {
        for (Student student : list) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }

    /**
     * This main checks the ID is exits or not
     *
     * @param list list of student ID
     * @param id list of the ID student
     * @return
     */
    public boolean checkIDExist(ArrayList<Student> list, String id) {
        for (Student student : list) {
            if (student.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This main check the ID student can be existed again
     *
     * @param list list of student ID
     * @param updateID update the student ID
     * @param updateSemester update the semester
     * @param updateCourse update the total number and name of the course on a
     * semester
     * @return
     */
    public boolean isDuplicate(ArrayList<Student> list, String updateID, String updateSemester, String updateCourse) {
        for (Student student : list) {
            if (updateID.equalsIgnoreCase(student.getId())
                    && updateSemester.equalsIgnoreCase(student.getSemester())
                    && updateCourse.equalsIgnoreCase(student.getCourseName())) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method writes the student data to a file.
     *
     * @param filename The name of the file to write the data to.
     */
    public void writeToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("ID|Student Name|Semester|Course Name");
            writer.newLine();

            for (Student student : list) {
                writer.write(student.getId() + "|" + student.getStudentName() + "|"
                        + student.getSemester() + "|" + student.getCourseName());
                writer.newLine();
            }

            System.out.println("Data has been written to the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    /**
     * This method reads student data from a file and adds it to the list.
     *
     * @param filename The name of the file to read data from.
     */
    public void readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine(); // Skip the header line

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length == 4) {
                    String id = data[0].trim();
                    String studentName = data[1].trim();
                    String semester = data[2].trim();
                    String courseName = data[3].trim();

                    // Create a new Student object with the read data
                    Student student = new Student(id, studentName, semester, courseName);
                    list.add(student);
                    // Perform further operations with the student object as needed
                    // Example: Add the student to a list or display the student's information
                }
            }

            System.out.println("Data has been read from the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
