import java.util.ArrayList;

class Course {
    int courseid;
    ArrayList<Course> dependsOn;
    ArrayList<Course> needs;
    int Startcourse;

    public Course(int courseid) {
        this.dependsOn = new ArrayList<>();
        this.needs = new ArrayList<>();
        this.courseid = courseid;
        this.Startcourse = 1;
    }

    public void addDepend(Course course) {
        this.dependsOn.add(course);
    }


    public void addNeed(Course course) {
        this.needs.add(course);
    }


    public void setStartCourse(int startcourse) {
        this.Startcourse = startcourse;
    }


    public int getStartCourse() {
        return Startcourse;
    }


    public void updateCourses() {
        for (Course course:this.needs) {
            if (course.getStartCourse() <= this.Startcourse) {
                course.setStartCourse(this.Startcourse + 1);
                course.updateCourses();
            }
        }
    }
}