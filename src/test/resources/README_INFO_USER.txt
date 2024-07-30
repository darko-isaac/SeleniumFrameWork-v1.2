{}
|

 (¡!)

<>

^

{
  "Email": {
    "GetFileBy": "id",
    "ValueToFind": "email"
  }
}

para instalar maven en mac y reconozca la consola los comandos
sudo export M2_HOME="/Users/isaac/Downloads/apache-maven-3.9.6"

export M2_HOME="/Users/isaac/Downloads/apache-maven-3.9.6"
PATH="${M2_HOME}/bin:${PATH}"
export PATH

pasos para agreegar el java home y maven en mac
comando para ver si el archivo existe y si no uar el touch para crearlo
ls -al
touch ~/.bash_profile
open ~/.zshenv
pegar la siguiente linea
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-21.jdk/
export M2_HOME=/Users/isaac/Downloads/apache-maven-3.9.6/
export PATH="${M2_HOME}/bin:${PATH}"
source ~/.bash_profile


echo "export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-21.jdk/Contents/Home" >> ~/.profile
export JAVA_HOME="/Library/Java/JavaVirtualMachines/jdk-21.jdk/"
PATH="${JAVA_HOME}/bin:${PATH}"

-javaagent:${settings.localRepository}/io/rest-assured/rest-assured/${restassured.version}/rest-assured-${restassured.version}.jar
-javaagent:${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar

 datos de mi instalacion de android estudio para saber como uar el commonstools con el sdkmanager
   Android platform libraries for targeting platform: Android 14.0 ("UpsideDownCake"; API 34)
   "Install Android Emulator v.34.1.20".
 eesto es para obteneer
 appPackage: Tu appPackage
 appActivity: Tu appActivity
adb shell
dumpsys window displays | grep -E 'mCurrentFocus'

/Users/isaac/.android/avd.       emulator -avd Pixel_3a_API_34_extension_level_7_x86_64

estas son todas las posibles capabilities que pueden usarse

AndroidUiautomator2Driver@4c01 (af375833)] Got response with status 200: {"sessionId":"334298b9-af23-4617-8767-647e04304693","value":{"androidId":"40b60e5ba6655298","apiVersion":"34","bluetooth":{"state":"OFF"},"brand":"google","carrierName":"T-Mobile","displayDensity":440,"locale":"en_US","manufacturer":"Google","model":"sdk_gphone64_x86_64","networks":[{"capabilities":{"SSID":null,"linkDownBandwidthKbps":30000,"linkUpstreamBandwidthKbps":12000,"networkCapabilities":"NET_CAPABILITY_NOT_METERED,NET_CAPABILITY_INTERNET,NET_CAPABILITY_NOT_RESTRICTED,NET_CAPABILITY_TRUSTED,
NET_CAPABILITY_NOT_VPN,NET_CAPABILITY_VALIDATED,NET_CAPABILITY_NOT_ROAMING,NET_CAPABILITY_FOREGROUND,NET_CAPABILITY_NOT_CONGESTED,NET_CAPABILITY_NOT_SUSPENDED","signalStrength":-50,"transportTypes":"TRANSPORT_WIFI"},"detailedState":"CONNECTED","extraInfo":"","isAvailable":true,"isConnected":true,"isFailover":false,"isRoaming":false,"state":"CONNECTED","subtype":-1,"subtypeName":"","type":1,"typeName":"WIFI"}],"platformVersion":"14","realDisplaySize":"1080x2220","timeZone":"America/Mexico_City"}}


comandos para implementar

// Click on the EditText element
driver.findElement(By.xpath("your_element_xpath_or_id")).click();
// Send keys to the EditText element (clears existing text)
driver.findElement(By.xpath("your_element_xpath_or_id")).sendKeys("textToBeTyped");
// Click on the EditText element
driver.findElement(By.xpath("your_element_xpath_or_id")).click();
// Send keys without clearing existing text
driver.getKeyboard().sendKeys("textToBeTyped");

driver.findElement(By.name("Shop byDepartment")).click();
driver.findElement(By.className("your-class-name")).click();
driver.findElement(By.id("your-element-id")).sendKeys("Hello");
driver.findElement(By.xpath("//android.widget.Button[@text='Login']")).click();


'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''¡¡¡¡¡¡¡

WebElement parentElement = driver.findElement(By.id("parent-id"));
WebElement childElement = parentElement.findElement(By.className("child-class"));


'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''¡¡¡¡¡¡¡
String expectedText = "Welcome to MyApp";
MobileElement element = driver.findElement(By.xpath("your_element_xpath_or_id"));
String actualText = element.getText();

// Assert that the actual text matches the expected text
Assert.assertEquals(actualText, expectedText, "Text validation failed!");
'''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''¡¡¡¡¡¡¡

// Take a screenshot and save it to a file
File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

// Specify the path where you want to save the screenshot
String screenshotPath = "path/to/save/screenshot.png";
FileUtils.copyFile(screenshotFile, new File(screenshotPath));

// Log the screenshot path for reference
System.out.println("Screenshot saved at: " + screenshotPath);

   =????¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿eesto es para windows

primero descargar intellij
descargar e instala el jdk 11 de preferencia, por que no eh validado que funcione con la version 21
que en teoria no deberia tener problemas

descargar la ultima version de maven
descargar nodejs la version recomendada , yo instale 10.2.4
descomprimir las carpetas
crear correctamente las variable de entorno
JAVA_HOME
M2_HOME
crear las variable del bin de cada una en el path
%JAVA_HOME%\bin
%M2_HOME%\bin\mvn
%M2_HOME%\bin\mvnDebug

validar que el jdk y el maven tienen bien las variables de entorno con los comandos
java -version
mvn -version
intalar el intellij y abrir el proyecto de Selenium
actualizar las dependiencias de maven y elejir el jdk correcto 11
intalar el nodejs
ejecutar el feature de prueba de cucumber pre cargado
una vez que se ejecuta sin errores 
para generar el reporte se ejecuta en la pantalla de comandos de maven dentro de intellij o por fuera 
mvn allure:report
mvn allure:serve
y se debera abrir en automatico el reporte de la prueba de selenium en cucumber.

------------esto es para configurar APPIUM


C:\Windows\System32>npm view appium-plugin <2.5.1> plugins
El sistema no puede encontrar el archivo especificado.

C:\Windows\System32>npx appium plugin list
√ Listing available plugins
- images [not installed]
- execute-driver [not installed]
- relaxed-caps [not installed]
- universal-xml [not installed]

C:\Windows\System32>npx appium plugin install images
√ Checking if '@appium/images-plugin' is compatible
√ Installing 'images' using NPM install spec '@appium/images-plugin'
i Plugin images@3.0.3 successfully installed

C:\Windows\System32>npx appium plugin install execute-driver
√ Checking if '@appium/execute-driver-plugin' is compatible
√ Installing 'execute-driver' using NPM install spec '@appium/execute-driver-plugin'
i Plugin execute-driver@3.0.25 successfully installed

C:\Windows\System32>npx appium plugin install relaxed-caps
√ Checking if '@appium/relaxed-caps-plugin' is compatible
√ Installing 'relaxed-caps' using NPM install spec '@appium/relaxed-caps-plugin'
i Plugin relaxed-caps@1.0.6 successfully installed

C:\Windows\System32>npx appium plugin install universal-xml


se supone que asi deberia pasar las variables de option a mi clase de cucumber test runner

 <systemPropertyVariables>
                        <cucumber.options>--glue StepDefinitions --features src/test/java/Futures --plugin pretty --plugin html:target/cucumber-html-report --plugin json:target/cucumber.json</cucumber.options>
                    </systemPropertyVariables>