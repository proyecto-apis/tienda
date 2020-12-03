package com.scriptkiddie.cmsshoppingcart.models;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scriptkiddie.cmsshoppingcart.models.data.Page;
//import org.springframework.data.jpa.repository.Query;



/*
 * Extender de JPA Repository nos permite acceer a todos los métodos
 * necesarios para realizar consultas a la tabla que mapea.
 * En este caso estamos utilizando como entity a Page (nuestra tabla).
 * El segundo genérico es el tipo de dato de la llave primaria de dicha tabla (Integer).
 */

public interface PageRestRepository extends JpaRepository<Page, Integer> {
	
	Page findBySlug(String slug);
//	@Query("SELECT p FROM Page p WHERE p.id != :id AND p.slug = :slug")
//	Page findBySlug(int id, String slug);
	Page findBySlugAndIdNot(String slug, int id);
	List<Page> findAllByOrderBySortingAsc();
	
	
}
