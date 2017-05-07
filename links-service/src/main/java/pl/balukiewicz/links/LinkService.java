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

    Link create(String name, String href, String owner) {
        Link link = new Link();
        link.setName(name);
        link.setHref(href);
        link.setOwner(owner);
        link.setId(UUID.randomUUID().toString());
        return linkRepository.save(link);
    }
}
