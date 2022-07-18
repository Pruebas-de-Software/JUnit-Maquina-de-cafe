package tarea.junit;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

	@BeforeEach
	void setUp() throws Exception {
	}
	
	// Probar Agregar Inventario, verificar inventario, comprar bebida y salir
	@Test
	void testMainGood() {
		//Given
		String userInput = "1 5 5 40 0 2 3 1 500 4";
		InputStream in = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(in);
		//When
		
		//Then
		Main.main(null);
	}
	
	// Probar Agregar Inventario, input incorrecto, verificar inventario, comprar bebida y salir
	@Test
	void testMainAddInventoryBad() {
		//Given
		String userInput = "1 a 5 -2 5 81 40 0 2 3 2 700 4";
		InputStream in = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(in);
		//When
		
		//Then
		Main.main(null);
	}
	
	// Probar Opcion incorrecta, Agregar Inventario, verificar inventario, comprar bebida y salir
	@Test
	void testMainBadMenuOptions() {
		//Given
		String userInput = "0 as 1 5 5 40 0 2 3 3 400 4";
		InputStream in = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(in);
		//When
		
		//Then
		Main.main(null);
	}
	
	// Probar comprar bebida y luego agregar inventario
	@Test
	void testMainShopDrinkAddInventory() {
		//Given
		String userInput = "3 1 500 1 7 5 44 2 4";
		InputStream in = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(in);
		//When
		
		//Then
		Main.main(null);
	}

}
