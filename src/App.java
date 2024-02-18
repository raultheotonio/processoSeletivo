import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) {
        String[] candidatos = {
                "Felipe",
                "Maria",
                "Joao",
                "Renato",
                "Fabiana"
        };

        for (String cand: candidatos) {
            entrandoEmContato(cand);
        }
    }

    static void entrandoEmContato(String candidato) {
        int tentativas = 1;
        boolean continarTentando = true;
        boolean atendeu=false;
        do {
            atendeu = atender();
            continarTentando = !atendeu;
            if(continarTentando) tentativas++;
            else System.out.println("Contato Realizado com sucesso!");

        }while (continarTentando && tentativas < 3);

        if(atendeu)
            System.out.println("Conseguimos contatos!");
        else
            System.out.println("Não conseguimos contatos!");
    }

    static boolean atender() {
        return new Random().nextInt(3) ==1;
    }

    static void imprimirSelecionados(){
        String[] candidatos = {
                "Felipe",
                "Maria",
                "Joao",
                "Renato",
                "Fabiana"
        };

        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de número "+ (indice + 1)+" é "+ candidatos[indice]);
        }
    }
    static void selecaoCandidatos() {
        String[] candidatos = {
                "Felipe",
                "Maria",
                "Joao",
                "Renato",
                "Fabiana"
        };

        int candSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while(candSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O Candidato " + candidato + " Solicitou este valor de salário");
            if(salarioBase >= salarioPretendido) {
                System.out.println("O candidato "+ candidato + " foi selecionado para a vaga");
                candSelecionados++;
            }
            candidatosAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        }else if(salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidado com contra proposta");
        }else {
            System.out.println("Aguardando o resultado dos demais candidados");
        }
    }
}