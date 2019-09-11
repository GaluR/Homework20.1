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
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();

        String meter = request.getParameter("meter");
        String centymeter = request.getParameter("centymeter");
        String milimeter = request.getParameter("milimeter");

            forDistance(writer, meter, centymeter, milimeter);
    }

    private void forDistance(PrintWriter writer, String meter, String centymeter, String milimeter) {
        PrzelicznikService service = new PrzelicznikService();
        boolean isTwoEmpty1 = !meter.isEmpty() && !milimeter.isEmpty();
        boolean isTwoEmpty2 = !centymeter.isEmpty() && !milimeter.isEmpty();
        boolean isTwoEmpty3 = !centymeter.isEmpty() && !meter.isEmpty();
        if (isTwoEmpty1 || isTwoEmpty2 || isTwoEmpty3) {
            writer.println("Nie można podać 2 lub więcej wartości jednoczenie. Wróć i wprowadż tylko jedną.");
        } else {
            if (!meter.isEmpty()) {
                double m = Double.parseDouble(meter);
                writer.println("Podana wartośc w przeliczeniu to: ");
                writer.println("metry: " + meter + "<br/>");
                writer.println("centymetry: " + service.metersToCenty(m) + "<br/>");
                writer.println("milimetry: " + service.metersToMili(m) + "<br/>");
            }
            if (!centymeter.isEmpty()) {
                double cm = Double.parseDouble(centymeter);
                writer.println("Podana wartośc w przeliczeniu to: ");
                writer.println("metry: " + service.centyToMetes(cm) + "<br/>");
                writer.println("centymetry: " + cm + "<br/>");
                writer.println("milimetry: " + service.centyToMili(cm) + "<br/>");
            }
            if (!milimeter.isEmpty()) {
                double mm = Double.parseDouble(milimeter);
                writer.println("Podana wartośc w przeliczeniu to: ");
                writer.println("metry: " + service.miliToMeters(mm) + "<br/>");
                writer.println("centymetry: " + service.miliToCenty(mm) + "<br/>");
                writer.println("milimetry: " + mm + "<br/>");
            }
        }
    }

}


