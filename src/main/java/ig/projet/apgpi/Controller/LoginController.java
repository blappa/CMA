package ig.projet.apgpi.Controller;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Entities.Autorisation;
import ig.projet.apgpi.Service.IServiceAutorisation;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@ManagedBean(name = "log")
@SessionScoped
@Controller
public class LoginController implements Serializable {

    ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-config.xml");
    private IServiceAutorisation administration=(IServiceAutorisation)ctx.getBean("serviceAdmin");
    
    private static String nom;
    
    private String name;

    public LoginController() {
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) throws DataAccessException {
/*
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        name = user.getUsername();
         
        Autorisation a=administration.getAutorisationByLogin(name);
        nom=a.getPersonnel().getNom()+" "+a.getPersonnel().getPrenom();
        model.addAttribute("username", nom);

        List<Autorisation>  cc =administration.getAutorisation();
        for (Autorisation au : cc) {
            if (au.getUsername().equals(name)) {
                if (au.getAuthority().equals("ROLE_ADMIN")) {
                    return "/pages/administration/superUser";
                }
                if (au.getAuthority().equals("ROLE_COM")) {
                    return "/pages/administration/comptableMatiere";
                }
                if (au.getAuthority().equals("ROLE_CHAR")) {
                    return "/pages/administration/chargerMaintenance";
                }
                if (au.getAuthority().equals("ROLE_USER")) {
                    return "/pages/administration/personnel";
                }
            }
        }
        return null;*/
                return "/pages/administration/superUser";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {

        return "index";

    }

    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {

        model.addAttribute("error", "true");
        //return "index";
        return "/pages/administration/superUser";

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        name = null;
        return "index";

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ApplicationContext getCtx() {
        return ctx;
    }

    public void setCtx(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    public static String getNom() {
        return nom;
    }

    public static void setNom(String nom) {
        LoginController.nom = nom;
    }
    
    public IServiceAutorisation getAdministration() {
        return administration;
    }

    public void setAdministration(IServiceAutorisation administration) {
        this.administration = administration;
    }
    
    
}