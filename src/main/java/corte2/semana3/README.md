# Analisis de Requerimientos - Plataforma de Batallas Bakugan

**Autor:** Joshua David Quiroga
**Semana:** 3 - Corte 2
**Materia:** DOSW

---

## Contexto del Escenario

Una startup desea lanzar una aplicacion web para fanaticos de Bakugan. Los usuarios podran coleccionar criaturas, mejorarlas y enfrentarse en combates estrategicos. El sistema debe soportar mecanicas de progresion, gestion de inventario y enfrentamientos entre jugadores. Los combates no son en tiempo real pero deben mantener consistencia. A futuro podrian integrarse rankings, eventos especiales y modos cooperativos.

---

## 1. Identificacion de Requerimientos

Se identificaron requerimientos tanto **explicitos** (mencionados directamente en el enunciado) como **implicitos** (supuestos razonables que toda plataforma de este tipo debe tener).

### Requerimientos Explicitos
Extraidos directamente del enunciado:

- Coleccion de criaturas Bakugan
- Mejora y evolucion de criaturas
- Sistema de combate estrategico (no en tiempo real)
- Mecanicas de progresion del jugador
- Gestion de inventario
- Emparejamiento justo entre jugadores
- Persistencia de resultados de combates
- Balance entre criaturas y habilidades
- Facilidad de evolucion del sistema a futuro
- Potenciales funcionalidades futuras: rankings, eventos especiales, modos cooperativos

### Requerimientos Implicitos
Supuestos razonables que el sistema necesita aunque el cliente no los menciono:

- Registro y autenticacion de usuarios
- Gestion de sesiones y seguridad
- Perfil de usuario con estadisticas
- Validacion de datos de entrada
- Manejo de errores y excepciones
- Historial de combates por usuario
- Panel de administracion para balance del juego
- Control de trampas o datos inconsistentes (integridad)
- Disponibilidad y rendimiento aceptables
- Escalabilidad para crecimiento futuro

---

## 2. Clasificacion y Redaccion de Requerimientos

Cada requerimiento fue reformulado en formato estandar: **"El sistema debe..."**

### Requerimientos Funcionales (RF)

Los requerimientos funcionales describen comportamientos especificos que el sistema debe ejecutar, es decir, *lo que el sistema hace*.

| ID    | Requerimiento | Justificacion |
|-------|---------------|---------------|
| RF-01 | El sistema debe permitir el registro de nuevos usuarios mediante correo electronico y contrasena. | Es la puerta de entrada a toda la plataforma; sin registro no hay usuarios. |
| RF-02 | El sistema debe autenticar a los usuarios mediante credenciales validas antes de permitir el acceso. | Garantiza que solo usuarios registrados accedan a su informacion y criaturas. |
| RF-03 | El sistema debe permitir a cada usuario visualizar, organizar y gestionar su coleccion de criaturas Bakugan. | Es el modulo central del juego; la coleccion es el activo principal del jugador. |
| RF-04 | El sistema debe permitir la mejora y evolucion de criaturas utilizando recursos obtenidos en el juego. | Corresponde directamente a la mecanica de progresion descrita por el cliente. |
| RF-05 | El sistema debe permitir a los jugadores desafiar a otros jugadores en combates estrategicos por turnos. | Es la funcionalidad principal de entretenimiento de la plataforma. |
| RF-06 | El sistema debe calcular y registrar el resultado de cada combate de forma determinista y consistente. | El cliente exige consistencia; el mismo estado de entrada debe producir el mismo resultado. |
| RF-07 | El sistema debe implementar un algoritmo de emparejamiento que agrupe jugadores de nivel similar. | El cliente menciona explicitamente la necesidad de emparejamientos justos. |
| RF-08 | El sistema debe gestionar el inventario de cada usuario incluyendo criaturas, recursos e items. | El enunciado menciona gestion de inventario como funcionalidad requerida. |
| RF-09 | El sistema debe llevar un historial completo de los combates de cada jugador con sus resultados. | Necesario para la persistencia de informacion de partidas requerida por el cliente. |
| RF-10 | El sistema debe mostrar el perfil de cada jugador con sus estadisticas, criaturas y progreso acumulado. | Parte esencial de la experiencia de usuario en cualquier plataforma de juego. |
| RF-11 | El sistema debe aplicar reglas de balance predefinidas para determinar las estadisticas de combate de cada criatura. | El cliente indica preocupacion por el balance; debe existir un mecanismo configurable. |
| RF-12 | El sistema debe proveer a los administradores la capacidad de ajustar estadisticas de criaturas y reglas del juego. | Sin esta capacidad, el balance no puede mantenerse a futuro sin desplegar nueva version. |
| RF-13 | El sistema debe soportar la estructura de datos necesaria para incorporar rankings, eventos y modos cooperativos en versiones futuras. | El cliente anticipa estas funcionalidades; el diseno actual debe no bloquearlas. |

---

### Requerimientos No Funcionales (RNF)

Los requerimientos no funcionales describen *como* debe comportarse el sistema en terminos de calidad, rendimiento y restricciones.

| ID     | Requerimiento | Justificacion |
|--------|---------------|---------------|
| RNF-01 | El sistema debe garantizar consistencia ACID en los registros de resultados de combate para evitar estados invalidos. | El cliente exige consistencia; la perdida de un resultado de combate es inaceptable. |
| RNF-02 | El sistema debe responder a las solicitudes de los usuarios en menos de 2 segundos bajo carga normal. | Un tiempo de respuesta alto afecta la experiencia de usuario y la retencion. |
| RNF-03 | El sistema debe estar disponible al menos el 99% del tiempo mensual (aprox. 7 horas de downtime al mes). | Una plataforma de juego con baja disponibilidad pierde jugadores rapidamente. |
| RNF-04 | El sistema debe escalar horizontalmente para soportar hasta 10 veces el numero inicial de usuarios sin rediseno. | El cliente anticipa crecimiento; la arquitectura debe permitirlo desde el inicio. |
| RNF-05 | El sistema debe cifrar las contrasenas de los usuarios con un algoritmo de hashing seguro (bcrypt o equivalente). | Requisito minimo de seguridad para cualquier sistema con autenticacion. |
| RNF-06 | El sistema debe proteger todos los endpoints mediante autenticacion con tokens (JWT o similar). | Evita acceso no autorizado a recursos privados de cada jugador. |
| RNF-07 | El sistema debe estar disenado bajo una arquitectura modular que permita agregar nuevos modulos sin modificar los existentes. | El cliente menciona explicitamente la facilidad de evolucion a futuro. |
| RNF-08 | El sistema debe validar y sanitizar todos los datos recibidos desde el cliente antes de procesarlos. | Previene inyeccion de datos maliciosos y estados inconsistentes en la base de datos. |
| RNF-09 | El sistema debe registrar logs de errores criticos con suficiente contexto para facilitar la depuracion. | Necesario para el mantenimiento y deteccion de problemas en produccion. |
| RNF-10 | El sistema debe ser usable desde navegadores web modernos sin requerir instalacion adicional de software. | El enunciado indica que es una aplicacion web; la accesibilidad es un requisito implicito. |

---

## 3. Priorizacion de Requerimientos

Criterios utilizados:
- **Alta:** Critico para el funcionamiento basico del sistema o valor central del negocio.
- **Media:** Importante para la experiencia completa pero no bloquea el MVP.
- **Baja:** Deseable o relacionado con funcionalidades futuras.

| ID     | Prioridad | Criterio de Priorizacion |
|--------|-----------|--------------------------|
| RF-01  | Alta      | Sin registro no existe la plataforma; es el punto de entrada de todo. |
| RF-02  | Alta      | La autenticacion es prerequisito de todas las demas funciones. |
| RF-03  | Alta      | La coleccion de criaturas es el activo central del juego. |
| RF-04  | Alta      | La evolucion impulsa la progresion y retencion del jugador. |
| RF-05  | Alta      | El combate es la propuesta de valor principal de la plataforma. |
| RF-06  | Alta      | Sin consistencia en resultados el juego pierde credibilidad. |
| RF-07  | Media     | Mejora la experiencia pero puede iniciarse con logica simple de nivel. |
| RF-08  | Alta      | La gestion de inventario soporta la coleccion y el combate. |
| RF-09  | Media     | El historial es importante pero no bloquea el combate en si. |
| RF-10  | Media     | El perfil mejora la experiencia; puede ser basico en el MVP. |
| RF-11  | Alta      | Sin reglas de balance, el juego es injugable desde el inicio. |
| RF-12  | Media     | Necesario pero puede iniciarse con ajustes via base de datos. |
| RF-13  | Baja      | Preparacion para futuro; no es urgente en el MVP. |
| RNF-01 | Alta      | La consistencia de datos en combates es un requisito del cliente. |
| RNF-02 | Media     | Importante para la experiencia; puede refinarse post-MVP. |
| RNF-03 | Alta      | La disponibilidad es critica para una plataforma de juego activa. |
| RNF-04 | Media     | La escalabilidad debe considerarse desde el diseno, pero puede crecer gradualmente. |
| RNF-05 | Alta      | La seguridad de contrasenas es un minimo no negociable. |
| RNF-06 | Alta      | Proteger los endpoints es critico desde el primer dia. |
| RNF-07 | Media     | La modularidad debe estar en el diseno inicial aunque no se note de inmediato. |
| RNF-08 | Alta      | La validacion previene errores criticos y vulnerabilidades. |
| RNF-09 | Media     | Los logs son importantes para mantenimiento pero no bloquean el lanzamiento. |
| RNF-10 | Alta      | Es una aplicacion web; la accesibilidad desde el navegador es fundamental. |

---

## 4. Dependencias y Bloqueos

### Mapa de Dependencias

```
RF-01 (Registro)
  └── RF-02 (Autenticacion)
        ├── RF-03 (Coleccion de criaturas)
        │     ├── RF-04 (Evolucion de criaturas)
        │     ├── RF-08 (Inventario)
        │     └── RF-11 (Balance)
        │           └── RF-05 (Combate)
        │                 ├── RF-06 (Resultado consistente)
        │                 │     └── RF-09 (Historial)
        │                 └── RF-07 (Emparejamiento)
        └── RF-10 (Perfil de usuario)
              └── RF-09 (Historial)

RF-12 (Admin de balance) ---------> RF-11 (Balance de criaturas)
RF-13 (Extensibilidad futura) -----> Todos los modulos anteriores
```

### Bloqueos Identificados

| Bloqueo | Requerimiento Afectado | Descripcion |
|---------|------------------------|-------------|
| Sin definicion de reglas de balance | RF-05, RF-11 | No se puede implementar el combate sin saber como se calculan las estadisticas. |
| Sin criterio claro de "emparejamiento justo" | RF-07 | No se puede implementar el matchmaking sin saber el algoritmo (ELO, nivel, victorias, etc.). |
| Sin definicion del flujo de combate | RF-05, RF-06 | El cliente dice "no en tiempo real" pero no especifica si es por turnos, simulado, etc. |
| Sin acuerdo en modelo de progresion | RF-04, RF-08 | No se puede implementar la evolucion sin saber que recursos se usan y como se obtienen. |
| Sin documentacion formal del cliente | Todos | El cliente no entrego especificaciones; cualquier supuesto puede ser incorrecto. |

---

## 5. Matriz de Trazabilidad

| ID     | Tipo | Descripcion Resumida | Modulo / Caso de Uso | Validacion / Prueba |
|--------|------|----------------------|----------------------|---------------------|
| RF-01  | F    | Registro de usuarios | Modulo de Autenticacion | Prueba: crear usuario con datos validos e invalidos; verificar respuesta HTTP 201 / 400. |
| RF-02  | F    | Autenticacion de usuarios | Modulo de Autenticacion | Prueba: login correcto retorna token; credenciales incorrectas retornan 401. |
| RF-03  | F    | Gestion de coleccion | Modulo de Coleccion | Prueba: agregar criatura al inventario; verificar que aparece en la lista del usuario. |
| RF-04  | F    | Evolucion de criaturas | Modulo de Progresion | Prueba: evolucionar criatura con recursos suficientes; verificar cambio de estadisticas. |
| RF-05  | F    | Sistema de combate | Modulo de Combate | Prueba: iniciar combate entre dos jugadores; verificar que se genera resultado valido. |
| RF-06  | F    | Consistencia de resultados | Modulo de Combate | Prueba: ejecutar el mismo combate dos veces con identico estado inicial; verificar mismo resultado. |
| RF-07  | F    | Emparejamiento justo | Modulo de Matchmaking | Prueba: verificar que jugadores emparejados tienen diferencia de nivel dentro del umbral definido. |
| RF-08  | F    | Gestion de inventario | Modulo de Inventario | Prueba: agregar, usar y remover items; verificar cambios reflejados en el inventario. |
| RF-09  | F    | Historial de combates | Modulo de Historial | Prueba: tras un combate, verificar que aparece en el historial con datos correctos. |
| RF-10  | F    | Perfil de usuario | Modulo de Perfil | Prueba: consultar perfil de usuario; verificar estadisticas, nivel y criaturas mostradas. |
| RF-11  | F    | Reglas de balance | Modulo de Combate / Admin | Prueba: criaturas con estadisticas identicas deben producir combate equilibrado (sin ventaja sistematica). |
| RF-12  | F    | Panel de administracion | Modulo Admin | Prueba: admin modifica estadistica de criatura; cambio se refleja en proximos combates. |
| RF-13  | F    | Extensibilidad futura | Arquitectura del sistema | Revision: agregar un nuevo modulo (ej. ranking) sin modificar modulos existentes. |
| RNF-01 | NF   | Consistencia ACID | Base de datos / Combate | Prueba: simular falla en mitad de un combate; verificar que no quedan estados a medias. |
| RNF-02 | NF   | Rendimiento < 2s | Todos los endpoints | Prueba de carga: 100 usuarios concurrentes; medir tiempo de respuesta promedio. |
| RNF-03 | NF   | Disponibilidad 99% | Infraestructura | Monitoreo mensual de uptime; verificar que el downtime no supera 7 horas al mes. |
| RNF-04 | NF   | Escalabilidad horizontal | Arquitectura / Infraestructura | Prueba: simular 10x usuarios; verificar que el sistema responde sin errores. |
| RNF-05 | NF   | Cifrado de contrasenas | Modulo de Autenticacion | Prueba: verificar que en base de datos no existen contrasenas en texto plano. |
| RNF-06 | NF   | Seguridad de endpoints | Todos los endpoints protegidos | Prueba: solicitud sin token valido retorna 401 en todos los endpoints protegidos. |
| RNF-07 | NF   | Arquitectura modular | Arquitectura general | Revision de arquitectura: cada modulo puede modificarse o reemplazarse sin afectar otros. |
| RNF-08 | NF   | Validacion de datos | Todos los endpoints de entrada | Prueba: enviar datos malformados o con SQL injection; verificar rechazo controlado. |
| RNF-09 | NF   | Logs de errores | Capa de infraestructura / logging | Prueba: provocar error critico; verificar que el log contiene contexto suficiente para depurar. |
| RNF-10 | NF   | Accesibilidad web | Frontend | Prueba: acceder desde Chrome, Firefox y Edge sin plugins adicionales; verificar funcionalidad completa. |

---

## 6. Analisis de Ambiguedades

Se identificaron los siguientes aspectos del enunciado que requieren aclaracion con el cliente antes de iniciar el desarrollo:

---

### Ambiguedad 1: Definicion de "Combate Consistente"

**Fragmento del enunciado:** *"los combates no requieren ser en tiempo real, pero si deben mantener consistencia en los resultados"*

**Problema:** No se especifica que mecanismo determina el resultado del combate. Las posibles interpretaciones son:
- Combate por turnos donde cada jugador toma decisiones secuencialmente.
- Combate simulado automaticamente con base en estadisticas (sin intervencion del jugador en tiempo real).
- Combate donde se selecciona la estrategia antes y el resultado se calcula al momento del enfrentamiento.

**Impacto:** El flujo del sistema cambia radicalmente segun la opcion elegida. Un combate por turnos requiere gestion de estado, sesiones y posiblemente websockets; una simulacion es mucho mas simple.

**Pregunta para el cliente:** ¿Como espera usted que transcurra un combate paso a paso? ¿Los jugadores toman decisiones activamente o el resultado se calcula automaticamente?

---

### Ambiguedad 2: Criterio de "Emparejamiento Justo"

**Fragmento del enunciado:** *"La posibilidad de hacer emparejamientos justos entre jugadores"*

**Problema:** No existe ninguna definicion de que constituye un emparejamiento "justo". Las posibles interpretaciones son:
- Emparejamiento por nivel de usuario.
- Emparejamiento por poder total de criaturas en el equipo.
- Emparejamiento por historial de victorias / derrotas (sistema tipo ELO).
- Emparejamiento por tiempo de espera (priorizar tiempo sobre precision).

**Impacto:** El algoritmo de matchmaking y las estructuras de datos asociadas dependen completamente de esta definicion. Un sistema ELO tiene mayor complejidad que uno por nivel simple.

**Pregunta para el cliente:** ¿Bajo que criterio considera que dos jugadores son "equivalentes" para un combate justo? ¿Tiene referencia de algun juego cuyo sistema de emparejamiento le parezca adecuado?

---

### Ambiguedad 3: Alcance y Duracion de la Persistencia de Partidas

**Fragmento del enunciado:** *"La persistencia de la informacion de las partidas"*

**Problema:** No se especifica:
- Por cuanto tiempo deben conservarse los registros (¿indefinidamente? ¿ultimos 30 combates?).
- Que informacion exacta de cada combate debe guardarse (¿solo resultado final? ¿cada movimiento/turno?).
- Si existe requerimiento legal o de negocio de auditoria sobre estos datos.

**Impacto:** Un historial completo de cada accion en cada combate puede generar volumenes de datos muy altos a largo plazo, afectando costos de almacenamiento y rendimiento de consultas.

**Pregunta para el cliente:** ¿Que informacion espera ver en el historial de un combate? ¿Solo quien gano, o tambien el detalle de como se desarrollo la batalla?

---

### Ambiguedad 4 (Adicional): Modelo de Progresion y Recursos

**Fragmento del enunciado:** *"mecanicas de progresion"* y *"mejorarlas"*

**Problema:** No se define:
- Como se obtienen los recursos para mejorar criaturas (combates, tiempo, compras).
- Si existe monetizacion (compras dentro del juego).
- Que significa exactamente "mejorar" una criatura (estadisticas, habilidades nuevas, nivel, forma evolucionada).

**Impacto:** El modelo de datos, el sistema de economia del juego y la integracion con posibles pasarelas de pago dependen de estas definiciones.

**Pregunta para el cliente:** ¿Como obtienen los jugadores recursos para mejorar sus criaturas? ¿Existe algun modelo de monetizacion contemplado?

---

## Conclusion del Analisis

El enunciado provee una vision general del producto pero carece de la especificidad necesaria para iniciar el desarrollo de forma segura. Se identificaron:

- **13 requerimientos funcionales** (7 de alta prioridad)
- **10 requerimientos no funcionales** (6 de alta prioridad)
- **5 bloqueos criticos** que deben resolverse antes de comenzar el disenio
- **4 ambiguedades** que requieren validacion con el cliente

**Recomendacion:** Antes de comenzar cualquier implementacion, se debe realizar al menos una sesion de refinamiento con el cliente para clarificar el flujo de combate, el criterio de emparejamiento y el modelo de progresion. Estos tres puntos son el nucleo del sistema y cualquier supuesto incorrecto sobre ellos representa un riesgo alto de retrabajo.
