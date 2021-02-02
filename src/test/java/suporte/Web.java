package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {

    public static WebDriver createChrome(){
        WebDriver navegador;
        System.setProperty("webdriver.chrome.driver", "/home/s2it_dsouza/tools/chromedriver_linux64/chromedriver");
        navegador = new ChromeDriver();
        navegador.get("http://www.juliodelima.com.br/taskit");
        navegador.manage().window().maximize();
        return navegador;

    }
}
