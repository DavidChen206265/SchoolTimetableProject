public class Student {
    private int id;
    private Arraylist<Course> requestedChosenCourses = new Arraylist<>();
    private Arraylist<Course> requestedAlternativeCourses = new Arraylist<>();
    private Arraylist<SingleClass> currentClasses = new ArrayList<>();

    public Student(int id, Arraylist<Course> requestedChosenCourses, Arraylist<Course> requestedAlternativeCourses) {
        this.id = id;
        this.requestedChosenCourses = requestedChosenCourses;
        this.requestedAlternativeCourses = requestedAlternativeCourses;
    }

    public void addToClass(SingleClass c) {
        currentClasses.add(c);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setRequestedChosenCourses(Arraylist<Course> requestedChosenCourses) {
        this.requestedChosenCourses = requestedChosenCourses;
    }

    public Arraylist<Course> getRequestedChosenCourses() {
        return requestedChosenCourses;
    }

    public void setRequestedAlternativeCourses(Arraylist<Course> requestedAlternativeCourses) {
        this.requestedAlternativeCourses = requestedAlternativeCourses;
    }

    public Arraylist<Course> getRequestedAlternativeCourses() {
        return requestedAlternativeCourses;
    }
}
