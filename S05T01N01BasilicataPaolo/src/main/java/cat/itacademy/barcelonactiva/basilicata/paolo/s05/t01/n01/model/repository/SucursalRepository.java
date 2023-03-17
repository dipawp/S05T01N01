package cat.itacademy.barcelonactiva.basilicata.paolo.s05.t01.n01.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import cat.itacademy.barcelonactiva.basilicata.paolo.s05.t01.n01.model.domain.Sucursal;

@Component
public interface SucursalRepository extends CrudRepository<Sucursal, Integer>{

}
