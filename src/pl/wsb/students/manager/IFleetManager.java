package pl.wsb.students.manager;

import pl.wsb.students.exceptions.FleetException;
import pl.wsb.students.model.Vehicle;

public interface IFleetManager {
    Vehicle rentVehicle(String loaner) throws FleetException;

    String recoverVehicle(Vehicle vehicle) throws FleetException;

}
