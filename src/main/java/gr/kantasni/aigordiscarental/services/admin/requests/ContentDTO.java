package gr.kantasni.aigordiscarental.services.admin.requests;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Nikos Kantas (kantasni)
 */
@Setter
@Getter
public class ContentDTO {

    private String language;

    private String text;

    private Long entityId;
}
