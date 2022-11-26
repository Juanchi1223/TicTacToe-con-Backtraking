public class main {
    public static void main(String[] args) {
        /*
        *todo
        *   1. Documentar Funciones
        *   2. Estrategia Ganadora
        *   3. Ver indices cambiar por 1 o -1
        *   4. Hacer Informe en PDF (Complejidad de cada funcion)
        *   5. Funcion para q arranque la maquina
        *
        * todo
        *   6. Presentacion:
        *       a. Cambiar a español
        *       b. Tabla posiciones Guia
        *       c. Cambiar ingresos para (ingresado-1)
        *       d. Simbolos y referencias
        *       e. Numero de Turno
        *       f. cls de consola
        *
        * --- ver como funciona MinMAx para explicarlo
        */

        TaTeTi juego = new TaTeTi(); juego.inicializar();

        Jugador pc = new IA();
        Jugador h = new Humano();

        int pos;

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

        /*
        bot = ComputerPlayer(self.botPlayer)
        human = humanPLayer(self.humanPLayer)
        while True:
            print(f"   Player {self.humanPLayer} turn")
            self.show_board()                   # muestra en pantalla la tabla 1

            #Human
            square = human.human_move(self.board) # pregunta casilla
            self.board[square] = self.humanPLayer   # agrega casilla
        if self.checkWinner():                  # se fija si ganaron
                break

            #Bot
            square = bot.machine_move(self.board)   # pregunta casilla al bot
            self.board[square] = self.botPlayer     # agrega casilla
            if self.checkWinner():                  # se fija si ganaron
                break

            # showing the final view of board
            print()
            self.show_board()                       # muestra en pantalla la tabla
        */
    }
}
