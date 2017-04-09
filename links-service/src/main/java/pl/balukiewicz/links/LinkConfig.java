package pl.balukiewicz.links;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LinkConfig {

    @Bean
    LinkService linkService(LinkRepository linkRepository) {
        return new LinkService(linkRepository);
    }
}
