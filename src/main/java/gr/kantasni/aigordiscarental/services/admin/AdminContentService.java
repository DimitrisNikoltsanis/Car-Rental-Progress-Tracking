package gr.kantasni.aigordiscarental.services.admin;

import gr.kantasni.aigordiscarental.services.admin.requests.ContentDTO;

/**
 * @author Nikos Kantas (kantasni)
 */
public interface AdminContentService {

    void createContent(ContentDTO contentDTO);

    void deleteContent(ContentDTO contentDTO);
}
