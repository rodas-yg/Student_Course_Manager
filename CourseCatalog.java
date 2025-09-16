import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final public class CourseCatalog {
    String courseName;
    int level;
    int credits;
    List<CourseCatalog> prerequisites;
    int maxEnrollment;
    String courseID;
    int enrolled;
    boolean isFull;
    static String fileName;
    CourseCatalog(String courseID,
                  String courseName,
                  int credits,
                  List<CourseCatalog> prerequisites,
                  int maxEnrollment, int level) throws IOException {
        this.courseName = courseName;
        this.credits = credits;
        this.level = level;
        this.maxEnrollment = credits;
        this.prerequisites = prerequisites;
        this.enrolled = 0;
        this.courseID = courseID;
        this.isFull = false;
        fileName = "Courses.csv";
        writeCourseCatalog();
    }
    void writeCourseCatalog() throws IOException {
        if (!courseExists(this.courseID)) {
            try(FileWriter fw = new FileWriter(fileName)){
                System.out.println("Writing " + this.courseID + " to " + fileName);
                fw.append(this.courseID);
                fw.append(",");
                fw.append(this.courseName);
                fw.append(",");
                fw.append(Float.toString(minGpa(this.level)));
                fw.append(",");
                fw.append(Integer.toString(this.maxEnrollment));
                fw.append(",");
                fw.append(String.join(this.prerequisites.toString(),"|"));
                fw.append("\n");
                System.out.println("Course added to " + fileName);
            }
            catch(IOException e){
                System.out.println("Error writing to file");
            }
        }

    }

    boolean courseExists(String courseID) throws IOException {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                line = line.split(",")[0].trim();
                if (line.contains(courseID)) {
                    return true;
                }
            }
            return false;
        }

    }
    float minGpa(int level) {
        if (level <= 1000) {
            return 2.0F;
        } else if (level <= 1500) {
            return 2.8F;
        } else if (level <= 2000) {
            return 3.0F;
        } else if (level > 2000) {
            return 3.2F;
        }
        return 0.0F;
    }

}
