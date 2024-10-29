

import java.util.Random;

class Cavalli extends Thread {
    private final String nome;
    private final int lunghezzaPercorso;
    private int distanzaPercorsa = 0;
    private static final Random random = new Random();

    public Cavalli(String nome, int lunghezzaPercorso) {
        this.nome = nome;
        this.lunghezzaPercorso = lunghezzaPercorso;
    }

    @Override
    public void run() {
        while (distanzaPercorsa < lunghezzaPercorso) {
       
            int passo = random.nextInt(10) + 1;
            distanzaPercorsa += passo;

      
            if (distanzaPercorsa > lunghezzaPercorso) {
                distanzaPercorsa = lunghezzaPercorso;
            }

   
            System.out.println("Cavallo " + nome + ": " + distanzaPercorsa + "/" + lunghezzaPercorso + " metri percorsi.");

     
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Cavallo " + nome + " ha raggiunto il traguardo!");
    }
}
