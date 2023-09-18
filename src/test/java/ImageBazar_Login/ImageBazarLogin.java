package ImageBazar_Login;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImageBazarLogin {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://imagesbazaar.appzlogic.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement signIn = driver.findElement(By.xpath("//div[@class='MuiBox-root css-192qrng']/div/button"));
		signIn.click();
		WebElement userName = driver.findElement(By.xpath("//input[@id='email']"));
		userName.sendKeys("maya@yopmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("Maya@1234");
		WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		signInButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement browse =driver.findElement(By.xpath("//div[@class='MuiBox-root css-geek62']/button"));
		browse.click();
		WebElement healthFitness =driver.findElement(By.xpath("//button[text()='Health & Fitness']"));
		healthFitness.click();
		WebElement healthyFood =driver.findElement(By.xpath("//button[text()='Healthy Food']"));
		healthyFood.click();
		WebElement healthyFoodImage =driver.findElement(By.xpath("//img[@alt='PK1021230']"));
		healthyFoodImage.click();
		List<String> handles = new ArrayList<String>(driver.getWindowHandles());
    	driver.switchTo().window(handles.get(1));
    	Thread.sleep(5000);
    	JavascriptExecutor js =(JavascriptExecutor)driver;
    	js.executeScript("window.scroll(0,700)","");			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement addToWishList = driver.findElement(By.xpath("//div[@class=\" moreinfo-wallpaper show-image-menu-w-hover\"]/child::div[2]/child::div/child::div[3]/button[2]"));
		addToWishList.click();
    	driver.switchTo().window(handles.get(0));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement wishList =driver.findElement(By.xpath("//button[@aria-label='Wishlist']"));
		wishList.click();

		
		
		
		
		driver.quit();
		
		
	}
}
