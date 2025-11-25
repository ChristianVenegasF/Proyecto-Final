Feature: Inicio de sesión fallido
  Como usuario
  Quiero recibir un mensaje de error si ingreso credenciales incorrectas
  Para saber que no puedo acceder

  Scenario: Iniciar sesión con contraseña incorrecta
    Given que el usuario está en la página de login "https://www.saucedemo.com/"
    When ingresa el usuario "standard_user"
    And ingresa la contraseña "12345"
    And hace clic en Login
    Then debe mostrarse el mensaje de error
    And el usuario debe permanecer en la página de login

  Scenario: Iniciar sesión con usuario inexistente
    Given que el usuario está en la página de login
    When ingresa un usuario inválido "pepito"
    And ingresa la contraseña "12345"
    And hace clic en Login
    Then el sistema debe mostrar un mensaje de que el usuario no existe
