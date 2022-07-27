package com.example.electricalcalc;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pojo.enteredData1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private Button btnClose;
    @FXML
    private Label titleInput;
    @FXML
    TableView<enteredData1> inputTable;
    @FXML
    TableColumn<enteredData1,Integer> objectID;
    @FXML
    TableColumn<enteredData1, String> adress;
    @FXML
    TableColumn<enteredData1, String> typeObject;
    @FXML
    TableColumn<enteredData1, String> enterBox;
    @FXML
    TableColumn<enteredData1, Double> power;
    @FXML
    TableColumn<enteredData1, String> connectionPoint;
    @FXML
    TableColumn <enteredData1, Double>voltage;
    @FXML
    TableColumn <enteredData1, Integer>lineLenght;
    @FXML
    TableColumn<enteredData1, String> condmaterial;
    @FXML
    TableColumn<enteredData1, Double> condCross;
    @FXML
    TableColumn<enteredData1, String> date;
    @FXML
    private Button btnInput;
    @FXML
    private Label welcomeText;
    @FXML
    TextField txtObjectID, txtAdress, txtTypeObject, txtEnterBox, txtPower, txtConnectionPoint, txtVoltage, txtLineLenght, txtCondmaterial, txtCondCross, txtDate;
    private final ObservableList<enteredData1> enteredObservableList = FXCollections.observableArrayList();
    public List<String> enteredData = new ArrayList<>();

    @Override
    public String toString() {
        return "HelloController{" +
                "enteredData=" + enteredData +
                '}';
    }

    @FXML
    private void initialize(){
        initData();
        objectID.setCellValueFactory(new PropertyValueFactory<enteredData1, Integer>("ID"));
        adress.setCellValueFactory(new PropertyValueFactory<enteredData1,String>("Адрес"));
        typeObject.setCellValueFactory(new PropertyValueFactory<enteredData1,String>("Тип объекта"));
        enterBox.setCellValueFactory(new PropertyValueFactory<enteredData1,String >("Название ВРУ"));
        power.setCellValueFactory(new PropertyValueFactory<enteredData1, Double>("МощностЬ"));
        connectionPoint.setCellValueFactory(new PropertyValueFactory<enteredData1,String>("Точка подключения"));
        voltage.setCellValueFactory(new PropertyValueFactory<enteredData1,Double>("Напряжение"));
        lineLenght.setCellValueFactory(new PropertyValueFactory<enteredData1,Integer>("Длина линии"));
        condmaterial.setCellValueFactory(new PropertyValueFactory<enteredData1,String>("Материал проводника"));
        condCross.setCellValueFactory(new PropertyValueFactory<enteredData1,Double>("Сечение проводника"));
        date.setCellValueFactory(new PropertyValueFactory<enteredData1,String>("Дата работ"));

        inputTable.setItems(enteredObservableList);
    }

    private void initData(){
        enteredObservableList.add(new enteredData1(enteredData));
    }
    @FXML
    protected void onBtnInput() {
        enteredData.clear();
        enteredData.add(txtObjectID.getText());
        enteredData.add(txtAdress.getText());
        enteredData.add(txtTypeObject.getText());
        enteredData.add(txtEnterBox.getText());
        enteredData.add(txtPower.getText());
        enteredData.add(txtConnectionPoint.getText());
        enteredData.add(txtVoltage.getText());
        enteredData.add(txtLineLenght.getText());
        enteredData.add(txtCondmaterial.getText());
        enteredData.add(txtCondCross.getText());
        enteredData.add(txtDate.getText());
        System.out.println(enteredData.toString());
        connection();
    }
    @FXML
    private void connection() {

        try (
                Connection conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/energyCounterDB", "postgres", "123")) {

            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
            runInsertEnteredDataToDB(enteredData, conn);
            //runSelect(conn);
        } catch (
                SQLException e) {
            System.err.format("SQL Status: %s\n%s", e.getSQLState(), e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
   private void runInsertEnteredDataToDB(List<String> enter, Connection conn)  throws SQLException{

        String q = "insert into public.i1(id, adress, typeOfobject, nameOfEnterBox, permittedPower, connectionPoint, voltage, lineLength, conductorMaterial, cable_cross_section, date) values ("+enteredData.get(0)+","+enteredData.get(1)+","+enteredData.get(2)+","+enteredData.get(3)+","+enteredData.get(4)+","+enteredData.get(5)+","+enteredData.get(6)+","+enteredData.get(7)+","+enteredData.get(8)+","+enteredData.get(9)+","+enteredData.get(10)+")";
        PreparedStatement statement = conn.prepareStatement(q);
        statement.execute();
    }
    @FXML
    private void handleBtnClose(ActionEvent event){
        Stage s = (Stage) btnClose.getScene().getWindow();
        s.close();

    }
}
