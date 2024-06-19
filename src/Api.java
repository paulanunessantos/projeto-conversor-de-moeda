import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {

    public Moeda converte(Consulta consulta) {
        String url = "https://v6.exchangerate-api.com/v6/8362d2fc388bc2487d584c7f" +
        "/pair/" + consulta.getMoedaBase() + "/" + consulta.getMoedaAlvo() + "/" + consulta.getValorBase();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Moeda.class);

        } catch (Exception e) {
            throw new RuntimeException("Não foi possível realizar a conversão.");
        }
    }
}
