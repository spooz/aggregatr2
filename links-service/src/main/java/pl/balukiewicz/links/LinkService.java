package pl.balukiewicz.links;


import java.util.UUID;

class LinkService {

    private LinkRepository linkRepository;

    LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    Link findById(Long linkId) {
      return linkRepository.findById(linkId).orElseThrow(() -> new LinkNotFoundException());
    }

    String create(Link link) {
        link.setId(UUID.randomUUID().toString());
        return linkRepository.save(link).getId();
    }
}
