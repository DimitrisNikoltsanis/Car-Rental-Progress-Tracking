package gr.kantasni.aigordiscarental.services.admin;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nikos Kantas (kantasni)
 */
@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BeanFactory beanFactory;

    @PostMapping("/create/content")
    public void createContent(@RequestBody CreateContentRequest request){
        beanFactory.getBean(request.getEntityType(),AdminContentService.class)
            .createContent(request.getContentDTO());
    }
}
