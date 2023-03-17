package cat.itacademy.barcelonactiva.basilicata.paolo.s05.t01.n01.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.basilicata.paolo.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.basilicata.paolo.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.basilicata.paolo.s05.t01.n01.model.repository.SucursalRepository;

@Service
public class SucursalsServiceImpl implements ISucursalService{

	@Autowired
	SucursalRepository sucursalRepository;
	
	
	@Override
	public void addSucursal(Sucursal sucursal) {
		// TODO Auto-generated method stub
		sucursalRepository.save(sucursal);
	}

	@Override
	public Sucursal updateSucursal(Sucursal sucursal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSucursal(int id) {
		sucursalRepository.deleteById(id);
		
	}

	@Override
	public SucursalDTO getScucursalById(int id) {
		// TODO Auto-generated method stub
		Optional<Sucursal> sucursal = sucursalRepository.findById(id);
		SucursalDTO sucursalDTO = new SucursalDTO();
		if(sucursal.isPresent()) {
			sucursalDTO.setPk_SucursalId(sucursal.get().getPk_SucursalId());
			sucursalDTO.setNomSucursal(sucursal.get().getNomSucursal());
			sucursalDTO.setPaisScursal(sucursal.get().getPaisScursal());
			sucursalDTO.setTipusSucursal(sucursalDTO.isUE(sucursal.get().getPaisScursal()));
		}
		return sucursalDTO;
	}

//	@Override
//	public List<Sucursal> getSucursals() {
//		// TODO Auto-generated method stub
//		return (List<Sucursal>) sucursalRepository.findAll();
//	}
	
	@Override
	public List<SucursalDTO> getSucursals() {
		// TODO Auto-generated method stub
		List<Sucursal> sucursals = (List<Sucursal>) sucursalRepository.findAll();
		List<SucursalDTO> sucursalsDto = new ArrayList<>();
		for (Sucursal suc : sucursals) {
			SucursalDTO sucDTO = new SucursalDTO();
			sucDTO.setPk_SucursalId(suc.getPk_SucursalId());
			sucDTO.setNomSucursal(suc.getNomSucursal());
			sucDTO.setPaisScursal(suc.getPaisScursal());
			sucDTO.setTipusSucursal(sucDTO.isUE(suc.getPaisScursal()));
			sucursalsDto.add(sucDTO);
		}
		return sucursalsDto;
	}

}
