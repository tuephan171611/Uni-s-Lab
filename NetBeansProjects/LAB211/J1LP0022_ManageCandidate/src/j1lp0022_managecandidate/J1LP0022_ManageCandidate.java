/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package j1lp0022_managecandidate;

import Controller.Manager;
import Entity.Candidate;
import Entity.Experience;
import Entity.Fresher;
import Entity.Internship;
import java.util.ArrayList;

/**
 *
 * @author msi
 */
public class J1LP0022_ManageCandidate {

    public static void main(String[] args) {
        ArrayList<Candidate> candidates = new ArrayList<>();
        Manager manager = new Manager();
        //loop until user want to exit
        candidates.add(new Experience(99, "code", "1", "Pham Ngoc", "Hoa", 1991, "Ninh Binh", "0968038714", "ngochoa@gmail.com", 0));
        candidates.add(new Experience(99, "code", "1", "Duy", "Anh", 2003, "Ha Noi", "0911781973", "trungkien@gmail.com", 0));
        candidates.add(new Fresher("2000", "good", "2", "Đo Quang", "Hiep", 1995, "Ha Noi", "0984481349", "quanghiep@gmail.com", 1));
        candidates.add(new Internship("PRJ311", "Spring", "FPT University", "3", "Trieu Dinh", "Duy Anh", 2018, "Ha Noi", "0986246813", "duyanh@gmail.com", 2));
        while (true) {
            int choice = manager.menu();
            switch (choice) {
                case 1:
                    manager.createCandidate(candidates, 0);
                    break;
                case 2:
                    manager.createCandidate(candidates, 1);
                    break;
                case 3:
                    manager.createCandidate(candidates, 2);
                    break;
                case 4:
                    manager.searchCandidate(candidates);
                    break;
                case 5:
                    return;
            }
        }
    }
}
