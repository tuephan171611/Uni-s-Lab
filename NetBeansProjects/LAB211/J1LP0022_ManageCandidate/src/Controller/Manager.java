         /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Entity.Candidate;
import Entity.Experience;
import Entity.Fresher;
import Entity.Internship;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author msi
 */
public class Manager {

    Validation val = new Validation();

    public int menu() {
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Searching");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = val.checkInputIntLimit(1, 5);
        return choice;
    }

    //allow user input information common of candidate
    public void createCandidate(ArrayList<Candidate> candidates, int type) {
        while (true) {
            System.out.print("Enter id: ");
            String id = val.checkInputString();
            if (!val.checkIdExist(candidates, id)) {
                return;
            }
            System.out.print("Enter first name: ");
            String firstName = val.checkInputString();
            System.out.print("Enter last name: ");
            String lastName = val.checkInputString();
            System.out.print("Enter birth year: ");
            int birthDate = val.checkInputIntLimit(1900, Calendar.getInstance().get(Calendar.YEAR));
            System.out.print("Enter address: ");
            String address = val.checkInputString();
            System.out.print("Enter phone: ");
            String phone = val.checkInputPhone();
            System.out.print("Enter email: ");
            String email = val.checkInputEmail();
            Candidate candidate = new Candidate(id, firstName, lastName, birthDate, address, phone, email, type);
            switch (type) {
                case 0:
                    System.out.print("Enter year of experience: ");
                    int yearExperience = val.checkInputExprience(candidate.getBirthDate());
                    System.out.print("Enter professional skill: ");
                    String professionalSkill = val.checkInputString();
                    candidates.add(new Experience(yearExperience, professionalSkill, candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
                    System.err.println("Create success.");
                    break;
                case 1:
                    System.out.print("Enter graduation date: ");
                    String graduationDate = val.checkInputString();
                    System.out.print("Enter graduation rank: ");
                    String graduationRank = val.checkInputGraduationRank();
                    candidates.add(new Fresher(graduationDate, graduationRank, candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
                    System.err.println("Create success.");
                    break;
                case 2:
                    System.out.print("Enter major: ");
                    String major = val.checkInputString();
                    System.out.print("Enter semester: ");
                    String semester = val.checkInputString();
                    System.out.print("Enter university: ");
                    String university = val.checkInputString();
                    candidates.add(new Internship(major, semester, university, candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
                    System.err.println("Create success.");
                    break;
            }
            System.out.print("Do you want to continue (Y/N): ");
            if (!val.checkInputYN()) {
                return;
            }
        }
    }

    public void searchCandidate(ArrayList<Candidate> candidates) {
        if (candidates.isEmpty()) {
            System.out.println("List empty");
        } else {
            printListNameCandidate(candidates);
            System.out.print("Enter candidate name (First name or Last name): ");
            String nameSearch = val.checkInputString().toUpperCase();
            System.out.print("Enter type of candidate: ");
            int typeCandidate = val.checkInputIntLimit(0, 2);
            int count = 0;
            for (Candidate candidate : candidates) {
                if (candidate.getTypeCandidate() == typeCandidate
                        && (candidate.getFirstName().toUpperCase().contains(nameSearch) || candidate.getLastName().toUpperCase().contains(nameSearch))) {
                    System.out.println(candidate.toString());
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Not found");
            }
        }
    }

    public void printListNameCandidate(ArrayList<Candidate> candidates) {
        System.out.println("====== Experience Candidate ======");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.out.println("====== Fresher Candidate ======");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.out.println("====== Internship Candidate ======");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Internship) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
    }
}
