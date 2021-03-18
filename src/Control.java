import java.awt.Point;
import java.util.ArrayList;

public class Control {
    public static final int FAMILY = 0;
    public static final int NAME = 1;
    public static final int MORAL = 2;
    public static final int POLITIK = 3;
    public static final int JOB = 4;
    public static final int GENDER = 5;
    public static final int AGE = 6;
    public static final int POSITON_X = 7;
    public static final int POSITON_Y = 8;
    public static final int HOME = 9;
    public static final int ROLE = 10;

    public Point point = new Point(0,0);
    public Point des = new Point(20,1);
    ArrayList<Citizen> citizens = new ArrayList<>();
    ArrayList<Family> families = new ArrayList<>();

    public Control() {
        for (int i = 0; i < 5; ++i) {
            point.x = i * 10 +2;
            point.y = (i*2) * 10 +2;
            citizens.add(new Citizen(5, "w",point,"Leto"));
        }
        citizens.get(3).edit_settler(GENDER, 0, "w", null);
        citizens.get(3).edit_settler(AGE, citizens.get(3).get_int_from_settler(AGE) + 1, null, null);
        families.add(new Family("Ziegler",new String[]{"Mann", "Frau"},citizens.get(0), citizens.get(1)));
        families.get(0).add_to_family(citizens.get(3), citizens.get(3).get_string_from_settler(ROLE));
        families.get(0).remove_from_family(citizens.get(0));
        citizens.get(2).move(des);

    }

    public int get_fam_member_x_pos(int fam, int member){
        return families.get(fam).get_member(member).get_int_from_settler(POSITON_X);
    }

    public int get_fam_member_y_pos(int fam, int member){
        return families.get(fam).get_member(member).get_int_from_settler(POSITON_Y);
    }

    public int get_families_size(){
        return families.size();
    }

}
