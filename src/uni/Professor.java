package uni;

import java.util.ArrayList;

public class Professor {
    public int id;
    public static ArrayList<Professor> professorsList = new ArrayList<>();
    public int personID;
    public int majorID;

    public Professor(int personID, int majorID){
        this.personID = personID;
        this.majorID = majorID;
        this.id = professorsList.size() + 1;
        professorsList.add(this);
    }

    public static Professor findById(int id) {
        for (Professor professor : professorsList) {
            if (professor.id == id) {
                return professor;
            }
        }
        return null;
    }
}
