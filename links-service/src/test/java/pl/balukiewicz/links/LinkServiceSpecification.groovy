import pl.balukiewicz.links.Link
import pl.balukiewicz.links.LinkNotFoundException
import pl.balukiewicz.links.LinkService
import spock.lang.Specification

class LinkServiceSpecification extends Specification {

    def linkService;
    def linkRepositoryMock;

    def setup() {
        linkRepositoryMock = Mock(pl.balukiewicz.links.LinkRepository);
        linkService = new LinkService(linkRepositoryMock);
    }

    def "shouldFindLinkById"() {
        given:
            linkRepositoryMock.findById(1L as Long) >> {
                Optional.of(new Link(id: 1L));
            }

        when:
            def linkReturn = linkService.findById(1L);

        then:
            new Long(linkReturn.getId()) == new Long(1L);

    }

    def "shouldThrowLinkNotFoundExceptionWhenLinkNotFound"() {
        given:
            linkRepositoryMock.findById(_ as Long) >> {
                Optional.empty();
            }

        when:
            linkService.findById(1L);

        then:
            thrown(LinkNotFoundException);
    }

    def "shouldCreateLinkWithRandomUUID"() {
        def testLink;
        given:
            def name = "testName";
            def href = "testHref";
            def owner = "testOwner";

        when:
            def linkReturn = linkService.create(name, href, owner);

        then:
            1 * linkRepositoryMock.save(_) >> {arguments -> testLink = arguments[0]}
            testLink.getName() == name;
            testLink.getHref() == href;
            testLink.getOwner() == owner;
            testLink.getId() != null;


    }


}