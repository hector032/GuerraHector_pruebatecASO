# API REST de Simulación de Contratación de Tarjetas de Crédito

Este proyecto implementa una API REST para gestionar simulaciones de contratación de tarjetas de crédito en el contexto de un banco. Utiliza Java, ASO, APX, Docker y Postman para desarrollar y probar el servicio.

## Descripción

La API REST permite recibir solicitudes POST con datos en formato JSON con detalles específicos sobre la simulación de contratación de tarjetas de crédito, validar los datos según ciertas reglas y devolver una respuesta con los resultados de la simulación.

## Características Principales

* **Validación de Campos:** Se valida que los campos de entrada y salida cumplan con las reglas establecidas.
* **Flujo de Capas:** Se sigue un flujo adecuado entre las capas de la aplicación, incluyendo facade, business y dao.
* **Mapeo de Datos:** Se realiza un mapeo eficiente entre los objetos de entrada y salida para garantizar la integridad de los datos.
* **Configuración con Docker:** La aplicación se puede configurar y ejecutar fácilmente utilizando Docker para mantener un entorno de desarrollo consistente.

## Uso del Servicio ASO

- El servicio ASO espera recibir un JSON con detalles sobre la simulación de contratación a través de @PathParam.

### Ejemplo de Request del Servicio ASO
```json
{
  "details": {
    "offerType": "CARD_HOLDER",
    "limitAmount": {
      "amount": 200000,
      "currency": "EUR"
    },
    "product": {
      "id": "TDC",
      "subproduct": {
        "id": "AV"
      }
    }
  }
}
```
### Ejemplo de Response del Servicio ASO

```json
{
  "data": {
    "id": "3242342343",
    "nuip": "123456789",
    "details": {
      "offerType": "CARD_HOLDER",
      "limitAmount": {
        "amount": 200000,
        "currency": "EUR"
      },
      "minimumAmount": {
        "amount": 180000,
        "currency": "EUR"
      },
      "maximumAmount": {
        "amount": 210000,
        "currency": "EUR"
      },
      "product": {
        "id": "TDC",
        "subproduct": {
          "id": "AV"
        }
      }
    }
  }
}
```
## Restricciones
* El mapeo entre capas debe ser correcto, siguiendo un flujo adecuado entre facade, business y dao.
* Se deben validar los campos de entrada y salida según las reglas establecidas.

## Configuración y Ejecución

1. Clonar este repositorio.
2. Compilar y ejecutar el proyecto utilizando Docker.
3. Realizar pruebas utilizando Postman u otra herramienta similar.

## Authors

- [@hector032](https://www.github.com/hector032)

