import java.awt.Point;
import java.util.ArrayList;

public class Control {
    public static final int FAMILY = 0;
    public static final int NAME = 1;
    public static final int MORAL = 2;
    public static final int POLITIK = 3;
    public static final int ROLE = 4;
    public static final int GENDER = 5;
    public static final int AGE = 6;
    public static final int POSITON_X = 7;
    public static final int POSITON_Y = 8;
    public static final int HOME = 9;

    public Point point = new Point(3,13);
    public Point des = new Point(20,1);
    ArrayList<Citizen> citizens = new ArrayList<>();
    ArrayList<Family> families = new ArrayList<>();

    public Control() {
        citizens.add(new Citizen(32,"m",point,"Ralf"));
        citizens.add(new Citizen(30,"w",new Point(143,79),"Ursula"));
        citizens.add(new Citizen(6,"m",new Point(32,123),"Jack"));
        families.add(new Family("Anderson",this));
        citizens.get(2).set_parents(0, 1);
        citizens.get(0).set_spouse(1);
        citizens.get(1).set_spouse(0);
        citizens.get(0).set_kids(2);
        citizens.get(1).set_kids(2);
    }



    public Citizen getCitizen(int index){
        return citizens.get(index);
    }

    public int get_fam_member_x_pos(int fam, int member){
        return citizens.get(families.get(fam).get_member(member)).get_int_from_settler(POSITON_X);
    }

    public int get_fam_member_y_pos(int fam, int member){
        return citizens.get(families.get(fam).get_member(member)).get_int_from_settler(POSITON_Y);
    }
    /*
    //WICHTIG: DELETE CITIZEN
    public void deleteCitizen(int citizenId){
        citizens.get(citizenId).
    }
*/
    public int get_families_amount(){
        return families.size();
    }
    public  Control getControl(){
        return this;
    }

}
