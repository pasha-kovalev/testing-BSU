package com.epam.aircompany.model.airport;

import com.epam.aircompany.model.plane.*;

import java.util.*;
import java.util.stream.Collectors;

public class Airport {
    private final List<Plane> planes;

    public Airport(List<Plane> planes) {
        this.planes = planes;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public List<PassengerPlane> takePassengerPlanes() {
        return planes.stream()
                .filter(plane -> plane instanceof PassengerPlane)
                .map(plane -> (PassengerPlane) plane)
                .collect(Collectors.toList());
    }

    public PassengerPlane takePassengerPlaneWithMaxPassengersCapacity() {
        return Collections.max(takePassengerPlanes(), Comparator.comparing(PassengerPlane::getPassengersCapacity));
    }

    public List<MilitaryPlane> takeMilitaryPlanes() {
        return planes.stream()
                .filter(plane -> plane instanceof MilitaryPlane)
                .map(plane -> (MilitaryPlane) plane)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> takeMilitaryPlanesByCertainType(MilitaryType militaryType) {
        return takeMilitaryPlanes().stream()
                .filter(plane -> plane.getType().equals(militaryType))
                .collect(Collectors.toList());
    }


    public List<ExperimentalPlane> takeExperimentalPlanes() {
        return planes.stream()
                .filter(plane -> plane instanceof ExperimentalPlane)
                .map(plane -> (ExperimentalPlane) plane)
                .collect(Collectors.toList());
    }

    public List<ExperimentalPlane> takeExperimentalPlanesByCertainType(ExperimentalType experimentalType) {
        return takeExperimentalPlanes().stream()
                .filter(plane -> plane.getType().equals(experimentalType))
                .collect(Collectors.toList());
    }

    public List<ExperimentalPlane> takeExperimentalPlanesByCertainClassificationLevel(ClassificationLevel classificationLevel) {
        return takeExperimentalPlanes().stream()
                .filter(plane -> plane.getClassificationLevel().equals(classificationLevel))
                .collect(Collectors.toList());
    }

    public List<ExperimentalPlane> takeExperimentalPlanesByCertainTypeAndClassificationLevel(
            ExperimentalType experimentalType, ClassificationLevel classificationLevel) {
        return takeExperimentalPlanes().stream()
                .filter(plane -> plane.getClassificationLevel().equals(classificationLevel))
                .filter(plane -> plane.getType().equals(experimentalType))
                .collect(Collectors.toList());
    }

    public void sortPlanesByMaxFlightDistance() {
        planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
    }

    public void sortPlanesByMaxSpeed() {
        planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
    }

    public void sortPlanesByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
    }


}
