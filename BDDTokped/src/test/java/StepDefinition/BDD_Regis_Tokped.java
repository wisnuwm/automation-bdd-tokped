package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.*;

public class BDD_Regis_Tokped {

	WebDriver driver=null;
	@Given("User open browsers")
	public void user_open_browsers() {
	    
		System.out.println("Steps - User open browsers");
	    
		//disable notif browser
		ChromeOptions opt = new ChromeOptions(); 
		opt.addArguments("--disable-notifications");

		//chromedriver setup
		System.setProperty("webdriver.chrome.driver", "C:/Users/wisnu/eclipse-workspace/BDDTokped/src/test/resources/drivers/chromedriver.exe");

		//open Chrome browser
		driver = new ChromeDriver();

		//Maximize browser
		driver.manage().window().maximize();

	}

	@Given("User on tokopedia register page")
	public void user_on_tokopedia_register_page() {
	    
		System.out.println("Steps - User on tokopedia register page");
		
		//open tokped register page
		driver.get("https://www.tokopedia.com/register");
	}

	@When("User enter email or phone number")
	public void user_enter_email_or_phone_number() {
	    
		System.out.println("Steps - User enter email or phone number");
		
		//enter email or phone number
		driver.findElement(By.id("regis-input")).sendKeys("wisnuwm265@gmail.com");
	}

	@When("Click Daftar button and confirmation")
	public void click_daftar_button_and_confirmation() throws InterruptedException {
	    
		System.out.println("Steps - Click Daftar button and confirmation");
		
		//click daftar button
		driver.findElement(By.xpath("//*[@id=\"zeus-root\"]/div/div[1]/div[3]/div[2]/div/form/button/span")).click();
		Thread.sleep(3000);
		//confirmation Ya Benar
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/button[1]/span")).click();
		Thread.sleep(3000);
	}

	@Then("User navigated to select verify methode")
	public void user_navigated_to_select_verify_methode() {
	 
		System.out.println("Steps - User navigated to select verify methode");
		
		//navigated to select verify methode
		driver.getPageSource().contains("Pilih Metode Verifikasi");
		
		//close browser
		driver.close();
		driver.quit();
	}
}
