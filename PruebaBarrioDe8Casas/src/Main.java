public class Main {

    public static void main(String[] args) {
        Main demo = new Main();

        demo.estateField( new int[]{1,0,0,0,0,1,0,0}, 1);
        demo.estateField( new int[]{1,1,1,0,1,1,1,1}, 2);
    }

    public static void estateField(int[] a, int days) {

        int[] estateOut = a;

        for (int i=0; i < days; i++){
            estateOut = setEstate(estateOut);
        }

        System.out.println("Cantidad de Dias " + days);

        System.out.print("Entrada: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();

        System.out.print("Salida: ");
        for (int i = 0; i < estateOut.length; i++) {
            System.out.print(estateOut[i] + ",");
        }

        System.out.println();

    }

    public static int[] setEstate(int[] a) {

        //Comprobar si los vecinos son iguales
        int[] estateOut = new int[a.length];

        for (int i = 0; i < a.length; i++) {

            //comprobar si estoy en el extremo

            //extremo izquierdo
            if (i == 0) {
                estateOut[i] = 0;
            }

            if (i > 0 && i < a.length - 1) {

                //comparo el vecino izquierdo con el vecino derecho
                if (a[i - 1] == a[i + 1]) {
                    //si vecinos son iguales, el estado es 0
                    estateOut[i] = 0;
                } else {
                    estateOut[i] = 1;
                }
            }

            //extremo derecho
            if (i == a.length - 1) {
                estateOut[i] = 0;
            }
        }
        return estateOut;
    }

}
