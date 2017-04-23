package bg.softuni.interfaces;

import bg.softuni.models.Student;
import bg.softuni.models.Course;

import java.util.Map;


public interface Courseble extends Comparable<Course>{
    int NUMBER_OF_TASKS_ON_EXAM = 5;
    int MAX_SCORE_ON_EXAM_TASK = 100;

    String getName();

    Map<String, Student> getStudentsByName();

    void enrollStudent(Student student);

    @Override
    String toString();
}
