package com.programacion.distribuida.customers.clients;
import com.programacion.distribuida.customers.dtos.BookDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;
import jakarta.ws.rs.Path;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient(baseUri = "stork://books-api")
public interface BookRestClient {

    @GET
    @Path("/{id}")
    List<BookDto> findByIsbn(@PathParam("id") Integer id);
}
