Feature: Proceso de checkout

  @Regression @Checkout
  Scenario: Checkout exitoso con un producto
    Given el usuario ha iniciado sesión exitosamente
    And ha agregado un producto al carrito
    And accede al carrito de compras
    And inicia el proceso de checkout
    When completa el checkout con "Juan" "Perez" "12345"
    Then debe ver la página de confirmación con el mensaje "Thank you for your order!"

  @Regression @Checkout
  Scenario: Checkout fallido por datos incompletos
    Given el usuario ha iniciado sesión exitosamente
    And ha agregado un producto al carrito
    And accede al carrito de compras
    And inicia el proceso de checkout
    When intenta completar el checkout sin ingresar datos
    Then debe mostrar un mensaje de error en checkout "Error: First Name is required"

  @Regression @Checkout
  Scenario: Checkout exitoso con múltiples productos
    Given el usuario ha iniciado sesión exitosamente
    And ha agregado un producto al carrito
    And agrega el producto "Sauce Labs Bike Light" al carrito
    And accede al carrito de compras
    And inicia el proceso de checkout
    When completa el checkout con "Maria" "Gonzalez" "54321"
    Then debe ver la página de confirmación con el mensaje "Thank you for your order!"