# 📘 Bitácora - Patrones de Diseño (DOSW)

## 👤 Autor
Joshua David Quiroga

---

# 🧩 Objetivo

El objetivo de este refuerzo es aplicar y combinar múltiples **patrones de diseño** dentro de un mismo sistema, entendiendo cómo trabajan en conjunto para resolver problemas reales de software, manteniendo principios como:

- Bajo acoplamiento
- Alta cohesión
- Extensibilidad
- Escalabilidad

---

# 🧪 Ejercicio 1: Sistema de Notificaciones

## 📌 Problema

Se requiere un sistema capaz de enviar notificaciones por distintos canales (Email, SMS, Push), donde:

- El canal pueda cambiar dinámicamente
- El sistema sea extensible
- Exista un único servicio de envío

---

## 🧠 Patrones utilizados

### 🔹 1. Strategy
- **Tipo:** Comportamiento
- **Justificación Técnica:**  
  Permite encapsular diferentes algoritmos de envío (Email, SMS, Push) y seleccionarlos dinámicamente en tiempo de ejecución sin modificar el código cliente. Esto cumple con el principio **Open/Closed**.

---

### 🔹 2. Singleton
- **Tipo:** Creacional
- **Justificación Técnica:**  
  Garantiza que exista una única instancia del servicio de notificaciones, evitando inconsistencias y consumo innecesario de recursos.

---

## 📊 Diagrama UML (simplificado)


---

## 💡 Análisis

La combinación de **Strategy + Singleton** permite:

- Cambiar el comportamiento sin afectar otras clases
- Centralizar la lógica de envío
- Facilitar la escalabilidad del sistema

---

# 🧪 Ejercicio 2: Sistema de Procesamiento de Pagos

## 📌 Problema

Se necesita procesar pagos con múltiples proveedores externos (PayPal, Stripe, etc.), donde:

- Cada proveedor tiene una API distinta
- Se deben ejecutar validaciones antes del pago
- Las validaciones deben ser configurables

---

## 🧠 Patrones utilizados

### 🔹 1. Adapter
- **Tipo:** Estructural
- **Justificación Técnica:**  
  Permite adaptar interfaces incompatibles de proveedores externos a una interfaz común (`PaymentProcessor`), evitando modificar el código principal.

---

### 🔹 2. Chain of Responsibility
- **Tipo:** Comportamiento
- **Justificación Técnica:**  
  Permite encadenar múltiples validaciones independientes donde cada una decide si el proceso continúa o se detiene.

---

### 🔹 3. Strategy (Complementario)
- **Tipo:** Comportamiento
- **Justificación Técnica:**  
  Permite seleccionar dinámicamente el proveedor de pago sin cambiar la lógica del sistema.

---

## 📊 Diagrama UML (simplificado)


---

## 💡 Análisis

La combinación de estos patrones permite:

- Integrar múltiples APIs sin acoplamiento
- Agregar o quitar validaciones fácilmente
- Escalar el sistema sin modificar código existente

---

# 🧪 Pruebas Unitarias

Se implementaron pruebas usando **JUnit 5**, validando:

- Cambio dinámico de estrategias
- Funcionamiento del Singleton
- Flujo correcto de validaciones
- Casos de éxito y fallo en pagos

✔ Se cumple con el requisito de pruebas automatizadas  
✔ Base para alcanzar cobertura ≥ 80%

---

# 📊 Cobertura de Código (JaCoCo)

Para generar cobertura:

```bash
mvn clean test
mvn jacoco:report