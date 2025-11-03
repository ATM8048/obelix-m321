package ch.bbw.obelix.webshop.service;

import ch.bbw.obelix.quarry.api.QuarryApi;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

public class QuarryWebClientService {

    private final QuarryApi quarryApi;

    public QuarryWebClientService(String baseUrl) {
        WebClient webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder()
                .build();

        this.quarryApi = factory.createClient(QuarryApi.class);
    }

    public QuarryApi api() {
        return quarryApi;
    }
}
