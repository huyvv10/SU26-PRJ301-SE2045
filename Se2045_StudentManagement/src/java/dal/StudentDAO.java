package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Student;

public class StudentDAO {
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Student> getAllStudent(){
        List<Student> listStd = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            conn = db.getConnection();
            String sql = "SELECT * FROM tbStudent";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                Date date = rs.getDate(4);
                Student x = new Student(id, name, age, date);
                listStd.add(x);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listStd;
    }
    
    public void deleteStudent(String id){
        try {
            DBContext db = new DBContext();
            conn = db.getConnection();
            String sql = "DELETE FROM tbStudent\n" +
                         "WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
        
    
}
