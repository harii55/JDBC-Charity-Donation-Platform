package main.java.com.charityapp;

import main.java.com.charityapp.db.dbUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        try (Connection conn = dbUtil.getConnection()) {
            System.out.println("DB Connected Successfully!");
            runSqlScript(conn, "src/main/resources/schema.sql");
            System.out.println("Database schema created successfully!");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void runSqlScript(Connection conn, String filePath) throws IOException, SQLException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sql = new StringBuilder();
            String line;

            try (Statement stmt = conn.createStatement()) {
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty() || line.startsWith("--")) continue; // skip empty lines and comments
                    sql.append(line);
                    if (line.endsWith(";")) {
                        stmt.execute(sql.toString());
                        sql.setLength(0); // clear the buffer
                    }
                }
            }
        }
    }
}