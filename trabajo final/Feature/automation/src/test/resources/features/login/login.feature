Feature: Login de SauceDemo

  @Regression @Login
  Scenario: Login exitoso con credenciales válidas
    Given el usuario está en la página de login de SauceDemo
    When ingresa el usuario "standard_user" y contraseña "secret_sauce"
    And hace clic en el botón Login
    Then debe redirigirse a la página de productos

  @Regression @Login
  Scenario: Login fallido con usuario bloqueado
    Given el usuario está en la página de login de SauceDemo
    When ingresa el usuario "locked_out_user" y contraseña "secret_sauce"
    And hace clic en el botón Login
    Then debe mostrar un mensaje de error "Sorry, this user has been locked out"