package cat.itacademy.barcelonactiva.basilicata.paolo.s05.t01.n01.model.dto;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.util.Strings;

import cat.itacademy.barcelonactiva.basilicata.paolo.s05.t01.n01.model.domain.Sucursal;

public class SucursalDTO extends Sucursal{
	
	private List<String> paisosUE = Arrays.asList("alemania","bélgica","croacia","dinamarca","españa", 
			"francia","irlanda","letonia","luxemburgo","países bajos","suecia","bulgaria","eslovaquia","estonia", 
			"grecia","malta","polonia","república checa","austria","chipre","eslovenia","finlandia","hungría", 
			"italia","lituania","portugal","rumanía");
	

	private String tipusSucursal;

	public String getTipusSucursal() {
		return tipusSucursal;
	}

	public void setTipusSucursal(String tipusSucursal) {
		this.tipusSucursal = tipusSucursal;
	}
	
	
	
	public SucursalDTO(int pk_SucursalId, String nomSucursal, String paisScursal, String tipusSucursal) {
		//super(pk_SucursalId, nomSucursal, paisScursal);
		// TODO Auto-generated constructor stub
		super(pk_SucursalId, nomSucursal, paisScursal);
		this.tipusSucursal = tipusSucursal;
	}


	public SucursalDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String isUE(String pais) {
		String result = "UE";
		if(Strings.isNotEmpty(pais)) {
			if (!paisosUE.contains(pais.toLowerCase())) {
			    result = "Fora UE";
		    }
		}
	    
		return result;
	}
	
}
