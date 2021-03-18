import java.util.ArrayList;

public class Family {
    String family;
    private ArrayList<Citizen> members = new ArrayList<>();

    public Family(String name, String[] roles,Citizen... cits){
        family = name;
        for (int j = 0; j < cits.length; ++j){
            cits[j].edit_settler(Control.FAMILY,0,family,roles[j]);
            members.add(cits[j]);
        }
    }

    public void add_to_family(Citizen citizen, String role){
        citizen.edit_settler(Control.FAMILY,0, family, role);
        members.add(citizen);
    }

    public void remove_from_family(Citizen citizen){
        citizen.edit_settler(Control.FAMILY, 0, "", "");
        members.remove(citizen);
    }

    public int get_member_count(){
        return members.size();
    }

    public Citizen get_member(int index){
        return members.get(index);
    }
}