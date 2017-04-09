package pl.balukiewicz.links;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document
@Data
class Link {

    @Id
    private String id;

    @NotNull
    @Length(max = 20)
    private String name;

    @NotNull
    private String href;

    @NotNull
    private String owner;


}
