package gr.kantasni.aigordiscarental.services.admin;

import gr.kantasni.aigordiscarental.repositories.LanguageRepository;
import gr.kantasni.aigordiscarental.repositories.TraitRepository;
import gr.kantasni.aigordiscarental.repositories.TraitTypeRepository;
import gr.kantasni.aigordiscarental.responces.admin.AdminTraitResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Nikos Kantas (kantasni)
 */
@Service
public class AdminService {

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private TraitRepository traitRepository;

    @Autowired
    private TraitTypeRepository traitTypeRepository;

    public AdminTraitResponse getTraitInformation(Long traitTypeId) {

        return new AdminTraitResponse(languageRepository.findAll(),
            traitRepository.findByTypeId(traitTypeId));
    }
}
