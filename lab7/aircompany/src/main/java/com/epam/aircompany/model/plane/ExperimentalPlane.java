package com.epam.aircompany.model.plane;

public class ExperimentalPlane extends Plane {

    private final ExperimentalType type;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                             ExperimentalType type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel) {
        this.classificationLevel = classificationLevel;
    }

    public ExperimentalType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ExperimentalPlane that = (ExperimentalPlane) o;

        if (type != that.type) return false;
        return classificationLevel == that.classificationLevel;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (classificationLevel != null ? classificationLevel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExperimentalPlane{");
        sb.append("type=").append(type);
        sb.append(", classificationLevel=").append(classificationLevel);
        sb.append(", model='").append(model).append('\'');
        sb.append(", maxSpeed=").append(maxSpeed);
        sb.append(", maxFlightDistance=").append(maxFlightDistance);
        sb.append(", maxLoadCapacity=").append(maxLoadCapacity);
        sb.append('}');
        return sb.toString();
    }
}
