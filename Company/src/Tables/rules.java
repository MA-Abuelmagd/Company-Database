package Tables;

import Main.Company;

import java.io.IOException;

public class rules {
    private int ID;
    private String ruleDescription;

    public rules() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRuleDescription() {
        return ruleDescription;
    }

    public void setRuleDescription(String ruleDescription) {
        this.ruleDescription = ruleDescription;
    }

    public rules(String ruleDescription) {
        this.ruleDescription = ruleDescription;
    }

    public void setRule() throws IOException {
        System.out.println("Please enter the rule description:");
        this.setRuleDescription(Company.br.readLine());
    }
    public void InsertRule(){
        String t="Insert Into rules(ruleDescription) Values ('"+this.getRuleDescription()+"') ;";
        Company.execute(t);
    }
    public void UpdateRule() throws IOException {
        System.out.println("Please enter the ID of the rule you want to update:");
        int id=Integer.parseInt(Company.br.readLine());
        String t="Update rules Set ruleDescription = '"+this.getRuleDescription()+"' where ID = "+id+" ;";
        Company.execute(t);
    }
    public void DeleteRule() throws IOException {
        System.out.println("Please enter the ID of the rule you want to delete:");
        int id=Integer.parseInt(Company.br.readLine());
        String t="Delete from rules where ID = "+id+" ;";
        Company.execute(t);
    }
}
