package bg.softuni.models;

import bg.softuni.exceptions.InvalidStringException;
import bg.softuni.exceptions.DuplicateEntryInStructureException;
import bg.softuni.interfaces.StudentInterface;
import bg.softuni.staticData.ExceptionMessages;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Student implements StudentInterface {

    private String userName;
    private LinkedHashMap<String, Course> enrolledCourses;
    private LinkedHashMap<String, Double> marksByCourseName;

    public Student(String userName) {
        this.setUserName(userName);
        this.enrolledCourses = new LinkedHashMap<>();
        this.marksByCourseName = new LinkedHashMap<>();
    }

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public Map<String, Course> getEnrolledCourses() {
        return Collections.unmodifiableMap(this.enrolledCourses);
    }

    @Override
    public Map<String, Double> getMarksByCourseName() {
        return Collections.unmodifiableMap(this.marksByCourseName);
    }

    private void setUserName(String userName) {
        if (userName == null || userName.equals("")){
            throw new InvalidStringException();
        }
        this.userName = userName;
    }

    @Override
    public void enrollInCourse(Course course){
        if (this.enrolledCourses.containsKey(course.getName())) {
            throw new DuplicateEntryInStructureException(this.userName, course.getName());
        }
        this.enrolledCourses.put(course.getName(), course);
    }

    @Override
    public void setMarksOnCourse(String courseName, int... scores){
        if (!this.enrolledCourses.containsKey(courseName)){
            throw new IllegalArgumentException(
                    ExceptionMessages.NOT_ENROLLED_IN_COURSE);
        }

        if (scores.length > Course.NUMBER_OF_TASKS_ON_EXAM){
            throw new IllegalArgumentException(
                    ExceptionMessages.INVALID_NUMBER_OF_SCORES);
        }

        double mark = calculateMark(scores);
        this.marksByCourseName.put(courseName, mark);
    }

    private double calculateMark(int[] scores) {
        double percentageOfSolveExam = Arrays.stream(scores).sum() /
                (double) (Course.NUMBER_OF_TASKS_ON_EXAM * Course.MAX_SCORE_ON_EXAM_TASK);
        double mark = percentageOfSolveExam * 4 + 2;
        return mark;
    }

    @Override
    public int compareTo(Student o) {
        return this.getUserName().compareTo(o.getUserName());
    }

    @Override
    public String toString() {
        return this.getUserName();
    }
}
