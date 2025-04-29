import controller.ConversorController;
import model.Moeda;

import java.net.URISyntaxException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        String resposta = " ";
        do {


            ConversorController conversorController = new ConversorController();

            System.out.println("Qual moeda deseja converter (ex: BRL,USD: )");
            String origem = scanner.nextLine().toUpperCase();

            System.out.println("Para qual moeda realizar conversão (ex: BRL)");
            String destino = scanner.nextLine().toUpperCase();

            System.out.println("Qual valor deseja converte (ex:20.55)");
            Double valor = scanner.nextDouble();
            scanner.nextLine();

            conversorController.realizarConversao(origem, destino, valor);

            System.out.println("Deseja converter mais moedas? s/n");
            resposta = scanner.nextLine();

        }while (resposta.equalsIgnoreCase("s"));
        scanner.close();

        System.out.println("Programa Finalizado");


    }
}

