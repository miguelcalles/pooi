package cuadricula;


public class Cuadricula {
    private byte filas;
    private byte cols;
    private byte[][] map;
    private final static char C_I = '+';
    private final static char C_H = '-';
    private final static char C_V = '|';
    
        
    public void mapUpdate(byte f, byte c, byte[] desplazamientos) {
        
        // puesta a 0 de todo el array bidimensional
        for(int i = 0; i < map.length; i++)
            for(int j=0; j < map[i].length; j++)
                map[i][j] = 0;

       // arranco el valor de fila y col con los datos que entran, pero 
       // impidiendo que se salgan del tamaño de la cuadrçicula
        byte fila = f < 0 ? (byte)0: f > filas ? filas : f;
        byte col = c < 0 ? (byte)0: c > cols ? cols : c;
        byte pos = 1;
        
        // Actualizo en la posición correspondiente del array map el valor del 
        // número de la posición y lo incremento 
        map[fila-1][col-1] = pos++;
        
        
        // Voy alternando las direcciones de movimiento y controlo que no se salga
        for (int i = 0; i < desplazamientos.length; i++) {
            if (i % 4 == 0) {
                col += (cols - col) < desplazamientos[i] ? cols - col: desplazamientos[i]; // right
            } else if ((i-1) % 4 == 0) {
                fila -= (fila - 1) < desplazamientos[i] ? fila - 1 : desplazamientos[i]; // bottom
            } else if ((i-2) % 4 == 0) {
                col -= (col - 1) < desplazamientos[i] ? col - 1 : desplazamientos[i]; // up
            } else {
                fila += (filas - fila) < desplazamientos[i] ? filas - fila: desplazamientos[i];  // left
            }
            map[fila-1][col-1] = pos;
            pos++;
        }  
    }
    
// Constructor 
    public Cuadricula(byte filas, byte cols) {
        // solo se permite generar cuadrículas con valores de filas y cols
        // entre 0 y 9.
        this.filas = filas > 9 ? (byte)9 : filas > 0 ? filas : (byte)0;
        this.cols = (byte)cols > 9 ? (byte)9 : cols > 0 ? cols : 0;
        // se instancia el array que contendrá los desplazamietnos absolutos
        // con sus numeritos de orden
        this.map = new byte[filas][cols];
    }
    
    public void show(byte type) {
        // 0 en blanco
        // 1 con coordenadas
        // 2 con array de puntos
        
        // Dibuja la fila de arriba  una vez
        String miFila1 = "" + C_I;
        String miFila2 = "" + C_V;
        for (int j = 1; j <= cols; j++)
            miFila1 += getSingleChain((byte)0, (byte)j, (byte)0, (byte)-1);
        System.out.println(miFila1);
        
        // Dibuja las dos líneas necesarias tantas veces como filas hay 
        
        for (int i = filas; i > 0; i--) {
            for (int j = 1; j <= cols; j++){
                miFila2 += getSingleChain((byte)j, (byte)i, (byte)map[i-1][j-1], (byte)type);    
            }
            System.out.println(miFila2);
            System.out.println(miFila1);

            miFila2 = "" + C_V;  
        }
    }
    
    public void test(byte filaInicial, byte colInicial, byte[][] arrayDesplazamientos){
        
        // Para una cuadrícula:
        
        // la muestra en blanco
        show((byte)0);
        // la mmuestra con las posiciones
        show((byte)1);
        
        // Para una posición inicial genera y guarda los valores de los números 
        // correspondientes a los desplazamientos y muestra la cuadrícula con 
        // los valores de los números
        
        // Eso lo hace para cada array de desplazamietnos contenidos en el array
        // de arrays de desplazamientos.
        
        for (byte[] array : arrayDesplazamientos) {
            mapUpdate((byte)filaInicial, (byte)colInicial, array);
            
            System.out.print("desplazamientos = ");
            for(byte b : array)
                System.out.print(b + " ");
            System.out.printf("%nTamaño = %d x %d%n", filas, cols);
            System.out.printf("Posición inicial = (%d, %d)%n", filaInicial, colInicial);

            show((byte)2);
        }
    }
 
    private static String getSingleChain(byte x, byte y, byte pos, byte type) {
        // valores posibles de type
        // negativo línea separadora
        // 0 en blanco
        // 1 linea central con coordenadas
        // 2 con array de puntos
        
        String resultado = "";
        
        // dibuja la línea separadora de una celda
        if (type < 0) {
            for (int i = 0; i < 6; i++) resultado += C_H;
            return resultado += C_I;
        }
        
        // dibuja la línea central fr una celda con el contenido en blanco
        if (type == 0)
            return "      " + C_V;
        
        // dibuja la línea central de una celda con las coordenadas
        if (type == 1)
            return "(" + x + ", " + y + ")" + C_V;

        // dibuja la línea central de una celda con el contendido del array que 
        // contiene las posiciones absolutas y su orden
        if (type == 2) 
            return pos <= 0 || pos >= 100 ? "      " + C_V : pos < 10 ? "   " 
                    + pos + "  " + C_V : "  " + pos + "  " + C_V;
            
        return "";  
    }   
}