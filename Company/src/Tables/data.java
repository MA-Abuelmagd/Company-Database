package Tables;
import Main.Company;

import java.io.IOException;

public class data {
    private int employeeID;
    private String address;
    private String college;
    private String certificate;

    public data(int employeeID, String address, String college, String certificate) {
        this.employeeID = employeeID;
        this.address = address;
        this.college = college;
        this.certificate = certificate;
    }

    public data() {

    }

    public int getEmployeeID() {
        return employeeID;
    }

    protected void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getAddress() {
        return address;
    }

    protected void setAddress(String address) {
        this.address = address;
    }

    public String getCollege() {
        return college;
    }

    protected void setCollege(String college) {
        this.college = college;
    }

    public String getCertificate() {
        return certificate;
    }

    protected void setCertificate(String certificate) {
        this.certificate = certificate;
    }
    public void setData() throws IOException {
        System.out.println("Please enter the employee ID:");
        this.setEmployeeID(Integer.parseInt(Company.br.readLine()));
        System.out.println("Please enter the address of the Employee:");
        this.setAddress(Company.br.readLine());
        System.out.println("Please enter the Employee college:");
        this.setCollege(Company.br.readLine());
        System.out.println("Please enter the Employee certificate:");
        this.setCertificate(Company.br.readLine());
    }
    public void InsertData(){
        String t="Insert into data(employeeID, address, college, certificate) Values("+this.getEmployeeID()+", '"+
                this.getAddress()+"', '"+this.getCollege()+"', '"+this.getCertificate()+"');";
        Company.execute(t);
    }
    public void UpdateData() throws IOException {
        System.out.println("Please enter the ID of the data you want to update the data for:");
        int id=Integer.parseInt(Company.br.readLine());
        String t="Update data Set address = '"+this.getAddress()+"', college = '"+this.getCollege()+"', certificate = '"
                +this.getCertificate()+"' where employeeID = "+id+" ;" ;
        Company.execute(t);
    }
    public void DeleteData() throws IOException {
        System.out.println("Please enter the ID of the data you want to delete the data for:");
        int id=Integer.parseInt(Company.br.readLine());
        String t ="Delete from data where employeeID = "+id+" ;";
        Company.execute(t);
    }
}