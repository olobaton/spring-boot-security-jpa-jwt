/**
 * 
 */
package com.example.dataaccess;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.dataaccess.DataPersonaPO;

/**
 * @author loboo
 *
 */
@Transactional(readOnly = true)
public interface DataAccessPersona extends JpaRepository<DataPersonaPO, Integer>{
	
	@Query("select p from DataPersonaPO p INNER JOIN p.usuario WHERE p.id =:id")
    public List<DataPersonaPO> find(@Param("id") Integer id);
	
	@Query("select p from DataPersonaPO p INNER JOIN p.usuario")
	public List<DataPersonaPO> findCustom();
}
