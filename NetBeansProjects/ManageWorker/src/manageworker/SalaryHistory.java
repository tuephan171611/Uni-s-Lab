/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageworker;

/**
 *
 * @author lenovo
 */
public class SalaryHistory {
    Worker worker;
    String status;
    String date;
    public SalaryHistory(Worker worker,String status,String date) {
        this.worker=worker;
        this.status=status;
        this.date=date;
    }

    @Override
    public String toString() {
        return String.format("%-6s%-15s%-15s%-15s%-15s%s",worker.ID,worker.name,worker.age,worker.salary,status,date);
    }
    
}
