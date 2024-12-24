import java.util.Objects;

public abstract class Vehicle {
    // Private encapsulated fields
    private String vehicleId;
    private String model;
    private double baseRentalRate;
    private boolean isAvailable;

    // Constructors with validation
    // Getters and setters
    // Abstract methods for rental calculation
    public Vehicle(){}

    public Vehicle(String vehicleId, String model, double baseRentalRate, boolean isAvailable) {
        if (vehicleId == null || model == null) {
            System.out.println("Vehicle id and model are required and cannot be empty");
    }
    this.vehicleId = vehicleId;
    this.model = model;
    this.baseRentalRate = baseRentalRate;
    this.isAvailable = isAvailable;
    }

    public abstract double calculateRentalCost(int days);
    public abstract boolean isAvailableForRental();

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBaseRentalRate(double baseRentalRate) {
        if (baseRentalRate <= 0) {
            System.out.println("Base Rental Rate must be greater than 0");
        }
        this.baseRentalRate = baseRentalRate;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }


    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    protected boolean isAvailable(){
        return isAvailable;
    };
    public String getVehicleDetails() {
        return "VehicleId: " + vehicleId + ", Model: " + model + ", Base Rate: " + baseRentalRate + ", Availability: " + isAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(baseRentalRate, vehicle.baseRentalRate) == 0 && isAvailable == vehicle.isAvailable && Objects.equals(vehicleId, vehicle.vehicleId) && Objects.equals(model, vehicle.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, model, baseRentalRate, isAvailable);
    }
}