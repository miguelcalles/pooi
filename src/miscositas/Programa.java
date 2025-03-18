package miscositas;


public class Programa {
    public static void main(String[] args) {
        Person p1 = new Person("Manuel", "Pérez de los Ríos de Guzmal y otras cosas");
        p1.show();
        Person p2 = new Person(p1);
        p1.show();
    }
}