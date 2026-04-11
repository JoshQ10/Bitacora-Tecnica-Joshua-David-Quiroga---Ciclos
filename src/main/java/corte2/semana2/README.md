# Bitacora - Refuerzo Patrones de Diseno Combinados (Semana 2, Corte 2)

## Autor
Joshua David Quiroga

---

## Objetivo

Practicar la combinacion de patrones de diseno dentro de un mismo sistema, entendiendo como se complementan para resolver problemas reales de software.

---

# Ejercicio 1: Sistema de Notificaciones

**Ubicacion:** `corte2/semana2/ejercicioNotificaciones/`

## Patrones Utilizados

### 1. Strategy
- **Tipo:** Comportamiento
- **Justificacion Tecnica:** Permite encapsular los algoritmos de envio (Email, SMS, Push) como clases intercambiables. El cliente (NotificationService) opera contra la interfaz `NotificationStrategy`, sin conocer la implementacion concreta. Cumple con el principio Open/Closed: agregar un nuevo canal no modifica el codigo existente.

### 2. Singleton
- **Tipo:** Creacional
- **Justificacion Tecnica:** Garantiza que exista una unica instancia de `NotificationService` en todo el sistema. Se implementa con double-checked locking y `volatile` para garantizar thread-safety en entornos concurrentes.

## Diagrama de Clases (UML)

```
+---------------------+         uses         +----------------------+
|  NotificationService|--------------------->| <<interface>>        |
|  (Singleton)        |                      | NotificationStrategy |
|---------------------|                      |----------------------|
| -instance: static   |                      | +send(msg: String)   |
| -strategy: Strategy |                      +----------------------+
|---------------------|                              ^
| +getInstance()      |              ________________|________________
| +setStrategy()      |             |                |               |
| +send(msg)          |   +------------------+ +-----------+ +---------------+
+---------------------+   | EmailNotification| |SMSNotific.| |PushNotific.   |
                          |------------------| |-----------| |---------------|
                          | +send(msg)       | | +send(msg)| | +send(msg)    |
                          +------------------+ +-----------+ +---------------+
```

## Estructura del Codigo

```
ejercicioNotificaciones/
  Main.java                          <- Clase de entrada (demostracion)
  service/
    NotificationService.java         <- Singleton + orquestador
  strategy/
    NotificationStrategy.java        <- Interfaz (Strategy)
    EmailNotification.java           <- Implementacion Email
    SMSNotification.java             <- Implementacion SMS
    PushNotification.java            <- Implementacion Push
```

## Pruebas Unitarias

Archivo: `src/test/java/corte2/semana2/ejercicioNotificaciones/NotificationServiceTest.java`

| Test | Que valida |
|------|-----------|
| `testSingleton_mismaInstancia` | El Singleton retorna siempre el mismo objeto |
| `testStrategy_email` | Email envia el mensaje correcto |
| `testStrategy_sms` | SMS envia el mensaje correcto |
| `testStrategy_push` | Push envia el mensaje correcto |
| `testStrategy_cambioDinamico` | El canal puede cambiarse en tiempo de ejecucion |

---

# Ejercicio 2: Sistema de Procesamiento de Pagos

**Ubicacion:** `corte2/semana2/sistemaPagos/`

## Patrones Utilizados

### 1. Adapter
- **Tipo:** Estructural
- **Justificacion Tecnica:** Cada proveedor externo (PayPal, Stripe, Tarjeta, Transferencia) tiene una API con metodos y firmas diferentes. Los Adapters traducen esas interfaces incompatibles a la interfaz comun `PaymentProcessor` del sistema interno, sin modificar las clases externas ni el codigo cliente.

### 2. Chain of Responsibility
- **Tipo:** Comportamiento
- **Justificacion Tecnica:** Las validaciones (saldo, fraude, limite) se encadenan de forma que cada handler decide si el pago continua o se detiene. Es posible agregar o quitar validaciones sin modificar el servicio principal ni los otros handlers.

### 3. Strategy (complementario via Adapter)
- **Tipo:** Comportamiento
- **Justificacion Tecnica:** `PaymentService` acepta cualquier `PaymentProcessor` y puede cambiarse en tiempo de ejecucion (`setProcessor()`), permitiendo seleccionar el proveedor dinamicamente sin cambiar la logica principal.

## Diagrama de Clases (UML)

```
PaymentService
  |-- PaymentProcessor (interfaz)          <- Adapter target
  |     |-- PayPalAdapter
  |     |     |-- PayPalAPI (external)
  |     |-- StripeAdapter
  |     |     |-- StripeAPI (external)
  |     |-- CreditCardAdapter
  |     |     |-- CreditCardAPI (external)
  |     |-- BankTransferAdapter
  |           |-- BankTransferAPI (external)
  |
  |-- PaymentHandler (abstracto)           <- Chain of Responsibility
        |-- BalanceHandler  -> FraudHandler -> LimitHandler -> null
```

```
+------------------+    setProcessor()   +--------------------+
|  PaymentService  |------------------->| <<interface>>       |
|------------------|                    | PaymentProcessor    |
| -processor       |                    |--------------------|
| -validationChain |                    | +processPayment()   |
|------------------|                    | +getProviderName()  |
| +processPayment()|                    +--------------------+
| +setProcessor()  |                           ^
+------------------+                  _________|_________
         |                           |    |    |         |
         |                     PayPal Stripe Credit Bank
         |                     Adapter Adapter Card  Transfer
         |                                     Adapter Adapter
         |
         | handle()
         v
+------------------+
| PaymentHandler   | (abstracto)
|------------------|
| -next            |
| +setNext()       |
| +handle()        |
| +passToNext()    |
+------------------+
         ^
    _____|_____
   |     |     |
Balance Fraud Limit
Handler Handler Handler
```

## Estructura del Codigo

```
sistemaPagos/
  SistemaPagoApplication.java          <- Clase de entrada (demostracion)
  model/
    PaymentRequest.java                <- Modelo de datos del pago
  adapter/
    PaymentProcessor.java              <- Interfaz comun (Adapter target)
    PayPalAdapter.java                 <- Adapter para PayPal
    StripeAdapter.java                 <- Adapter para Stripe
    CreditCardAdapter.java             <- Adapter para Tarjeta de Credito
    BankTransferAdapter.java           <- Adapter para Transferencia Bancaria
    external/
      PayPalAPI.java                   <- API externa simulada (PayPal)
      StripeAPI.java                   <- API externa simulada (Stripe)
      CreditCardAPI.java               <- API externa simulada (Tarjeta)
      BankTransferAPI.java             <- API externa simulada (Banco)
  chain/
    PaymentHandler.java                <- Handler abstracto (CoR)
    BalanceHandler.java                <- Valida saldo suficiente
    FraudHandler.java                  <- Detecta posible fraude (umbral: $10,000)
    LimitHandler.java                  <- Valida limite diario (umbral: $5,000)
  service/
    PaymentService.java                <- Orquestador principal
```

## Pruebas Unitarias

Archivo: `src/test/java/corte2/semana2/sistemaPagos/PaymentServiceTest.java`

| Test | Que valida |
|------|-----------|
| `testValidacion_saldoInsuficiente_rechazaPago` | Cadena detiene el pago si no hay saldo |
| `testValidacion_posibleFraude_rechazaPago` | Cadena detiene el pago si hay indicios de fraude |
| `testValidacion_limiteExcedido_rechazaPago` | Cadena detiene el pago si excede el limite |
| `testValidacion_pagoValido_aprueba` | Cadena aprueba cuando todo es valido |
| `testAdapter_paypal_procesaCorrectamente` | Adapter PayPal adapta la API externa |
| `testAdapter_stripe_procesaCorrectamente` | Adapter Stripe adapta la API externa |
| `testAdapter_creditCard_procesaCorrectamente` | Adapter CreditCard adapta la API externa |
| `testAdapter_bankTransfer_procesaCorrectamente` | Adapter BankTransfer adapta la API externa |
| `testCambioDinamicoDeProveedor` | El proveedor puede cambiar en tiempo de ejecucion |

---

# Cobertura de Codigo (JaCoCo)

```bash
mvn clean test
mvn jacoco:report
```

Reporte generado en: `target/site/jacoco/index.html`

---

# Analisis Estatico (SonarQube)

```bash
mvn sonar:sonar
```

Configuracion en `pom.xml`:
- `sonar.host.url=http://localhost:9000`
- `sonar.projectKey=DOSW-ParcialT2`
