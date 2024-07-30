Feature: home page de Amazon
  descripcion opcional
  @Test

  Scenario: Cliente busca en Amazon
    And Iniciar el browser Amazon
    Given El cliente se encuentra en la pantalla Principal Amazon
    Then cargar el DOM de mi pagina "DOM-Amazon.json"
    And teclear mi palabra de busqueda Amazon "airpods" "BusquedaText"
    And hago clic en el boton buscar Amazon "BtnBusqueda"
    And tomo captura de pantalla Amazon "busqueda de airpods"
    Then capturo pantalla para reporte Amazon "busqueda exitosa"
  Scenario: Cliente busca en amazon otro articulo
    And Iniciar el browser Amazon
    Given El cliente se encuentra en la pantalla Principal Amazon
    Then cargar el DOM de mi pagina "DOM-Amazon.json"
    And teclear mi palabra de busqueda Amazon "watch" "BusquedaText"
    And hago clic en el boton buscar Amazon "BtnBusqueda"
    And tomo captura de pantalla Amazon "busqueda de airpods"
    Then capturo pantalla para reporte Amazon "busqueda exitosa"

  Scenario: Cliente busca en amazon otro articulo
    And Iniciar el browser Amazon
    Given El cliente se encuentra en la pantalla Principal Amazon
    Then cargar el DOM de mi pagina "DOM-Amazon.json"
    And teclear mi palabra de busqueda Amazon "reebok" "BusquedaText"
    And hago clic en el boton buscar Amazon "BtnBusqueda"
    And tomo captura de pantalla Amazon "busqueda de airpods"
    Then capturo pantalla para reporte Amazon "busqueda exitosa"
    Then cerrar navegador Amazon