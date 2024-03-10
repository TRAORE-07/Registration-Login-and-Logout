package com.imdom;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        int contact = Integer.parseInt(request.getParameter("contact"));
        String address = request.getParameter("address");
        // Hash the password
        String hashedPassword = hashPassword(password);

        try {
            // Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/experiment5", "root", "root");
            // Prepare SQL statement
            String sql = "INSERT INTO registration(username, password, email, age, contact, address) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, hashedPassword);
            statement.setString(3, email);
            statement.setInt(4, age);
            statement.setInt(5, contact);
            statement.setString(6, address);

            int i = statement.executeUpdate();
            if (i > 0) {
                response.sendRedirect("login.jsp");
            } else {
                response.getWriter().println("Registration failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database error: " + e.getMessage());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.getWriter().println("Invalid age or contact format.");
        }
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            // Handle the error gracefully, maybe return an error message or throw a custom exception
            return null;
        }
    }
}


//CREATE TABLE registration ( id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(150) UNIQUE, password VARCHAR(255), email VARCHAR(255), age INT, contact INT,address VARCHAR(255));