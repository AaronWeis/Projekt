import java.util.ArrayList;

public class ProgramTools {

    public static int getIndexOf(Object object, ArrayList list) {
        int index = -1;
        for (int i = 0; i < list.size(); i++){
            if(object == list.get(i)){
                index = i;
                break;
            }
        }
        return index;
    }
}
