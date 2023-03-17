package cat.itacademy.barcelonactiva.basilicata.paolo.s05.t01.n01.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Sucursal")
public class Sucursal {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pk_SucursalId;
	@Column(name = "nom_sucursal", length = 50, nullable = true)
	private String nomSucursal;
	@Column(name = "pais_sucursal", length = 50)
	private String paisScursal;
	public String getNomSucursal() {
		return nomSucursal;
	}
	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}
	public String getPaisScursal() {
		return paisScursal;
	}
	public void setPaisScursal(String paisScursal) {
		this.paisScursal = paisScursal;
	}
	public int getPk_SucursalId() {
		return pk_SucursalId;
	}
	
	public void setPk_SucursalId(int pk_SucursalId) {
		this.pk_SucursalId = pk_SucursalId;
	}
	public Sucursal(String nomSucursal, String paisScursal) {
		super();
		this.nomSucursal = nomSucursal;
		this.paisScursal = paisScursal;
	}
	
	
	public Sucursal(int pk_SucursalId, String nomSucursal, String paisScursal) {
		super();
		this.pk_SucursalId = pk_SucursalId;
		this.nomSucursal = nomSucursal;
		this.paisScursal = paisScursal;
	}
	public Sucursal() {
		
	}
	@Override
	public String toString() {
		return "Sucursal [pk_SucursalId=" + pk_SucursalId + ", nomSucursal=" + nomSucursal + ", paisScursal="
				+ paisScursal + "]";
	}
	
	
	
	
	

}
