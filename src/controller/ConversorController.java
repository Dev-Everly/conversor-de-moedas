package controller;

import model.Moeda;
import service.ConversorService;

import java.net.URISyntaxException;

public class ConversorController {
     private final ConversorService conversorService = new ConversorService();

     public void realizarConversao(String origem,String destino,double valor) throws URISyntaxException {
         Moeda moeda = new Moeda(origem,destino,valor);
         Double resultado = conversorService.converter(moeda);

         if(resultado != null) {
             String linha = String.format("%s %.2f = %s %.2f", origem, valor, destino, resultado);
             System.out.println(linha);
         }else {
             System.out.println("Erro na conversão. Verifique os dados");
         }
     }
}
