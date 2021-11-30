package gr.kantasni.aigordiscarental.services.admin;

import gr.kantasni.aigordiscarental.services.admin.requests.ContentDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Nikos Kantas (kantasni)
 */
@Setter
@Getter
public class CreateContentRequest {

    private String entityType;

    private ContentDTO contentDTO;
}
