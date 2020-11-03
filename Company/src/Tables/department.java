package Tables;
import Main.Company;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Statement;

public class department {
    private int ID;
    private String description;

    public department(String description) {
        this.description = description;
    }

    public department(){
        description="";
    }

    public int getID() {
        return ID;
    }

    protected void setID(int ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }
    public void setDepartment() throws IOException {
        System.out.println("please enter the department description:");
        this.setDescription(Company.br.readLine());
    }
    public void InsertDepartment(){
        String temp="Insert into department (description) Values ('"+this.getDescription()+"');";
        Company.execute(temp);
    }
    public void UpdateDepartment() throws IOException {
        System.out.println("please enter the ID of the department that you want to update:");
        int id=Integer.parseInt(Company.br.readLine());
        String t="Update department Set description='"+this.getDescription()+"' where ID = "+id+" ;";
        Company.execute(t);
    }
    public void DeleteDepartment() throws IOException {
        System.out.println("please enter the ID of the department you want to delete:");
        int id=Integer.parseInt(Company.br.readLine());
        String t="Delete from department where ID= "+id+" ;";
        Company.execute(t);
    }
}
