package gr.kantasni.aigordiscarental.requests.admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Nikos Kantas (kantasni)
 */
@Setter
@Getter
@AllArgsConstructor
public class CreateTraitRequest {

    private String language;

    private String text;

    private Long traitTypeId;
}
