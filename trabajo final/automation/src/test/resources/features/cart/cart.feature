Feature: Gestión del carrito de compras

  @Regression @Cart
  Scenario: Agregar producto al carrito
    Given el usuario ha iniciado sesión exitosamente
    When agrega el producto "Sauce Labs Backpack" al carrito
    And accede al carrito de compras
    Then el producto "Sauce Labs Backpack" debe estar en el carrito

  @Regression @Cart
  Scenario: Remover producto del carrito
    Given el usuario ha iniciado sesión exitosamente
    When agrega el producto "Sauce Labs Bike Light" al carrito
    And accede al carrito de compras
    And remueve el producto "Sauce Labs Bike Light" del carrito
    Then el carrito debe estar vacío

  @Regression @Cart
  Scenario: Continuar al checkout desde el carrito
    Given el usuario ha iniciado sesión exitosamente
    And ha agregado un producto al carrito
    When accede al carrito de compras
    And inicia el proceso de checkout
    Then debe estar en la página de información de checkout