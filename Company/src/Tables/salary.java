package Tables;

import Main.Company;

import java.io.IOException;

public class salary {
    private int employeeID;
    private int baseSalary;
    private int variable;
    private int total;

    public salary() {

    }

    public int getEmployeeID() {
        return employeeID;
    }

    protected void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getBaseSalry() {
        return baseSalary;
    }

    protected void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getVariable() {
        return variable;
    }

    protected void setVariable(int variable) {
        this.variable = variable;
    }

    public int getTotal() {
        return total;
    }

    protected void setTotal(int total) {
        this.total = total;
    }

    public salary(int employeeID, int baseSalary, int variable) {
        this.employeeID = employeeID;
        this.baseSalary = baseSalary;
        this.variable = variable;
    }

    public void setSalary() throws IOException {
        System.out.println("Please enter the employee ID:");
        this.setEmployeeID(Integer.parseInt(Company.br.readLine()));
        System.out.println("Please enter the base salary:");
        this.setBaseSalary(Integer.parseInt(Company.br.readLine()));
        System.out.println("Please enter the variable:");
        this.setVariable(Integer.parseInt(Company.br.readLine()));
    }
    public void InsertSalary(){
        String t="Insert Into salary(employeeID, baseValue, variable) Values("+this.getEmployeeID()+" , "+this.getBaseSalry()+
                " , "+this.getVariable()+");";
        Company.execute(t);
    }
    public void UpdateSalary() throws IOException {
        System.out.println("please enter the ID of the employee you want to update the salary for:");
        int id=Integer.parseInt(Company.br.readLine());
        String t="Update salary Set baseValue = "+this.getBaseSalry()+" , variable = "+this.getVariable()+
                " where employeeID = "+id+" ;";
        Company.execute(t);
    }
    public void DeleteSalary() throws IOException {
        System.out.println("please enter the ID of the employee you want to delete the salary for:");
        int id=Integer.parseInt(Company.br.readLine());
        String t="Delete from salary where employeeID = "+id+" ;";
        Company.execute(t);
    }
}
