package dal;

import java.util.List;
import models.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoryDAO extends DBContext{
    public List<Category> getAllCategories(){
        String sql = "SELECT * FROM tbCategory";
        List<Category> catList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(2);
                Category x = new Category(id, name);
                catList.add(x);
            }
            return catList;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
