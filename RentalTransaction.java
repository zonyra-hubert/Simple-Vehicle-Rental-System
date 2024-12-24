import java.util.Objects;

public class RentalTransaction {
    private String transactionId; // Unique transaction identifier
    private String vehicleId; // ID of the vehicle rented
    private String customerId; // ID of the customer renting the vehicle
    private int rentalDays; // Duration of the rental in days
    private double rentalCost; // Total cost of the rental
    private String status; // Status of the transaction (e.g., "Active", "Completed")

    private static final int MAX_TRANSACTIONS = 100; // Maximum number of transactions
    private static RentalTransaction[] transactions = new RentalTransaction[MAX_TRANSACTIONS];
    private static int transactionCount = 0; // Current count of transactions

    // Constructor
    public RentalTransaction(String transactionId, String vehicleId, String customerId, int rentalDays, double rentalCost, String status) {
        if (transactionId == null || vehicleId == null || customerId == null || rentalDays <= 0 || rentalCost < 0) {
            throw new IllegalArgumentException("Invalid transaction details provided.");
        }
        this.transactionId = transactionId;
        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.rentalDays = rentalDays;
        this.rentalCost = rentalCost;
        this.status = status;
    }

    // Getters and setters
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        if (rentalDays <= 0) {
            throw new IllegalArgumentException("Rental days must be positive.");
        }
        this.rentalDays = rentalDays;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        if (rentalCost < 0) {
            throw new IllegalArgumentException("Rental cost must be non-negative.");
        }
        this.rentalCost = rentalCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status == null || (!status.equals("Active") && !status.equals("Completed"))) {
            throw new IllegalArgumentException("Invalid status. Use 'Active' or 'Completed'.");
        }
        this.status = status;
    }

    // Static methods to manage transactions
    public static void addTransaction(RentalTransaction transaction) {
        if (transactionCount >= MAX_TRANSACTIONS) {
            System.out.println("Cannot add transaction. Maximum limit reached.");
            return;
        }
        transactions[transactionCount++] = transaction;
        System.out.println("Transaction added successfully: " + transaction.getTransactionId());
    }

    public static void listAllTransactions() {
        System.out.println("Listing all transactions:");
        for (int i = 0; i < transactionCount; i++) {
            System.out.println(transactions[i]);
        }
    }

    public static RentalTransaction findTransactionById(String transactionId) {
        for (int i = 0; i < transactionCount; i++) {
            if (transactions[i].getTransactionId().equals(transactionId)) {
                return transactions[i];
            }
        }
        System.out.println("Transaction not found: " + transactionId);
        return null;
    }

    // toString for display
    @Override
    public String toString() {
        return "RentalTransaction{" +
                "transactionId='" + transactionId + '\'' +
                ", vehicleId='" + vehicleId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", rentalDays=" + rentalDays +
                ", rentalCost=" + rentalCost +
                ", status='" + status + '\'' +
                '}';
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalTransaction that = (RentalTransaction) o;
        return Objects.equals(transactionId, that.transactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId);
    }
}
