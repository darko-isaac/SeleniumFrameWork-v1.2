Feature: home page
  descripcion opcional
  @Test

  Scenario: Cliente no se logea
    And Iniciar el browser
    Given El cliente se encuentra en la pantalla de logeo
    Then cargar el DOM de mi pagina "all_Element_Page1.json"
    #And hago clic en el boton login "BtnLogin"
    And teclear mi correo "isaac.garcia@gmail.com" en el elemento "EmailUser"
    And teclear mi pass "pa55word" en el campo "PassUser"
    Then identificar el captcha
    And check no soy un robot "CheckCaptcha"
    #Then clic en boton submit "BtnSubmit"
    And tomo captura de pantalla "teclearCorreoPassIncorrecto"
    Then capturo pantalla para reporte "EvidenciaCaptcha"

  Scenario: Cliente no se logea sin pass
    And Iniciar el browser
    Given El cliente se encuentra en la pantalla de logeo
    Then cargar el DOM de mi pagina "all_Element_Page1.json"
    #And hago clic en el boton login "BtnLogin"
    And teclear mi correo "isaac.garcia@gmail.com" en el elemento "EmailUser"
    Then identificar el captcha
    And check no soy un robot "CheckCaptcha"
    #Then clic en boton submit "BtnSubmit"
    And tomo captura de pantalla "teclearCorreoPassIncorrecto"
    Then capturo pantalla para reporte "EvidenciaCaptcha"
    Then cerrar navegador