package homework9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Students> result = getListOfStudents(3,3);

        result.stream().flatMap(student -> student.getCoursesList().stream()).distinct().collect(Collectors.toList());
        result.stream().flatMap(student -> student.getCoursesList().stream()).collect(Collectors.toSet());


        result.stream().sorted((student1,student2) -> student1.getCoursesList().size() - student2.getCoursesList().size()).limit(3).collect(Collectors.toList());


        Courses paramCourses = new Courses("course1");
        result.stream().filter(student -> student.getCoursesList().contains( paramCourses )).collect(Collectors.toList());

        System.out.println();

    }



    private static List<Students> getListOfStudents(int j, int m){
        ArrayList<Students> result = new ArrayList<>();
        for (int i=0; i<j ;i++){
            ArrayList<Courses> courses = new ArrayList<>();
            for (int h=0; h<m ;h++){
                courses.add(new Courses("student"+h));
            }
            result.add(new Students("course"+i, courses ));
        }
        return result;
    }
}