package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecretPage extends BasePage {

    public SecretPage(WebDriver navegador) {
        super(navegador);
    }

    public MePage clickMe() throws InterruptedException {
        Thread.sleep(2000);
        navegador.findElement(By.className("me")).click();
        return new MePage(navegador);

    }
}
