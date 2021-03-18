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

    public Point point = new Point(0,0);
    public Point des = new Point(20,1);
    ArrayList<Citizen> citizens = new ArrayList<>();
    Family[] fams = new Family[2];

    public Control() {
        for (int i = 0; i < 5; i++) {
            point.x = i * 10 +2;
            point.y = (i*2) * 10 +2;
            citizens.add(new Citizen(5, "w",point,"Leto"));
        }
        citizens.get(3).edit_settler(GENDER, 0, "w");
        citizens.get(3).edit_settler(AGE, citizens.get(3).get_int_from_settler(AGE) + 1, null);
        fams[0] = new Family(citizens.get(0), citizens.get(1), "Ziegler");
        fams[0].add_to_family(citizens.get(3));
        fams[0].remove_from_family(citizens.get(0));
        citizens.get(2).move(des);
        print(citizens);
    }

    public void print(ArrayList<Citizen> citizens) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Siedler Nr." + (i+1) + "\nName: " + citizens.get(i).get_string_from_settler(NAME) + "\nAlter: " + citizens.get(i).get_int_from_settler(AGE));
            System.out.println("Geschlecht: " + citizens.get(i).get_string_from_settler(GENDER) + "\nPosition: " + citizens.get(i).get_int_from_settler(POSITON_X) + "/" + citizens.get(i).get_int_from_settler(POSITON_Y));
            System.out.println("---");
        }
    }
}
