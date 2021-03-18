import java.util.ArrayList;

public class Family {
    String family;
    ArrayList<Citizen> members = new ArrayList<>();
    public Family(String name,Citizen... cits){
        family = name;
        for (int j = 0; j < cits.length; j++){
            cits[j].edit_settler(Control.FAMILY,0,family);
            members.add(cits[j]);
        }

    }

    public void add_to_family(Citizen citizen){
        citizen.edit_settler(Control.FAMILY,0, family);
        members.add(citizen);
    }

    public void remove_from_family(Citizen citizen){
        citizen.edit_settler(Control.FAMILY, 0, "");
        members.remove(citizen);
    }

    public void print_family_tree(){

    }
}
