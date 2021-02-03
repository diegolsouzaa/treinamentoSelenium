package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suporte.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioPageObjectsTest.csv" )
public class InformacoesUsuarioPageObjectsTest {

    private WebDriver navegador;

    @Before
    public void setUp(){
        navegador = Web.createChrome();
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param(name = "login")String login,
                                                             @Param(name = "password")String password,
                                                             @Param(name = "type")String type,
                                                             @Param(name = "contact")String contact,
                                                             @Param(name = "message")String message
                                                             ) throws InterruptedException {
       String toastText =  new LoginPage(navegador).clickSignin().login(login,password)
                .clickMe().clickTabMoreDataAboutYou().clickBtnAddMoreDataAboutYou()
                .addContact(type, contact).getToastText();

       Assert.assertEquals(message, toastText);

        ;
    }

    @After
    public void tearDown(){

        //navegador.quit();
    }
}
