import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Gara{
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Inserisci la lunghezza del percorso in metri: ");
            int lunghezzaPercorso = scanner.nextInt();
            scanner.nextLine();
            
            
            System.out.print("Inserisci i nomi dei cavalli (separati da una virgola): ");
            String[] nomiCavalli = scanner.nextLine().split(",");
            
            
            List<Cavalli> cavalli = new ArrayList<>();
            for (String nome : nomiCavalli) {
                nome = nome.trim();
                cavalli.add(new Cavalli(nome, lunghezzaPercorso));
            }
            
            System.out.println("La gara inizia!");
            
            
            for (Cavalli cavallo : cavalli) {
                cavallo.start();
            }
            
            for (Cavalli cavallo : cavalli) {
                try {
                    cavallo.join();
                } catch (InterruptedException e) {
                }
            }
            
            System.out.println("\n--- La gara è terminata! ---");
        }
    }
}
