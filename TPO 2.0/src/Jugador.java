import java.util.*;

public abstract class Jugador {
    private char simbolo;

    public Jugador(char s){
        this.simbolo = s;
    }
    public char getSimbolo() {
        return simbolo;
    }
    public int jugar(TaTeTi tab){
        return 0;
    }
}
