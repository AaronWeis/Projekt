import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class Citizen {
    private String first_name;
    private String last_name;
    private String family_role;
    private int moral;
    private int politics;
    private int job;
    private int age;
    private String gender;
    private String life_state = "";
    private int stress;
    private Point position;
    private Point home;
    private Citizen[] parents = new Citizen[2];
    private ArrayList<Citizen> children = new ArrayList<>();
    private Citizen spouse;

    public Citizen(int age, String gender, Point position, String name) {
        position = new Point(position.x, position.y);
        Point home = new Point(0,0);
        first_name = name;
        last_name = "";
        this.age = age;
        this.gender = gender;
        this.position = position;
        stress = 0;
        job = 0;
        politics = 0;
        moral = 0;
        upadte_life_state();
    }

    public int get_int_from_settler(int attribute) {
        switch (attribute) {
            case Control.MORAL:
                return moral;
            case Control.AGE:
                return age;
            case Control.JOB:
                return job;
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
                 return first_name + " " + last_name;
            case Control.ROLE:
                return family_role;
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

    public void edit_settler(int attribute, int amount, String text, String role) {
        switch (attribute) {
            case Control.FAMILY:
                last_name = text;
                family_role = role;
                break;
            case Control.NAME:
                first_name = text;
                break;
            case Control.MORAL:
                moral = amount;
                break;
            case Control.POLITIK:
                politics = amount;
                break;
            case Control.JOB:
                job = amount;
                break;
            case Control.GENDER:
                gender = text;
                break;
            case Control.AGE:
                age = amount;
                break;
        }
    }

    public void do_work() {

    }

    public void react() {

    }

    public void set_parents(Citizen parent1, Citizen parent2){
        parents[0] = parent1;
        parents[1] = parent2;
    }

    public void set_kids(Citizen... kids){
        children.addAll(Arrays.asList(kids));
    }

    public void set_spouse(Citizen cit){
        spouse = cit;
    }

    public void move(Point destination) {
        position = destination;
    }

    private void upadte_life_state(){
        if(age < 4){
            life_state = "Baby";
            return;
        }else if(age < 12){
            life_state = "Child";
            return;
        }else if(age < 18){
            life_state = "Teenager";
            return;
        }else if(age < 65){
            life_state = "Adult";
            return;
        }else{
            life_state = "Pensioner";
        }
    }

}
