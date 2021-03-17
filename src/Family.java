public class Family {
    String family;
    public Family(Citizen c1, Citizen c2, String name){
        family = name;
        c1.edit_settler(Control.FAMILY,0,family);
        c2.edit_settler(Control.FAMILY,0,family);
    }

    public void add_to_family(Citizen c){
        c.edit_settler(Control.FAMILY,0, family);
    }

    public void remove_from_family(Citizen c){
        c.edit_settler(Control.FAMILY, 0, "");
    }
}
