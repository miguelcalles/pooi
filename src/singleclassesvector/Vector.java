package singleclassesvector;

public class Vector {
    // propiedades
    private int x;
    private int y;

    // Constructores
    
    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Vector(int xy) {
        this(xy, xy);
    } 
    
    public Vector(Vector v) {
        this(v.x, v.y);
    }
    
    // Getters y Setters

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    /* Los dejo comentados pero los elimino del programa
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    */
    
    // Métodos
    public void show(){
        System.out.printf("Vector de coordenadas (%d, %d)%n", x, y);
    }
    
    public Vector suma(Vector v){
        return new Vector(x + v.x, y + v.y);
    }
    
    public Vector resta(Vector v){
        return new Vector(x - v.x, y - v.y);
    }
    
    public Vector opera(Vector v, char operacion){
        Vector resultado = null;
        if(operacion == '-') {
            resultado = resta(v);          
        } else {
            operacion = '+';
            resultado = suma(v);
        }
        System.out.printf("(%d, %d) %c (%d, %d) = (%d, %d)%n", 
                    x, y, operacion, v.x,  v.y, resultado.x, resultado.y);
        return resultado;
    }
    
    public Vector prod(int n){
        return new Vector(x * n, y * n);
    }
    
    public Vector opera(int n){
        Vector resultado = prod(n);
        System.out.printf("%d * (%d, %d) = (%d,%d)%n",
                n, x, y, resultado.x, resultado.y);
        return resultado;
    }
    
    public int prodE(Vector v){
        return x * v.x + y * v.y;
    }
    
    public int prodV(Vector v){
        return x * v.y - y * v.x;
    }

    public boolean esParalelo(Vector v){
        return prodV(v) == 0 && (x != 0 || y != 0) && (v.x != 0 || v.y != 0);
    }
    
    public boolean esPerpendicular(Vector v){
        return prodE(v) == 0 && (x != 0 || y != 0) && (v.x != 0 || v.y != 0);
    }          
}