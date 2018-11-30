package Selenium;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Selenium {
	
	@Test
	public void testSearch() throws FileNotFoundException, IOException, ParseException
	{
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//driver.get("http://www.google.lk");
		
		String url,searchWord, linkText;
		JSONParser parser = new JSONParser();
		
				
		Object obj = parser.parse(new FileReader(".\\Data\\sel.json"));
		// Object obj = parser.parse(new FileReader("C:\\Users\\Nilmie\\eclipse-workspace\\NG7\\Data\\sel.json"));

	      JSONObject jsonObject = (JSONObject) obj;
	      url = (String) jsonObject.get("URL");
	      searchWord = (String) jsonObject.get("SearchWord");
		  linkText = (String) jsonObject.get("linkSearch");

		  driver.get(url);
		  driver.findElement(By.id("lst-ib")).sendKeys(searchWord);
		  driver.findElement(By.name("btnK")).click();
	
		  //driver.findElement(By.linkText(readExcel(1,2, ".\\Data\\data.xlsx","Sheet1")));
		  driver.findElement(By.xpath("//h3[@class='LC20lb']")).click();
		  
		
		//driver.close();
		//driver.quit();
		
	}
}
