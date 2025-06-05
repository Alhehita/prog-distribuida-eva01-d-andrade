package com.programacion.distribuida.customers.rest;

import com.programacion.distribuida.customers.clients.BookRestClient;
import com.programacion.distribuida.customers.db.Customers;
import com.programacion.distribuida.customers.dtos.BookDto;
import com.programacion.distribuida.customers.dtos.CurstomerDto;
import com.programacion.distribuida.customers.repo.CustomersRepository;
import io.smallrye.mutiny.Uni;
import io.smallrye.stork.Stork;
import io.smallrye.stork.api.Service;
import io.smallrye.stork.api.ServiceInstance;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.modelmapper.ModelMapper;

import java.util.Map;

@Path("/customers")
//@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Transactional
public class CustomerRest {

    @Inject
    CustomersRepository customersRepository;
    @Inject
    ModelMapper mapper;

    @Inject
    @RestClient
    private BookRestClient client;


    @Path("/{id}")
    @GET
    public Response findById(@PathParam("id") Integer id) {

        var stork = Stork.getInstance();

        Service service = stork.getService("books-api");
        Uni<ServiceInstance> instance = service.selectInstance();
        instance
                .subscribe()
                .with(inst -> {
                    System.out.println("**Instancia seleccionada: " + inst.getHost() + ":" + inst.getPort());
                });

        CurstomerDto ret = new CurstomerDto();

        //1. buscar el cliente
        var obj = customersRepository.findByIdOptional(id);
        if(obj.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        mapper.map(obj.get(), ret);
        var books = client.findByIsbn(id)
                .stream().map(BookDto::getIsbn)
                .toList();
        ret.setBooks(books);

        return Response.ok(ret)
                .build();
    }


}
