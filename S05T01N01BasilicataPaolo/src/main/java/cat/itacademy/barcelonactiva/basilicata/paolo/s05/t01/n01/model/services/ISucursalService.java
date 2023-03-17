package cat.itacademy.barcelonactiva.basilicata.paolo.s05.t01.n01.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import cat.itacademy.barcelonactiva.basilicata.paolo.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.basilicata.paolo.s05.t01.n01.model.dto.SucursalDTO;

@Component
public interface ISucursalService {
	
	public void addSucursal(Sucursal sucursal);
	public Sucursal updateSucursal(Sucursal sucursal);
	public void deleteSucursal(int id);
	public SucursalDTO getScucursalById(int id);
	public List<SucursalDTO> getSucursals();

}
