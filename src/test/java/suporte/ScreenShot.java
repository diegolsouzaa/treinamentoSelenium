package suporte;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class ScreenShot {

    public static void tirarScreenShot(WebDriver navegador, String arquivo)
    {
        File screenshot = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);

        try {

            FileUtils.copyFile(screenshot, new File(arquivo));

        }catch (Exception ex)
        {
            System.out.println("problemas pra copiar o arquivo" + ex.getMessage());
        }

    }

}
