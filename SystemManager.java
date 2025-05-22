import java.util.ArrayList;

public class SystemManager {
    private ArrayList<Student> allStudents;
    private ArrayList<Course> allCourses;
    private Block[] timetable = new Block[8];

    // Constructor
    public SystemManager() {
        this.allStudents = new ArrayList<>();
        this.allCourses = new ArrayList<>();
        this.timetable = new Block[8];

        for (int i = 0; i < timetable.length; i++) {
            timetable[i] = new Block();
        }
    }

    public ArrayList<Student> getAllStudents() {
        return allStudents;
    }

    public void setAllStudents(ArrayList<Student> allStudents) {
        this.allStudents = allStudents;
    }

    public ArrayList<Course> getAllCourses() {
        return allCourses;
    }

    public void setAllCourses(ArrayList<Course> allCourses) {
        this.allCourses = allCourses;
    }

    public Block[] getTimetable() {
        return timetable;
    }

    public void setTimetable(Block[] timetable) {
        this.timetable = timetable;
    }
}
