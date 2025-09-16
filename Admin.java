public class Admin extends User {
    /*
    Adds available courses and makes changes to them.
    See which students are enrolled in a course
     */
    String username;
    String password;
    public Admin(String username, String password) {
        super(username, password);
    }
}
