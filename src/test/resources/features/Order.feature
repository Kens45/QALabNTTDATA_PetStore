@ProbarFeatureOrder
Feature: Order

  @crearOrder
   Scenario Outline: Crear Order
    Given la url "https://petstore.swagger.io/v2/" del servicio
    When creo la orden con orderId <orderId>, petId <petId>, quantity <quantity>, shipDate "<shipDate>" y status "<status>"
    Then valido que el codigo de la respuesta sea <statusCode>
    And valido que la respuesta devuelva orderId <orderId> petId <petId>, quantity <quantity>, shipDate "<shipDate>" y status "<status>"

    Examples:
      | orderId  | petId  | quantity | shipDate                     | status | statusCode |
      | 101      | 10     | 8        | 2025-01-25T20:59:09.684+0000 | placed | 200        |
      | 102      | 11     | 5        | 2025-01-28T20:59:09.684+0000 | placed | 200        |
      | 103      | 12     | 15       | 2025-01-29T20:59:09.684+0000 | placed | 200        |

  @consultarOrder
  Scenario Outline: Consultar Order
    Given la url "https://petstore.swagger.io/v2/" del servicio
    When consulto la orden con id <orderId>
    Then valido que el codigo de la respuesta sea <statusCode>
    And valido que la respuesta devuelva orderId <orderId> petId <petId>, quantity <quantity>, shipDate "<shipDate>" y status "<status>"

    Examples:
      | orderId  | petId  | quantity | shipDate                     | status | statusCode |
      | 101      | 10     | 8        | 2025-01-25T20:59:09.684+0000 | placed | 200        |
      | 102      | 11     | 5        | 2025-01-28T20:59:09.684+0000 | placed | 200        |
      | 103      | 12     | 15       | 2025-01-29T20:59:09.684+0000 | placed | 200        |
