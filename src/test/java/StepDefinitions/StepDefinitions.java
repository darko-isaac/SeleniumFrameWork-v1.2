package StepDefinitions;

import Functions.CreateDriver;
import Functions.SeleniumFunctions;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class StepDefinitions {

    private static Properties pro = new Properties();
    private static InputStream in = CreateDriver.class.getResourceAsStream("../test.properties");

   /* WebDriver driver;

    public StepDefinitions(){
        driver = Hooks.driver;
    }
*/
   WebDriver driver;
    private Scenario scenario;
    @Given("Iniciar el browser")

    public void iniciar_el_browser() throws IOException {

        driver = Hooks.driver;
        pro.load(in);
        String url = pro.getProperty("MainAppUrlBase");

        driver.get(url);
    }


    @Given("El cliente se encuentra en la pantalla de logeo")
    public void el_cliente_se_encuentra_en_la_pantalla_de_logeo() throws IOException {
        pro.load(in);
        String url = pro.getProperty("MainAppUrlBase");

        driver.get(url);
        //driver.quit();
    }



    @Then("cargar el DOM de mi pagina {string}")
    public void cargarElDOMDeMiPagina(String archivojsonName) throws IOException, ParseException {

        /*este bloque de codigo sirve para leer mi variable del nombre
        del archivo json en caso de enviarme error pasando el parametro directo en cucumber

      pro.load(in);
        String file = pro.getProperty("JSONFileNameDOM");
       */

        SeleniumFunctions.FileName = archivojsonName;
        SeleniumFunctions.readJson();

        /*solo es un ejemplo de como lee el elmento del json
        JSONObject Entity = SeleniumFunctions.ReadEntity("Email");
        System.out.println(Entity);
        */
    }
    @And("hago clic en el boton login {string}")
    public void hagoClicEnElBotonLogin(String element) throws IOException, ParseException {
        By seleniumElement = SeleniumFunctions.getCompleteElement(element);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera hasta 10 segundos
        wait.until(ExpectedConditions.elementToBeClickable(seleniumElement));

        driver.findElement(seleniumElement).click();
    }
    @And("teclear mi correo {string} en el elemento {string}")
    public void teclearMiCorreo(String text, String element) throws IOException, ParseException {

        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElement).sendKeys(text);


    }


    @And("teclear mi pass {string} en el campo {string}")
    public void teclearMiPassEnElCampo(String text, String element) throws IOException, ParseException {

        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElement).sendKeys(text);

    }

    @Then("identificar el captcha")
    public void identificarElCaptcha() {
        driver.findElement(By.xpath("//div[@id='login-container-simple']")).click();
        driver.switchTo().frame(0);
    }

    @And("check no soy un robot {string}")
    public void checkNoSoyUnRobot(String element) throws IOException, ParseException, InterruptedException {


        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElement).click();
    }
    @Then("clic en boton submit {string}")
    public void clicEnBotonSubmit(String element) throws IOException, ParseException {
        driver.switchTo().frame("relative=parent");
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElement).click();

    }
    @And("tomo captura de pantalla {string}")
    public void tomoCapturaDePantalla(String name) throws IOException {
        SeleniumFunctions.Screenshot(name);
    }


    @Then("capturo pantalla para reporte {string}")
    public void capturoPantallaParaReporte(String name) throws IOException {
        SeleniumFunctions.attachScreenShot(name);
    }

    @Then("cerrar navegador")
    public void cerrar_navegador() throws IOException {
        driver.quit();
    }


}
