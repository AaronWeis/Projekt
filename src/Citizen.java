import java.awt.Point;
import java.util.ArrayList;


public class Citizen {
    private class  Credentials{
        String first_name;
        String last_name;
        String family_role;
        Point address;
        int age;
        int familyId;
    }
    Credentials credentials;
    private int moral;
    private int politics;
    private String gender;
    private String life_state = "";
    private int stress;
    private Point position;
    private Point home;
    private ArrayList<Integer> parents;
    private ArrayList<Integer> children;
    private ArrayList<Integer> spouses;
    private Profession job;

    public Citizen(int age, String gender, Point position, String name) {
        initComponents(age, gender, position, name);
        upadte_life_state();
    }

    private void initComponents(int age, String gender, Point position, String name) {
        credentials = new Credentials();
        position = new Point(position.x, position.y);
        Point home = new Point(0,0);
        credentials.first_name = name;
        credentials.last_name = "";
        credentials.age = age;
        this.gender = gender;
        this.position = position;
        stress = 0;
        politics = 0;
        moral = 0;
        parents = new ArrayList<>();
        spouses = new ArrayList<>();
        children = new ArrayList<>();
    }

    public int get_int_from_settler(int attribute) {
        switch (attribute) {
            case Control.MORAL:
                return moral;
            case Control.AGE:
                return credentials.age;
            case Control.POLITIK:
                return politics;
            case Control.POSITON_X:
                return position.x;
            case Control.POSITON_Y:
                return position.y;
        }
        return 0;
    }

    public String get_string_from_settler(int attribute) {

        switch (attribute) {
            case Control.NAME:
                 return credentials.first_name + " " + credentials.last_name;
            case Control.ROLE:
                return credentials.family_role;
            case Control.GENDER:
                if (gender.equals("m")) {
                    return "männlich";
                } else if (gender.equals("w")) {
                    return "weiblich";
                } else {
                    return "divers";
                }
        }

        return "unknown";
    }

    public Profession getProfession() { return job;}

    public void edit_settler(int attribute, int amount, String text, String role) {
        switch (attribute) {
            case Control.FAMILY:
                credentials.last_name = text;
                credentials.family_role = role;
                break;
            case Control.NAME:
                credentials.first_name = text;
                break;
            case Control.MORAL:
                moral = amount;
                break;
            case Control.POLITIK:
                politics = amount;
                break;
            case Control.GENDER:
                gender = text;
                break;
            case Control.AGE:
                credentials.age = amount;
                break;
        }
    }

    public void do_work() {

    }

    public void react() {

    }

    public void set_parents(int... parents){
        for (int parentId: parents) {
            this.parents.add(parentId);
        }

    }

    public void remove_parents(int... parentIds){
        for (int parentId: parentIds) {
            if(parents.contains(parentId)){
                int index = ProgramTools.getIndexOf(parentId, parents);
                parents.remove(index);
            }
        }
    }

    public void set_kids(int... kids){
        for (int kidID: kids) {
            children.add(kidID);
        }
    }

    public void remove_kids(int... kidIds){
        for(int kidID:kidIds){
            if(children.contains(kidID)){
                int index = ProgramTools.getIndexOf(kidID,children);
                children.remove(index);
            }
        }
    }

    public void set_spouse(int... spouses){
        for (int spouseID: spouses) {
            this.spouses.add(spouseID);
        }
    }

    public void remove_spouse(int... spouseIds){
        for(int spouseID:spouseIds){
            if(spouses.contains(spouseID)){
                int index = ProgramTools.getIndexOf(spouseID,spouses);
                spouses.remove(index);
            }
        }
    }

    public void move(Point destination) {
        position = destination;
    }

    private void upadte_life_state(){
        if(credentials.age < 4){
            life_state = "Baby";
        }else if(credentials.age < 12){
            life_state = "Child";
        }else if(credentials.age < 18){
            life_state = "Teenager";
        }else if(credentials.age < 65){
            life_state = "Adult";
        }else{
            life_state = "Pensioner";
        }
    }

}
