Feature: Agregar producto al carrito
  Como usuario
  Quiero agregar un producto al carrito
  Para poder comprarlo

  Scenario: Agregar un producto desde el catálogo
    Given que el usuario está logueado
    And está en la página del inventario
    When localiza el producto "Camiseta Bolt de Sauce Labs"
    And hace clic en el botón "Añadir a la cesta"
    Then el carrito debe mostrar 1 producto agregado

  Scenario: Verificar que el producto agregado aparezca en el carrito
    Given que el usuario agregó un producto al carrito
    When hace clic en el ícono del carrito
    Then debe mostrarse "Camiseta Bolt de Sauce Labs" en la lista
