package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver navegador) {
        super(navegador);
    }

    // caso a ação do click nos leve para outra pagina, devemos retornar ela
    public LoginFormPage clickSignin(){
        navegador.findElement(By.linkText("Sign in")).click();
        return new LoginFormPage(navegador);

    }

}
