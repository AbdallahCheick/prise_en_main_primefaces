package org.acme;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/liste")
@RegisterRestClient(baseUri = "http://host.docker.internal:8081/plaques")
public interface RestList {

    @GET
    @Produces(MediaType.APPLICATION_JSON) 
    List<PlaqueDto> liste();
}
