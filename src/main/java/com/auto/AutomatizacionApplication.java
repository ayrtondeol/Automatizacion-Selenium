package com.auto;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutomatizacionApplication {
	public static WebDriver driver;
	public static WebElement email;
	static String url = "https://www.consultoriaglobal.com.ar/";
	
	public static void main(String[] args) {
		SpringApplication.run(AutomatizacionApplication.class, args);
		
		File file = new File("chromedriver.exe");
		String path = file.getAbsolutePath();
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println("\n Se ingresó a la página de Consultoria Global");
		driver.findElement(By.id("menu-item-1364")).click();
		System.out.println("\n Se accedió a la sección de contacto");
	    email = driver.findElement(By.name("your-email"));
		email.sendKeys("ayrtondeoliveiras9gmail.com");
		System.out.println("\n Se seleccionó la casilla de email y se ingresó una dirección inválida (no tiene @)");
		driver.findElement(By.className("wpcf7-submit")).click();
		System.out.println("\n Se seleccionó el botón de enviar formulario y se aguardan resultados");
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	    if(driver.findElement(By.xpath("//*[@id=\"wpcf7-f1297-p370-o1\"]/form/p[2]/span/span")).isDisplayed())
			{
		System.out.println("\n La dirección de correo electrónico ingresada es inválida");
			}
	}
}
