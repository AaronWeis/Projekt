import java.awt.Point;
import java.util.ArrayList;


public class Citizen {

    private static class  Credentials{
        String first_name;
        String last_name;
        String family_role;
        Point address;
        int age;
        String life_state;
        int familyId;
        String gender;
    }
    public static class Attributes{
        int moral;
        int politics;
        int stress;
        Profession job;
    }

    Credentials credentials;
    Attributes attributes;
    private Point position;
    private Point home;
    private ArrayList<Integer> parents;
    private ArrayList<Integer> children;
    private ArrayList<Integer> spouses;


    public Citizen(int age, String gender, Point position, String name) {
        initComponents(age, gender, position, name);
        update_life_state();
    }

    private void initComponents(int age, String gender, Point position, String name) {
        credentials = new Credentials();
        attributes = new Attributes();
        this.position = position;
        Point home = new Point(0,0);
        credentials.first_name = name;
        credentials.last_name = "";
        credentials.age = age;
        credentials.gender = gender;
        this.position = position;
        attributes.stress = 0;
        attributes.politics = 0;
        attributes.moral = 0;
        parents = new ArrayList<>();
        spouses = new ArrayList<>();
        children = new ArrayList<>();
    }

    public int get_int_from_settler(int attribute) {
        return switch (attribute) {
            case Control.MORAL -> attributes.moral;
            case Control.AGE -> credentials.age;
            case Control.POLITIK -> attributes.politics;
            case Control.POSITON_X -> position.x;
            case Control.POSITON_Y -> position.y;
            default -> 0;
        };
    }

    public String get_string_from_settler(int attribute) {

        return switch (attribute) {
            case Control.NAME -> credentials.first_name + " " + credentials.last_name;
            case Control.ROLE -> credentials.family_role;
            case Control.GENDER -> credentials.gender;
            default -> "unknown";
        };
    }

    public Profession getProfession() { return attributes.job;}

    public void edit_settler(int attribute, int amount, String text, String role) {
        switch (attribute) {
            case Control.FAMILY -> {
                credentials.last_name = text;
                credentials.family_role = role;
            }
            case Control.NAME -> credentials.first_name = text;
            case Control.MORAL -> attributes.moral = amount;
            case Control.POLITIK -> attributes.politics = amount;
            case Control.GENDER -> credentials.gender = text;
            case Control.AGE -> credentials.age = amount;
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

    private void update_life_state(){
        if (credentials.age >= 4) {
            if(credentials.age < 12){
                credentials.life_state = "Child";
            }else if(credentials.age < 18){
                credentials.life_state = "Teenager";
            }else if(credentials.age < 65){
                credentials.life_state = "Adult";
            }else{
                credentials.life_state = "Pensioner";
            }
        } else {
            credentials.life_state = "Baby";
        }
    }

}
