import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Customer {
    private String customerId;
    private String name;
    private String dob;
    private int rewardPoints;
    private String[] rentalHistory; // Stores rental transaction details
    private int historyCount;
    private List<String> currentRentals; // Tracks current rental vehicles

    // Constructors
    public Customer() {
        this.rentalHistory = new String[10];
        this.historyCount = 0;
        this.currentRentals = new ArrayList<>();
    }

    public Customer(String customerId, String name, String dob, int rewardPoints, String[] rentalHistory, int historyCount) {
        if (customerId == null || name == null || dob == null || rewardPoints < 0) {
            throw new IllegalArgumentException("CustomerId, name, and dob are required, and reward points must be non-negative.");
        }
        this.customerId = customerId;
        this.name = name;
        this.dob = dob;
        this.rewardPoints = rewardPoints;
        this.rentalHistory = rentalHistory;
        this.historyCount = historyCount;
        this.currentRentals = new ArrayList<>();
    }

    public Customer(String customerId, String name) {
        if (customerId == null || name == null) {
            throw new IllegalArgumentException("CustomerId and name are required");
        }
        this.customerId = customerId;
        this.name = name;
        this.rentalHistory = new String[10];
        this.historyCount = 0;
        this.currentRentals = new ArrayList<>();
    }

    // Getters and setters
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public String[] getRentalHistory() {
        return Arrays.copyOf(rentalHistory, historyCount); // Return only filled history
    }

    public void setRentalHistory(String[] rentalHistory) {
        this.rentalHistory = rentalHistory;
    }

    public int getHistoryCount() {
        return historyCount;
    }

    public void setHistoryCount(int historyCount) {
        this.historyCount = historyCount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return dob;
    }

    public void setAge(String dob) {
        this.dob = dob;
    }

    public void addLoyaltyPoints(int points) {
        if (points > 0) rewardPoints += points;
    }

    // Methods to show rental history
    public void rentalHistory() {
        System.out.println("Rental History for Customer: " + name);
        for (int i = 0; i < historyCount; i++) {
            System.out.println("- " + rentalHistory[i]);
        }
    }

    // Method to track current rentals
    public void currentRentals() {
        System.out.println("Current Rentals for Customer: " + name);
        if (currentRentals.isEmpty()) {
            System.out.println("No current rentals.");
        } else {
            for (String rental : currentRentals) {
                System.out.println("- " + rental);
            }
        }
    }

    // Method to check rental eligibility
    public void eligibility() {
        System.out.println("Checking eligibility for Customer: " + name);
        if (currentRentals.size() >= 3) { // Example rule: Max 3 rentals at a time
            System.out.println("Not eligible for more rentals. Maximum active rentals reached.");
        } else {
            System.out.println("Eligible for rental.");
        }
    }

    // Add rental to history
    public void addRentalToHistory(String rentalDetails) {
        if (historyCount == rentalHistory.length) {
            rentalHistory = Arrays.copyOf(rentalHistory, rentalHistory.length + 10); // Expand history array
        }
        rentalHistory[historyCount++] = rentalDetails;
    }

    // Add a current rental
    public void addCurrentRental(String vehicleId) {
        currentRentals.add(vehicleId);
    }

    // Remove a current rental
    public void removeCurrentRental(String vehicleId) {
        currentRentals.remove(vehicleId);
    }

    // toString method for displaying customer details
    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", rewardPoints=" + rewardPoints +
                ", rentalHistory=" + Arrays.toString(getRentalHistory()) +
                ", currentRentals=" + currentRentals +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }
}
