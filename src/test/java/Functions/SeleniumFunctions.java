package Functions;


import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static StepDefinitions.Hooks.driver;

public class SeleniumFunctions {

    private static Properties pro = new Properties();
    private static InputStream in = CreateDriver.class.getResourceAsStream("../test.properties");
    public static String readProperties(String property) throws IOException{
        pro.load(in);
        return pro.getProperty(property);
    }

    private static final int EXPLICIT_TIMEOUT =10;

    public static Map<String, String> HandleMyWindows = new HashMap<>();


    private static final Logger log = LogManager.getLogger(SeleniumFunctions.class);
    public static String FileName = "";
    public static String PageFilePath = "src/test/resources/DOMPage/";
    public static String GetFielBy = "";
    public static String ValueToFind = "";

    public static Object readJson() throws IOException, ParseException {
        FileReader reader = null;

        try {
            reader = new FileReader(PageFilePath + FileName);
            JSONParser jsonParser = new JSONParser();
            return jsonParser.parse(reader);
        } catch (FileNotFoundException | NullPointerException e) {
            log.error("No existe el archivo: " + FileName);
            throw new IllegalStateException("No existe el archivo: " + FileName, e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    log.error("Error al cerrar el lector", e);
                }
            }
            if (reader == null) {
                try {
                   reader.close();
                } catch (IOException e) {
                    log.error("Error el archivo esta vacio", e);
                }
            }
        }
    }

    public static JSONObject ReadEntity(String element) throws IOException, ParseException {
        JSONObject Entity =null;
        JSONObject jsonObject = (JSONObject) readJson();
        Entity = (JSONObject) jsonObject.get(element);
        log.info(Entity.toJSONString());
        return Entity;
    }

    public static By getCompleteElement(String element) throws IOException, ParseException {
        By result = null;
        JSONObject Entity = ReadEntity(element);

        GetFielBy = (String) Entity.get("GetFielBy");
        ValueToFind = (String) Entity.get("ValueToFind");

        if ("className".equalsIgnoreCase(GetFielBy)) {
            result = By.className(ValueToFind);
        } else if ("cssSelector".equalsIgnoreCase(GetFielBy)){
            result = By.cssSelector(ValueToFind);
        } else if ("id".equalsIgnoreCase(GetFielBy)){
            result = By.id(ValueToFind);
        } else if ("linkText".equalsIgnoreCase(GetFielBy)){
            result = By.linkText(ValueToFind);
        }else if ("name".equalsIgnoreCase(GetFielBy)){
            result = By.name(ValueToFind);
        }else if ("link".equalsIgnoreCase(GetFielBy)){
            result = By.partialLinkText(ValueToFind);
        }else if ("tagName".equalsIgnoreCase(GetFielBy)){
            result = By.tagName(ValueToFind);
        }else if ("xpath".equalsIgnoreCase(GetFielBy)){
            result = By.xpath(ValueToFind);
        }
        return result;

    }


    public static void Screenshot(String TestCaptura) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmm");
        String formattedDate = dateFormat.format(new Date()); // Format the current date/time
        String screenShotName = readProperties("ScreenShotPath") + "\\" + readProperties("browser") + "-" + TestCaptura + "_(" + formattedDate + ")";
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(String.format("%s.png", screenShotName)));
    }

    public static byte[] attachScreenShot(String nameCapture){
        log.info("adjuntar captura de pantalla");
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(nameCapture, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        return screenshot;


    }

}
