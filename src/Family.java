import java.util.ArrayList;

public class Family {
    String family;
    private ArrayList<Integer> members = new ArrayList<>();
    Control ctr;
    public Family(String name, Control p_ctr){
        family = name;
        ctr = p_ctr.getControl();

    }

    public void add_to_family(int citizenId, String role){
        members.add(citizenId);

    }

    public void remove_from_family(int citizenId){
        members.remove(citizenId);
        for (int memberId:members) {

        }
    }

    public int get_member_count(){
        return members.size();
    }

    public int get_member(int index){
        return members.get(index);
    }
}