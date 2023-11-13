package org.acme;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;


@Named("buttonBasicView")
@RequestScoped
@Path("plaques")
public class Enregistrer {
	
private String text;


        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
        
        /*@Inject
    	EntityManager entityManager;
        @Transactional
        public void enregistrer() {
        	// Afficher la valeur dans la console action="#{buttonBasicView.enregistrer()}"
        	Date date = new Date();
        	Plaque plaque = new Plaque();
        	
        	plaque.numero = text;
    		plaque.identifiant = UUID.randomUUID().toString();
    		plaque.date = date ;
    		
    		entityManager.persist(plaque);
    		
        }*/
        
        
        @org.eclipse.microprofile.rest.client.inject.RestClient
		@Inject
        RestClient plaquesService;
        
        public void enregistrer() {
        	
            // Appelez la méthode du client REST pour enregistrer une plaque
            String plaque = text;
            Response response = plaquesService.savePlaque(plaque);
            info();
            // Affichez la réponse
            System.out.println("Réponse de l'API : " + response);
        	System.out.println("Success");
        }
        public void info() {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Message Content"));
        }
}

