package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class DealershipFileManager {
    public Dealership getDealership() {

        Dealership dealership = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("dealership.csv"));
            String line = reader.readLine();
            String[] dealershipTokens = line.split("\\|");
            String name = dealershipTokens[0];
            String address = dealershipTokens[1];
            String phone = dealershipTokens[2];

            ArrayList<Vehicle> inventory = new ArrayList<Vehicle>();

            dealership = new Dealership(name, address, phone);

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\|");

                int vin = Integer.parseInt(tokens[0]);
                int year = Integer.parseInt(tokens[1]);
                String make = tokens[2];
                String model = tokens[3];
                String vehicleType = tokens[4];
                String color = tokens[5];
                int odometer = Integer.parseInt(tokens[6]);
                double price = Double.parseDouble(tokens[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                inventory.add(vehicle);
            }

        } catch (Exception e) {
            File file = new File("inventory.csv");
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership) {

    }
}
