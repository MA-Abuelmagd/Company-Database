package Tables;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import Main.Company;

public class employee {
    private int id;
    private String name;
    private Date birthDate;
    private int departmentID;
    private int ruleID;

    public employee(String name, Date birthDate, int departmentID, int ruleID) {
        this.name = name;
        this.birthDate = birthDate;
        this.departmentID = departmentID;
        this.ruleID = ruleID;
    }

    public employee() {

    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() throws ParseException {
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-mm-dd");
        return temp.parse(temp.format(this.birthDate));
    }

    protected void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    protected void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public int getRuleID() {
        return ruleID;
    }

    protected void setRuleID(int ruleID) {
        this.ruleID = ruleID;
    }
    public void setEmployee() throws IOException, ParseException {

        System.out.println("please enter the name of the employee:");
        this.setName(Company.br.readLine());
        System.out.println("please enter the birthData of the employee in the this format (yyyy-mm-dd):");
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-mm-dd");
        this.setBirthDate(temp.parse(Company.br.readLine()));
        System.out.println("please enter the department ID of the employee:");
        this.setDepartmentID(Integer.parseInt(Company.br.readLine()));
        System.out.println("please enter the rule ID of the employee:");
        this.setRuleID(Integer.parseInt(Company.br.readLine()));
    }
    public void InsertEmployee() throws ParseException {
        java.sql.Date sqlDate=new java.sql.Date(this.getBirthDate().getTime());
        String t ="Insert into employee(Name,birthDate,departmentID,ruleID) Values ('"+this.getName()+"','"+sqlDate+"',"+
                this.getDepartmentID()+","+this.getRuleID()+");";
        Company.execute(t);
    }
    public void UpdateEmployee() throws IOException, ParseException {
        System.out.println("please enter the ID of the employee that you want to update:");
        int id=Integer.parseInt(Company.br.readLine());
        java.sql.Date sqlDate=new java.sql.Date(this.getBirthDate().getTime());
        String t="Update employee Set name='"+ this.getName()+"', birthDate = Date_Format(birthDate,'"+sqlDate+"'), departmentID = "+
                this.getDepartmentID()+", ruleID = "+this.getRuleID()+" where ID = "+id+";";
        Company.execute(t);
    }
    public void DeleteEmployee() throws IOException {
        System.out.println("please enter the ID of the employee you want to delete:");
        int id=Integer.parseInt(Company.br.readLine());
        String t="Delete from employee where ID= "+id+" ;";
        Company.execute(t);
    }
}
