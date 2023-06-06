package com.userservice.userservice.config.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Component;

@Component
@Configuration
@RequiredArgsConstructor
public class FeignClientInterceptor implements RequestInterceptor {
    private final OAuth2AuthorizedClientManager clientManager;

    @Override
    public void apply(RequestTemplate template) {
      String token=clientManager.authorize(OAuth2AuthorizeRequest.withClientRegistrationId("my-internal-client").principal("internal").build()).getAccessToken().getTokenValue();
        template.header("Authorization","Bearer "+token);
    }
}
