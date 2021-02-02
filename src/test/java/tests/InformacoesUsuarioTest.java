package tests;

import java.util.concurrent.TimeUnit;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.ScreenShot;
import suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioTest.csv")
public class InformacoesUsuarioTest {

    private WebDriver navegador;

    @Rule
    public TestName nomeDoTeste = new TestName();

    @Before
    public void setUp()
    {
        navegador = Web.createChrome();

        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //clicar em signin
        navegador.findElement(By.linkText("Sign in")).click();

        //Identificando o formulario de login
        WebElement formularioSinginBox = navegador.findElement(By.id("signinbox"));

        // digitar no campo name "login" o texto julio001
        formularioSinginBox.findElement(By.name("login")).sendKeys("julio0001");

        // clicar no campo com name "password" que esta dentro no formulario com id "signinbox"
        formularioSinginBox.findElement(By.name("password")).sendKeys("123456");

        // clicar no LINK com o texto SIGN IN (<a href= ...>)
        navegador.findElement(By.linkText("SIGN IN")).click();

        // clicar em um link que possui a class 'me'
        navegador.findElement(By.className("me")).click();

        // clicar em um link que possui o texto MORE DATA ABOUT YOU
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param(name = "tipo")String tipo, @Param(name="contato")String contato, @Param(name = "mensagemEsperada")String mensagemEsperada)
    {
        // clicar em um botao atraves do seu xpath
        navegador.findElement(By.xpath("//button[@data-target='addmoredata']")).click();

        // identificar a popup onde está o formulario de id 'addmoredata'
        WebElement popupaAddMoreData = navegador.findElement(By.id("addmoredata"));

        // no combo de name "type" escolher a opçao "Phone"
        WebElement campoType = popupaAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);

        // no campo de name "contact" inserir o valor
        popupaAddMoreData.findElement(By.name("contact")).sendKeys(contato);

        // clicar no link de text 'Save' que está na popup
        popupaAddMoreData.findElement(By.linkText("SAVE")).click();

        // na mensagem de id 'toast-container' validar que o texto é 'Your contact has been added!'
        WebElement mensagemSucess = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemSucess.getText();
        Assert.assertEquals(mensagemEsperada, mensagem);

    }

    @Test
    public void removerUmContatoDeUmUsuario()
    {
        // encontrar e clicar n o meu telefone pelo xpath: //span[text()="+5516912345678"]/following-sibling::a
        navegador.findElement(By.xpath("//span[text()='+5516912345678']/following-sibling::a")).click();

        // interagir com o pop up java scrip
        navegador.switchTo().alert().accept();

        // validar a exibiçao da 'Rest in peace, dear phone!'
        WebElement mensagemSucess = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemSucess.getText();
        Assert.assertEquals("Rest in peace, dear phone!", mensagem);

        String screenShotArquivo = "/home/s2it_dsouza/TestReport/taskit_" + Generator.dataHoraParaArquivo() + "_" + nomeDoTeste.getMethodName() + ".png";
        ScreenShot.tirarScreenShot(navegador,screenShotArquivo);

        // aguardar ate 10 seg para que a janela desapareça
        WebDriverWait aguardar = new WebDriverWait(navegador,10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemSucess));

        // fazer logout, clicando no link com o texto logout
        navegador.findElement(By.linkText("Logout")).click();
    }

    @After
    public void tearDown()
    {
        navegador.quit();
    }

}
