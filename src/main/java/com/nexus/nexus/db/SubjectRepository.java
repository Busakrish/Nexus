package com.nexus.nexus.db;

import com.nexus.nexus.model.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectRepository {
    public static void add(Subject subject){
        String sql = """
                INSERT INTO subjects (name, color_hex) VALUES (?, ?)
                """;
        try(Connection conn = DatabaseManager.connect();
        PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            pstmt.setString(1, subject.getName());
            pstmt.setString(2, subject.getColorHex());

            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                subject.setId(rs.getLong(1));
            }

            System.out.println("Subject saved: " + subject.getName());

        }catch(SQLException e){
            System.out.println("Error saving task: " + e.getMessage());
        }
    }

    public static List<Subject> getAll(){
        List<Subject> subjects = new ArrayList<>();
        String sql = "SELECT * FROM subjects";

        try(Connection conn = DatabaseManager.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()){
                Subject subject = new Subject(rs.getString("name"),rs.getString("color_hex"));

                subject.setId(rs.getLong("id"));
                subjects.add(subject);
            }


        } catch (SQLException e) {
            System.out.println("Error reading subject:" + e.getMessage());
        }

        return subjects;
    }

    public static void update(Subject subject) {
        String sql = """
            UPDATE subjects SET 
                name = ?, color_hex = ?
            WHERE id = ?
            """;

        try (Connection conn = DatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, subject.getName());
            pstmt.setString(2, subject.getColorHex());

            pstmt.setLong(3, subject.getId());

            int rowsChanged = pstmt.executeUpdate();
            System.out.println("Rows updated: " + rowsChanged);

        } catch (SQLException e) {
            System.out.println("Error updating subject: " + e.getMessage());
        }
    }

    public static void delete(long id) {
        String sql = "DELETE FROM subjects WHERE id = ?";

        try (Connection conn = DatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            int rowsChanged = pstmt.executeUpdate();
            System.out.println("Rows deleted: " + rowsChanged);

        } catch (SQLException e) {
            System.out.println("Error deleting subject: " + e.getMessage());
        }
    }

}
