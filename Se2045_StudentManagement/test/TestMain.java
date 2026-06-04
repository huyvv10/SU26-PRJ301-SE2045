
import dal.StudentDAO;
import java.util.ArrayList;
import java.util.List;
import model.Student;

/**
 *
 * @author VU VAN HUY
 */
public class TestMain {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        List<Student> stdLst = new ArrayList<>();
        stdLst=dao.getAllStudent();
        
        for (Student s : stdLst) {
            System.out.println(s.toString());
        }
    }
    
}
