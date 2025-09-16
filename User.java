import java.util.ArrayList;
import java.util.List;

public abstract class User {
    String netId;
    protected String password;
    float prevGPA;
    String name;
    List<String> pastCourses;
    User(String netId, String password){
        this.netId = netId;
        this.password = password;
    }
    User(String netId, String name, float prevGPA, List<String> pastCourses) {
        this.name = name;
        this.netId = netId;
        this.prevGPA = prevGPA;
        this.pastCourses = pastCourses;
    }


}
