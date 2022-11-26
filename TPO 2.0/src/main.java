public class main {
    public static void main(String[] args) {
        /*
        *todo
        *   1. Documentar Funciones
        *   2. Estrategia Ganadora
        *   3. -HECHO- Ver indices cambiar por 1 o -1
        *   4. Hacer Informe en PDF (Complejidad de cada funcion)
        *   5. -HECHO- Funcion para q arranque la maquina (VER COMO LO HIZO JUANI ;) )
        *
        * todo
        *   6. Presentacion:
        *       a. Cambiar a español
        *       b. Tabla posiciones Guia
        *       c. Cambiar ingresos para (ingresado-1)
        *       d. Simbolos y referencias
        *       e. Numero de Turno
        *       f. cls de consola
        *       g. Ganador aclarar
        *
        *   --- ver como funciona MinMAx para poder explicarlo
        */

        TaTeTi juego = new TaTeTi(); juego.inicializar();

        Jugador pc = new IA();
        Jugador h = new Humano();

        int pos;

        juego.Turno();
        juego.mostrar();

        for(;;){
            pos = h.jugar(juego);
            juego.setPosicion(pos, h);

            if (juego.JuegoTermino())
                break;

            pos = pc.jugar(juego);
            juego.setPosicion(pos, pc);

            if (juego.JuegoTermino())
                break;

            juego.mostrar();
        }
        juego.mostrar();
    }
}
