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


import com.project.model.Course;


import org.springframework.ui.Model;
@Controller
@RequestMapping("course")
public class CourseController {
	@RequestMapping("/add")
	
	public String addCourse(@ModelAttribute Course course) {

	    try (Connection conn = databaseconn.openConnection()) {
	        String sql = "INSERT INTO course (course_name, description, teacher_id) VALUES (?, ?, ?)";
	        try (PreparedStatement pst = conn.prepareStatement(sql)) {
	            pst.setString(1, course.getName());
	            pst.setString(2, course.getDescription());
	            pst.setInt(3, course.getTeacherId());  // Assuming you have a getTeacherId() method in your model
	            pst.executeUpdate();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return "Error adding course: " + e.getMessage();
	    }
	    return "courseDashboard";
	}

	
	


	@RequestMapping("/courseDashboard")
	public String adminCourseDashboard(Model model) {
	    List<Course> courseList = new ArrayList<>();
	    try (Connection conn = databaseconn.openConnection()) {
	        String sql = "SELECT course.*, user.username AS teacher_name " +
	                     "FROM course " +
	                     "JOIN user ON course.teacher_id = user.user_id " +
	                     "WHERE user.role_id = 1"; // Assuming role_id = 1 is for teachers

	        try (PreparedStatement pst = conn.prepareStatement(sql)) {
	            ResultSet rs = pst.executeQuery();
	            while (rs.next()) {
	                Course course = new Course(
	                    rs.getInt("course_id"),
	                    rs.getString("course_name"),
	                    rs.getString("description"),
	                    rs.getString("teacher_name") // Get teacher name instead of ID
	                );
	                courseList.add(course);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        model.addAttribute("errorMessage", "Error fetching courses: " + e.getMessage());
	        return "errorPage"; // Error page view name.
	    }
	    model.addAttribute("courses", courseList);
	    return "courseDashboard"; // The JSP file that lists the courses.
	}

	@RequestMapping(value = "/delete/{courseId}", method = RequestMethod.GET)
	public String deleteCourse(@PathVariable("courseId") int courseId, Model model) {
		 List<Course> courseList = new ArrayList<>();
		    
		        String sql = "DELETE FROM course WHERE course_id=?";

	    try (Connection conn = databaseconn.openConnection();
	         PreparedStatement pst = conn.prepareStatement(sql)) {

	        pst.setInt(1, courseId);

	        int rowsAffected = pst.executeUpdate();
	        if (rowsAffected > 0) {
	            model.addAttribute("successMessage", "Course deleted successfully!");
	        } else {
	            model.addAttribute("errorMessage", "No course found with ID: " + courseId);
	        }
	    } catch (SQLException e) {
	        model.addAttribute("errorMessage", "Error occurred: " + e.getMessage());
	    }

	    model.addAttribute("courses", courseList);
	    return "courseDashboard"; 
	}

	
	// Update the course and return the updated list of courses
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCourse(@ModelAttribute("course") Course course, Model model) {
		List<Course> courseList = new ArrayList<>();
	    String sql = "UPDATE course SET course_name = ?, description = ?, teacher_id = ? WHERE course_id = ?";

	    try (Connection conn = databaseconn.openConnection();
	         PreparedStatement pst = conn.prepareStatement(sql)) {

	        pst.setString(1, course.getName());
	        pst.setString(2, course.getDescription());
	        pst.setString(3, course.getTeacherName());
	        pst.setInt(4, course.getId());

	        int rowsAffected = pst.executeUpdate();
	        if (rowsAffected > 0) {
	            model.addAttribute("successMessage", "Course updated successfully!");
	        } else {
	            model.addAttribute("errorMessage", "No course found with ID: " + course.getId());
	        }
	    } catch (SQLException e) {
	        model.addAttribute("errorMessage", "Error occurred: " + e.getMessage());
	    }

	    // Update model with a list of courses to be displayed
	    model.addAttribute("courses", courseList);
	    return "courseDashboard"; // Return the view that displays the list of courses
	}
	
	
	@RequestMapping(value = "/edit/{courseId}", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("courseId") int courseId, Model model) {
	   String sql = "SELECT course.*, user.username AS teacher_name FROM course JOIN user ON course.teacher_id = user.user_id WHERE course.course_id = ?";

	    try (Connection conn = databaseconn.openConnection();
	         PreparedStatement pst = conn.prepareStatement(sql)) {

	        pst.setInt(1, courseId);
	        ResultSet rs = pst.executeQuery();

	        if (rs.next()) {
	            Course course = new Course(
	                rs.getInt("course_id"),
	                rs.getString("course_name"),
	                rs.getString("description"),
	                rs.getString("teacher_name") // Assuming you have a teacher_name column
	            );
	            model.addAttribute("course", course);
	        } else {
	            model.addAttribute("errorMessage", "Course not found with ID: " + courseId);
	            return "redirect:/courseDashboard"; // Redirect if no course is found
	        }
	    } catch (SQLException e) {
	        model.addAttribute("errorMessage", "Error occurred: " + e.getMessage());
	        return "redirect:/courseDashboard"; // Redirect on error
	    }

	    return "updateCourseForm"; // JSP page for the update form
	}


	
	@RequestMapping("/courses")
    public String listCourses(Model model) {
        List<Course> courses = getAllCourses();
        model.addAttribute("courses", courses);
        return "courses"; // JSP that lists courses
    }
	
	
	private List<Course> getAllCourses() {
	    List<Course> courses = new ArrayList<>();
	    String sql = "SELECT * FROM course"; // Assuming your table is named 'courses'

	    try (Connection conn = databaseconn.openConnection();
	         PreparedStatement pst = conn.prepareStatement(sql);
	         ResultSet rs = pst.executeQuery()) {

	        while (rs.next()) {
	            Course course = new Course();
	            course.setId(rs.getInt("course_id"));
	            course.setName(rs.getString("course_name"));
	            course.setDescription(rs.getString("description"));
	            course.setTeacherName(rs.getString("teacherName"));
	            courses.add(course);
	        }
	    } catch (SQLException e) {
	        // Log and handle exception
	        e.printStackTrace();
	    }

	    return courses;
	}

	
	@RequestMapping(value="/teacherdashboard", method = RequestMethod.GET)
	public String teacherDashboard(HttpSession session, Model model) {
	    Integer teacherId = (Integer) session.getAttribute("teacherId");

	    if (teacherId == null) {
	        return "redirect:/users/login";
	    }

	    List<Course> assignedCourses = getAssignedCourses(teacherId);
	    model.addAttribute("courses", assignedCourses);

	    String teacherName = (String) session.getAttribute("userName");
		model.addAttribute("teacherName", teacherName);
	    return "teacherCourse";
	}

	private List<Course> getAssignedCourses(int teacherId) {
	    List<Course> courses = new ArrayList<>();
	    String sql = "SELECT course.*, user.username AS teacher_name " +
	            "FROM course " +
	            "JOIN user ON course.teacher_id = user.user_id " +
	            "WHERE course.teacher_id = ? AND user.role_id = 1";

	    try (Connection conn = databaseconn.openConnection();
	         PreparedStatement pst = conn.prepareStatement(sql)) {
	        pst.setInt(1, teacherId);
	        ResultSet rs = pst.executeQuery();

	        while (rs.next()) {
	        	Course course = new Course(
	        			rs.getInt("course_id"),
	                    rs.getString("course_name"),
	                    rs.getString("description"),
	                    rs.getString("teacher_name") // Get teacher name instead of ID
	                );
	            courses.add(course);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Proper error handling should be implemented
	    }
	    return courses;
	}

	
	@RequestMapping(value = "/student/courses", method = RequestMethod.GET)
			public String showStudentCourses(HttpSession session, Model model) {
			Integer studentId = (Integer) session.getAttribute("studentId");

			
			// Check if the studentId was properly set in the session
			if (studentId == null) {
			    // If not, redirect to the login page
			    return "redirect:/login";
			}

			// Fetch the enrolled courses from the database
			List<Course> enrolledCourses = getEnrolledCoursesForStudent(studentId);
			model.addAttribute("courses", enrolledCourses);

			// Add additional attributes as needed
			String studentName = (String) session.getAttribute("userName");
			model.addAttribute("studentName", studentName);

			// Return the student dashboard view
			return "studentDashboard";
			}

			private List<Course> getEnrolledCoursesForStudent(int studentId) {
			List<Course> courses = new ArrayList<>();
			// Assuming you have a method to open a connection to the database
			try (Connection conn = databaseconn.openConnection()) {
			// Your SQL query to fetch courses
			String sql = "SELECT c.course_id, c.course_name, c.description " +
			"FROM course c JOIN enrollment e ON c.course_id = e.course_id " +
			"WHERE e.student_id = ?";
			try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, studentId);
			try (ResultSet rs = pst.executeQuery()) {
			while (rs.next()) {
			// Create course object and add it to the list
			Course course = new Course(
			rs.getInt("course_id"),
			rs.getString("course_name"),
			rs.getString("description"),
			// You'll need to add logic to get the teacher's name if required
			"");
			courses.add(course);
			}
			}
			}
			} catch (SQLException e) {
			e.printStackTrace();
			// Handle the error appropriately
			}
			return courses;
			}


}
