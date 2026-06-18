package dal;

import java.util.ArrayList;
import java.util.List;
import models.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class ProductDAO extends DBContext{
    public List<Product> getAllProducts(){
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM tbProduct";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(2);
                int qty = rs.getInt(3);
                Date impDate = rs.getDate(4);
                double price = rs.getDouble(5);
                String catId = rs.getString(6);
                Product x = new Product(id, name, qty, impDate, price, catId);
                productList.add(x);
            }
            return productList;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public List<Product> searchProductByName(String kw){
        List<Product> rsSearch = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tbProduct\n" +
                     "WHERE name LIKE '%"+kw+"%'";
//            String sql = "SELECT * FROM tbProduct\n" +
//                     "WHERE name LIKE '%?%'";
            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, kw);
            ResultSet rs = ps.executeQuery();            
            while (rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(2);
                int qty = rs.getInt(3);
                Date impDate = rs.getDate(4);
                double price = rs.getDouble(5);
                String catId = rs.getString(6);
                Product x = new Product(id, name, qty, impDate, price, catId);
                rsSearch.add(x);
            }    
            return rsSearch;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
