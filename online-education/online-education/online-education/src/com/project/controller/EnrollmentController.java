package com.project.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import com.project.util.databaseconn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import com.project.model.Enrollment;


import org.springframework.ui.Model;



@Controller
@RequestMapping("/enrollments")
public class EnrollmentController {

    @RequestMapping("/dashboard")
    public String enrollmentDashboard(Model model) {
        List<Enrollment> enrollments = new ArrayList<>();
        String sql = "SELECT e.enrollment_id, s.username AS student_name, c.course_name " +
                     "FROM enrollment e " +
                     "JOIN user s ON e.student_id = s.user_id " +
                     "JOIN course c ON e.course_id = c.course_id " +
                     "WHERE s.role_id = 2"; // Assuming role_id = 2 is for students

        try (Connection conn = databaseconn.openConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
             
            while (rs.next()) {
                enrollments.add(new Enrollment(
                    rs.getInt("enrollment_id"),
                    rs.getString("student_name"),
                    rs.getString("course_name")
                ));
            }
            model.addAttribute("enrollments", enrollments);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
            model.addAttribute("errorMessage", "Error retrieving enrollments: " + e.getMessage());
            return "errorPage"; // JSP page to show error
        }
        return "enrollmentDashboard"; // JSP page that lists enrollments
    }

    @RequestMapping("/add")
    public String addEnrollment(@RequestParam("studentId") int studentId,
                                @RequestParam("courseId") int courseId,
                                Model model) {
        String sql = "INSERT INTO enrollment (student_id, course_id) VALUES (?, ?)";
        try (Connection conn = databaseconn.openConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
             
            pst.setInt(1, studentId);
            pst.setInt(2, courseId);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                model.addAttribute("successMessage", "Enrollment added successfully!");
            } else {
                model.addAttribute("errorMessage", "Failed to add enrollment.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
            model.addAttribute("errorMessage", "Error adding enrollment: " + e.getMessage());
        }
        return "redirect:/enrollments/dashboard"; // Redirect back to enrollment list page
    }

    @RequestMapping("/delete/{id}")
    public String deleteEnrollment(@PathVariable("id") int enrollmentId, Model model) {
        String sql = "DELETE FROM enrollment WHERE enrollment_id = ?";
        try (Connection conn = databaseconn.openConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
             
            pst.setInt(1, enrollmentId);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                model.addAttribute("successMessage", "Enrollment deleted successfully!");
            } else {
                model.addAttribute("errorMessage", "Failed to delete enrollment.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
            model.addAttribute("errorMessage", "Error deleting enrollment: " + e.getMessage());
        }
        return "redirect:/enrollments/dashboard"; // Redirect back to enrollment list page
    }
}

