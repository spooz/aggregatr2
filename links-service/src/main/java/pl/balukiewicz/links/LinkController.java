package pl.balukiewicz.links;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/links")
class LinkController {

    private LinkService linkService;

    LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/{id}")
    ResponseEntity<Link> getById(@PathVariable Long id) {
        return ResponseEntity.ok(linkService.findById(id));
    }


    //TODO: DTO?
    @PostMapping
    ResponseEntity<String> create(@Valid @RequestBody LinkForm link) {
        return ResponseEntity.ok(
                linkService.create(link.getName(), link.getHref(), link.getOwner())
                .getId());
    }

    @ExceptionHandler(LinkNotFoundException.class)
    ResponseEntity<Void> handleLinkNotFoundException(LinkNotFoundException e) {
        return ResponseEntity.badRequest().build();
    }


}
