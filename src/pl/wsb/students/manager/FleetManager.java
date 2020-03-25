package pl.wsb.students.manager;

import org.apache.commons.lang3.StringUtils;

import pl.wsb.students.exceptions.FleetException;
import pl.wsb.students.model.Car;
import pl.wsb.students.model.Motor;
import pl.wsb.students.model.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;

public class FleetManager implements IFleetManager {

    @Override
    public Vehicle rentVehicle(String loaner) throws FleetException {
        if (this.fleetInPlace.size() <= 0) {
            throw new FleetException("No available vehicles to rent");
        }
        if (StringUtils.isBlank(loaner)) {
            throw new FleetException("Unspecified loaner name - cannot rent a vehicle...");
        }
        Vehicle vehicle = this.fleet.remove(0);
        this.fleetInUse.put(
                vehicle,
                loaner
        );
        return vehicle;
    }

    @Override
    public String recoverVehicle(Vehicle vehicle) throws FleetException {
        if (this.fleetInUse.size() <= 0) {
            throw new FleetException("No rented vehicles found...");
        } //if
        if (vehicle == null) {
            throw new FleetException("Please provide vehicle to recover...");
        } //if
        if (this.fleetInUse.get(vehicle) == null) {
            throw new FleetException("Provided vehicle is not rented...");
        } //if
        String loaner = this.fleetInUse.remove(vehicle);
        this.fleetInPlace.add(vehicle);
        return loaner;
    }


    private ArrayList<Vehicle> fleet = new ArrayList<>();

    private ArrayList<Vehicle> fleetInPlace = new ArrayList<>();

    private HashMap<Vehicle, String> fleetInUse = new HashMap<>();

    private void initFleet() {
        this.fleet.add(new Car("Samochód", "Pierwszy", 99));
        this.fleet.add(new Car("Samochód", "Drugi", 110));
        this.fleet.add(new Motor("Samochód", "Pierwszy", 120));
        this.fleet.addAll(this.fleet);
    }

    public FleetManager() {
        this.initFleet();
    }

}
