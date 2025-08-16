package henrotaym.env.shared.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {
  @Bean
  public RestClient swapiRestClient(RestClient.Builder builder) {
    return builder.baseUrl("https://swapi-node.vercel.app/api").build();
  }
}
