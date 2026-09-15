# ☕ JUnit Máquina de hacer café

## 🔍 El problema

Vamos a modelar la forma en la que ésta opera la máquina de café presentada en una tarea anterior, por lo tanto, debemos construir un programa de línea de comandos que simule la operación de la nueva máquina de café. 

---

### 📋 Requerimientos de usuario

#### ✅ Req1: Estado de espera  
**Prioridad:** 1  

Cuando la máquina de café no está en uso, se encuentra a la “espera” la entrada del usuario. Hay tres opciones diferentes de entrada del usuario que se presentan en este estado:

- Agregar inventario
- Verificar inventario
- Comprar bebida

#### ✅ Req2: Agregar inventario  
**Prioridad:** 1  

El inventario (contenedor de insumos) de la cafetera se puede agregar en cualquier momento desde el menú principal. Se agrega al inventario actual de la máquina de café. Los tipos de inventario son:

- Café (en polvo)
- Leche (en polvo)
- Chocolate (en polvo)
- Azúcar  
- **Nota:** La máquina tiene un suministro de agua permanente (no considerar).  

📌 *El inventario se mide en unidades enteras.*  
📌 *Solo se puede quitar inventario al comprar una bebida.*  
📌 *Al finalizar una operación, la máquina vuelve al estado de espera.*

#### ✅ Req3: Verificar inventario  
**Prioridad:** 2  

- El inventario se puede comprobar en cualquier momento desde el menú principal.
- Las unidades de cada insumo son mostradas.
- Al finalizar, la máquina vuelve al estado de espera.

#### ✅ Req4: Comprar bebidas  
**Prioridad:** 1  

- El usuario selecciona una bebida e inserta una cantidad de dinero (entero).
- Si el usuario pagó suficiente dinero y la bebida está en las recetas disponibles:
  - Se entrega la bebida
  - Se devuelve cualquier cambio
- Si no hay suficiente inventario o dinero, se cancela la operación y se devuelve el dinero.

📢 *Mensaje final:* “Su bebida Receta_k está lista”.  
📌 *La máquina vuelve a su estado de espera.*

#### ✅ Req5: Configuración inicial  
**Prioridad:** 1  

La máquina maneja una configuración inicial de sus recetas, que se componen de:

- Nombre de receta
- Precio
- Unidades de café
- Unidades de chocolate
- Unidades de leche
- Unidades de azúcar

📌 *La máquina solo maneja 3 recetas, cargadas antes de la puesta en servicio.*  

📍 **Ejemplo de receta:**  
- (Café con leche, 500, 2, 0, 4, 2)  
- Nombre: Café con leche  
- Precio: 500  
- Café: 2  
- Chocolate: 0  
- Leche: 4  
- Azúcar: 2  

🔢 **Límites de la máquina:**  
- Café: 10  
- Chocolate: 10  
- Leche: 80  
- Azúcar: 40  

---

## 📑 Casos de uso

### 🛠 UC1: Agregar inventario

**1.1 Condiciones previas:** ninguna  
**1.2 Flujo principal:**  
- Se le pedirá al usuario las unidades de cada ingrediente que desea agregar. [E1], [E2]  
**1.3 Subflujos:** Ninguno  
**1.4 Flujos alternativos:**  
- [E1] Si el número es negativo o no entero, se vuelve a solicitar.  
- [E2] Si el carácter ingresado no es entero, se vuelve a solicitar.

---

### 🛠 UC2: Verificar inventario

**2.1 Condiciones previas:** ninguna  
**2.2 Flujo principal:**  
- Se muestra la lista del inventario actual.  
**2.3 Subflujos:** Ninguno  
**2.4 Flujos alternativos:** Ninguno

---

### 🛠 UC3: Comprar bebida

**3.1 Condiciones previas:** ninguna  
**3.2 Flujo principal:**  
- El usuario selecciona la bebida y deposita dinero. [S1], [S2]  
**3.3 Subflujos:**  
- [S1] La máquina verifica si hay inventario suficiente. [E1]  
- [S2] La máquina verifica si se ha depositado suficiente dinero. [E2]  
**3.4 Flujos alternativos:**  
- [E1] Si no hay inventario, se cancela la compra y se devuelve el dinero.  
- [E2] Si el dinero es insuficiente, se devuelve el monto y se regresa al menú.

---

## 👨‍💻 Autor de la solución

**Diego Aguilera**  

---

## 📘 Descripción

Tarea 4 para la asignatura **INF331 - Pruebas de Software** del Departamento de Informática de la Universidad Técnica Federico Santa María.

La aplicación permite:
- Comprar una de las bebidas ya cargadas en la máquina  
- Comprobar el inventario de ingredientes  
- Rellenar el inventario  

---

## 🛠 Instalación

Clonar el repositorio e importar como un proyecto **[Maven](https://maven.apache.org/)** con **[Eclipse IDE](https://www.eclipse.org/ide/)**.

---

## ▶️ Cómo usar

### Aplicación

Ejecutar el archivo `Main.java` ubicado en `src/main/java/tarea/junit/` desde Eclipse (`Ctrl + F11` o menú Run → Run).

### Pruebas

Los archivos de prueba se encuentran en:  
`src/test/java/tarea/junit/`

- `CoffeeMakerTest.java`: prueba funcionalidades principales  
- `MainTest.java`: se usa para pruebas de coverage

---

### ▶️ Ejecutar pruebas

Con JDK 17 o superior y Maven instalados, ejecutar desde la raíz del proyecto:

```sh
mvn clean test
```

Maven descarga JUnit 5 y ejecuta las pruebas mediante Surefire.

Para medir cobertura desde Eclipse:

1. Instalar [EclEmma](https://www.eclemma.org/index.html)  
2. Ir a "Coverage Configurations" (Run → Coverage Configurations...)  
3. Crear configuración para JUnit: "Run all tests in the selected project..."  
4. Aplicar y presionar "Coverage"  

📊 **Coverage estimado:**
- Promedio: 97.1%  
- `CoffeeMaker.java`: 99.5%  
- `Main.java`: 98.1%

---

## 🤝 Cómo contribuir

Las contribuciones son bienvenidas. Por favor, crea una **issue** en este proyecto para discutir los cambios.

---

## 📄 Licencia

Este proyecto está licenciado bajo la  
**[GNU General Public License v3.0](https://www.gnu.org/licenses/)**

