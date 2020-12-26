# automation-bdd-tokped
Automation Web Testing using Selenium Java, 
#BDD Testing using Cucumber Selenium Java

This project is for my portofolio
-
Hi, My name is Wisnu Munawar,
I Love outdoor activity like hiking, camping etc,
I studied informatics engineering at Indraprasta PGRI University

My resume : 
<a href="https://www.canva.com/design/DAEN6UE9gHw/IT44M4JB4SRFftmqu8O9TQ/view?utm_content=DAEN6UE9gHw&utm_campaign=designshare&utm_medium=link&utm_source=publishsharelink">Click Here</a>

# Guidance
1. Create Maven project Eclipse
<img src="https://i.imgur.com/zY7bWiW.jpg" width="500">
<img src="https://i.imgur.com/kkvv9qG.jpg" width="500">
<img src="https://i.imgur.com/J4PTujs.jpg" width="500">
<img src="https://i.imgur.com/GFdzmJI.jpg" width="500">


2. add dependencies at pom.xml
```

<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<maven.compiler.source>1.8</maven.compiler.source>
		<maven.compiler.target>1.8</maven.compiler.target>
	</properties>

	<dependencies>

		<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-java</artifactId>
			<version>6.9.0</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/junit/junit -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.13.1</version>
			<scope>test</scope>
		</dependency>

		<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-junit</artifactId>
			<version>6.9.0</version>
			<scope>test</scope>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>3.141.59</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/net.masterthought/cucumber-reporting -->
		<dependency>
			<groupId>net.masterthought</groupId>
			<artifactId>cucumber-reporting</artifactId>
			<version>5.4.0</version>
		</dependency>


	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
				<version>2.22.0</version>
				<configuration>
					<testFailureIgnore>true</testFailureIgnore>
				</configuration>
			</plugin>
			<plugin>
				<groupId>net.masterthought</groupId>
				<artifactId>maven-cucumber-reporting</artifactId>
				<version>2.8.0</version>
				<executions>
					<execution>
						<id>execution</id>
						<phase>verify</phase>
						<goals>
							<goal>generate</goal>
						</goals>
						<configuration>
							<projectName>BDD-KasKus</projectName>
							<outputDirectory>${project.build.directory}/cucumber-report-html</outputDirectory>
							<cucumberOutput>${project.build.directory}/cucumber.json</cucumberOutput>
						</configuration>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>

```
3. Create folder drivers at src/test/resources and Add chromedriver.exe to src/test/resources/drivers
<br><img src="https://i.imgur.com/CQ3QaDA.jpg" width="500"> </br>

4. Create folder Features at src/test/resources
<br><img src="https://i.imgur.com/i9lwtPN.jpg" width="500"> </br>

5. Create file login-kaskus.feature
<img src="https://i.imgur.com/UTcR4rQ.jpg" width="500">
<img src="https://i.imgur.com/SlvYyrm.jpg" width="500">

6. add code
```

Feature: Feature test tokopedia login page
  User want to login successfully

  Scenario: Validate tokopedia login is working
    Given User open the browser
    And User on tokopedia login page
    When User enter valid email or phone number
    And Click Selanjutnya button
    And User enter valid password
    And Click Login button
    Then User navigated to verify with phone number or email

```
7. Right click and Run as Cucumber feature
<br><img src="https://i.imgur.com/oUOzQlV.jpg" width="500"></br>

8. Create folder StepDef at src/test/java and create java class BDD_Login_Tokped.java
```

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
		driver = new ChromeDriver(opt);

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

```

9. Run with cucumber feature again
<br><img src="https://i.imgur.com/oUOzQlV.jpg" width="500"></br>

10. Create Folder Runner at src/test/java and create java class TestRunner.java
<br><img src="https://i.imgur.com/Al0PNr6.jpg" width="500"></br>
```

package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
	
	@RunWith(Cucumber.class)
	@CucumberOptions(features="src/test/resources/Features/BDD_Search_Tokped.feature",
	glue= {"StepDefinition"},
	plugin ={"json:target/cucumber.json"})

	public class TestRunner {
}

```

11. Run TestRunnet.java as JUnit Test
<br><img src="https://i.imgur.com/IgD8YCC.jpg" width="500"></br>
