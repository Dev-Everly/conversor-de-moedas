package service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.Moeda;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorService {

    public Double converter(Moeda moeda) throws URISyntaxException {
        try {



            URI endereco = URI.create("https://v6.exchangerate-api.com/v6/ee1772f4b3c6608c4cb16992/latest/" + moeda.origem());


            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(endereco)
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());




            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

            if(rates != null && rates.has(moeda.destino())) {
                double taxa = rates.get(moeda.destino()).getAsDouble();
                return moeda.valor() * taxa;
            }else {
                System.out.println("Moeda  não encontrada");
                return null;
            }



        } catch (IOException | InterruptedException  e) {
            System.out.println("Erro ao acessar API " +  e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
        return null;
    }
}
