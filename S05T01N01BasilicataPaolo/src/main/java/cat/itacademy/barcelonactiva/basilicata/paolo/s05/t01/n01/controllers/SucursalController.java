package cat.itacademy.barcelonactiva.basilicata.paolo.s05.t01.n01.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import cat.itacademy.barcelonactiva.basilicata.paolo.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.basilicata.paolo.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.basilicata.paolo.s05.t01.n01.model.services.SucursalsServiceImpl;

@Controller
@RequestMapping("/sucursal")
public class SucursalController {
	
	@Autowired
	SucursalsServiceImpl sucursalsServiceImpl;
	
	
	@GetMapping("/add")
	public String addSucursal(Model model) {
		Sucursal sucursal = new Sucursal();
		model.addAttribute("title", "Crea nova sucursal");
		model.addAttribute("sucursal", sucursal);
		return "views/add";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Sucursal sucursal, Model model) {
		try {
			sucursalsServiceImpl.addSucursal(sucursal);
			return "redirect:/sucursal/getAll";
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", "Internal Server Error - 500");
			return "/errors/error";
		}
	}
	
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") int id, Model model) {
		try {
			SucursalDTO sucursal = sucursalsServiceImpl.getScucursalById(id);
			model.addAttribute("sucursal", sucursal);
			return "views/add";
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", "Resource Not Found Error - 404");
			return "/errors/error";
		}
		
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) {
		try {
			sucursalsServiceImpl.deleteSucursal(id);
			return "redirect:/sucursal/getAll";
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", "Resource Not Found Error - 404");
		}
		return "/errors/error";
	}
	
	@GetMapping("/getOne/{id}")
	public String getOne(@PathVariable("id")int id, Model model) {
		try {
			SucursalDTO sucursalDTO = sucursalsServiceImpl.getScucursalById(id);
			model.addAttribute("title", "Detalle Sucursal");
			model.addAttribute("sucursal", sucursalDTO);
			return "/views/item";
			
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error", "Resource Not Found Error - 404");
			return "/errors/error";
		}
	}
	
	
	
	@GetMapping("/getAll")
	public String getAll(Model model) {
		List<SucursalDTO> sucursalsDto = sucursalsServiceImpl.getSucursals();
		model.addAttribute("title", "Llista sucursals");
		model.addAttribute("sucursals", sucursalsDto);
		return "views/items";
	}

}
