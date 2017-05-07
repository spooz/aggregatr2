package pl.balukiewicz.links;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
class LinkForm {

    @NotEmpty
    private String name;

    @NotEmpty
    private String href;

    @NotEmpty
    private String owner;
}
