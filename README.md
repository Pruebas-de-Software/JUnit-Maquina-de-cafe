# JUnit Máquina de hacer café

## El problema

Vamos a modelar la forma en la que ésta opera la máquina de café presentada en una tarea anterior, por lo tanto, debemos construir un programa de línea de comandos que simule la operación de la nueva máquina de café. 

Se ha declarado los siguiente:

**Requerimientos de usuario**

**Req1: Estado de espera**

Prioridad 1

Cuando la máquina de café no está en uso, se encuentra a la “espera” la entrada del usuario. “Hay tres opciones diferentes de entrada del usuario” que se presentan en este estado:

- Agregar inventario
- Verificar inventario
- Comprar bebida

**Req2: Agregar inventario**

Prioridad 1

El inventario (contenedor de insumos) de la cafetera se puede agregar a la máquina en cualquier momento desde el menú principal, y se agrega a el inventario actual de la máquina de café. Los tipos de inventario son:

- Café (en polvo)
- Leche (en polvo)
- Chocolate (en polvo)
- Azúcar
- La máquina tiene un suministro de agua permanente( no considerar).

El inventario se mide en unidades enteras.

El inventario solo se puede quitar de la máquina de café comprando una bebida. Al finalizar una operación la máquina vuelve al estado espera, “menú principal”.

**Req3: Verificar inventario**

Prioridad: 2

El inventario se puede comprobar en cualquier momento desde el menú principal.

Las unidades de cada insumo son mostradas.

Al finalizar, la máquina de café vuelve al estado de espera.

**Req3: Comprar bebidas**

Prioridad 1

El usuario selecciona una bebida e inserta una cantidad de dinero.

El dinero debe ser un entero.

Si la bebida está en dentro de las opciones posibles de “Recetas” y el usuario pagó suficiente dinero, Se dispensará bebida y se devolverá cualquier cambio de dinero.

El usuario no podrá comprar una bebida si no depositan suficiente dinero en la máquina de café.

Se devolverá el dinero si no hay suficiente inventario para hacer la bebida.

Una vez entregada la bebida, mensaje: “Su bebida Receta\_k esta lista”, la máquina de café vuelve a su estado de espera.

**

**Req4: Configuración inicial**

Prioridad 1

La máquina maneja tiene una configuración inicial de sus “Recetas”, estas se componen de:

- Nombre de receta
- Precio
- Unidades de café
- Unidades de chocolate
- Unidades de leche
- Unidades de azúcar

La máquina solo maneja 3 recetas y estas deben ser cargadas antes de la puesta en servicio de la máquina.

Las recetas son a elección, por ejemplo: 

- (Café con leche, 500, 2, 0, 4, 2)
  - Nombre de receta: Café con leche
  - Precio: 500
  - Unidades de café: 2
  - Unidades de chocolate: 0
  - Unidades de leche: 4
  - Unidades de azúcar: 2

Los límites de la máquina, o máximos soportados son:

- Max. unidades de café: 10
- Max. unidades de chocolate: 10
- Max. unidades de leche: 80
- Max. unidades de azúcar: 40
**


**Casos de uso:**

**UC1: Flujo de eventos para el caso de uso “*Agregar inventario”***

1.1 Condiciones previas: ninguna

1.2 Flujo principal: 

Se le pedirá al usuario las unidades de cada uno de los cuatro ingredientes que desea agregar al inventario. [E1] [E2]

1.3 Subflujos: Ninguno

1.4 Flujos alternativos:

[E1] Si el usuario selecciona un número que es negativo o que no es entero, se volverá a solicitar al usuario la cantidad.

[E2] Si el usuario ingresa un carácter no entero, se le solicitará nuevamente la cantidad.

**UC2: Flujo de eventos para el caso de uso de “*Verificar inventario”***

2.1 Condiciones previas: ninguna

2.2 Flujo principal: se le mostrará al usuario una lista del inventario de ingredientes en la máquina de café.

2.3 Subflujos: Ninguno

2.4 Flujos alternativos: Ninguno

**UC3: Flujo de eventos para el caso de uso de “*Comprar de bebida”***

3.1 Condiciones previas: ninguna

3.2 Flujo principal: El usuario seleccionará la bebida que desea comprar. El usuario depositará dinero para pagar la bebida. [S1] [S2]

3.3 Subflujos:

[S1] La máquina comprobará si hay suficientes ingredientes en el inventario para preparar la bebida seleccionada. [E1]

[S2] La máquina se asegurará de que se haya depositado suficiente dinero [E2], se dispensará la bebida y se realizará cualquier cambio adicional.

3.4 Flujos alternativos:

[E1] Si no hay suficiente inventario para hacer la bebida, se mostrará un mensaje, se devolverá el dinero del usuario y se volverá al menú principal.

[E2] Si el usuario no ingresa suficiente dinero, se le devolverá su dinero y el usuario regresará al menú principal.


## Autor de la solución

Diego Aguilera 201673033-8

## Descripción

Tarea 4 para la asignatura INF331 Pruebas de Software del Departamento de Informática de la Universidad Técnica Federico Santa María.

El sistema simula una máquina expendedora de café, donde el usuario puede:
- Comprar una de las bebidas ya cargadas en la máquina
- Comprobar el inventario de ingredientes
- Rellenar el inventario de ingredientes
## Instalación

Clonar el repositorio y luego importar como un proyecto de [Maven](https://maven.apache.org/) con [Eclipse](https://www.eclipse.org/ide/).
## Como usar

### Aplicación

Para ejecutar la aplicación, abrir el archivo `Main.java`, ubicado en `src/main/java/tarea/junit/`, luego presionando `Ctrl + F11` o presionando `Run` en el menú `Run`.

### Pruebas

Hay 2 archivos de pruebas que se encuentran en `src/test/java/tarea/junit/`, `CoffeeMakerTest.java` y `MainTest.java`.

`CoffeeMakerTest.java` se enfoca en probar las distintas funcionalidades de la aplicación. Mientras que `MainTest.java` se utiliza para realizar coverage del código.

### Ejecutar pruebas

Primero se recomienda instalar la extensión [EclEmma](https://www.eclemma.org/index.html), luego abrir la ventana "Coverage Configurations" (`Run -> Coverage Configurations...`) y allí crear una nueva configuración para JUnit marcando la opción "Run all tests in the selected project, package or source folder:". Después se aplican los cambios y se presiona el botón "Coverage" ubicado en la esquina inferior derecha de la ventana.

El resultado da un porcentaje de coverage del 97.1% en promedio, dando 99.5% y 98.1% para *CoffeeMaker.java* y *Main.java* respectivamente.

## Cómo contribuir

Cualquier contribución es bienvenida, por favor hacerla a través de una issue en este proyecto.

## Licencia

Este proyecto está licenciado bajo la [GNU General Public License V3](https://www.gnu.org/licenses/)
