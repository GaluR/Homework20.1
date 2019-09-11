package pl.javastart.przelicznik.servlet;

import pl.javastart.service.PrzelicznikService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/przelicznikWag")
public class PrzelicznikWag extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();

        String kilo = request.getParameter("kilo");
        String grams = request.getParameter("grams");
        String miligrams = request.getParameter("miligrams");
        forWeight(writer, kilo, grams, miligrams);

    }

    private void forWeight(PrintWriter writer1, String kilo, String grams, String miligrams) {
        PrzelicznikService service = new PrzelicznikService();
        boolean condition1 = !kilo.equals("") && !miligrams.equals("");
        boolean condition2 = !grams.equals("") && !miligrams.equals("");
        boolean condition3 = !grams.equals("") && !kilo.equals("");
        if (condition1 || condition2 || condition3) {
            writer1.println("Nie można podać 2 lub więcej wartości jednoczenie. Wróć i wprowadż tylko jedną.");
        } else {
            if (!kilo.isEmpty()) {
                double kg = Double.parseDouble(kilo);
                writer1.println("Podana wartośc w przeliczeniu to: ");
                writer1.println("kilogramy: " + kg + "<br/>");
                writer1.println("gramy: " + service.kiloToGrams(kg) + "<br/>");
                writer1.println("miligramy: " + service.kiloToMiligrams(kg) + "<br/>");
            }
            if (!grams.isEmpty()) {
                double g = Double.parseDouble(grams);
                writer1.println("Podana wartośc w przeliczeniu to: ");
                writer1.println("kilogramy: " + service.gramsToKilo(g) + "<br/>");
                writer1.println("gramy: " + g + "<br/>");
                writer1.println("miligramy: " + service.gramsToMiligrams(g) + "<br/>");
            }
            if (!miligrams.isEmpty()) {
                double mg = Double.parseDouble(miligrams);
                writer1.println("Podana wartośc w przeliczeniu to: ");
                writer1.println("kilogramy: " + service.miligramsToKilo(mg) + "<br/>");
                writer1.println("gramy: " + service.miligramsToGrams(mg) + "<br/>");
                writer1.println("miligramy: " + mg + "<br/>");
            }
        }
    }
}
