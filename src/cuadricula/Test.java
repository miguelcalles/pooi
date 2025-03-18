package cuadricula;

public class Test {
    public static void main(String[] args) {
        // Array de Arrays de Desplazamientos para hacer pruebas múltiples
        // Se usa apra pasarlo al método test y qu epruebe con varios Arrays de
        // desplazamiento
        byte[][] arraysDesplazamientos = new byte[][] {
            new byte[]{},
            new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 
            new byte[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            new byte[]{2, 2, 2, 2, 2},
        };
        
        System.out.println("Test: Cuadrículas de distitos tamaños");
        System.out.println("=====================================\n");
        System.out.println("1 fila y 4 columnas");
        Cuadricula c1 = new Cuadricula((byte)1, (byte)4);
        // El método test se encaga de todas la pruebas
        c1.test((byte)1, (byte)2, arraysDesplazamientos);
        
        System.out.println("\n3 fila y 7 columnas");
        Cuadricula c2 = new Cuadricula((byte)3, (byte)7);
        c2.test((byte)1, (byte)2, arraysDesplazamientos);
        
        System.out.println("\n7 fila y 3 columnas");
        Cuadricula c3 = new Cuadricula((byte)7, (byte)3);
        c3.test((byte)1, (byte)2, arraysDesplazamientos);
        
        System.out.println("\n20 fila y 20 columnas");
        Cuadricula c4 = new Cuadricula((byte)20, (byte)20);
        c4.test((byte)1, (byte)2, arraysDesplazamientos);
    }
    
}