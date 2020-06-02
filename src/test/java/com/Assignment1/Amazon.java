package com.Assignment1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) {
		// firefox browser
		// WebDriverManager.firefoxdriver().setup();
		// WebDriver driver = new FirefoxDriver();
		// IE browser
		// WebDriverManager.iedriver().setup();
		// WebDriver driver = new InternetExplorerDriver();
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung");

		driver.findElement(By.className("nav-input")).click();

		int count = driver
				.findElements(By.xpath("//div[@class='sg-col-inner']/div/h2/a/span[contains(text(),'Samsung Galaxy')]"))
				.size();

		System.out.println("number of mobiles displayed  are " + count);

		String name;

		String rating;

		for (int i = 1; i <= count; i++)

		{

			name = driver.findElement(By.xpath(
					"(//div[@class='sg-col-inner']/div/h2/a/span[contains(text(),'Samsung Galaxy')])[" + i + "]"))
					.getText();

			rating = driver
					.findElement(By.xpath(
							"(//div[@class='a-section a-spacing-none a-spacing-top-micro']/div/span[2])[" + i + "]"))
					.getText();

			System.out.println(name + "the rating is " + rating);

		}

		driver.close();

		driver.quit();

	}

}
