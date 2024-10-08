import java.util.Random;

public class Coche {
    //Variables globales de esta classe
    String id;
    String matricula;
    int potencia;
    int longitud;
    String tipo;
    int numRuedas;
    boolean motorEncendido;
    boolean lucesEncendidas;

    //Para poder usar
    public Coche(String id, String matricula, int potencia, int longitud, String tipo) {
        this.id = id;
        this.matricula = matricula;
        this.potencia = potencia;
        this.longitud = longitud;
        this.tipo = tipo;
        this.numRuedas = calcularRuedas(tipo);
        this.motorEncendido = false;
        this.lucesEncendidas = false;
    }

    //Para el parking que quede bonito
    public String toString() {
        return "[ " + tipo.substring(0, 1).toUpperCase() + " ]";
    }

    // Pa la info del parking
    public String getInfo() {
        String info = "Coche ID: " + id + ", Tipo: " + tipo + ", Matrícula: " + matricula + ", Potencia: " + potencia + " CV, Longitud: " + longitud + " metros, Número de ruedas: " + numRuedas;
        info += "\nEstado del motor: " + (motorEncendido ? "Encendido" : "Apagado");
        info += "\nEstado de las luces: " + (lucesEncendidas ? "Encendidas" : "Apagadas");
        return info;
    }

    // Funciones varias pa usar motor luces etc...
    public void encenderMotor() {
        motorEncendido = true;
    }

    public void apagarMotor() {
        motorEncendido = false;
    }

    public void encenderLuces() {
        lucesEncendidas = true;
    }

    public void apagarLuces() {
        lucesEncendidas = false;
    }

    // Pa las ruedas
    private int calcularRuedas(String tipo) {
        switch (tipo) {
            case "Kart":

            case "Deportivo":
                return 4;

            case "SUV":

            case "4x4":
                return 5;
                
            default:
                return 4;
        }
    }
}
