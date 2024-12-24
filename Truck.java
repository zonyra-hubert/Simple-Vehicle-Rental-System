public class Truck extends Vehicle implements Rentable {
private int payLoadCapacity;
private double overloadRate;
private double actualLoad;
private Customer currentCustomer;

    public double getActualLoad() {
        return actualLoad;
    }

    public void setActualLoad(double actualLoad) {
        this.actualLoad = actualLoad;
    }

    public Truck(){}
    public Truck(String vehicleId, String model, double baseRentalRate, boolean isAvailable, int payLoadCapacity) {
    super(vehicleId, model, baseRentalRate=300, isAvailable);
    this.payLoadCapacity = payLoadCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return 0;
    }

    public double getOverloadRate() {
        return overloadRate;
    }


    public void setOverloadRate(double overloadRate) {
        this.overloadRate = overloadRate;
    }

    @Override
    public boolean isAvailableForRental() {
        return false;
    } double maxLoadCapacity = 0;

    @Override
    public String toString() {
        return "Motorcycle{" + "vehicleId='" + getVehicleId() + '\'' + ", model='" + getModel() + '\'' +
                ", baseRentalRate=" + getBaseRentalRate() + ", hasGPS=" + payLoadCapacity + '}';
    }

    public double calculateOverloadPenalty(double actualLoad) {
        double maxLoadCapacity = 1000;//in tons
        if (actualLoad > maxLoadCapacity) {
            return (actualLoad - maxLoadCapacity) * overloadRate;
        }
        return 0;
    }

    @Override
    public void rent(Customer customer, int days) {
    if(isAvailable()){
        System.out.println("Truck is available");
        this.currentCustomer = customer;
        setAvailable(false);
        System.out.println("Truck rented to " + customer.getName() + " for " + days + " days.");

    }else {
        System.out.println("Truck is not available. Try another truck");
    }


    }

    @Override
    public void returnVehicle() {
        this.currentCustomer = null;
        setAvailable(true);
        System.out.println("Truck returned. Thanks for doing business with us, we wish to see you another time");
    }
}
