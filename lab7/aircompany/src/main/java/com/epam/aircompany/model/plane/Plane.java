package com.epam.aircompany.model.plane;

import java.util.Objects;

abstract public class Plane {
    protected final String model;
    protected final int maxSpeed;
    protected final int maxFlightDistance;
    protected final int maxLoadCapacity;

    public Plane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public int getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plane plane = (Plane) o;

        if (maxSpeed != plane.maxSpeed) return false;
        if (maxFlightDistance != plane.maxFlightDistance) return false;
        if (maxLoadCapacity != plane.maxLoadCapacity) return false;
        return Objects.equals(model, plane.model);
    }

    @Override
    public int hashCode() {
        int result = model != null ? model.hashCode() : 0;
        result = 31 * result + maxSpeed;
        result = 31 * result + maxFlightDistance;
        result = 31 * result + maxLoadCapacity;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Plane{");
        sb.append("model='").append(model).append('\'');
        sb.append(", maxSpeed=").append(maxSpeed);
        sb.append(", maxFlightDistance=").append(maxFlightDistance);
        sb.append(", maxLoadCapacity=").append(maxLoadCapacity);
        sb.append('}');
        return sb.toString();
    }
}
