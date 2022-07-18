package tarea.junit;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static void showMenuOptions() {
		System.out.println("-----Opciones-----");
		System.out.println("1) Agregar Inventario");
		System.out.println("2) Verificar Inventario");
		System.out.println("3) Comprar Bebida");
		System.out.println("4) Salir");
		System.out.print("Elija una opción (1/2/3/4): ");
	}
	
	public static Boolean mainMenu(Scanner sc, CoffeeMaker cafetera, int menuOption, String s) {
		
		showMenuOptions();
		if (sc.hasNextInt()) {
			menuOption = sc.nextInt();
			switch (menuOption) {
			case 1:
				cafetera.addInventory(sc);
				return false;
			case 2:
				cafetera.showInventory();
				return false;
			case 3:
				while (true) {
					if (cafetera.shopDrink(sc))
						return false;
				}
			case 4:
				return true;
			default:
				System.out.printf("La opción '%d' no existe%n", menuOption);
				return false;
			}
		} else {
			s = sc.next();
			System.out.printf("La opción '%s' no existe%n", s);
			return false;
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int menuOption = 0;
		String s = "";
		
		Recipe cafeConLeche = new Recipe("Café con Leche",500,2,0,4,2);
		Recipe cafeConChocolate = new Recipe("Café con Chocolate",700,2,4,0,2);
		Recipe cafeDulce = new Recipe("Café Dulce",400,2,0,0,4);
		
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		
		Scanner sc = new Scanner(System.in);
		
		recipes.add(cafeConLeche);
		recipes.add(cafeConChocolate);
		recipes.add(cafeDulce);
		System.out.println("Cafetera UTFSM");
		
		CoffeeMaker cafetera = new CoffeeMaker(5,5,40,40,recipes);
		
		
		while (true) {
			if (mainMenu(sc, cafetera, menuOption, s))
				break;
		}
		sc.close();
	}

}
