Feature: Inicio de sesión correcto
  Como usuario
  Quiero iniciar sesión con credenciales válidas
  Para acceder al catálogo de productos

  Scenario: Iniciar sesión exitosamente con usuario válido
    Given que el usuario está en la página de login "https://www.saucedemo.com/"
    And el usuario está registrado y su cuenta está activa
    When ingresa el usuario "standard_user"
    And ingresa la contraseña "secret_sauce"
    And hace clic en Login
    Then el sistema debe redirigir al catálogo
    And los productos deben mostrarse correctamente

  Scenario: Validar que el usuario logueado pueda ver el inventario
    Given que el usuario inició sesión correctamente
    When accede a la página del inventario
    Then debe visualizar la lista de productos sin errores
