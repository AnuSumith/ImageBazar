package ImageBazar_Login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login_TC {
	String url = "https://imagesbazaar.appzlogic.com/";
	WebDriver driver = null;

	public void browserSetUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(8000);
		WebElement signIn = driver.findElement(By.xpath("//div[@class='MuiBox-root css-192qrng']/div/button"));
		signIn.click();
	}
//Test case 1
	public void loginWithValidCredentials() throws InterruptedException {
		Thread.sleep(5000);
		WebElement userName = driver.findElement(By.xpath("//input[@id='email']"));
		userName.sendKeys("maya@yopmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("Maya@1234");
		WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		signInButton.click();
		Thread.sleep(2000);
		WebElement toastMessage = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']/child::div[2]"));
		String message = toastMessage.getText();
		System.out.println("displayed success message: " + message);

		if (message.contains("You have Successfully logged In")) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test Failed");

		}

		driver.quit();

	}
	//Test case 2
	public void loginWithInvalidUsername() throws InterruptedException {
		Thread.sleep(5000);
		WebElement userName = driver.findElement(By.xpath("//input[@id='email']"));
		userName.sendKeys("mayayopmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("Maya@1234");
		WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		signInButton.click();
		WebElement errorMessage1 = driver.findElement(By.xpath("//p[@id='email-helper-text']"));
		String message = errorMessage1.getText();
		System.out.println("Displayed error message1: " + message);
		if (message.contains("Please enter Email")) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test Failed");

		}
		driver.quit();

	}
	//Test case 3
	public void loginWithWrongPassword() throws InterruptedException {
		Thread.sleep(5000);
		WebElement userName = driver.findElement(By.xpath("//input[@id='email']"));
		userName.sendKeys("maya@yopmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("Maya12345");
		WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		signInButton.click();
		Thread.sleep(2000);
		WebElement toastMessage = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']/child::div[2]"));
		String message = toastMessage.getText();
		System.out.println("displayed Error message2: " + message);
		if (message.contains("Incorrect password!")) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test Failed");

		}
		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {
		Login_TC obj = new Login_TC();
		obj.browserSetUp();
		obj.loginWithValidCredentials();
		obj.browserSetUp();
		obj.loginWithInvalidUsername();
		obj.browserSetUp();
		obj.loginWithWrongPassword();
	}

}
