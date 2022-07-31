package com.example.electricalcalc;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class enteredData2 {
    public SimpleIntegerProperty id_object = new SimpleIntegerProperty();
    SimpleStringProperty connectionPoint = new SimpleStringProperty();
    SimpleStringProperty consumer = new SimpleStringProperty();//тип нагрузки,категория нагрузки
    SimpleDoubleProperty powerOfConsumer = new SimpleDoubleProperty();
    SimpleIntegerProperty voltage = new SimpleIntegerProperty();
    SimpleIntegerProperty lineLenght = new SimpleIntegerProperty();
    SimpleStringProperty conductorMaterial = new SimpleStringProperty();
    SimpleDoubleProperty cable_cross_section = new SimpleDoubleProperty();


    public enteredData2(SimpleIntegerProperty id_object, SimpleStringProperty connectionPoint, SimpleStringProperty consumer, SimpleDoubleProperty powerOfConsumer, SimpleIntegerProperty voltage, SimpleIntegerProperty lineLenght, SimpleStringProperty conductorMaterial, SimpleDoubleProperty cable_cross_section) {
        this.id_object = id_object;
        this.connectionPoint = connectionPoint;
        this.consumer = consumer;
        this.powerOfConsumer = powerOfConsumer;
        this.voltage = voltage;
        this.lineLenght = lineLenght;
        this.conductorMaterial = conductorMaterial;
        this.cable_cross_section = cable_cross_section;
    }

    public enteredData2() {

    }

    public int getId_object() {
        return id_object.get();
    }

    public SimpleIntegerProperty id_objectProperty() {
        return id_object;
    }

    public void setId_object(int id_object) {
        this.id_object.set(id_object);
    }

    public String getConnectionPoint() {
        return connectionPoint.get();
    }

    public SimpleStringProperty connectionPointProperty() {
        return connectionPoint;
    }

    public void setConnectionPoint(String connectionPoint) {
        this.connectionPoint.set(connectionPoint);
    }

    public String getConsumer() {
        return consumer.get();
    }

    public SimpleStringProperty consumerProperty() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer.set(consumer);
    }



    public double getPowerOfConsumer() {
        return powerOfConsumer.get();
    }

    public SimpleDoubleProperty powerOfConsumerProperty() {
        return powerOfConsumer;
    }

    public void setPowerOfConsumer(double powerOfConsumer) {
        this.powerOfConsumer.set(powerOfConsumer);
    }

    public int getVoltage() {
        return voltage.get();
    }

    public SimpleIntegerProperty voltageProperty() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage.set(voltage);
    }

    public int getLineLenght() {
        return lineLenght.get();
    }

    public SimpleIntegerProperty lineLenghtProperty() {
        return lineLenght;
    }

    public void setLineLenght(int lineLenght) {
        this.lineLenght.set(lineLenght);
    }

    public String getConductorMaterial() {
        return conductorMaterial.get();
    }

    public SimpleStringProperty conductorMaterialProperty() {
        return conductorMaterial;
    }

    public void setConductorMaterial(String conductorMateria) {
        this.conductorMaterial.set(conductorMateria);
    }

    public double getCable_cross_section() {
        return cable_cross_section.get();
    }

    public SimpleDoubleProperty cable_cross_sectionProperty() {
        return cable_cross_section;
    }

    public void setCable_cross_section(double cable_cross_section) {
        this.cable_cross_section.set(cable_cross_section);
    }

    @Override
    public String toString() {
        return "enteredData2{" +
                "id_object=" + id_object +
                ", connectionPoint=" + connectionPoint +
                ", consumer=" + consumer +

                ", power=" + powerOfConsumer +
                ", voltage=" + voltage +
                ", lineLenght=" + lineLenght +
                ", conductorMaterial=" + conductorMaterial +
                ", cable_cross_section=" + cable_cross_section +
                '}';
    }
}
