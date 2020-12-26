package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.*;

public class BDD_Login_Tokped {

	WebDriver driver=null;

	@Given("User open the browser")
	public void user_open_the_browser() {
		System.out.println("Steps - User open the browser");
		
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

	@And("User on tokopedia login page")
	public void user_on_tokopedia_login_page() {
		System.out.println("Steps - User on tokopedia login page");

		//open tokped login page
		driver.get("https://www.tokopedia.com/login");
	}

	@When("User enter valid email or phone number")
	public void user_enter_valid_email_or_phone_number() {
		System.out.println("Steps - User enter valid email or phone number");

		//input email or phone number
		driver.findElement(By.id("email")).sendKeys("YourEmail/PhoneNumberHere");
	}

	@And("Click Selanjutnya button")
	public void click_selanjutnya_button() throws InterruptedException {
		System.out.println("Steps - Click Selanjutnya button");

		//click "selanjutnya"
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/section[1]/form/button")).click();
		Thread.sleep(3000);
	}

	@And("User enter valid password")
	public void user_enter_valid_password() {
		System.out.println("Steps - User enter valid password");

		//input password
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("YourPasswordHere");
	}

	@And("Click Login button")
	public void click_login_button() {
		System.out.println("Steps - Click Login button");

		//click "masuk"
		driver.findElement(By.id("login-submit")).click();
	}

	@Then("User navigated to verify with phone number or email")
	public void user_navigated_to_verify_with_phone_number_or_email() throws InterruptedException {
		System.out.println("Steps - User navigated to verify with phone number or email");

		//user navigated to verify account
		driver.getPageSource().contains("Pilih Metode Verifikasi");
		Thread.sleep(3000);

		//close browser
		driver.close();
		driver.quit();
	}

}
