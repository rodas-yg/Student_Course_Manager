import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.List;

//public class Student_CSV_Writer extends Student {

//    Student_CSV_Writer(String netId, String fullName, int preGPA, List<String> pastCourses) {
//        super(netId, fullName, preGPA, pastCourses);
//    }

//    void writeCSV(String fileName) {
//        String filename = "Student.csv";
//        try(FileWriter fw = new FileWriter(fileName, true)){ //set the append mode to true so that it won't override things
//            boolean fileExists = new File(fileName).exists(); //checks if th  e file already exists
//            String fLine = "";
//            if(!fileExists){
//                fw.append("NetID,Full Name,GPA,Courses Taken\n");
//            }
//            else{
//                fw.append(this.netId);
//                fw.append(",");
//                fw.append(this.name);
//                fw.append(",");
//                fw.append(Integer.toString(this.prevGPA));
//                fw.append(String.join("|", this.pastCourses));
//                fw.append("\n");
//            }
//
//        }
//        catch(IOException e){
//            System.out.println("Problem writing to file");
//        }
//    }
//}
