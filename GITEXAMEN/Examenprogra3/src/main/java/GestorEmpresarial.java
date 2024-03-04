import java.util.Random;

public class GestorEmpresarial {

    public static void main(String[] args) {
        Random random = new Random();
        
        // Definir matrices para las industrias
        double[][] camaraIndustria = new double[5][4];
        double[][] camaraConstruccion = new double[5][4];
        double[][] camaraTransporte = new double[5][4];
        
        // Llenar las matrices con montos de ventas aleatorios
        llenarMatriz(camaraIndustria, random);
        llenarMatriz(camaraConstruccion, random);
        llenarMatriz(camaraTransporte, random);
        
        // Mostrar los datos de las industrias
        System.out.println("Datos de la Cámara de Industria:");
        mostrarDatos(camaraIndustria);
        System.out.println("Datos de la Cámara de Construcción:");
        mostrarDatos(camaraConstruccion);
        System.out.println("Datos de la Cámara de Transporte:");
        mostrarDatos(camaraTransporte);
        
        // Calcular promedios y encontrar la mejor industria
        double[] promediosIndustria = calcularPromedios(camaraIndustria);
        double[] promediosConstruccion = calcularPromedios(camaraConstruccion);
        double[] promediosTransporte = calcularPromedios(camaraTransporte);
        
        // Encontrar la mejor industria
        String mejorIndustria = encontrarMejorIndustria(promediosIndustria, promediosConstruccion, promediosTransporte);
        
        // Mostrar los resultados
        System.out.println("La mejor industria es: " + mejorIndustria);
        System.out.println("Promedio de ventas de la mejor industria: Q" + obtenerPromedioMejorIndustria(mejorIndustria, promediosIndustria, promediosConstruccion, promediosTransporte));
    }
    
    // Método para llenar la matriz con montos de ventas aleatorios
    public static void llenarMatriz(double[][] matriz, Random random) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = 1000000 * random.nextDouble();
            }
        }
    }
    
    // Método para mostrar los datos de la matriz de una industria
    public static void mostrarDatos(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Empresa " + (i+1) + ":");
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("  Año " + (2015 + j) + ": Q" + matriz[i][j]);
            }
        }
    }
    
    // Método para calcular los promedios de ventas de una industria
    public static double[] calcularPromedios(double[][] matriz) {
        double[] promedios = new double[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            double sum = 0;
            for (int j = 0; j < matriz[0].length; j++) {
                sum += matriz[i][j];
            }
            promedios[i] = sum / matriz[0].length;
        }
        return promedios;
    }
    
    // Método para encontrar la mejor industria
    public static String encontrarMejorIndustria(double[] promediosIndustria, double[] promediosConstruccion, double[] promediosTransporte) {
        double mejorPromedio = 0;
        String mejorIndustria = "";
        
        double promedioIndustria = calcularPromedio(promediosIndustria);
        double promedioConstruccion = calcularPromedio(promediosConstruccion);
        double promedioTransporte = calcularPromedio(promediosTransporte);
        
        if (promedioIndustria > mejorPromedio) {
            mejorPromedio = promedioIndustria;
            mejorIndustria = "Cámara de Industria";
        }
        if (promedioConstruccion > mejorPromedio) {
            mejorPromedio = promedioConstruccion;
            mejorIndustria = "Cámara de Construcción";
        }
        if (promedioTransporte > mejorPromedio) {
            mejorPromedio = promedioTransporte;
            mejorIndustria = "Cámara de Transporte";
        }
        
        return mejorIndustria;
    }
    
    // Método para calcular el promedio de una lista de promedios
    public static double calcularPromedio(double[] promedios) {
        double sum = 0;
        for (double promedio : promedios) {
            sum += promedio;
        }
        return sum / promedios.length;
    }
    
    // Método para obtener el promedio de ventas de la mejor industria
    public static double obtenerPromedioMejorIndustria(String mejorIndustria, double[] promediosIndustria, double[] promediosConstruccion, double[] promediosTransporte) {
        double promedio = 0;
        if (mejorIndustria.equals("Cámara de Industria")) {
            promedio = calcularPromedio(promediosIndustria);
        } else if (mejorIndustria.equals("Cámara de Construcción")) {
            promedio = calcularPromedio(promediosConstruccion);
        } else if (mejorIndustria.equals("Cámara de Transporte")) {
            promedio = calcularPromedio(promediosTransporte);
        }
        return promedio;
    }
}

