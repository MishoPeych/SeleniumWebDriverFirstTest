package org.example;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    static void main() {

        WebDriver driver = new ChromeDriver();
                driver.navigate().to("https://www.selenium.dev/documentation/");
                var buttonGrid = driver.findElement(By.xpath("//*[@id='m-documentationgrid']"));
                buttonGrid.click();
                var components = driver.findElement(By.xpath("//*[@id='m-documentationgridcomponents']"));
                components.click();

                var title  = driver.getTitle();

                Assertions.assertEquals("Selenium Grid Components | Selenium",title);


                driver.quit();
            }

            public void checkTitle(){


            }
        }
