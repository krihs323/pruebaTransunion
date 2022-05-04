import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SistemaCargas {

    public static void main(String[] args) {
        SistemaCargas sistemaCargas = new SistemaCargas();

        sistemaCargas.cargaPaquete(90, new Integer[]{10, 60, 40, 35, 20});
    }

    private void cargaPaquete(int tamano, Integer[] Apaquetes) {

        Arrays.sort(Apaquetes, Collections.reverseOrder());

        System.out.println("Tamaño del camion: " + tamano);

        System.out.print("[");
        for (int k = 0; k < Apaquetes.length; k++) {
            System.out.print(Apaquetes[k]);
            System.out.print(",");
        }
        System.out.println("]");

        int tamanoExacto = tamano - 30;
        System.out.println("Resultado: ");
        for (int i=0; i < Apaquetes.length; i++){

            int[] aPar = evaluar(i, Apaquetes, tamanoExacto);

            int suma = 0;
            for (int j = 0; j < aPar.length; j++) {
                suma = suma + aPar[j];
            }
            if (suma>0){
                System.out.print("[");
                System.out.print(aPar[0]);
                System.out.print(",");
                System.out.print(aPar[1]);
                System.out.print("]");
                break;
            }

        }

    }

    private int[] evaluar(int indice, Integer[] aPaquetes, int tamanoExacto) {

        //Creo un nuevo array, sin el indice con el que se va a evaluar

        List<Integer> aPaqueteEvalua = new ArrayList<Integer>(Arrays.asList(aPaquetes));
        aPaqueteEvalua.remove(indice);

        int[] arrayOut = new int[2];


        for (int i = 0; i < aPaqueteEvalua.size() ; i++) {

            //sumo el indice con el paquete que se va a evaluar
            //si suma 60 entonces esta bien
            if((aPaquetes[indice] + aPaqueteEvalua.get(i) == tamanoExacto)) {
                arrayOut[0]=aPaquetes[indice];
                arrayOut[1]=aPaqueteEvalua.get(i);
                return arrayOut;
            }

        }
        return arrayOut;

    }

}
