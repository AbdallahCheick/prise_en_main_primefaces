package org.acme;

import java.io.Serializable;
import java.util.List;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.primefaces.PrimeFaces;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("dtBasicView")
@ViewScoped
public class ListGlobal implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @RestClient
	@Inject
    private RestList service;
    
    private List<PlaqueDto> plaques;
    
    @PostConstruct
    public void init() {
        plaques = service.liste();
        // Affichez les données récupérées à des fins de débogage
        for (PlaqueDto plaque : plaques) {
            System.out.println("ID: " + plaque.getId());
            System.out.println("Plaque: " + plaque.getValue());
            System.out.println("Date: " + plaque.getDate());
        }
    }

    public List<PlaqueDto> getPlaques() {
        return plaques;
    }

}
