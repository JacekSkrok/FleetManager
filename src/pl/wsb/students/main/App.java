package pl.wsb.students.main;

import pl.wsb.students.exceptions.FleetException;
import pl.wsb.students.manager.FleetManager;
import pl.wsb.students.manager.IFleetManager;
import pl.wsb.students.model.Vehicle;

public class App {
    public static void main(String[] args) {
        try {
            IFleetManager fleetManager = new FleetManager();
            Vehicle rentedVehicle = fleetManager.rentVehicle("Testowy Test");
            System.out.println(
                    String.format(
                            "Wypożyczony pojazd - marka %s, model %s",
                            rentedVehicle.getBrand(),
                            rentedVehicle.getModel()
                    )
            );
            Vehicle secondRentedVehicle = fleetManager.rentVehicle("Drugi Testowy Test");
            System.out.println(
                    String.format(
                            "Kolejny wypożyczony pojazd - marka %s, model %s",
                            rentedVehicle.getBrand(),
                            rentedVehicle.getModel()
                    )
            );
            System.out.println(
                    String.format(
                            "Pojazd zwrócony przez %s",
                            fleetManager.recoverVehicle(rentedVehicle)
                    )
            );
            System.out.println(
                    String.format(
                            "Pojazd zwrócony przez %s",
                            fleetManager.recoverVehicle(secondRentedVehicle)
                    )
            );
        } catch (FleetException ex) {
            System.err.println("Przykro nam, wystąpił błąd obsługi wypożyczenia lub zwrotu pojazdu...");
        } catch (Exception ex) {
            System.err.println("Przykro nam, wystąpił błąd aplikacji...");
        }
    }

}
