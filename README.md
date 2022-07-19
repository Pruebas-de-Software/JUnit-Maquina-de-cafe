# INF331 2022-1 Tarea4 JUnit

## Autor

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