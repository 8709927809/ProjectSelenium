package MavenAmazonProject.MavenAmazonProject;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.amazonpages.BaseClass;
import com.amazonpages.Product;

public class AmazonTest extends BaseClass {
	@Test(enabled=false)
	public void searchProductAndSort(){
		Product prod=PageFactory.initElements(driver, Product.class);
		prod.searchProduct();
		prod.sortAllProduct();
	}
	
	@Test(enabled=true)
	public void selectOneProductAndAddToCart(){
		Product prod=PageFactory.initElements(driver, Product.class);
		prod.searchProduct();
		prod.selectOneProduct();
		prod.clickOnAddToCartButton();
	}
}
