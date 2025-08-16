package henrotaym.env.shared.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

  @Bean
  public RestClient swapiRestClient(
      @Value("${swapi.base-url}") String baseUrl, RestClient.Builder builder) {
    return builder.baseUrl(baseUrl).build();
  }
}
