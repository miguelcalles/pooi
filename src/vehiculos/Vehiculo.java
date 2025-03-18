package vehiculos;

public class Vehiculo {
    
    String marca;
    String tipo;
    byte numRuedas;
    short anioFabricacion;

    String[] historicoColores; // máximo 5    
    String color;

    int x;
    double velocidad;
    boolean nuevo;
    double kms;
    double precio;

    public void show() {
        System.out.printf(
                "%s %s %s %s [%d] de %d ruedas con %.2f kms a %.2f km/h de precio %.2f (x=%d).%n",
                tipo, marca, color, nuevo ? "nuevo" : "usado", anioFabricacion,
                numRuedas, kms,
                velocidad, precio, x);
        System.out.println("Histórico de colores");
        for (String c : historicoColores) {
            System.out.printf("%S ", c != null ? c: "");
        }
        System.out.println();
        
    }

    public Vehiculo(Vehiculo v) {
        x = 0;
        anioFabricacion = v.anioFabricacion;
        velocidad = v.velocidad;
        color = v.color;
        marca = v.marca;
        tipo = v.tipo;
        numRuedas = v.numRuedas;
        nuevo = v.nuevo;
        kms = v.kms;
        historicoColores = v.historicoColores;
        precio = v.precio;
    }

    public Vehiculo(Vehiculo ve, double precio) {
        this(ve.color, ve.marca, ve.numRuedas, precio);
    }

    public Vehiculo() {
        this("blanco", "Seat", (byte) 4, (int) 1_000.4);
    }

    public Vehiculo(String color, String marca, 
								    byte numRuedas, double precio) {
        // tengo ya el this con los valores por defecto
        x = 0;

        anioFabricacion = 2024;
        velocidad = 0;
        this.color = color;
        this.marca = marca == null ? "Seat" : marca; // Seat si no hay marca

        this.numRuedas = numRuedas < 2 ? 2 : numRuedas;

        switch (this.numRuedas) {
            case 2:
                tipo = "moto";
                break;
            case 3:
                tipo = "triciclo";
                break;
            case 4:
                tipo = "coche";
                break;
            case 10:
                tipo = "autobús";
                break;
            default:
                tipo = "camión";
        }

        nuevo = true;
        kms = 0;
        historicoColores = new String[5];
        if (this.color != null) {
            historicoColores[0] = this.color;
        }
        this.precio = precio < 100 ? 100 : precio;
    }

    public Vehiculo pintar(String color) {
        int puedoEscribirEn = -1;

        for (int i = 0; i < historicoColores.length; i++) {
            if (historicoColores[i] == null) {
                puedoEscribirEn = i;
                break;
            }
        }

        if (puedoEscribirEn != -1) {
            historicoColores[puedoEscribirEn] = color;
            this.color = color;
            return this;
        } else {
            return null;
        }
    }

    // se llama pintar y coge el vehículo sobre el que aplica 
    // cambia a color blanco
    public Vehiculo pintar() {
        return pintar("blanco"); 
    }

    public Vehiculo para(){
        velocidad = 0;
        System.out.println("Vehículo detenido.");
        return this;
    }
    
    public void circula(double velocidad) {
    }
    
    public Vehiculo acelera() {
        
        velocidad = ((velocidad + 10) >= 120) ? 120: velocidad + 10;
        System.out.printf("Nueva velocidad: %.2f%n", velocidad);
        return this;
    }

    public Vehiculo frena() {
        velocidad = ((velocidad - 10) <=0) ? 0: velocidad - 10;
        System.out.printf("Nueva velocidad: %.2f%n", velocidad);
        return this;
    }
    
    public Vehiculo pintarBasadoEn (Vehiculo vehiculo) {
        
        return vehiculo == null ? null: pintar(vehiculo.color);

    }

    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo();
        v1.show();
        Vehiculo v2 = new Vehiculo(v1, 2345);
        v2.show();
        Vehiculo v3 = new Vehiculo(v2);
        v3.show();
        Vehiculo v4 = new Vehiculo("azul", "renault", (byte) 4, 9999);
        v4.acelera().acelera().frena().para().show();
    }
}
