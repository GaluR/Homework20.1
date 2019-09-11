package pl.javastart.service;

public class PrzelicznikService {
    public double miliToCenty(double number1) {
        double result = number1 * 0.1;
        return result;
    }

    public double miliToMeters(double number1) {
        double result = number1 * 0.001;
        return result;
    }

    public double CentyToMetes(double number1) {
        double result = number1 * 0.01;
        return result;
    }

    public double CentyToMili(double number1) {
        double result = number1 * 10;
        return result;
    }

    public double metersToCenty(double number1) {
        double result = number1 * 100;
        return result;
    }

    public double metersToMili(double number1) {
        double result = number1 * 1000;
        return result;
    }
}
