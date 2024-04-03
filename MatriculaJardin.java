public class MatriculaJardin {
    public static void main(String[] args) {
        // Datos de los niños
        Niño[] niños = {
            new Niño("Matricula Mariana", 3, 1),
            new Niño("Matricula Pedrito", 5, 1),
            new Niño("Matricula Sara", 1, 3),
            new Niño("Matricula Miguel", 2, 0)
        };

        // Calculando el costo de matrícula para cada niño
        for (Niño niño : niños) {
            double costo = calcularCostoMatricula(niño);
            System.out.println(niño.nombre + ": " + costo);
        }
    }

    // Función para calcular el costo de matrícula para un niño dado
    public static double calcularCostoMatricula(Niño niño) {
        double costo = 0;

        if (niño.edad >= 1 && niño.edad <= 2) {
            costo = 4300000;
        } else if (niño.edad >= 3 && niño.edad <= 4) {
            costo = 3900000;
        } else if (niño.edad == 5) {
            costo = 3500000;
        }

        // Aplicar descuento si hay hermanos
        if (niño.numHermanos == 1) {
            costo *= 0.85; // Aplicar descuento del 15%
        } else if (niño.numHermanos >= 2 && niño.numHermanos <= 4) {
            costo *= (1 - (0.05 * niño.numHermanos)); // Aplicar descuento del 5% por cada hermano
        }

        return costo;
    }

    // Clase para representar a un niño
    static class Niño {
        String nombre;
        int edad;
        int numHermanos;

        public Niño(String nombre, int edad, int numHermanos) {
            this.nombre = nombre;
            this.edad = edad;
            this.numHermanos = numHermanos;
        }
    }
}
