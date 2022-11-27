public class main {
    public static void main(String[] args) {
        /*
        *todo
        *   1. Documentar Funciones
        *   2. Estrategia Ganadora
        *   3. Pode Alfa Beta (Codigo minmax n: 75)
        *   3. -HECHO- Ver indices cambiar por 1 o -1
        *   4. Hacer Informe en PDF (Complejidad de cada funcion)
        *   5. -HECHO- Funcion para q arranque la maquina (VER COMO LO HIZO JUANI ;) )
        *   6. Cambiar score a indice y ver si cambiar IA si no es tanto kilombo
        *
        * todo
        *   Presentacion:
        *       a. -HECHO- Cambiar a español
        *       b. -HECHO- Tabla posiciones Guia
        *       c. -HECHO- Cambiar ingresos para (ingresado-1)
        *       d. -HECHO- Simbolos y referencias (podemos poner un nombre a las clases)
        *       e. -HECHO- Numero de Turno
        *       f. cls de consola
        *       g. -HECHO- Ganador aclarar
        *
        *   --- ver como funciona MinMAx para poder explicarlo
        */

        TaTeTi juego = new TaTeTi(); juego.inicializar();

        Jugador pc = new IA();
        Jugador h = new Humano();

        int pos;
        int NroTurno = 0;

        System.out.println();
        System.out.println("EN ESTA CASO 'X' ES EL JUGADOR Y 'O' ES LA MAQUINA! "); System.out.println();


        System.out.println("Tablero Guia (Posiciones): ");

        System.out.println(" 1 |  2 |  3");
        System.out.println(" 4 |  5 |  6");
        System.out.println(" 7 |  8 |  9"); System.out.println();

        if(juego.Turno())
            NroTurno++;

        juego.mostrar();

        for(;;){
            NroTurno++;
            System.out.println();
            System.out.println("Turno Nro: " + NroTurno );

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
