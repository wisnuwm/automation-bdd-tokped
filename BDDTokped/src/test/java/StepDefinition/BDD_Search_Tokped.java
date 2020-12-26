package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.*;

public class BDD_Search_Tokped {

	WebDriver driver=null;
	
	@Given("User open browser")
	public void user_open_browser() {
	    
		System.out.println("Step - User open browser");
		
		//disable notif browser
		ChromeOptions opt = new ChromeOptions(); 
		opt.addArguments("--disable-notifications");

		//chromedriver setup
		System.setProperty("webdriver.chrome.driver", "C:/Users/wisnu/eclipse-workspace/BDDTokped/src/test/resources/drivers/chromedriver.exe");

		//open Chrome browser
		driver = new ChromeDriver(opt);

		//Maximize browser
		driver.manage().window().maximize();
	}

	@And("User on tokopedia homepage")
	public void user_on_tokopedia_homepage() {
	    
		System.out.println("Step - User on tokopedia home");
		
		//tokped homepage
		driver.get("https://www.tokopedia.com/");
	}

	@When("User search seblak on search box")
	public void user_search_seblak_on_search_box() throws InterruptedException {
	    
		System.out.println("Step - user search seblak on search box");
		
		//searching seblak on search box
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div[2]/form/div/div/input")).sendKeys("seblak");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[1]/div/div[2]/div[2]/form/div/div/input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@Then("User navigated to seblak result page")
	public void user_navigated_to_seblak_result_page() {
	    
		System.out.println("Step - user navigated to seblak result page");
		
		//seblak result page
		driver.getPageSource().contains("seblak hot");
		
		//close browser
		driver.close();
		driver.quit();
	}
	
}
