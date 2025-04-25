// Plasma Donor Application - Single File Full Stack Java (Using JSP/Servlet)

// This single Java file combines both backend logic (Servlet) and frontend (JSP-like HTML rendering).

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/plasma")
public class PlasmaDonorApp extends HttpServlet {

    static class Donor {
        Long id;
        String name;
        String bloodGroup;
        String contact;
        boolean isEligible;

        Donor(Long id, String name, String bloodGroup, String contact, boolean isEligible) {
            this.id = id;
            this.name = name;
            this.bloodGroup = bloodGroup;
            this.contact = contact;
            this.isEligible = isEligible;
        }
    }

    static class Recipient {
        String name;
        String requiredBloodGroup;
        String contact;

        Recipient(String name, String requiredBloodGroup, String contact) {
            this.name = name;
            this.requiredBloodGroup = requiredBloodGroup;
            this.contact = contact;
        }
    }

    // Simulate database
    private static final List<Donor> donors = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        donors.add(new Donor(1L, "John Doe", "A+", "1234567890", true));
        donors.add(new Donor(2L, "Jane Smith", "B+", "0987654321", true));
        donors.add(new Donor(3L, "Raj Patel", "A+", "1122334455", false));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Plasma Donor Match</title></head><body>");
        out.println("<h1>Find Plasma Donors</h1>");
        out.println("<form method='POST' action='/plasma'>");
        out.println("Required Blood Group: <input type='text' name='bloodGroup'/><br/>");
        out.println("<input type='submit' value='Find Donors'/>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bloodGroup = request.getParameter("bloodGroup");

        List<Donor> matched = new ArrayList<>();
        for (Donor d : donors) {
            if (d.bloodGroup.equalsIgnoreCase(bloodGroup) && d.isEligible) {
                matched.add(d);
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Matches</title></head><body>");
        out.println("<h2>Matching Donors:</h2>");
        if (matched.isEmpty()) {
            out.println("<p>No eligible donors found.</p>");
        } else {
            out.println("<ul>");
            for (Donor donor : matched) {
                out.println("<li>" + donor.name + " - " + donor.contact + "</li>");
            }
            out.println("</ul>");
        }
        out.println("<a href='/plasma'>Search Again</a>");
        out.println("</body></html>");
    }
}
