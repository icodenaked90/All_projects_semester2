import java.util.Scanner;

public class Mandatory3_Courses {

    static int numberofnodes;
    static int numberofedges;
    static int numbersOfSemestersNeeded;
    static Course[] courses;

    public static void main(String[] args) {
        Input();
        System.out.println(numbersOfSemestersNeeded);
    }


    public static void Input(){
        Scanner scan = new Scanner(System.in);

        numberofnodes = scan.nextInt();
        numberofedges = scan.nextInt();

        courses = new Course[numberofnodes];

        for (int i = 0; i < numberofnodes; i++) {
            courses[i] = new Course(i+1);
        }

        for (int i = 0; i < numberofedges; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            addingDependencies(x,y);

        }

        for (Course course : courses) {
            if (course.getStartCourse() >= numbersOfSemestersNeeded) {
                numbersOfSemestersNeeded = course.getStartCourse();
            }
        }
    }

    public static void addingDependencies(int x, int y){
             courses[x - 1].addDepend(courses[y - 1]);
             courses[y - 1].addNeed(courses[x - 1]);

             if (courses[x - 1].getStartCourse() <= courses[y - 1].getStartCourse()) {
                 courses[x - 1].setStartCourse(courses[y - 1].getStartCourse() + 1);
                 courses[x - 1].updateCourses();
             }
    }
}

