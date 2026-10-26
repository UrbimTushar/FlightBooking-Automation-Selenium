package com.BookFlight.TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.BookFlight.pom.HomePage;

public class TestCases {

    WebDriver driver;


    @BeforeTest
    public void launchChromeBrowser()
    {
    	 driver =new ChromeDriver();
    	 driver.get("https:/www.makemytrip.com/");
    	 driver.manage().window().maximize();
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
	}
	
	@Test
	public void searchFlightTickets() throws InterruptedException
	{
		HomePage homepage =new HomePage(driver);
		homepage.closePopUp();
		homepage.clickRoundTripButton();
		homepage.enterSourceCity("Pune");
		homepage.enterdestinationCity("Mumbai");
		homepage.clickSearchButton();
		
	}
	
	@AfterTest
	
	public void CloseBrowser()
	{
		driver.close();
	}
	
	
}
