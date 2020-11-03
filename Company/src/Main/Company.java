package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import Tables.*;


public class Company {
    private static Connection con;
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    private static Statement stmt;

    public static void execute(String t){
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Company","root","295812");
            stmt=con.createStatement();
            stmt.executeUpdate(t);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void executeSelect(String t){
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Company","root","295812");
            stmt=con.createStatement();
            ResultSet res=stmt.executeQuery(t);
            while(res.next()){
                for (int i = 1; i <=res.getMetaData().getColumnCount() ; i++) {
                    System.out.print(res.getString(i)+" ");
                }
                System.out.println("");
            }
        }catch(Exception e){

        }
    }
    public static void SelectMoreThan5000() throws IOException {
        System.out.println("please enter the id of the department you want to check about:");
        int id=Integer.parseInt(br.readLine());
        String t="Select "+
                        "e.ID , e.name, e.birthDate, e.departmentID, e.ruleID, d.address, d.college, " +
                        "d.certificate, s.total "+
                "From "+
                        "employee e "+
                "Inner Join "+
                        "salary s On e.ID = s.employeeID "+
                "Inner Join "+
                        "data d On e.ID = d.employeeID "+
                "Where "+
                        "s.total >= 5000 AND e.departmentID = "+id+" ;";
        executeSelect(t);
    }
    public static void SeectOlderThan30() throws IOException {
        System.out.println("please enter the id of the rule you want to check about:");
        int id=Integer.parseInt(br.readLine());
        String t="Select \n" +
                "\te.ID , e.name, e.birthDate, e.departmentID, e.ruleID, d.address, d.college, d.certificate, s.total\n" +
                "From\n" +
                "\temployee e\n" +
                "Inner Join\n" +
                "\tdata d on e.ID = d.employeeID\n" +
                "Inner Join\n" +
                "\tsalary s on e.id =s.employeeID\n" +
                "where\n" +
                "\te.ruleID ="+id+" and e.age>30 ;";
        executeSelect(t);
    }
    public static void main(String args[]){
        employee e=new employee();
        department d=new department();
        rules r=new rules();
        data data=new data();
        salary s= new salary();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            SelectMoreThan5000();
//            SeectOlderThan30();
//            for (int i = 1; i <= 10; i++) {
//                department d=new department("dpeartment"+i);
//                d.InsertDepartment();
//            }
//            for (int i = 1; i <=10 ; i++) {
//                rules r=new rules("rule"+i);
//                r.InsertRule();
//            }
//            int dep=0;
//            int rule=0;
//            for (int i = 1; i <= 100; i++) {
//                if(dep==10){
//                    dep=0;
//                }
//                if(rule==10){
//                    rule=0;
//                }
//                SimpleDateFormat temp=new SimpleDateFormat("yyyy-mm-dd");
//                Date sqlDate=new Date(temp.parse((2010-i)+"-05-17").getTime());
//                employee employee=new employee("mohamed"+i,sqlDate,++dep,++rule);
//                employee.InsertEmployee();
//            }
//            for (int i = 1; i <= 100; i++) {
//                data d=new data(i,"el rehab"+i,"engineering"+i,"guc"+i);
//                d.InsertData();
//            }
//            for (int i = 1; i <= 100; i++) {
//                salary s=new salary(i,1970+i,3000);
//                s.InsertSalary();
//            }
//            System.out.println("setting the department:\n-----------------------------");
//            d.setDepartment();
//            d.InsertDepartment();
//            d.UpdateDepartment();
//            d.DeleteDepartment();
//            System.out.println("-----------------------------\nsetting the rule:\n-----------------------------");
//            r.setRule();
//            r.InsertRule();
//            r.UpdateRule();
//            r.DeleteRule();
//            System.out.println("-----------------------------\nsetting the employee:\n-----------------------------");
//            e.setEmployee();
//            e.InsertEmployee();
//            e.UpdateEmployee();
//            e.DeleteEmployee();
//            System.out.println("-----------------------------\nsetting the data:\n-----------------------------");
//            data.setData();
//            data.InsertData();
//            data.UpdateData();
//            data.DeleteData();
//            System.out.println("-----------------------------\nsetting the salary:\n-----------------------------");
//            s.setSalary();
//            s.InsertSalary();
//            s.UpdateSalary();
//            s.DeleteSalary();
            con.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}

