package tarea.junit;

import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeMaker {
	
	private int coffee, chocolate, milk, sugar;
	private ArrayList<Recipe> recipes;
	
	public CoffeeMaker() {}
	
	public CoffeeMaker(int coffee, int chocolate, int milk, int sugar, ArrayList<Recipe> recipes) {
		super();
		this.coffee = coffee;
		this.chocolate = chocolate;
		this.milk = milk;
		this.sugar = sugar;
		this.recipes = recipes;
	}
	
	public void showInventory() {
		System.out.printf(
			"-----Inventario-----"
			+ "%n Cafe: %d/10%n Chocolate: %d/10%n Leche: %d/80%n Azúcar: %d/40%n",
			this.coffee,
			this.chocolate,
			this.milk,
			this.sugar
			);
	}
	
	public int fillItem(Scanner sc, int itemId) {
		String itemName;
		int itemAmount, itemMaxAmount, itemAddedAmount;
		
		switch (itemId) {
		case 0:
			itemName = "Café";
			itemAmount = getCoffee();
			itemMaxAmount = 10;
			break;
		case 1:
			itemName = "Chocolate";
			itemAmount = getChocolate();
			itemMaxAmount = 10;
			break;
		case 2:
			itemName = "Leche";
			itemAmount = getMilk();
			itemMaxAmount = 80;
			break;
		case 3:
			itemName = "Azúcar";
			itemAmount = getSugar();
			itemMaxAmount = 40;
			break;
		default:
			return 0;
		}
		
		if (itemAmount < itemMaxAmount) {
			System.out.printf("Agregando %s %d/%d%n", itemName.toLowerCase(), itemAmount, itemMaxAmount);
			itemAddedAmount = 0;
			String s;
			
			System.out.printf("Unidades de %s: ", itemName.toLowerCase());
			if (sc.hasNextInt()) {
				itemAddedAmount = sc.nextInt();
			} else {
				s = sc.next();
				System.out.printf("'%s' no es un entero, ingrese nuevamente%n", s);
				return 0;
			}
			if (itemAddedAmount < 0) {
				System.out.println("Cantidad negativa, ingrese nuevamente");
				return 0;
			}
			if (itemAmount + itemAddedAmount > itemMaxAmount) {
				System.out.printf("Sobrepasa el límite de %s %d/%d, ingrese nuevamente%n", itemName.toLowerCase(), itemAmount + itemAddedAmount, itemMaxAmount);
				return 0;
			}
			switch (itemId) {
			case 0:
				setCoffee(itemAmount + itemAddedAmount);
				itemAmount = getCoffee();
				break;
			case 1:
				setChocolate(itemAmount + itemAddedAmount);
				itemAmount = getChocolate();
				break;
			case 2:
				setMilk(itemAmount + itemAddedAmount);
				itemAmount = getMilk();
				break;
			case 3:
				setSugar(itemAmount + itemAddedAmount);
				itemAmount = getSugar();
				break;
			}
				
		    System.out.printf("Nuevo total de %s: %d/%d%n", itemName.toLowerCase(), itemAmount, itemMaxAmount);
		    return 1;
		    
		} else {
			System.out.printf("%s al máximo%n", itemName);
			return 2;
		}
	}

	public void addInventory(Scanner sc) {
		int result;
	    for (int i = 0; i < 4; i++) {
	    	while (true) {
	    		result = fillItem(sc, i);
	    		if (result == 1 || result == 2) {
	    			break;
	    		}
	    	}
	    	
	    }
	}
	
	public boolean checkAvailableIngredients(Recipe drink) {
		return (getCoffee() >= drink.getCoffe()) &&
				(getChocolate() >= drink.getChocolate()) &&
				(getMilk() >= drink.getMilk()) &&
				(getSugar() >= drink.getSugar());
	}
	
	public boolean shopDrink(Scanner sc) {
		int drinkIndex, amount;
		String s;
		Recipe drink;
		
		// Elegir una bebida
		
		showDrinksList();
		System.out.print("Elija una bebida (1/2/3): ");
		if (sc.hasNextInt()) {
			drinkIndex = sc.nextInt();
			switch (drinkIndex) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				System.out.printf("La opción '%d' no existe%n", drinkIndex);
				return false;
			}
			
			drink = getRecipes().get(drinkIndex - 1);
			System.out.println(drink.getName());
			
		} else {
			s = sc.next();
			System.out.printf("La opción '%s' no es válida%n", s);
			return false;
		}
		
		// Ingresar dinero a la maquina
		System.out.printf("Ingrese un monto mayor o igual a $%d: ", drink.getPrice());
		
		
		if (sc.hasNextInt()) {
			amount = sc.nextInt();
		} else {
			s = sc.next();
			
			System.out.println("Lo ingresado no se reconoce como dinero, intente de nuevo");
			return false;
		}
		
		if (amount < drink.getPrice()) {
			System.out.println("Cantidad insuficiente, retire su dinero");
			amount = 0;
			return false;
		}
		
		if (!checkAvailableIngredients(drink)) {
			System.out.println("No hay suficientes ingredientes.");
			System.out.printf("Por favor, recoja su dinero ($%d)%n", amount);
			amount = 0;
			return false;
		}
		
		if (amount > drink.getPrice()) {
			System.out.printf("Su vuelto es $%d%n", amount - drink.getPrice());
		}
		
		setCoffee(getCoffee() - drink.getCoffe());
		setChocolate(getChocolate() - drink.getChocolate());
		setMilk(getMilk() - drink.getMilk());
		setSugar(getSugar() - drink.getSugar());
		
		System.out.printf("Su bebida %s está lista%n", drink.getName());
		return true;
	}
	
	public void showDrinksList() {
		System.out.println("-----Bebidas-----");
		Recipe recipe;
		for (int i = 0; i < recipes.size(); i++) {
			recipe = recipes.get(i);
			System.out.printf("%d) %s: $%d %n", i+1, recipe.getName(), recipe.getPrice());
		}	
	}
	

	// Getters y Setters
	public int getCoffee() {
		return coffee;
	}

	public void setCoffee(int coffee) {
		this.coffee = coffee;
	}

	public int getChocolate() {
		return chocolate;
	}

	public void setChocolate(int chocolate) {
		this.chocolate = chocolate;
	}

	public int getMilk() {
		return milk;
	}

	public void setMilk(int milk) {
		this.milk = milk;
	}

	public int getSugar() {
		return sugar;
	}

	public void setSugar(int sugar) {
		this.sugar = sugar;
	}

	public ArrayList<Recipe> getRecipes() {
		return recipes;
	}
}
