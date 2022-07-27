package pojo;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.List;

public class enteredData1 {
    SimpleIntegerProperty objectID = new SimpleIntegerProperty();
    SimpleStringProperty adress = new SimpleStringProperty();
    SimpleStringProperty typeObject = new SimpleStringProperty();
    SimpleStringProperty enterBox = new SimpleStringProperty();
    SimpleDoubleProperty power = new SimpleDoubleProperty();
    SimpleStringProperty connectionPoint = new SimpleStringProperty();
    SimpleDoubleProperty voltage = new SimpleDoubleProperty();
    SimpleIntegerProperty lineLenght = new SimpleIntegerProperty();
    SimpleStringProperty condmaterial = new SimpleStringProperty();
    SimpleDoubleProperty condCross = new SimpleDoubleProperty();
    SimpleStringProperty date =new SimpleStringProperty();

    public enteredData1(int objectID, String adress, String typeObject, String enterBox, double power, String connectionPoint, double voltage, int lineLenght, String condmaterial, double condCross, String date) {
        setObjectID(objectID);
        setAdress(adress);
        setTypeObject(typeObject);
        setEnterBox(enterBox);
        setPower(power);
        setConnectionPoint(connectionPoint);
        setVoltage(voltage);
        setLineLenght(lineLenght);
        setCondmaterial(condmaterial);
        setCondCross(condCross);
        setDate(date);
    }

    public enteredData1(SimpleIntegerProperty objectID, SimpleStringProperty adress, SimpleStringProperty typeObject, SimpleStringProperty enterBox, SimpleDoubleProperty power, SimpleStringProperty connectionPoint, SimpleDoubleProperty voltage, SimpleIntegerProperty lineLenght, SimpleStringProperty condmaterial, SimpleDoubleProperty condCross, SimpleStringProperty date) {
        this.objectID = objectID;
        this.adress = adress;
        this.typeObject = typeObject;
        this.enterBox = enterBox;
        this.power = power;
        this.connectionPoint = connectionPoint;
        this.voltage = voltage;
        this.lineLenght = lineLenght;
        this.condmaterial = condmaterial;
        this.condCross = condCross;
        this.date = date;
    }

    public enteredData1(List enteredData) {

    }

    public int getObjectID() {
        return objectID.get();
    }

    public SimpleIntegerProperty objectIDProperty() {
        return objectID;
    }

    public void setObjectID(int objectID) {
        this.objectID.set(objectID);
    }

    public String getAdress() {
        return adress.get();
    }

    public SimpleStringProperty adressProperty() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress.set(adress);
    }

    public String getTypeObject() {
        return typeObject.get();
    }

    public SimpleStringProperty typeObjectProperty() {
        return typeObject;
    }

    public void setTypeObject(String typeObject) {
        this.typeObject.set(typeObject);
    }

    public String getEnterBox() {
        return enterBox.get();
    }

    public SimpleStringProperty enterBoxProperty() {
        return enterBox;
    }

    public void setEnterBox(String enterBox) {
        this.enterBox.set(enterBox);
    }

    public double getPower() {
        return power.get();
    }

    public SimpleDoubleProperty powerProperty() {
        return power;
    }

    public void setPower(double power) {
        this.power.set(power);
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

    public double getVoltage() {
        return voltage.get();
    }

    public SimpleDoubleProperty voltageProperty() {
        return voltage;
    }

    public void setVoltage(double voltage) {
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

    public String getCondmaterial() {
        return condmaterial.get();
    }

    public SimpleStringProperty condmaterialProperty() {
        return condmaterial;
    }

    public void setCondmaterial(String condmaterial) {
        this.condmaterial.set(condmaterial);
    }

    public double getCondCross() {
        return condCross.get();
    }

    public SimpleDoubleProperty condCrossProperty() {
        return condCross;
    }

    public void setCondCross(double condCross) {
        this.condCross.set(condCross);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    @Override
    public String toString() {
        return "input1{" +
                "ID=" + objectID +
                ", Адрес=" + adress +
                ", Тип_объекта=" + typeObject +
                ", Наименование_вводного_щита=" + enterBox +
                ", Разрешенная_мощность=" + power +
                ", Точка_подключения=" + connectionPoint +
                ", Напряжение(В)=" + voltage +
                ", Длина_линии(М)=" + lineLenght +
                ", Материал_проводника=" + condmaterial +
                ", Сечение_проводника=" + condCross +
                ", Дата_работ=" + date +
                '}';
    }
}
