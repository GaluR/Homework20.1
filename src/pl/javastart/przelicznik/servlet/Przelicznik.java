package pl.javastart.przelicznik.servlet;

import pl.javastart.service.PrzelicznikService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/przelicznik")
public class Przelicznik extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrzelicznikService service = new PrzelicznikService();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();

        Double meter = Double.parseDouble(request.getParameter("meter"));
        Double centymeter = Double.parseDouble(request.getParameter("centymeter"));
        Double milimeter = Double.parseDouble(request.getParameter("milimeter"));

        if (!(meter.equals(0))&&centymeter.equals(0)&&milimeter.equals(0)) {
            writer.println("Podana wartośc w przeliczeniu to: ");
            writer.println("metry: " + meter + "<br/>");
            writer.println("centymetry: " + service.metersToCenty(meter) + "<br/>");
            writer.println("milimetry: " + service.metersToMili(meter) + "<br/>");
        }
        if (centymeter.equals(0)) {
            writer.println("centymetry" + service.metersToCenty(centymeter));
            writer.println("milimetry" + service.metersToMili(centymeter));
        }
        if (milimeter.equals(0)) {
            writer.println("centymetry" + service.metersToCenty(milimeter));
            writer.println("milimetry" + service.metersToMili(milimeter));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
