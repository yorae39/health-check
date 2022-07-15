package br.ce.wcaquino.prod;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HealthCheckIT {
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void healtCheck() {
		WebDriver driver = new ChromeDriver();
		
		try {
			driver.navigate().to("http://192.168.0.106:9999/tasks/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String version = driver.findElement(By.id("version")).getText();
			Assert.assertTrue(version.startsWith("build"));
		} finally {
			driver.quit();
		}
	
	}

}
