import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
Car car = new Car();
car.setAvailable(true);
car.setVehicleId("1234");
car.setModel("BMW");
car.setBaseRentalRate(50);
        System.out.println(car.getVehicleDetails());

        System.out.println(car.toString());

        String[] initialVehicles = {"V001", "V002"};
        String[] initialTransactions = {};
        RentalAgency agency = new RentalAgency(initialVehicles, initialTransactions);

        // Adding a new vehicle
        Vehicle newVehicle = new Car("V003", "Toyota Corolla", 50.0, true);
        agency.addVehicle(newVehicle);

        // Renting a vehicle
        Customer customer = new Customer("C001", "John Doe");
        agency.rentVehicle("V001", customer, 5);

        // Viewing transaction list
        for (String transaction : agency.getTransactionList()) {
            System.out.println(transaction);
        }

        RentalAgency rentalAgency = new RentalAgency();

        rentalAgency.setVehicleList(agency.getVehicleList());
        rentalAgency.setTransactionList(agency.getTransactionList());

        System.out.println(rentalAgency.toString());
        System.out.println("----------------------------------------------------------");
        newVehicle = new Car("V003", "Toyota Corolla", 50.0, true);
        rentalAgency.addVehicle(newVehicle);





    }
}