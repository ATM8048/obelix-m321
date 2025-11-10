package ch.bbw.obelix.webshop.service;

import ch.bbw.obelix.quarry.api.QuarryApi;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpExchangeAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Service
public class QuarryWebClientService {

    private final QuarryApi quarryApi;

    public QuarryWebClientService() {
        WebClient webClient = WebClient.builder().baseUrl("http://localhost:8081").build();
        WebClientAdapter adapter = WebClientAdapter.create(webClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        this.quarryApi = factory.createClient(QuarryApi.class);
    }

    public QuarryApi api() {
        return quarryApi;
    }
}
