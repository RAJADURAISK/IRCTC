package IrctcBookig;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BussesBooking
{
	public static WebDriver Driver;
	
	public static void setup()
	{
		Driver = new ChromeDriver();
	}
	public static void gaturl()
	{
		Driver.get("https://www.irctc.co.in/nget/train-search");
		Driver.manage().window().maximize();
	}
	public static void busesselect()
	{
		Driver.findElement(By.xpath("/html/body/app-root/app-home/div[1]/app-header/div[2]/div[2]/div[2]/nav/ul/li[4]/a")).click();
		
	}
	public static void WindowsHandles()
	{
		Set<String> BusTickets = Driver.getWindowHandles();
		
		Object[] A1 = BusTickets.toArray();
		String HomePage = A1[0].toString();
		String Buspage = A1[1].toString();
		System.out.println(HomePage);
		System.out.println(Buspage);
		
		Driver.switchTo().window(Buspage);
	}
	public static void BoardingPoint() throws InterruptedException
	{
		//departFrom
		//name="departFrom"--//class="ui-menu-item"
				Driver.findElement(By.name("departFrom")).sendKeys("Chennai");
				Thread.sleep(1000);
				List<WebElement> startPoint = Driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
				for (int i=0;i<startPoint.size();i++)
					{
						System.out.println(startPoint.get(i).getText());
							if(startPoint.get(i).getText().equalsIgnoreCase("Chennai"))
							{
								startPoint.get(i).click();
							}
					}
				Thread.sleep(1000);
				
		//Going to
		//name="goingTo"--//class="ui-menu-item"
				Driver.findElement(By.name("goingTo")).sendKeys("Bangalore");
				Thread.sleep(1000);
				List<WebElement> Endpoint = Driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
				
				for (int i=0;i<Endpoint.size();i++)
				{
					System.out.println(Endpoint.get(i).getText());
					if (Endpoint.get(i).getText().equalsIgnoreCase("Bangalore"))
					{
							Endpoint.get(i).click();
					}
				}
				Thread.sleep(2000);	
				
		//id="departDate"
				WebElement departDate = Driver.findElement(By.partialLinkText("12"));
				departDate.click();
				System.out.println("departDate : " + departDate);
				Thread.sleep(2000); 
				
		//search to bus
				Driver.findElement(By.xpath("/html/body/app-root/ng-component/div[3]/div[2]/div[2]/form/div[4]/button")).click();
				Thread.sleep(4000);
	}
	public static void selectbus () throws InterruptedException
	{
		// select a bus
				WebElement SelectBus = Driver.findElement(By.xpath("//*[@id=\"accordionExample\"]/div[1]/div[7]/button"));
				Actions A = new Actions(Driver);
				A.click(SelectBus).build().perform();
				Thread.sleep(2000);
				
		// select Seat
				WebElement selectseat= Driver.findElement(By.xpath("//*[@id=\"seatLayout0\"]/div/div/div[1]/div/div[2]/div/div[2]/div[2]/span[7]"));
				Actions B = new Actions(Driver);
				B.click(selectseat).build().perform();
				Thread.sleep(3000);
						
		//select Boarding Point
				WebElement bordTime = Driver.findElement(By.xpath("//*[@id=\"myTabContent\"]/div/div/table/tbody/tr[9]/td[1]/input"));
				Actions c = new Actions(Driver);
				c.click(bordTime).build().perform();
				Thread.sleep(1000);

		//select DeBoarding Point
				WebElement Debordtime = Driver.findElement(By.xpath("//*[@id=\"myTabContent\"]/div/div/table/tbody/tr[7]/td[1]/input"));
				Actions d = new Actions(Driver);
				d.click(Debordtime).build().perform();
				Thread.sleep(1000);
				
		// proceed to pay 
				WebElement proceedpay = Driver.findElement(By.xpath("//*[@id=\"seatLayout0\"]/div/div/div[2]/div[2]/div[4]/button"));
				proceedpay.click();
				Thread.sleep(2000);
	}
	public static void PayDetails() throws InterruptedException
	{
		//id="profile-tab"
				WebElement guestuser= Driver.findElement(By.id("profile-tab"));
				guestuser.click();
				Thread.sleep(2000);	 
				
				Driver.findElement(By.id("emailLogin")).sendKeys("rajaduraisk06@gmail.com") ;
				Thread.sleep(1000);
				
				Driver.findElement(By.id("phoneLogin")).sendKeys("6385232544");
				Thread.sleep(1000);
				
				Driver.findElement(By.xpath("//*[@id=\"profile\"]/div/form/div[3]/button")).click();
				Thread.sleep(8000);

		//Contact Details	
				
			//address
				WebElement addressDetails = Driver.findElement(By.name("address"));
				addressDetails.sendKeys("chennai");
				Thread.sleep(3000);
				
			//country
				Driver.findElement(By.name("country")).sendKeys("India");
				Thread.sleep(3000);
				
			//state
				Driver.findElement(By.name("state")).sendKeys("Tamil Nadu");
				Thread.sleep(3000);
				
			//pincode
				Driver.findElement(By.name("pincode")).sendKeys("600024");
				Thread.sleep(3000);
				
			//Traveller Name
				Driver.findElement(By.xpath("/html/body/app-root/ng-component/div/form/div/div/div[1]/div[4]/div[3]/div[2]/input")).sendKeys("Durai sk");
				Thread.sleep(3000);
				
			//Select Gender
				Driver.findElement(By.name("select")).sendKeys("Male");
				Thread.sleep(3000);
				
			//Age
				Driver.findElement(By.xpath("/html/body/app-root/ng-component/div/form/div/div/div[1]/div[4]/div[3]/div[4]/input")).sendKeys("24");
				Thread.sleep(3000);
				
			//agree
				Driver.findElement(By.id("agree")).click();
				Thread.sleep(10000);
				
		  
			   	
	}
	public static void logout() throws InterruptedException
	{
		 //logout
		Driver.findElement(By.id("dropdown11")).click();
		Driver.findElement(By.xpath("//a[text()='Logout']")).click();
	   	Thread.sleep(1000);
	  
	}
	public static void quite()
	{
	  	Driver.quit();
	}
}
