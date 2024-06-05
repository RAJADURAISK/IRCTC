package IrctcBookig;
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class BookingRun 
	{
	@BeforeTest
	public void setup()
	{
		BussesBooking.setup();
	}
	@BeforeMethod
	public void puturl()
	{
		BussesBooking.gaturl();
	}
	public void busselect() throws InterruptedException
	{
		BussesBooking.busesselect();
		BussesBooking.WindowsHandles();
		BussesBooking.BoardingPoint();		
	}
	@AfterMethod
	public void searchbus() throws InterruptedException
	{
		BussesBooking.selectbus();
		BussesBooking.PayDetails();
	}
	@AfterTest
	public void quit() throws InterruptedException
	{
		BussesBooking.logout();
		BussesBooking.quite();
	}
	}
