package com.cih.design_rest_formation_dryrun.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cih.design_rest_formation_dryrun.service.entity.BookEntity;

public interface BookRepository  extends JpaRepository<BookEntity, Long> {	

}
