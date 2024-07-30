package Functions;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.InputStream;
import java.util.Properties;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
//import java.util.logging.Logger;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ie.InternetExplorerOptions;

//import org.apache.log4j.Logger;

public class WebDriverFactory {

    private static Properties pro = new Properties();
    private static InputStream in = CreateDriver.class.getResourceAsStream("../test.properties");
    private static String resourceFolder;
    private static final Logger log = LogManager.getLogger(WebDriverFactory.class);
    private static WebDriverFactory instance = null;


     private WebDriverFactory() {
     }
     public static WebDriverFactory getInstance(){
         if (instance == null){
             instance = new WebDriverFactory();
         }

         return instance;
     }
     public static WebDriver createNewWebDriver(String browser, String os) throws IOException{

             WebDriver driver;
             pro.load(in);
            // browser = pro.getProperty("browser");
            // os = pro.getProperty("os");
             resourceFolder = pro.getProperty("resourceFolder");

         ChromeOptions options = new ChromeOptions();
         options.setCapability("acceptInsecureCerts", true);
         FirefoxProfile firefoxProfile = new FirefoxProfile();
         firefoxProfile.setAcceptUntrustedCertificates(true);

         // Configuración adicional de opciones de Firefox
         FirefoxOptions firefoxOptions = new FirefoxOptions();
         firefoxOptions.setProfile(firefoxProfile);

         // Configuración para manejar certificados SSL en Internet Explorer
         InternetExplorerOptions ieOptions = new InternetExplorerOptions();
         ieOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

         EdgeOptions edgeOptions = new EdgeOptions();
         //esta linea es para desahibilitar la ejecucion en segundo plano

         edgeOptions.addArguments("--headless");

         edgeOptions.setCapability("acceptInsecureCerts", true);


     /******************* the driver is Firefox ************/
     if ("FIREFOX".equalsIgnoreCase(browser)) {
         if("WINDOWS".equalsIgnoreCase(os)) {
             System.setProperty("webdriver.gecko.driver", resourceFolder + "geckodriver.exe");
         }
         else{
             System.setProperty("webdriver.gecko.driver", resourceFolder + "geckodriver");
         }
         driver = new FirefoxDriver(firefoxOptions);
     }

     /******************* the driver is Chrome ************/

     if ("CHROME".equalsIgnoreCase(browser)) {
         if("WINDOWS".equalsIgnoreCase(os)) {
             System.setProperty("webdriver.chrome.driver", resourceFolder+"chromedriver.exe");

         }
         else{
             System.setProperty("webdriver.chrome.driver", resourceFolder+"chromedriver");

         }

         driver = new ChromeDriver(options);


     }

         /******************* the driver is EDGE ************/

         if ("EDGE".equalsIgnoreCase(browser)) {
             if("WINDOWS".equalsIgnoreCase(os)) {
                 System.setProperty("webdriver.edge.driver", resourceFolder+"msedgedriver.exe");

             }
             else{
                 System.setProperty("webdriver.edge.driver", resourceFolder+"msedgedriver");


             }

             driver = new EdgeDriver(edgeOptions);


         }


     /******************* the driver is IExplorer ************/
     else {
         if ("SAFARI".equalsIgnoreCase(browser)) {
             System.setProperty("webdriver.chrome.driver", resourceFolder +"msedgedriver.exe");
             driver = new InternetExplorerDriver(ieOptions);
         }
         else {
             //log.error("The driver is not selected propertly, invalid name:"+browser +","+ os);
             log.info("posible Error");
             return null;
         }

     }

        driver.manage().window().maximize();
     return driver;

 }


}
