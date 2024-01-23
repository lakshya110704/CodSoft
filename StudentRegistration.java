package CodSoft;
import java.util.*;
class Course{
    String courseCode;
    String courseName;
    String description;
    int capacity;
    String schedule;

    public Course(String courseCode, String courseName, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    @Override
    public String toString(){
        return "Course Code: " + courseCode + "\nTitle: " + courseName + "\nDescription: " + description + "\nCapacity: " + capacity + "\nSchedule: " + schedule;
    }
}

class Student{
    String name;
    int studentID;
    int maxCourses;
    List <Course> registeredCourses;

    public Student(String name, int studentID){
        this.name = name;
        this.studentID = studentID;
        this.registeredCourses = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + "\nName: " + name + "\nRegistered Courses: " + registeredCourses;
    }
}

class Registration{
    List<Course> availableCourses;
    List<Student> students;

    public Registration(){
        this.availableCourses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addCourse(Course course){
        availableCourses.add(course);
    }

    public void registerStudent(Student newStudent, Course course){
        if(availableCourses.contains(course) && course.capacity > 0){
            newStudent.registeredCourses.add(course);
            course.capacity --;
            System.out.println("Registration Succesful for " + newStudent.name + " in  " + course.courseName );
            newStudent.maxCourses --;
        }

        else{
            System.out.println("Registration Unsuccesful. Please register for another course");
        }   
        System.out.println();
    }

    public void removeCourse(Student newStudent, Course course) {
        if (newStudent.registeredCourses.contains(course)) {
            newStudent.registeredCourses.remove(course);
            course.capacity++;
            System.out.println("Course " + course.courseName + " removed successfully for " + newStudent.name);
        } 
        else {
            System.out.println("Cannot remove. Student is not registered for " + course.courseName);
        }
        System.out.println();
    }

    public void displayAvailableCourses(Student newStudent) {
        
        System.out.println("Available Courses:");
        for (Course course : availableCourses) {
            if (newStudent.registeredCourses.contains(course)) {
                continue;
            }  
            System.out.println(course);
            System.out.println("-------------");
        }
        System.out.println();
    }
}
    
    
public class StudentRegistration {
    public static void main(String[] args) {
        Registration registrationSystem = new Registration();

        Course c1 = new Course("CSE101", "Introduction to Programming", "Basic programming concepts", 30, "Mon-Wed-Fri");
        Course c2 = new Course("MAT201", "Calculus I", "Fundamental concepts of calculus", 25, "Tue-Thu");
        Course c3 = new Course("ENG102", "English Composition", "Developing writing skills", 20, "Mon-Wed");

        registrationSystem.addCourse(c1);
        registrationSystem.addCourse(c2);
        registrationSystem.addCourse(c3);        

        Student s1 = new Student("Lakshya", 229309175);
        Student s2 = new Student("Harsh", 229309145);

        registrationSystem.students.add(s1);
        registrationSystem.students.add(s2);


        registrationSystem.displayAvailableCourses(s1);
        registrationSystem.registerStudent(s1, c1);
        registrationSystem.removeCourse(s1, c1);
        registrationSystem.displayAvailableCourses(s1);
    }
}

