import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Registrar {
    /*
    Assigns courses to students based on gpa and prerequisites
    Retrives students stats (GPA and past courses)
     */
boolean canStudentRegester(String courseID, String NetId) throws IOException {
    // TODO: implement a function that returns a boolean following an input course and a student to check
    //  if that student can take that course based on his/her past courses taken
    Student s = new Student(NetId, null, 0, null);
    ArrayList<String> preferences = new ArrayList<>();
    ArrayList<String> pastCourses = new ArrayList<>();
    preferences = s.getPreferredCourses(NetId);
//    pastCourses = s.
//    ArrayList<String> courses = getPrerequisites(courseID);
//    if(preferences.isEmpty()){
//        return false;
//    }
//    if ()
//    preferences.get(0);
    return true;
}
    ArrayList<String> getPrerequisites(String courseID) throws FileNotFoundException {

    //Returns an array of prerequisites required for the input course

        try(BufferedReader br = new BufferedReader(new FileReader("Courses.csv"))) {
            String line;
            while((line=br.readLine()) !=null){
                line = line.split(",")[0].trim();
                if(line.contains(courseID)) {
                    String p = line.split(",")[4];
                    return new ArrayList<> (Arrays.asList(p.split("\\|")));
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error reading file");
        }
        return new ArrayList<>();
    }
}
