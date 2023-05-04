package paquetitoAFND;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

public class AFN2_Velazco20490742 {

    private static final int q0 = 0;
    private static final int q1 = 1;
    private static final int q2 = 2;
    private static final int q3 = 3;
    private static final int q4 = 4;
    private static final int q5 = 5;
    private static final int q6 = 6;
    private static final int q7 = 7;
    private static final int q8 = 8;

    private int estadoActual;
    private Set<Integer> estadosActuales;

    public static void main(String[] args) {
    	String string = JOptionPane.showInputDialog(null, "Ingrese una cadena que con a, b o c");
        AFN2_Velazco20490742  afnd = new AFN2_Velazco20490742 ();
        boolean resultado = afnd.accept(string);
        JOptionPane.showMessageDialog(null, "La cadena " + string + " es " + (resultado ? "aceptada" : "rechazada") + ".");
    }

    public AFN2_Velazco20490742 () {
        estadoActual = q0;
        estadosActuales = new HashSet<>();
        estadosActuales.add(q0);
    }

    public boolean accept(String cadena) {
        List<Integer> estadosVisitados = new ArrayList<>();
        for (char c : cadena.toCharArray()) {
            estadosActuales = transiciones(estadosActuales, c);
            if (estadosActuales.isEmpty()) {
                return false;
            }
            estadosVisitados.addAll(estadosActuales);
        }
        estadosVisitados.addAll(estadosActuales);
        if (estadosActuales.contains(q8)) {
            System.out.println("Camino seguido: " + estadosVisitados);
            return true;
        } else {
            return false;
        }
    }


    private Set<Integer> transiciones(Set<Integer> estadosActuales, char simbolo) {
        Set<Integer> nuevosEstados = new HashSet<>();
        for (int estado : estadosActuales) {
            switch (estado) {
                case q0:
                    if (simbolo == 'a') {
                        nuevosEstados.add(q0);
                        nuevosEstados.add(q1);
                    }
                    break;
                case q1:
                    if (simbolo == 'b') {
                        nuevosEstados.add(q2);
                    }
                    break;
                case q2:
                    if (simbolo == 'a' || simbolo == 'b') {
                        nuevosEstados.add(q3);
                    }
                    break;
                case q3:
                    if (simbolo == 'a' || simbolo == 'b') {
                        nuevosEstados.add(q4);
                    }
                    break;
                case q4:
                    if (simbolo == 'a' || simbolo == 'b') {
                        nuevosEstados.add(q5);
                    }
                    break;
                case q5:
                    if (simbolo == 'a') {
                        nuevosEstados.add(q6);
                    }
                    break;
                case q6:
                    if (simbolo == 'b') {
                        nuevosEstados.add(q7);
                    }
                    break;
                case q7:
                    if (simbolo == 'a' || simbolo == 'b') {
                        nuevosEstados.add(q8);
                    }
                    break;
            }
        }
        return nuevosEstados;
    }
}