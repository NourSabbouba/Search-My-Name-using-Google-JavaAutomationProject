cmdimport org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyClass {

WebDriver driver= new ChromeDriver();
SoftAssert MyAssertion = new SoftAssert();
	
   @BeforeTest
   public void mysetup() {
	  
	   driver.get("https://www.google.com");
	   
		//Locate the search box and insert my name
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Nour Sabbouba");
				
		//Click the search button
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")).click();
   }


  @Test()
  public void check_the_result() {
	  String result = driver.findElement(By.id("result-stats")).getText().split(" ")[1];
	  int Actual =Integer. parseInt(result);
	 int Expected =10;
	 
	MyAssertion.assertEquals(Actual, Expected);
	MyAssertion.assertAll();
  }
  

 @AfterTest
 public void theEnd () {
	 driver.close();
 }
  
  
}