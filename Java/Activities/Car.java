package Day1;

public class Car {
	String carName;
	int carNumber;
	String color;

	Car(String carName, int carNumber, String color) {
		this.carName = carName;
		this.carNumber = carNumber;
		this.color = color;
	}

	public void displayCar1() {
		System.out.println("Car details are : " + carName + " , " + carNumber + " , " + color);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c1 = new Car("Toyota", 12323, "Red");
		Car c2 = new Car("Ford", 123, "Blue");
		c1.displayCar1();
		c2.displayCar1();

	}
}
