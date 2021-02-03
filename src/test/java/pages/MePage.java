package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MePage extends BasePage{


    public MePage(WebDriver navegador) {
        super(navegador);
    }

    public MePage clickTabMoreDataAboutYou(){
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
        return this;
    }

    public AddContactPage clickBtnAddMoreDataAboutYou(){
        navegador.findElement(By.xpath("//button[@data-target='addmoredata']")).click();
        return new AddContactPage(navegador);
    }
}
