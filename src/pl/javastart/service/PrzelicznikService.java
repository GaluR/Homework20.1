package pl.javastart.service;

public class PrzelicznikService {
    public double miliToCenty(double number1) {
        double result = number1 / 10;
        return result;
    }

    public double miliToMeters(double number1) {
        double result = number1 / 1000;
        return result;
    }

    public double centyToMetes(double number1) {
        double result = number1 / 100;
        return result;
    }

    public double centyToMili(double number1) {
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

    public double kiloToGrams(double number1) {
        double result = number1 * 1000;
        return result;
    }

    public double kiloToMiligrams(double number1) {
        double result = number1 * 1000000;
        return result;
    }

    public double gramsToMiligrams(double number1) {
        double result = number1 * 1000;
        return result;
    }

    public double gramsToKilo(double number1) {
        double result = number1 / 1000;
        return result;
    }

    public double miligramsToGrams(double number1) {
        double result = number1 / 1000;
        return result;
    }

    public double miligramsToKilo(double number1) {
        double result = number1 / 1000000;
        return result;
    }


}
