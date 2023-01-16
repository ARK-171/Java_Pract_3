package com.example.demo.model;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DB {
    public static String db_Path = "C:\\Users\\Alexey\\IdeaProjects\\demo\\Pract_3.db";
    private static String url = "jdbc:sqlite:" + db_Path;
    private static Connection co;
    private String in = "INSERT INTO Offer (id, serialNumber, signDate, endingDate, startDate, client, office, stuff) " +
            "VALUES ";


    public static Connection getConnection() {
        if (co == null){
            try {
                co = DriverManager.getConnection(url);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return co;
    }

    public String Insert(int id, String serialNumber, LocalDate signDate, LocalDate endingDate,
                       LocalDate startDate, int client, int office, int stuff) {
        StringBuilder sb = new StringBuilder("(");
        sb.append(id);
        sb.append(serialNumber);
        sb.append("\""); sb.append(signDate); sb.append("\"");
        sb.append("\""); sb.append(endingDate); sb.append("\"");
        sb.append("\""); sb.append(startDate); sb.append("\"");
        sb.append(client);
        sb.append(office);
        sb.append(stuff);
        sb.append(")");
        String s = sb.toString();
        return s;
    }
}
