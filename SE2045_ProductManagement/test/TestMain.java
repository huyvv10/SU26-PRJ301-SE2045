
import dal.CategoryDAO;
import dal.ProductDAO;
import java.util.ArrayList;
import java.util.List;
import models.Category;
import models.Product;

public class TestMain {
    public static void main(String[] args) {
//        CategoryDAO catDao = new CategoryDAO();
//        List<Category> catList = new ArrayList<>();
//        catList = catDao.getAllCategories();
//        for (Category c : catList) {
//            System.out.println(c.toString());
//        }
//        
//        System.out.println("");
//        ProductDAO prdDao = new ProductDAO();
//        List<Product> prdList = new ArrayList<>();
//        prdList = prdDao.getAllProducts();
//        
//        for (Product p : prdList) {
//            System.out.println(p.toString());            
//        }
        
//        ProductDAO prdDao = new ProductDAO();
//        List<Product> prdList = new ArrayList<>();
//        prdList = prdDao.searchProductByName("sung", "all");
//        for (Product p : prdList) {
//            System.out.println(p.toString());            
//        }     
        System.out.println("\n---Test paging---");
        ProductDAO prdDao = new ProductDAO();
        List<Product> prdList = new ArrayList<>();
        prdList = prdDao.pagingProducts(3, 7);
        for (Product p : prdList) {
            System.out.println(p.toString());            
        }        
    }
}
