package com.bizanalytics.dataIngestor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;

@RestController()
@RequestMapping("/api/v1/ingestor/db")
public class DatabaseIngestor {

    @PostMapping("/connect")
    public ResponseEntity<?> connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?useSSL=false", "usr", "pwd");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tbl_patient");
            while(rs.next()) {
                System.out.println(rs.getString("email"));
            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException  | SQLException ex) {
            throw new RuntimeException(ex);
        }

        return ResponseEntity.ok("database connection made");
    }
}
