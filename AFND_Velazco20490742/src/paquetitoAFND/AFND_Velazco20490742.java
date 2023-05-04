package paquetitoAFND;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

public class AFND_Velazco20490742 {
	/* Alumno: Velazco Mendiola Candy Nohemi
	 * No.Contro: 20490742
	 * Lenguajes y Automatas I*/

	// Uno como antepenultimo caracter
    private static final int q0 = 0;
    private static final int q1 = 1;
    private static final int q2 = 2;
    private static final int q3 = 3;

    private int estadoActual;
    private Set<Integer> estadosActuales;
	
	public static void main(String[] args) {
    	AFND_Velazco20490742 afnd = new AFND_Velazco20490742();
        System.out.println(afnd.accept("1010")); // false
        System.out.println(afnd.accept("11100")); // true
        String string = JOptionPane.showInputDialog(null, "Ingrese una cadena que con 1 y 0");
        boolean resultado = afnd.accept(string);
        JOptionPane.showMessageDialog(null, "La cadena " + string + " es " + (resultado ? "aceptada" : "rechazada") + ".");
    }

    public AFND_Velazco20490742() {
        estadoActual = q0;
        estadosActuales = new HashSet<>();
        estadosActuales.add(q0);
    }

    public boolean accept(String cadena) {
        for (char c : cadena.toCharArray()) {
            estadosActuales = transiciones(estadosActuales, c);
            if (estadosActuales.isEmpty()) {
                return false;
            }
        }
        return estadosActuales.contains(q3);
    }

    private Set<Integer> transiciones(Set<Integer> estadosActuales, char simbolo) {
        Set<Integer> nuevosEstados = new HashSet<>();
        for (int estado : estadosActuales) {
            switch (estado) {
                case q0:
                    if (simbolo == '1') {
                    	nuevosEstados.add(q0);
                        nuevosEstados.add(q1);
                    }else if (simbolo == '0'){
                    	nuevosEstados.add(q0);
                    }
                    break;
                case q1:
                    if (simbolo == '0' || simbolo == '1') {
                        nuevosEstados.add(q2);
                    } 
                    break;
                case q2:
                	if (simbolo == '0' || simbolo == '1') {
                        nuevosEstados.add(q3);
                    } 
                    break;
            }
        }
        return nuevosEstados;
    }
}