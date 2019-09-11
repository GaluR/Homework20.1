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
        String kilo = request.getParameter("kilo");
        String grams = request.getParameter("grams");
        String miligrams = request.getParameter("miligrams");

        String meter = request.getParameter("meter");
        String centymeter = request.getParameter("centymeter");
        String milimeter = request.getParameter("milimeter");

        if(meter.equals("") && centymeter.equals("") && milimeter.equals("")) {
            forWeight(writer, kilo, grams, miligrams);
        }
            forDistance(writer, meter, centymeter, milimeter);
    }

    private void forDistance(PrintWriter writer, String meter, String centymeter, String milimeter) {
        PrzelicznikService service = new PrzelicznikService();
        if ((!meter.equals("") && !(centymeter.equals(""))
                || !meter.equals("") && !(milimeter.equals(""))) || !milimeter.equals("") && !(centymeter.equals(""))) {
            writer.println("Nie można podać 2 lub więcej wartości jednoczenie. Wróć i wprowadż tylko jedną.");
        } else {
            if (!meter.equals("")) {
                double m = Double.parseDouble(meter);
                writer.println("Podana wartośc w przeliczeniu to: ");
                writer.println("metry: " + meter + "<br/>");
                writer.println("centymetry: " + service.metersToCenty(m) + "<br/>");
                writer.println("milimetry: " + service.metersToMili(m) + "<br/>");
            }
            if (!(centymeter.equals(""))) {
                double cm = Double.parseDouble(centymeter);
                writer.println("Podana wartośc w przeliczeniu to: ");
                writer.println("metry: " + service.centyToMetes(cm) + "<br/>");
                writer.println("centymetry: " + cm + "<br/>");
                writer.println("milimetry: " + service.centyToMili(cm) + "<br/>");
            }
            if (!(milimeter.equals(""))) {
                double mm = Double.parseDouble(milimeter);
                writer.println("Podana wartośc w przeliczeniu to: ");
                writer.println("metry: " + service.miliToMeters(mm) + "<br/>");
                writer.println("centymetry: " + service.miliToCenty(mm) + "<br/>");
                writer.println("milimetry: " + mm + "<br/>");
            }
        }
    }

    private void forWeight(PrintWriter writer1, String kilo, String grams, String miligrams) {
        PrzelicznikService service = new PrzelicznikService();
        if ((!kilo.equals("")) && !(grams.equals(""))
                || (!kilo.equals("")) && !(miligrams.equals("")) || !miligrams.equals("") && !(grams.equals(""))) {
            writer1.println("Nie można podać 2 lub więcej wartości jednoczenie. Wróć i wprowadż tylko jedną.");
        } else {
            if (!kilo.equals("")) {
                double kg = Double.parseDouble(kilo);
                writer1.println("Podana wartośc w przeliczeniu to: ");
                writer1.println("kilogramy: " + kg + "<br/>");
                writer1.println("gramy: " + service.kiloToGrams(kg) + "<br/>");
                writer1.println("miligramy: " + service.kiloToMiligrams(kg) + "<br/>");
            }
            if (!(grams.equals(""))) {
                double g = Double.parseDouble(grams);
                writer1.println("Podana wartośc w przeliczeniu to: ");
                writer1.println("kilogramy: " + service.gramsToKilo(g) + "<br/>");
                writer1.println("gramy: " + g + "<br/>");
                writer1.println("miligramy: " + service.gramsToMiligrams(g) + "<br/>");
            }
            if (!(miligrams.equals(""))) {
                double mg = Double.parseDouble(miligrams);
                writer1.println("Podana wartośc w przeliczeniu to: ");
                writer1.println("kilogramy: " + service.miligramsToKilo(mg) + "<br/>");
                writer1.println("gramy: " + service.miligramsToGrams(mg) + "<br/>");
                writer1.println("miligramy: " + mg + "<br/>");
            }
        }
    }
}


