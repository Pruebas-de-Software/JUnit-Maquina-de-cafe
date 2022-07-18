package tarea.junit;

public class Recipe {
	private String name;
	private int price, coffee, chocolate, milk, sugar;

	public Recipe() {

	}

	public Recipe(String name, int price, int coffee, int chocolate, int milk, int sugar) {
		super();
		this.name = name;
		this.price = price;
		this.coffee = coffee;
		this.chocolate = chocolate;
		this.milk = milk;
		this.sugar = sugar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCoffe() {
		return coffee;
	}

	public void setCoffe(int coffe) {
		this.coffee = coffe;
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

}
