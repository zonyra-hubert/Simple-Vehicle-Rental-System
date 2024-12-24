import java.util.Arrays;

public class RentalAgency {
    private String[] vehicleList; // Stores the list of vehicle IDs
    private String[] transactionList; // Stores transaction details

    // Getter for transaction list
    public String[] getTransactionList() {
        return transactionList;
    }

    // Setter for transaction list
    public void setTransactionList(String[] transactionList) {
        this.transactionList = transactionList;
    }

    // Getter for vehicle list
    public String[] getVehicleList() {
        return vehicleList;
    }

    // Setter for vehicle list
    public void setVehicleList(String[] vehicleList) {
        this.vehicleList = vehicleList;
    }

    public RentalAgency() {
    }

    // Constructor to initialize vehicle and transaction lists
    public RentalAgency(String[] vehicleList, String[] transactionList) {
        this.vehicleList = vehicleList;
        this.transactionList = transactionList;
    }

    // Method to add a vehicle to the vehicle list
    public void addVehicle(Vehicle vehicle) {
        // Assuming vehicleList is dynamically expandable for simplicity
        String[] newVehicleList = new String[vehicleList.length + 1];
        System.arraycopy(vehicleList, 0, newVehicleList, 0, vehicleList.length);
        newVehicleList[vehicleList.length] = vehicle.getVehicleId();
        vehicleList = newVehicleList;
        System.out.println("Vehicle added: " + vehicle.getVehicleId());
    }

    // Method to rent a vehicle
    public void rentVehicle(String vehicleId, Customer customer, int days) {
        // Check if vehicle is available
        boolean vehicleFound = false;
        for (String id : vehicleList) {
            if (id.equals(vehicleId)) {
                vehicleFound = true;
                break;
            }
        }

        if (!vehicleFound) {
            System.out.println("Vehicle with ID " + vehicleId + " not found.");
            return;
        }

        // Create a transaction and add it to transaction list
        String transaction = "Customer: " + customer.getCustomerId() + ", Vehicle: " + vehicleId + ", Days: " + days;
        String[] newTransactionList = new String[transactionList.length + 1];
        System.arraycopy(transactionList, 0, newTransactionList, 0, transactionList.length);
        newTransactionList[transactionList.length] = transaction;
        transactionList = newTransactionList;

        System.out.println("Vehicle rented successfully: " + transaction);
    }
    @Override
    public String toString() {
        return "List of vehicles: " + Arrays.toString(vehicleList) + ", List of transactions: " + Arrays.toString(transactionList) ;
    }



}
