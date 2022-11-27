import java.security.KeyStore;
import java.util.Scanner;

public class TaTeTi {
    private char[] tablero;

    public TaTeTi(){}

    public void inicializar(){
        tablero =  new char[9];

        for(int i = 0; i < 9; i++){
            tablero[i] = ' ';
        }
    }

    public void mostrar(){
        System.out.println();
        for(int i = 0; i < 9; i++){
            if ((i+1) % 3 == 0) {
                System.out.printf("%3s", tablero[i]);
                System.out.println();
            }
            else
                System.out.printf("%3s |", tablero[i]);
        }
    }

    public char[] getTablero() {
        return tablero;
    }

    public void setPosicion(int x, Jugador jg){
        this.tablero[x] = jg.getSimbolo();
    }

    public void setTablero(char[] tablero) {
        this.tablero = tablero;
    }

    public boolean lleno(){
        boolean flag = true;
        for(int i = 0; i < 9; i++){
            if(tablero[i] == ' ')
                flag = false;
        }
        return flag;
    }

    public boolean jugadorGano(Jugador x){
        if (tablero[0] == tablero[1] && tablero[1] == tablero[2] && tablero[2] == x.getSimbolo())
            return true;
        else if (tablero[3] == tablero[4] && tablero[4] == tablero[5] && tablero[5] == x.getSimbolo())
            return true;
        else if (tablero[6] == tablero[7] && tablero[7] == tablero[8] && tablero[8] == x.getSimbolo())
            return true;
        else if (tablero[0] == tablero[3] && tablero[3] == tablero[6] && tablero[6] == x.getSimbolo())
            return true;
        else if (tablero[1] == tablero[4] && tablero[4] == tablero[7] && tablero[7] == x.getSimbolo())
            return true;
        else if (tablero[2] == tablero[5] && tablero[5] == tablero[8] && tablero[8] == x.getSimbolo())
            return true;
        else if (tablero[0] == tablero[4] && tablero[4] == tablero[8] && tablero[8] == x.getSimbolo())
            return true;
        else if (tablero[2] == tablero[4] && tablero[4] == tablero[6] && tablero[6] == x.getSimbolo())
            return true;
        else
            return false;
    }

    public boolean Gano(){
        Jugador auxPc = new IA();
        Jugador auxH = new Humano();

        if(jugadorGano(auxH))
            return true;
        else if (jugadorGano(auxPc))
            return true;
        else
            return false;
    }

    public boolean JuegoTermino(){
        Jugador auxPc = new IA();
        Jugador auxH = new Humano();

        if (jugadorGano(auxH)){
            System.out.println();
            System.out.println("    Gano " + auxH.getNombre());
            return true;
        }
        if (jugadorGano(auxPc)) {
            System.out.println();
            System.out.println("    Gano " + auxPc.getNombre());
            return true;
        }
        if (lleno()){
            System.out.println();
            System.out.println("    Empate");
            return true;
        }
        return false;
    }

    public boolean Turno(){
        int pos;
        boolean flag = false;
        Scanner input = new Scanner(System.in);

        System.out.println("Quien arranca a jugar (0 para vos, 1 para maquina): ");
        int x = input.nextInt();

        while(x != 1 && x != 0){
            System.out.println("Quien arranca a jugar (0 para vos, 1 para maquina): ");
            x = input.nextInt();
        }

        if (x == 1){
            flag = true;
            mostrar();
            System.out.println("Donde queres que juege la maquina? : ");
            pos = input.nextInt();

            while(!(1 <= pos && pos <= 9)) {
                System.out.println("Donde queres que juege la maquina? : ");
                pos = input.nextInt();
            }

            setPosicion(pos-1, new IA());
        }
        return flag;
    }
}
