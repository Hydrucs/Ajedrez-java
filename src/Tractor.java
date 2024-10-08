public class Tractor {
    //Variables globales de esta classe
    String id;
    String matricula;
    int potencia;
    int longitud;
    String artilugio;
    int numRuedas;
    boolean motorEncendido;
    boolean lucesEncendidas;

    //Para poder usar
    public Tractor(String id, String matricula, int potencia, int longitud, String artilugio) {
        this.id = id;
        this.matricula = matricula;
        this.potencia = potencia;
        this.longitud = longitud;
        this.artilugio = artilugio;
        this.numRuedas = 4;
        this.motorEncendido = false;
        this.lucesEncendidas = false;
    }

    //Para el parking que quede bonito
    public String toString() {
        return "[ T ]";
    }

    // Pa la info del parking
    public String getInfo() {
        String info = "Tractor ID: " + id + ", Matrícula: " + matricula + ", Potencia: " + potencia + " CV, Longitud: " + longitud + " metros, Artilugio: " + artilugio + ", Número de ruedas: " + numRuedas;
        info += "\nEstado del motor: " + (motorEncendido ? "Encendido" : "Apagado");
        info += "\nEstado de las luces: " + (lucesEncendidas ? "Encendidas" : "Apagadas");

        if (artilugio.equals("arador")) {
            info += "\nEste tractor puede arar.";
        } else if (artilugio.equals("regador")) {
            info += "\nEste tractor puede regar.";
        } else if (artilugio.equals("aplanador")) {
            info += "\nEste tractor puede aplanar.";
        }

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
    // Aqui no hay opcion de ruedas porque son las mismas pa todos
}
