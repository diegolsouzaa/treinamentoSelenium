package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver navegador;

    public LoginPage(WebDriver navegador){
        this.navegador=navegador;

    }

    public LoginFormPage clickSignin(){
        navegador.findElement(By.linkText("Sign in")).click();
        return new LoginFormPage(navegador);

    }

}
