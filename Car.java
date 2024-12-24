import java.util.Objects;

public class Car extends Vehicle implements Rentable {
    private boolean hasGPS ;
    private Customer currentCustomer;

    public Car(){}
    public Car(String vehicleId, String model, double baseRentalRate, boolean isAvailable, boolean hasGPS) {
        super(vehicleId, model, baseRentalRate =200, isAvailable);
        this.hasGPS = hasGPS;

    }

    public Car(String vehicleId, String model, double baseRentalRate, boolean isAvailable) {
        super(vehicleId, model, baseRentalRate, isAvailable);


    }

    public boolean isHasGPS() {
        return hasGPS;
    }

    public void setHasGPS(boolean hasGPS) {
        this.hasGPS = hasGPS;
    }

    @Override
    public double calculateRentalCost(int days) {
        double cost = getBaseRentalRate() * days;
        if (hasGPS) {
            cost += 10 * days; // GPS surcharge
        }
        return cost;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }
    @Override
    public String toString() {
        return "Car{" + "vehicleId='" + getVehicleId() + '\'' + ", model='" + getModel() + '\'' +
                ", baseRentalRate=" + getBaseRentalRate() + ", hasGPS=" + hasGPS + '}';
    }

    public void enableEcoMode() {
        System.out.println("Eco mode enabled. Enjoy better fuel efficiency!");
    }


    @Override
    public void rent(Customer customer, int days) {
        if (!isAvailable()) {
            System.out.println("Car is full. Car can't rent!");
        }
        this.currentCustomer = customer;
        setAvailable(false);
        System.out.println("Car rented to " + customer.getName() + " for " + days + " days.");

    }

    @Override
    public void returnVehicle() {
        this.currentCustomer = null;
        setAvailable(true);
        System.out.println("Car returned. Thanks for the return!, we wish to see you another time");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return hasGPS == car.hasGPS && Objects.equals(currentCustomer, car.currentCustomer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hasGPS, currentCustomer);
    }
}


