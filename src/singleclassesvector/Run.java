package singleclassesvector;

public class Run {
    public static void main(String[] args) {
        System.out.println("v1: constructor dado x e y");
        Vector v1 = new Vector(5, 9);
        v1.show();
        System.out.println("v2: constructor dado un solo valor");
        Vector v2 = new Vector(17);
        v2.show();
        System.out.println("v3: constructor copia");
        Vector v3 = new Vector(v1);
        v3.show();
        System.out.println("v4: suma de v1 y v2");
        Vector v4 = v1.suma(v2);
        v4.show();
        System.out.println("v5: resta de v1 y v2");
        Vector v5 = v1.resta(v2);
        v5.show();
        System.out.println("v6: opera restando v1 y v2");
        Vector v6 = v1.opera(v2, '-');
        v6.show();
        System.out.println("v7: opera sumando v1 y v2");
        Vector v7 = v1.opera(v2, '+');
        v7.show();
        System.out.println("v8: producto de vector por número v1 * 10");
        Vector v8 = v1.prod(10);
        v8.show();
        v1.opera(10);
        System.out.println("Producto escalar de v1 y v2");
        System.out.println(v1.prodE(v2));
        System.out.println("Producto vectorial de v1 y v2");
        System.out.println(v1.prodV(v2)); 
        System.out.println("Sabiendo que (3, 5) y (6, 10) son paralelos");
        System.out.println(new Vector(3, 5).esParalelo(new Vector(6, 10)));
        System.out.println("Sabiendo que (3, 5) y (-5, 3) son perpendiculares");
        System.out.println(new Vector(3, 5).esPerpendicular(new Vector(-5, 3)));  
    }
}