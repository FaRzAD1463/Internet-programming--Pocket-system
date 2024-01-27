package com.project.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.project.util.databaseconn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import com.project.model.User;


import org.springframework.ui.Model;

@Controller
@RequestMapping("users")
public class UserController {

    @RequestMapping("getall")
    @ResponseBody
    public String getAllUsers() {
        try (Connection conn = databaseconn.openConnection()) {
            String sql = "SELECT * FROM user";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    // Logic to process each user
                    System.out.println("User: " + rs.getString("username"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error fetching users";
        }
        return "Fetched all users";
    }

    @RequestMapping("add")
    
    public String addUser(@RequestParam Map<String, String> req) {
        String username = req.get("username");
        String password = req.get("password");
        String email = req.get("email");
        int roleId = Integer.parseInt(req.get("role_id"));

        try (Connection conn = databaseconn.openConnection()) {
            String sql = "INSERT INTO user (username, passward, email, role_id) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, username);
                pst.setString(2, password);
                pst.setString(3, email);
                pst.setInt(4, roleId);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error adding user: " + e.getMessage();
        }
        return "usersList";
    }


    
    
    @RequestMapping("/dashboard")
    public String adminDashboard(Model model) {
        List<User> userList = new ArrayList<>();
        try (Connection conn = databaseconn.openConnection()) {
            String sql = "SELECT * FROM user";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    User user = new User(rs.getInt("user_id"), rs.getString("username"),rs.getString("passward"), rs.getString("email"), rs.getInt("role_id"));
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception properly
        }
        model.addAttribute("users", userList);
        return "usersList";
    }

    // Additional methods for updating and deleting users
    
    

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteUser(@PathVariable("id") int userId) {
        try (Connection conn = databaseconn.openConnection()) {
            String sql = "DELETE FROM user WHERE user_id = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, userId);
                int deletedRows = pst.executeUpdate();
                if (deletedRows > 0) {
                    return "User deleted successfully";
                } else {
                    return "User not found";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error deleting user: " + e.getMessage();
        }
}
    
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") int userId, Model model) {
        try (Connection conn = databaseconn.openConnection()) {
            String sql = "SELECT * FROM user WHERE user_id = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, userId);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    User user = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("passward"), rs.getString("email"), rs.getInt("role_id"));
                    model.addAttribute("user", user);
                    return "updateUserForm"; // JSP file for updating user
                } else {
                    // User not found logic here
                    return "userNotFound"; // JSP file or a redirect if user not found
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Error handling logic here
        }
        return "errorPage"; // General error page or redirect
    }

    
    @RequestMapping("/updating")
    public String updateUser(@ModelAttribute("user") User user, Model model) {
        String sql = "UPDATE user SET username = ?, passward = ?, email = ?, role_id = ? WHERE user_id = ?";

        try (Connection conn = databaseconn.openConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

        	pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());  
            pst.setString(3, user.getEmail());
            pst.setInt(4, user.getRoleId());
            pst.setInt(5, user.getId());

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                model.addAttribute("successMessage", "User updated successfully!");
            } else {
                model.addAttribute("errorMessage", "No user found with ID " + user.getId());
            }
        } catch (SQLException e) {
            // Log the exception and handle it
            model.addAttribute("errorMessage", "Error occurred: " + e.getMessage());
        }

        // Fetch the updated list of users to display
        return "usersList";
    }
    
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model model) {
        String sql = "SELECT * FROM user WHERE username = ? AND passward = ?";  // Fixed typo here
        try (Connection conn = databaseconn.openConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("user_id");
                String retrievedUsername = rs.getString("username");
                int roleId = rs.getInt("role_id");

                // Set user-specific attributes into the session
                session.setAttribute("userId", userId);
                session.setAttribute("userName", retrievedUsername);
                session.setAttribute("role", roleId);
                
                if (roleId == 1) {
                	 session.setAttribute("teacherId", userId);
                	 session.setAttribute("teacherName", retrievedUsername);
                     // Redirect to the teacher dashboard
                     return "redirect:/course/teacherdashboard";// Assuming 1 is for teachers
                    
                } else if (roleId == 2) { // Assuming 2 is for students
                    // For students, directly set the userId as studentId in the session
                    session.setAttribute("studentId", userId);
                    // Redirect to a method that fetches and displays courses
                    return "redirect:/course/student/courses";  // This should be the path to your method that handles course display
                } else if (roleId == 3) { // Assuming 3 is for admins
                    return "adminDashboard";
                } else {
                    return "redirect:/error";
                }
            } else {
                model.addAttribute("errorMessage", "Invalid username or password");
                return "login";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Error occurred: " + e.getMessage());
            return "login";
        }
    }


}

