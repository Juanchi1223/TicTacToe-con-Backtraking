public class main {
    public static void main(String[] args) {

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
