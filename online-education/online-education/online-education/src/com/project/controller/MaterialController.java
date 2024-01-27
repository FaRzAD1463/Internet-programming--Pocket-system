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


import com.project.model.Material;


import org.springframework.ui.Model;
@Controller
@RequestMapping("/materials")
public class MaterialController {

    // Display a list of materials for a specific course
	@RequestMapping("/list")
	 public String listMaterials(@RequestParam("courseId") int courseId, Model model) {
	  List<Material> materials = new ArrayList<>();
	  String sql = "SELECT * FROM material WHERE course_id = ?";

	  try (Connection conn = databaseconn.openConnection();
	     PreparedStatement stmt = conn.prepareStatement(sql)) {
	    stmt.setInt(1, courseId);
	    ResultSet rs = stmt.executeQuery();

	    while (rs.next()) {
	      Material material = new Material(
	        rs.getInt("material_id"),
	        rs.getInt("course_id"),
	        rs.getString("title"),
	        rs.getString("content")
	      );
	      materials.add(material);
	    }
	    model.addAttribute("courseId", courseId); // Add courseId to the model
	    model.addAttribute("materials", materials);
	  } catch (SQLException e) {
	    e.printStackTrace();
	    model.addAttribute("errorMessage", "Error retrieving materials: " + e.getMessage());
	  }

	  return "listMaterials"; // JSP page that lists materials for the course
	}
	
	
	
    // Add a new material to a course
	@RequestMapping("/add")
    public String addMaterial(@ModelAttribute("material") Material material, Model model) {
        String sql = "INSERT INTO material (course_id, title, content) VALUES (?, ?, ?)";

        try (Connection conn = databaseconn.openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, material.getCourseId());
            stmt.setString(2, material.getTitle());
            stmt.setString(3, material.getContent());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                model.addAttribute("successMessage", "Material added successfully!");
} else {
model.addAttribute("errorMessage", "Unable to add material.");
}
} catch (SQLException e) {
e.printStackTrace();
model.addAttribute("errorMessage", "Database error while adding material: " + e.getMessage());
}


    return "listMaterials"; // Redirect to the list of materials for the course
}

// Show form for updating a material
	@RequestMapping("/edit/{id}")
public String showEditForm(@PathVariable("id") int id, Model model) {
    String sql = "SELECT * FROM material WHERE material_id = ?";

    try (Connection conn = databaseconn.openConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Material material = new Material(
                rs.getInt("material_id"),
                rs.getInt("course_id"),
                rs.getString("title"),
                rs.getString("content")
            );
            model.addAttribute("material", material);
            return "editMaterial"; // JSP page for editing material
        } else {
            model.addAttribute("errorMessage", "Material not found.");
            return "listMaterials"; // Redirect to the list of materials
        }
    } catch (SQLException e) {
        e.printStackTrace();
        model.addAttribute("errorMessage", "Database error while fetching material: " + e.getMessage());
        return "listMaterials"; // Redirect to the list of materials
    }
}

// Update a material
	@RequestMapping("/update")
public String updateMaterial(@ModelAttribute("material") Material material, Model model) {
    String sql = "UPDATE material SET title = ?, content = ? WHERE material_id = ?";

    try (Connection conn = databaseconn.openConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, material.getTitle());
        stmt.setString(2, material.getContent());
        stmt.setInt(3, material.getId());

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            model.addAttribute("successMessage", "Material updated successfully!");
        } else {
            model.addAttribute("errorMessage", "Unable to update material.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        model.addAttribute("errorMessage", "Database error while updating material: " + e.getMessage());
    }

    return "listMaterials"; // Redirect to the list of materials for the course
}

// Delete a material
	@RequestMapping("/delete/{id}")
public String deleteMaterial(@PathVariable("id") int id, Model model) {
    String sql = "DELETE FROM material WHERE material_id = ?";

    try (Connection conn = databaseconn.openConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            model.addAttribute("successMessage", "Material deleted successfully!");
        } else {
        	model.addAttribute("errorMessage", "Unable to delete material.");
        	}
        	} catch (SQLException e) {
        	e.printStackTrace();
        	model.addAttribute("errorMessage", "Database error while deleting material: " + e.getMessage());
        	}
    return "listMaterials";
	}
	
	@RequestMapping("/show")
	public String showAddMaterialForm(Model model) {
	    model.addAttribute("material", new Material());
	    return "addMaterialForm"; // JSP page with the form to add a new material
	}


	// Method to retrieve all materials for a specific course
	// Assuming you have a method to get course ID
	private List<Material> getMaterialsForCourse(int courseId) {
	    List<Material> materials = new ArrayList<>();
	    String sql = "SELECT * FROM material WHERE course_id = ?";

	    try (Connection conn = databaseconn.openConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, courseId);

	        try (ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                materials.add(new Material(
	                    rs.getInt("material_id"),
	                    rs.getInt("course_id"),
	                    rs.getString("title"),
	                    rs.getString("content")
	                ));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return materials;
	}
	}