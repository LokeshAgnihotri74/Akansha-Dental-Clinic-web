package backend.src.main.java;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bookAppointment")
public class AppointmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String name = request.getParameter("patient_name");
        String email = request.getParameter("email");
        String date = request.getParameter("appointment_date");
        String time = request.getParameter("appointment_time");

        try {
            // DBConnection se connect kar rahe hain
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO appointments (patient_name, email, appointment_date, appointment_time) VALUES (?, ?, ?, ?)";
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, date);
            ps.setString(4, time);

            ps.executeUpdate();
            con.close();

            response.sendRedirect("appointment.html?status=success");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}