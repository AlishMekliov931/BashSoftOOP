package bg.softuni.interfaces;

import bg.softuni.dataStructures.SimpleSortedList;
import bg.softuni.models.Course;
import bg.softuni.models.Student;

import java.util.Comparator;

public interface Requester {
    void getStudentMarksInCourse(String course, String student);

    void getStudentsByCourse(String course);

    SimpleSortedList<Course> getAllCoursesSorted(Comparator<Course> cmp);

    SimpleSortedList<Student> getAllStudentsSorted(Comparator<Student> cmp);
}
