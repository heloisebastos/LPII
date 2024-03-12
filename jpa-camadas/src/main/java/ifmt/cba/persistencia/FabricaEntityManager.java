package ifmt.cba.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

//classe responsavel por criar e retornar uma instancia do objeto EntityManager, usado p/ a manipulação das entidades de persistencia
// responsavel tambem por criar o contexto persistencia a partir da unidade persistencia conf. no arquivo xml
public class FabricaEntityManager {
    private static EntityManagerFactory emf;

    static{
        emf = Persistence.createEntityManagerFactory("JPACamadas");
    }
    
    
    private FabricaEntityManager(){

    }

    public static EntityManager getEntityManager(){
        if(emf == null){
            return null;
        }else{
            return emf.createEntityManager();
        }
    }
}