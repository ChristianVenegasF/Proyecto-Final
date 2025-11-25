Feature: Eliminar producto del carrito
  Como usuario
  Quiero eliminar un producto del carrito
  Para corregir mi selección

  Scenario: Eliminar un producto agregado
    Given que el usuario tiene un producto en el carrito
    When hace clic en el ícono del carrito
    And presiona el botón "Eliminar" del producto "Camiseta Bolt de Sauce Labs"
    Then el carrito debe quedar vacío

  Scenario: Verificar que el carrito vacío no muestre productos
    Given que no hay productos en el carrito
    When el usuario accede al carrito
    Then la lista debe estar vacía
