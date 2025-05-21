public class Student {
    private int id;
    private int grade;
    private Arraylist<Course> requestedChosenCourses = new Arraylist<>();
    private Arraylist<Course> requestedAlternativeCourses = new Arraylist<>();


    public Student(int id, int grade, Arraylist<Course> requestedChosenCourses, Arraylist<Course> requestedAlternativeCourses) {
        this.id = id;
        this.grade = grade;
        this.requestedChosenCourses = requestedChosenCourses;
        this.requestedAlternativeCourses = requestedAlternativeCourses;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
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
