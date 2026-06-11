
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
        dao.addStudent("005", "Nguyễn Tiến Tùng", "19", "2000-03-13");
        
        List<Student> stdLst = new ArrayList<>();
        stdLst=dao.getAllStudent();
        
        for (Student s : stdLst) {
            System.out.println(s.toString());
        }
        
        System.out.println("");
        Student x = dao.getStudentById("004");
        System.out.println(x.toString());
        
        dao.updateStudent("004", "Tần Thuỷ Hoàng", "99", "1880-05-25");
        x = dao.getStudentById("004");
        System.out.println(x.toString());
    }
    
}
