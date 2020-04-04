package com.gmail.estrynvladislav;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

@AllArgsConstructor
public class CheckPageTask implements Runnable {

    private static final String DRIVER_URL = "src/main/resources/chromedriver";
    @Setter
    private String urlAddress;

    @SneakyThrows
    public void run() {
        // config
        System.setProperty("webdriver.chrome.driver", DRIVER_URL);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(capabilities); // end

        driver.get(urlAddress);
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/index/ul/li[1]/a"));
        element.click();
        Thread.sleep(3000);
        driver.navigate().back();
        element = driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/index/ul/li[8]/a"));
        element.click();
        Thread.sleep(3000);
        driver.navigate().back();
        element = driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/index/ul/li[14]/a"));
        element.click();
        Thread.sleep(4000);
        driver.close();
    }
}