
import dal.CategoryDAO;
import java.util.ArrayList;
import java.util.List;
import models.Category;

public class TestMain {
    public static void main(String[] args) {
        CategoryDAO catDao = new CategoryDAO();
        List<Category> catList = new ArrayList<>();
        catList = catDao.getAllCategories();
        for (Category c : catList) {
            System.out.println(c.toString());
        }
    }
}
