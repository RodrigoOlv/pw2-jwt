package dev.ifrs;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.oidc.token.propagation.AccessToken;

@RegisterRestClient(baseUri = "https://localhost:8444/backend")
@AccessToken
public interface BackendClient {
    
    @POST
    @Path("/sum")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed({ "User"})
    public int sum(@FormParam("a") int a, @FormParam("b") int b);
}
