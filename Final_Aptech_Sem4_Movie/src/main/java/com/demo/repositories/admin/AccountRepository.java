package com.demo.repositories.admin;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.models.Account;
import com.demo.models.Movie;
import com.demo.models.Ticket;

@Repository("AdminAccountRepository")
public interface AccountRepository extends PagingAndSortingRepository<Account, Integer>{

	@Query("from Account where id = :id")
	public Account findAccountById(@Param("id")int id);

	@Query(value = "select * from Account where status = 1",nativeQuery = true)
	public Page<Account> findAllByStatus(Pageable pageable);
	
	@Query(value = "select * from Account where status = 1 and user_type = 2",nativeQuery = true)
	public List<Account> findAll();
	
	@Query(value = "select count(*) from account where user_type = 1 ", nativeQuery = true)
	public int countAccount();
 
	@Query(value="from Account where fullName like %:keyword% and status = 1")
	public List<Account> findByKeyword(@Param("keyword")String keyword);
}

// database ---> repositories ---> service ---> controller
// HQL, JPAQL
