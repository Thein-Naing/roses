package com.life.roses.repository;

import com.life.roses.model.Rose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoseRepository extends JpaRepository<Rose, Long> {

}
