package com.nexus.nexus.db;

import java.sql.DriverManager;
import java.sql.*;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:"+ System.getProperty("user.home")+"/nexus.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void createTables() {
        String taskSql = """
            CREATE TABLE IF NOT EXISTS tasks (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                title TEXT NOT NULL,
                subject TEXT,
                notes TEXT,
                estimated_pomodoros INTEGER DEFAULT 0,
                completed_pomodoros INTEGER DEFAULT 0,
                deadline TEXT,
                created_at TEXT,
                priority TEXT,
                status TEXT DEFAULT 'TODO'
            )
            """;

        String subjectSql = """
            CREATE TABLE IF NOT EXISTS subjects (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                color_hex TEXT
            )
            """;


        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(taskSql);
            stmt.execute(subjectSql);
            System.out.println("Database ready!");
        } catch (SQLException e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }
    }
}
