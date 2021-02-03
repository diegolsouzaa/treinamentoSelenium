package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver navegador;

    public BasePage(WebDriver navegador){
        this.navegador=navegador;
    }

    public String getToastText() throws InterruptedException {
        Thread.sleep(2000);
        return navegador.findElement(By.id("toast-container")).getText();
    }
}
