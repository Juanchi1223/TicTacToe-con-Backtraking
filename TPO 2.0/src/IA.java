import java.util.Vector;

public class IA extends Jugador{
    public IA() {
        super('O', "la Computadora");
    }
    private Vector<Integer> espaciosLibres(TaTeTi x){
        Vector<Integer> result = new Vector<Integer>();
        char[] listaTab = x.getTablero();

        for(int i = 0; i < 9; i++){
            if(listaTab[i] == ' ')
                result.add(i);
        }

        return result;
    }
    private TaTeTi variante(TaTeTi tab, int casillero, char jg){
        char[] original = new char[9];
        TaTeTi var;

        char[] tablero = tab.getTablero();
        

        for(int i = 0; i < 9; i++)
            original[i] = tablero[i];

        original[casillero] = jg;

        var = new TaTeTi(); var.inicializar();
        var.setTablero(original);

        return var;
    }
    private PosInd minmax(TaTeTi tab, char x){
        char maxJg = new Humano().getSimbolo();
        char Jg;

        if(x == maxJg)                  // Cambian los sibmolos ; )
            Jg = new IA().getSimbolo();
        else
            Jg = maxJg;

        PosInd casoBase;

        if(tab.Gano()){
            if(Jg == maxJg){
                casoBase = new PosInd(-1, espaciosLibres(tab).size() + 1); // uso -1 como un parametro imposible solo para remplazar despues de salir del caso base, sumamos 1 en el caso q se llene la por completo
            }
               else{
                casoBase = new PosInd(-1, -1 * (espaciosLibres(tab).size() + 1));
            }
            return casoBase;
        }
        else if(tab.lleno()){
            casoBase =  new PosInd(-1, 0); // empate = 0
            return casoBase;
        }

        PosInd resultado;

        if (x == maxJg)
            resultado = new PosInd(-1,-1);
        else
            resultado = new PosInd(-1,1);

        Vector<Integer> espacios = espaciosLibres(tab);

        for(int i : espacios){
            TaTeTi variante = variante(tab, i, x);
            PosInd camino;

            camino = minmax(variante, Jg);

            camino.setPos(i);

            if(x == maxJg){
                if (camino.getIndice() > resultado.getIndice())
                    resultado = camino;
            }
            else{
                if (camino.getIndice() < resultado.getIndice())
                    resultado = camino;
            }
        }
        return resultado;
    }
    public int jugar(TaTeTi tab){
        int pos = minmax(tab, super.getSimbolo()).getPos();
        return pos;
    }
}
