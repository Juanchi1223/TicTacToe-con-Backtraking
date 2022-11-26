import java.util.Scanner;

public class Humano extends Jugador{

    public Humano() {
        super('X');
    }
    public int jugar(TaTeTi tab){
        int pos;

        char[] espacios = tab.getTablero();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the square to fix spot(1-9): ");
        pos = input.nextInt();
        while(!(0 <= pos && pos <= 8)) {
            System.out.println("Enter the square to fix spot(1-9): ");
            pos = input.nextInt();
        }
        if(espacios[pos] != ' ')
            return jugar(tab);
        return pos;
    }
}
