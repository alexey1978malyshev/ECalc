package com.example.electricalcalc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HelloController {

   @FXML
   private AnchorPane enter1;
    @FXML
    private Button btnClose;
    @FXML
    private Label titleInput;
    @FXML
    TableView<enteredData2>enter2Table;
    @FXML
    TableColumn<enteredData2, Integer> id_object;
    @FXML
    TableColumn<enteredData2, String> connectionPoint;
    @FXML
    TableColumn<enteredData2, String> consumer;
    @FXML
    TableColumn<enteredData2, Double> powerOfConsumer;
    @FXML
    TableColumn <enteredData2, Integer>voltage;
    @FXML
    TableColumn <enteredData2, Integer> lineLength;
    @FXML
    TableColumn<enteredData2, String> conductorMaterial;
    @FXML
    TableColumn<enteredData2, Double> cable_cross_section;
    @FXML
    private Button btnInput, btnActivateEnter1;
    @FXML
    private Label welcomeText;
    @FXML
    TextField txtObjectID, txtAdress, txtTypeObject, txtEnterBox, txtPower, txtConnectionPoint, txtVoltage, txtLineLenght, txtCondmaterial, txtCondCross, txtDate;

    private ObservableList<enteredData2> consumerList = FXCollections.observableArrayList();


    public List<String> mainData = new ArrayList<>();


    @FXML
    private void initialize(){
        initData();
        id_object.setCellValueFactory(new PropertyValueFactory<enteredData2, Integer>("id_object"));
        connectionPoint.setCellValueFactory(new PropertyValueFactory<enteredData2,String>("connectionPoint"));
        consumer.setCellValueFactory(new PropertyValueFactory<enteredData2,String >("consumer"));
      /* powerOfConsumer.setCellValueFactory(new PropertyValueFactory<enteredData2, Double>("Мощность(кВт)"));
        voltage.setCellValueFactory(new PropertyValueFactory<enteredData2,Integer>("Напряжение(В)"));
        lineLength.setCellValueFactory(new PropertyValueFactory<enteredData2,Integer>("Длина линии(м)"));
        conductorMaterial.setCellValueFactory(new PropertyValueFactory<enteredData2,String>("Материал проводника"));
        cable_cross_section.setCellValueFactory(new PropertyValueFactory<enteredData2,Double>("Сечение(мм2)"));*/


        enter2Table.setItems(consumerList);
        enter2Table.setEditable(true);


    }

    private void initData(){
        consumerList.add(new enteredData2());
        consumerList.get(0).setId_object(99);
        consumerList.get(0).setConnectionPoint("ГРЩ");
        consumerList.get(0).setConsumer("Tesla");
    }
    @FXML
    protected void onBtnInput() {
        mainData.clear();
        mainData.add(txtAdress.getText());
        mainData.add(txtTypeObject.getText());
        mainData.add(txtEnterBox.getText());
        mainData.add(txtPower.getText());
        mainData.add(txtConnectionPoint.getText());
        mainData.add(txtVoltage.getText());
        mainData.add(txtLineLenght.getText());
        mainData.add(txtCondmaterial.getText());
        mainData.add(txtCondCross.getText());
        mainData.add(txtDate.getText());
        System.out.println("EnteredData: "  + mainData.toString());

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
            runInsertEnteredDataToDB(mainData, conn);
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

        for (int i=0;i<enter.lastIndexOf(enter); i++){ // попытка обрботать пустые строки
            if(mainData.get(i) == "")
                mainData.set(i,"'нет данных'"); //строка не инсертится
        }
        String q = "insert into public.i1(adress, \"typeOfobject\", \"nameOfEnterBox\", \"permittedPower\", \"connectionPoint\", voltage, \"lineLength\", \"conductorMaterial\", cable_cross_section, date) values ('" + mainData.get(0) + "','" + mainData.get(1) + "','" + mainData.get(2) + "','" + mainData.get(3) + "','" + mainData.get(4) + "'," + mainData.get(5) + ",'" + mainData.get(6) + "','" + mainData.get(7) + "'," + mainData.get(8) + ",'" + mainData.get(9) + "')";
        PreparedStatement statement = conn.prepareStatement(q);
        statement.execute();
        txtObjectID.setId("select id from public.i1");  // попытка получить id объекта из базы
        enter1.setDisable(true);                        //поля ввода данных становятся неактивными
        conn.close();

    }
    @FXML
    private void handleBtnClose(ActionEvent event){     //нажатие кнопки  'закрыть'
        Stage s = (Stage) btnClose.getScene().getWindow();
        s.close();

    }
    @FXML
    private void handleBtnActivateEnter1(ActionEvent event){   //активация полей ввода и их очистка
        enter1.setDisable(false);
        for (Node child : enter1.getChildren()) {
            txtObjectID.clear();
            txtAdress.clear();
            txtEnterBox.clear();
            txtTypeObject.clear();
            txtPower.clear();
            txtDate.clear();
            txtCondCross.clear();
            txtLineLenght.clear();
            txtVoltage.clear();
            txtConnectionPoint.clear();
        }

    }
}
