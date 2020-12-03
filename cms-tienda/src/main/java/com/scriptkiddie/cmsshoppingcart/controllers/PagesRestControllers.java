package com.scriptkiddie.cmsshoppingcart.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.scriptkiddie.cmsshoppingcart.models.PageRestRepository;
import com.scriptkiddie.cmsshoppingcart.models.data.Page;



@RestController
@RequestMapping(path = "/pages", produces = "application/json")
public class PagesRestControllers {
	
	@Autowired
	PageRestRepository pageRepo;
	
	@GetMapping("/all")
	public Iterable<Page> pages() {
		List <Page> pages = pageRepo.findAllByOrderBySortingAsc();
		return pages;
	}
	
	@GetMapping("/{id}")
	public Page page(@PathVariable int id){
		List<Page> paginas = pageRepo.findAll();
		Page pagina = new Page();
		for (int i = 0; i < paginas.size(); i++) {
			if(paginas.get(i).getId() == id) {
				pagina = paginas.get(i);
			}
		}
		return pagina;
	}
	
	@PostMapping(path = "/add", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Page add(@RequestBody Page page) {
		return pageRepo.save(page);
	}
	
	@GetMapping("/edit/{id}")
	public Optional<Page> edit(@PathVariable int id){
		Optional<Page> page = pageRepo.findById(id);
		
		return page;
	}
	
	@PutMapping("/edit")
	public Page put(@RequestBody Page page) {
		return pageRepo.save(page);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		try {
			pageRepo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			
		}
		
	}
}
