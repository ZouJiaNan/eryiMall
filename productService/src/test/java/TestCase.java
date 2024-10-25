import com.eryi.Main;
import com.eryi.domain.Product;
import com.eryi.domain.query.ProductQuery;
import com.eryi.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Main.class)
public class TestCase {
    @Autowired
    ProductService productService;
    @Test
    public void test_01(){
        productService.getProductList(new ProductQuery());
    }
}
