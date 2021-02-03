package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage {


    public LoginFormPage(WebDriver navegador) {
        super(navegador);
    }

    // caso apos a ação eu permaneça na mesma pagina, deve retornar a mesma pagina que estou
    public LoginFormPage typeEmail(String login){
        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);
        return this;
    }

    // caso apos a ação eu permaneça na mesma pagina, deve retornar a mesma pagina que estou
    public LoginFormPage typePassword(String password){
        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);
        return this;
    }

    // caso a ação do click nos leve para outra pagina, devemos retornar ela
    public SecretPage clickBtnSignIn(){
        navegador.findElement(By.linkText("SIGN IN")).click();
        return new SecretPage(navegador);

    }

    public SecretPage login(String login, String password){
       typeEmail(login);
       typePassword(password);
       clickBtnSignIn();
       return new SecretPage(navegador);
    }



}
