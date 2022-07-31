package com.example.electricalcalc;

import com.example.electricalcalc.pojo.enteredData1;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataAccessor {

    private static DataAccessor da = new DataAccessor("jdbc:postgresql://localhost:5432/energyCounterDB","postgres", "123");
    private Connection connection;
    public static DataAccessor getDataAccessor(){
        return da;
    }
    private DataAccessor(String dbUrl, String usr, String pass){
        try {
            connection = DriverManager.getConnection(dbUrl,usr, pass);
        }catch (SQLException e){}

    }
    public List<enteredData1> getEteredDataList() throws SQLException {
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select* from i1");
        List<enteredData1> inputList1 = new ArrayList<>();
        String nameOfEnterBox = null;
        while (rs.next()) {
            Integer id = rs.getInt("id");
            String adress = rs.getString("adress");
            String typeOfobject = rs.getString("typeOfobject");
            nameOfEnterBox = rs.getString("nameOfEnterBox");
            Double permittedPower = rs.getDouble("permittedPower");
            String connectionPoint = rs.getString("connectionPoint");
            Integer voltage = rs.getInt("voltage");
            Integer lineLength = rs.getInt("lineLength");
            String conductorMaterial = rs.getString("conductorMaterial");
            Integer cable_cross_section = rs.getInt("cable_cross_section");
            Date date = rs.getDate("date");
            enteredData1 ed1 = new enteredData1(id, adress, typeOfobject, nameOfEnterBox, permittedPower, connectionPoint, voltage, lineLength, conductorMaterial, cable_cross_section, String.valueOf(date));
            inputList1.add(ed1);
        }
        return inputList1;
    }
}

