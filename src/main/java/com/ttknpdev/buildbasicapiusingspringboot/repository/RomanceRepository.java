package com.ttknpdev.buildbasicapiusingspringboot.repository;

import com.ttknpdev.buildbasicapiusingspringboot.entity.Romance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RomanceRepository extends JpaRepository<Romance,String> { }
