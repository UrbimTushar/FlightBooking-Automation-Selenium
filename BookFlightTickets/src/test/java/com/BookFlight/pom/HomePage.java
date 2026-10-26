package com.BookFlight.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
     By close = By.xpath("//span[@class=\"commonModal__close\"]");	
	 By roundTripButton = By.xpath("//li[@data-cy=\'roundTrip\']");
	 By sourceCity = By.id("fromCity");
	 By sourceSearchBox = By.xpath("//input[@aria-controls=\"react-autowhatever-1\"] ");
	 By destinationCity = By.id("toCity");
	 By destinationSearchBox = By.xpath("//input[@aria-controls=\"react-autowhatever-1\"]");
	 By searchButton = By.xpath("//a[@class=\"primaryBtn font24 latoBold widgetSearchBtn \"]");
	 
	 //Action method :
	 
	 public void closePopUp() throws InterruptedException
	 {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    wait.until(ExpectedConditions.elementToBeClickable(close)).click();
	 }
	 public void clickRoundTripButton() throws InterruptedException
	 {
		 driver.findElement(roundTripButton).click();
	 }
	 public void enterSourceCity(String fromCity)throws InterruptedException
	 {
		 driver.findElement(sourceCity).click();

		    WebElement searchBox = driver.findElement(sourceSearchBox);
		    searchBox.clear();
		    searchBox.sendKeys(fromCity);

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		    By puneAirport = By.xpath(
		            "//li[@role='option'][.//p[@class='revampedAirportName' and text()='Pune Airport']]"
		    	    );

		    	    WebElement airport = wait.until(
		    	        ExpectedConditions.visibilityOfElementLocated(puneAirport)
		    	    );

		    	    JavascriptExecutor js = (JavascriptExecutor) driver;
		    	    js.executeScript("arguments[0].scrollIntoView({block:'center'});", airport);

		    	    wait.until(ExpectedConditions.elementToBeClickable(airport)).click();
		    	}
	 
	 
	 public void enterdestinationCity(String toCity)throws InterruptedException
	 {
		 driver.findElement(destinationCity).click();
		 driver.findElement(destinationSearchBox).sendKeys(toCity);
		 driver.findElement(By.xpath("//p[@class='revampedAirportName' and text()='Chhatrapati Shivaji International Airport']")).click();
		 
	 }
	 public void selectDeparturDate() throws InterruptedException
	 {
		 JavascriptExecutor js= (JavascriptExecutor) driver; 
		 js.executeScript("window.scrollIntoView()",  "");   
		 driver.findElement(By.xpath("//div[@aria-label='Tue Oct 27 2026']") ).click();
		 
	 }
	 public void selectReturndate() throws InterruptedException
	 {
		 driver.findElement(By.xpath("\"//div[@aria-label='Tue Oct 29 2026']\"")).click();
	 }
    public void clickSearchButton()
    {
    	 WebDriverWait wait =
    		        new WebDriverWait(driver, Duration.ofSeconds(15));

    		    // Close calendar by clicking outside it
    		    driver.findElement(By.xpath("//span[text()='Flights']")).click();

    		    // Wait until Search button is clickable
    		    wait.until(
    		        ExpectedConditions.elementToBeClickable(searchButton)
    		    ).click();
    }
	 
}
    
