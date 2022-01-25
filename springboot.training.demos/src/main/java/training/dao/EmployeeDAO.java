package training.dao;

import org.springframework.data.jpa.respository.JpaRepository;

import com.entity.EmployeeEntity;

//CrudRepository:		main provides CRUD functions
	//PagingAndSortingRepository: provides methods to do pagination and sorting records,
	//JpaRepository:		provides some JPA-related methods such as flushing
		//the persistence context and deleting records in a batch.Because of the inheritance
		//mentioned below,JpaRepository will have all the functions of CrudRepository and
		//PagingAndSorting,So if you don't need the repository to have the
		//functions provided by JpaRepository and PagingAndSortingRepository,use CrudRepository.
public interface EmployeeDAO JpaRepository<EmployeeEntity,Integer>{
	
	
}