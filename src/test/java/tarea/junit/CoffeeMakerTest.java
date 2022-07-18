package tarea.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeMakerTest {
	
	private CoffeeMaker coffeeMaker;

	@BeforeEach
	void setUp() throws Exception {
		
		Recipe cafeConLeche = new Recipe("Café con Leche",500,6,0,4,2);
		Recipe cafeConChocolate = new Recipe("Café con Chocolate",700,2,4,0,2);
		Recipe cafeDulce = new Recipe("Café Dulce",400,2,0,0,4);
		
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		recipes.add(cafeConLeche);
		recipes.add(cafeConChocolate);
		recipes.add(cafeDulce);
		
		// Se inicia la cafetera con la mitad de capacidad para los ingredientes
		coffeeMaker = new CoffeeMaker(5,5,40,20,recipes);
	}
	
	// Pruebas de agregar inventario
	
	// Probar aumentar el cafe de la maquina
	@Test
	void testFillItemNotFull() {
		//Given
		// Ingediente cafe
		int itemId = 0;
	
		//Cantidad de café que agrega el usuario
		Scanner sc = new Scanner("4"); 
		//When
		
		//Then
		// Se retorna 1 cuando se agregan unidades a un ingrediente
		assertEquals(1, coffeeMaker.fillItem(sc, itemId));
	}
	
	// Probar llenar el chocolate de la maquina
	@Test
	void testFillItemFull() {
		//Given
		// Ingediente chocolate
		int itemId = 1;
	
		//Cantidad de café que agrega el usuario
		Scanner sc = new Scanner("5"); 
		//When
		
		//Then
		// Se retorna 1 cuando se agregan unidades a un ingrediente
		assertEquals(1, coffeeMaker.fillItem(sc, itemId));
	}
	
	// Probar sobrellenar la leche de la maquina
	@Test
	void testFillItemMilkOverFull() {
		//Given
		// Ingediente leche
		int itemId = 2;
	
		//Cantidad de café que agrega el usuario
		Scanner sc = new Scanner("41"); 
		//When
		
		//Then
		// Se retorna 0 cuando al agregar se supera el maximo
		assertEquals(0, coffeeMaker.fillItem(sc, itemId));
	}
	
	// Probar sobrellenar el azucar de la maquina
	@Test
	void testFillItemSugarOverFull() {
		//Given
		// Ingediente leche
		int itemId = 3;
	
		//Cantidad de café que agrega el usuario
		Scanner sc = new Scanner("21"); 
		//When
		
		//Then
		// Se retorna 0 cuando al agregar se supera el maximo
		assertEquals(0, coffeeMaker.fillItem(sc, itemId));
	}
	
	// Probar ingresar un float
	@Test
	void testFillItemFloat() {
		//Given
		// Ingediente cafe
		int itemId = 0;
	
		//Cantidad de café que agrega el usuario
		Scanner sc = new Scanner("3.2"); 
		//When
		
		//Then
		// Se retorna 0 cuando no se ingresa un entero positivo
		assertEquals(0, coffeeMaker.fillItem(sc, itemId));
	}
	
	// Probar ingresar un negativo
	@Test
	void testFillItemNegative() {
		//Given
		// Ingediente cafe
		int itemId = 0;
	
		//Cantidad de café que agrega el usuario
		Scanner sc = new Scanner("-3"); 
		//When
		
		//Then
		// Se retorna 0 cuando no se ingresa un entero positivo
		assertEquals(0, coffeeMaker.fillItem(sc, itemId));
	}
	
	// Probar ingresar un char/string
	@Test
	void testFillItemChar() {
		//Given
		// Ingediente cafe
		int itemId = 0;
	
		//Cantidad de café que agrega el usuario
		Scanner sc = new Scanner("asd"); 
		//When
		
		//Then
		// Se retorna 0 cuando no se ingresa un entero positivo
		assertEquals(0, coffeeMaker.fillItem(sc, itemId));
	}
	
	// Probar un ingrediente que no existe
	@Test
	void testFillItemWrongItem() {
		//Given
		// Ingediente cafe
		int itemId = 5;
	
		//Cantidad de café que agrega el usuario
		Scanner sc = new Scanner("asd"); 
		//When
		
		//Then
		// Se retorna 0 cuando no se ingresa un entero positivo
		assertEquals(0, coffeeMaker.fillItem(sc, itemId));
	}
	
	// Probar si hay suficientes ingredientes: hay suficientes
	@Test
	void testCheckAvailableIngredientsEnough() {
		//Given
		Recipe cafeDulce = new Recipe("Café Dulce",400,2,0,0,4);
		
		//When
				
		//Then
		assertEquals(true, coffeeMaker.checkAvailableIngredients(cafeDulce));
	}
	
	// Probar si hay suficientes ingredientes: no hay suficientes
	@Test
	void testCheckAvailableIngredientsNotEnough() {
		//Given
		Recipe cafeConLeche = new Recipe("Café con Leche",500,6,0,4,2);
		
		//When
				
		//Then
		assertEquals(false, coffeeMaker.checkAvailableIngredients(cafeConLeche));
	}
	
	// Probar comprar bebida existente con dinero justo
	@Test
	void testShopDrink() {
		//Given
		Scanner sc = new Scanner("2 700"); 
		
		//When
				
		//Then
		assertEquals(true, coffeeMaker.shopDrink(sc));
	}
	
	// Probar comprar bebida existente con dinero de sobra
	@Test
	void testShopDrinkWithChange() {
		//Given
		Scanner sc = new Scanner("2 800"); 
		
		//When
				
		//Then
		assertEquals(true, coffeeMaker.shopDrink(sc));
	}
	
	// Probar comprar bebida existente con dinero insuficiente
	@Test
	void testShopDrinkNotEnoughMoney() {
		//Given
		Scanner sc = new Scanner("2 600"); 
		
		//When
				
		//Then
		assertEquals(false, coffeeMaker.shopDrink(sc));
	}
	
	// Probar comprar bebida existente con dinero invalido
	@Test
	void testShopDrinkWithInvalidMoney() {
		//Given
		Scanner sc = new Scanner("2 asd"); 
		
		//When
				
		//Then
		assertEquals(false, coffeeMaker.shopDrink(sc));
	}
	
	// Probar comprar bebida existente con insuficientes ingredientes
	@Test
	void testShopDrinkInsufficientIngredients() {
		//Given
		Scanner sc = new Scanner("1 500"); 
		
		//When
				
		//Then
		assertEquals(false, coffeeMaker.shopDrink(sc));
	}
	
	// Probar comprar bebida no existente
	@Test
	void testShopDrinkDoesNotExist() {
		//Given
		Scanner sc = new Scanner("6 600"); 
		
		//When
				
		//Then
		assertEquals(false, coffeeMaker.shopDrink(sc));
	}
	
	// Probar comprar bebida no valida
	@Test
	void testShopDrinkNotValid() {
		//Given
		Scanner sc = new Scanner("asd 600"); 
		
		//When
				
		//Then
		assertEquals(false, coffeeMaker.shopDrink(sc));
	}

}
