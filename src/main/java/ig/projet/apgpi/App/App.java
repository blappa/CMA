package ig.projet.apgpi.App;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Entities.Autorisation;
import ig.projet.apgpi.Entities.Magazin;
import ig.projet.apgpi.Entities.Materiel;
import ig.projet.apgpi.Entities.Personnel;
import ig.projet.apgpi.Entities.Service;
import ig.projet.apgpi.Service.IServiceAutorisation;
import ig.projet.apgpi.Service.IServiceMagazin;
import ig.projet.apgpi.Service.IServiceMateriel;
import ig.projet.apgpi.Service.IServicePersonnel;
import ig.projet.apgpi.Service.IServiceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
     private static IServiceAutorisation IserviceAutorisation;
     private static IServiceMateriel iServiceMateriel;
     private static IServicePersonnel iServicePersonnel;
     private static IServiceService iServiceService;
     private static IServiceMagazin iServiceMagazin;
     
    public static void main( String[] args ) throws DataAccessException
    {
          //initialisation de l'interface
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-config.xml");
        IserviceAutorisation=(IServiceAutorisation)ctx.getBean("serviceAdmin");
        iServicePersonnel=(IServicePersonnel)ctx.getBean("servicePersonnel");
        iServiceMateriel=(IServiceMateriel)ctx.getBean("serviceMateriel");
        iServiceService=(IServiceService)ctx.getBean("serviceService");
        iServiceMagazin=(IServiceMagazin)ctx.getBean("serviceMagazin");
        
//        Autorisation auth = IserviceAutorisation.getAutorisationByLogin("Lappa Bertrick");
//        System.out.println(auth.toString());
                Service ser=new Service("secretariat", "SER");
        iServiceService.createService(ser);
                Service ser1=new Service("sec", "S");
        iServiceService.createService(ser1);
        
        Service s=iServiceService.findById(1L);
        iServiceService.deleteService(s.getId());

//        Service ser=new Service("secretariat", "SER");
//        iServiceService.createService(ser);
//        
//        Personnel p = new Personnel("lappa", null, null,null, ser, null);
//        iServicePersonnel.SavePersonnel(p);
//        Autorisation a = new Autorisation(p, "admin","admin", "ROLE_ADMIN",true);
//        IserviceAutorisation.enregistrerNouveauLogin(a);
//        
//         Personnel p1 = new Personnel("lateu", null, null,null, ser, null);
//        iServicePersonnel.SavePersonnel(p1);
//        Autorisation a1 = new Autorisation(p1, "lat","lateu", "ROLE_COM",true);
//        IserviceAutorisation.enregistrerNouveauLogin(a1);
//        
//         Materiel m = new Materiel("imprimante", null, null, null, null, null, null, null, null, null, null, null, null, null, p);
//         iServiceMateriel.enregistrerNouveauMateriel(m);
////         
//         Materiel m1 = new Materiel("ordi", null, null, null, null, null, null, null, null, null, null, null, null, null, null);
//         iServiceMateriel.enregistrerNouveauMateriel(m1);
//         
//          Materiel m2 = new Materiel("laptop", null, null, null, null, null, null, null, null, null, null, null, null, null, null);
//         iServiceMateriel.enregistrerNouveauMateriel(m2);
////         
//         Magazin ma=new Magazin(null,10l, null);
//         iServiceMagazin.create(ma);
//         Magazin ma1=new Magazin(null,10l, m2);
//        iServiceMagazin.create(ma1);
//        
//        Materiel mo= iServiceMateriel.getMaterielById(1l);
//        iServiceMateriel.delete(mo);
//                Magazin m= iServiceMagazin.findById(1L);
//        iServiceMagazin.deletem(m.getIdStock());
         
//        if(IserviceAutorisation.identifierLogin("lappa bertrick")){
//        System.out.println("true");
//        }
    }
}
   
