package StepDefinitions;

import Functions.CreateDriver;
import Functions.SeleniumFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AmazonExample {

    private static Properties pro = new Properties();
    private static InputStream in = CreateDriver.class.getResourceAsStream("../test.properties");


    WebDriver driver;
    @Given("Iniciar el browser Amazon")
    public void iniciar_el_browser() throws IOException {

        driver = Hooks.driver;
        pro.load(in);

    }


    @Given("El cliente se encuentra en la pantalla Principal Amazon")
    public void el_cliente_se_encuentra_en_la_pantalla_de_logeo() throws IOException {
        pro.load(in);
        String url = pro.getProperty("MainAppUrlBaseAmazon");

        driver.get(url);

    }
    @Then("cargar el POM de Amazon {string}")
    public void cargarElDOMDeMiPagina(String archivojsonName) throws IOException, ParseException {

    SeleniumFunctions.FileName = archivojsonName;
        SeleniumFunctions.readJson();

    }

    @And("teclear mi palabra de busqueda Amazon {string} {string}")
    public void teclearMiBusqueeda(String text, String element) throws IOException, ParseException {

        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElement).sendKeys(text);


    }

    @And("hago clic en el boton buscar Amazon {string}")
    public void hagoClicEnElBotonBusquedaAmazon(String element) throws IOException, ParseException {
        System.out.println(element);
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElement).click();


    }


    @And("tomo captura de pantalla Amazon {string}")
    public void tomoCapturaDePantallaAmazon(String name) throws IOException {
        SeleniumFunctions.Screenshot(name);
    }


    @Then("capturo pantalla para reporte Amazon {string}")
    public void capturoPantallaParaReporteAmazon(String name)  {
        SeleniumFunctions.attachScreenShot(name);
    }

    @Then("cerrar navegador Amazon")
    public void cerrar_navegador()  {
        driver.quit();
    }

}
