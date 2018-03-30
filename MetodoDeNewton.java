package matematicas;

import javax.swing.JOptionPane;

public class MetodoDeNewton {
    static final int num = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un numero:"));
    static final int exactitud = Integer.parseInt(JOptionPane.showInputDialog("¿Cuanta exactitud deseas?"));
    static double raiz;

    public static void main(String[] args) {
        raiz = raiz(num,aproximacion(num),exactitud);
        System.out.println("La raiz cuadrada de " + num + " es igual a " + raiz);
    }

    private static int aproximacion(final int num) {
        int anterior, actual, aproximacion = 0;

        for(int i = 0; i < num; i++) {
            aproximacion++;
            anterior = (aproximacion-1) * (aproximacion-1);
            actual = aproximacion * aproximacion;

            if(actual > num && anterior <= num) {
                aproximacion--;
                break;
            }
        }

        return aproximacion;
    }

    private static double raiz(final int num, final int aproximacion, final int exactitud) {
        double estimacion = aproximacion;
        double cuociente, promedio;

        for(int i = 0; i < exactitud; i++) {
            cuociente = (double)num/estimacion;
            promedio = (cuociente + estimacion)/2;

            estimacion = promedio;
        }

        return estimacion;
    }
}
