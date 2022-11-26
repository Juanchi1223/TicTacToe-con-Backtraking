import java.util.Scanner;

public class Humano extends Jugador{

    public Humano() {
        super('X', "el Jugador");
    }
    public int jugar(TaTeTi tab){
        int pos;

        char[] espacios = tab.getTablero();
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresar una posicion para la ficha(1-9): ");
        pos = input.nextInt();
        while(!(1 <= pos && pos <= 9)) {
            System.out.println("Ingresar una posicion para la ficha(1-9):");
            pos = input.nextInt();
        }
        if(espacios[pos-1] != ' ')
            return jugar(tab);
        return pos-1;
    }
}
