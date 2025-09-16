import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student extends User{
    /*
    Represents each student's username and password.
    It also writes the username corresponding to their names and passwords to a CSV file.
     */
    ArrayList<String> registeredCourses;
    static List<String> pastCourses;
    String fullName;
    static String fileName;
    static int studentCount = 0;
    ArrayList<String> prefferedCourses;
  Student(String netId, String fullName, float preGPA, List<String> pastCourses) throws IOException {
        super(netId, fullName, preGPA, pastCourses);

      this.pastCourses = pastCourses;
      fileName = "Student.csv";
        writeCSV();
    }
    void writeCSV() throws IOException {
        boolean fileExists = new File(fileName).exists(); //checks if the file already exists

 //set the append mode to true so that it won't override things
            try(FileWriter fw = new FileWriter(fileName, true)) {
                if (!fileExists) {
                        fw.append("NetID,Full Name,GPA,Courses Taken\n");
                }
                if (!studentExists(this.netId))  {
                System.out.println("Writing Student.csv");
                fw.append(this.netId);
                fw.append(",");
                fw.append(this.name);
                fw.append(",");
                fw.append(Float.toString(this.prevGPA));
                fw.append(",");
                fw.append(String.join("|", this.pastCourses));
                fw.append("\n");
                System.out.println("Student Added Successfully");
                    studentCount ++;
            }
            }
            catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
            catch(IOException e){
                System.out.println("Problem writing to file");
            }
        }
    void studentCoursePrefWriter(ArrayList<String> prefferedCourses) throws IOException {
        this.prefferedCourses = prefferedCourses;
        fileName = "StudentPref.csv";
      try(FileWriter fw = new FileWriter(fileName, true)){
          fw.append(this.netId);
          fw.append(",");
          fw.append(String.join("|", this.pastCourses));
          fw.append("\n");
      }
    }
    public static ArrayList<String> getPreferredCourses(String netId) throws IOException {
      ArrayList<String> preferredCourses = new ArrayList<>();
      try(BufferedReader br = new BufferedReader(new FileReader("Student.csv"))) {
          String line;
          while((line=br.readLine())!=null){
              line = line.trim();
              if(line.contains(netId.trim())){
                  String courses = line.substring(line.lastIndexOf(",")+1).trim();
                  preferredCourses.addAll(Arrays.asList(courses.split("\\|")));
              }
          }
        return preferredCourses;
      }
    }
    public static ArrayList<String> getPastCourses(String netId) throws IOException {
      ArrayList<String> pastCourses = new ArrayList<>();
      try(BufferedReader br = new BufferedReader(new FileReader("Courses.csv"))) {
          String line;
          while((line=br.readLine())!=null){
              line = line.trim();
              if(line.contains(netId.trim())){
                  String courses = line.substring(line.indexOf(",", 15),line.lastIndexOf(",")).trim();//TODO: NEEDS CORRECTION
                  pastCourses.addAll(Arrays.asList(courses.split("\\|")));
              }
          }
        return pastCourses;
      }
    }
    public static boolean studentExists(String netId) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.split(",")[0].trim();
                if (line.equalsIgnoreCase(netId.trim())) {
                    System.out.println("NetId is found");
                    return true;
                }
            }

        }
        return false;
    }
    static int getStudentCount() {
      return studentCount;
    }
}