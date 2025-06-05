package com.programacion.distribuida.customers.repo;

import com.programacion.distribuida.customers.db.Customers;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CustomersRepository implements PanacheRepositoryBase<Customers, Integer> {

    public void update(Integer id, Customers customers) {
        this.findByIdOptional(id)
                .ifPresent(existingCustomer -> {
                    existingCustomer.setName(customers.getName());
                    existingCustomer.setEmail(customers.getEmail());
                    existingCustomer.setVersion(existingCustomer.getVersion()+1);
                });
    }
}
