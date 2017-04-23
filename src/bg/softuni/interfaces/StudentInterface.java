package bg.softuni.interfaces;

import bg.softuni.models.Course;
import bg.softuni.models.Student;

import java.util.Map;

public interface StudentInterface extends Comparable<Student>{
    String getUserName();

    Map<String, Course> getEnrolledCourses();

    Map<String, Double> getMarksByCourseName();

    void enrollInCourse(Course course);

    void setMarksOnCourse(String courseName, int... scores);
}
