package Assignment3;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int courseId;
    private String courseName;
    private int maxCapacity;
    private int professorId;
    private int credits;
    private int[] studentIds;

    void registerStudent(int studentId){
        int[] arr = new int[studentIds.length + 1];
        System.arraycopy(studentIds, 0, arr, 0, studentIds.length);
        arr[studentIds.length] = studentId;
        this.studentIds = arr;
    }

    Course(int coureseId){
        if(courseId <= 0){
            throw new IllegalArgumentException("should not be negative or 0");
        }
        this.courseId = coureseId;
    }
    Course(int courseId, int professorId){
        if(courseId <= 0){
            throw new IllegalArgumentException("should not be negative or 0");
        }
        if(professorId < 100000 || professorId > 999999){
            throw new IllegalArgumentException("should be a six digit integer");
        }
        this.courseId = courseId;
        this.professorId = professorId;
    }
    Course(int courseId, int professorId, int credits){
        if(courseId <= 0){
            throw new IllegalArgumentException("should not be negative or 0");
        }
        if(professorId < 100000 || professorId > 999999){
            throw new IllegalArgumentException("should be a six digit integer");
        }
        if(credits < 1 || credits > 9){
            throw new IllegalArgumentException("should be a single digit but greater than 0");
        }
        this.courseId = courseId;
        this.professorId = professorId;
        this.credits = credits;
    }

    public int getCourseId(){
        return courseId;
    }
    public String getCourseName(){
        return courseName;
    }
    public int getMaxCapacity(){
        return maxCapacity;
    }
    public int getProfessorId(){
        return professorId;
    }
    public int getCredits(){
        return credits;
    }
    public int[] getStudentIds(){
        return studentIds;
    }

    public void setCourseId(int courseId){
        if(courseId <= 0){
            throw new IllegalArgumentException("should not be negative or 0");
        }
        this.courseId = courseId;
    }
    public void setCourseName(String courseName){
        if(courseName.length() < 10 || courseName.length() > 60){
            throw new IllegalArgumentException("should be a string with minimum length 10 and maximum 60");
        }
        this.courseName = courseName;
    }
    public void setMaxCapacity(int maxCapacity) {
        if(maxCapacity < 10 || maxCapacity > 100){
            throw new IllegalArgumentException("should not be less than 10 greater than 100");
        }
        this.maxCapacity = maxCapacity;
    }
    public void setProfessorId(int professorId) {
        if(professorId < 100000 || professorId > 999999){
            throw new IllegalArgumentException("should be a six digit integer");
        }
        this.professorId = professorId;
    }
    public void setCredits(int credits) {
        if(credits < 1 || credits > 9){
            throw new IllegalArgumentException("should be a single digit but greater than 0");
        }
        this.credits = credits;
    }
    public void setStudentIds(int[] studentIds) {
        this.studentIds = studentIds;
    }


    public int[] removeDuplicates(int[] studentIds){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < studentIds.length; i++){
            if(!list.contains(studentIds[i])){
                list.add(studentIds[i]);
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public int groupsOfStudents(int[] studentIds){
        int odd = 0, even = 0;
        for(int i = 0; i < studentIds.length; i++){
            if(studentIds[i] % 2 == 0){
                even++;
            } else {
                odd++;
            }
        }
        int result = ((odd * (odd - 1)) + even * (even - 1)) / 2;
        return result;
    }

}
