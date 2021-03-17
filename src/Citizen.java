import java.awt.Point;

public class Citizen {
    private String first_name;
    private String last_name;
    private int moral;
    private int politics;
    private int job;
    private int age;
    private String gender;
    private int stress;
    private Point position;
    private Point home;

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
        String name;
        switch (attribute) {
            case Control.NAME:
                name = first_name + " " + last_name;
                return name;
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

    public void edit_settler(int attribute, int amount, String text) {
        switch (attribute) {
            case Control.FAMILY:
                last_name = text;
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

    public void move(Point destination) {
        position = destination;
    }
}
