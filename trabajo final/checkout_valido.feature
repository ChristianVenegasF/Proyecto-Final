Feature: Checkout con datos válidos
  Como usuario
  Quiero completar el checkout con datos válidos
  Para finalizar mi compra

  Scenario: Finalizar compra exitosamente
    Given que el usuario está logueado
    And tiene al menos un producto en el carrito
    And está en la página del carrito
    When hace clic en Checkout
    And ingresa nombre "Ariana"
    And ingresa apellido "Pérez"
    And ingresa código postal "12345"
    And hace clic en Continuar
    Then debe mostrarse el resumen del pedido
    And el sistema debe permitir completar la compra

  Scenario: Confirmación de compra completada
    Given que el usuario ingresó datos válidos y continuó
    When verifica el resumen y finaliza la compra
    Then el sistema debe mostrar el mensaje de éxito
