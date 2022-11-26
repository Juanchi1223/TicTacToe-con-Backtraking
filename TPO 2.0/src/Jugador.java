import java.util.*;

public abstract class Jugador {
    private char simbolo;
    private String nombre;

    public Jugador(char s, String n){
        this.simbolo = s;
        this.nombre = n;
    }
    public char getSimbolo() {
        return simbolo;
    }

    public String getNombre() {
        return nombre;
    }

    public int jugar(TaTeTi tab){
        return 0;
    }
}
