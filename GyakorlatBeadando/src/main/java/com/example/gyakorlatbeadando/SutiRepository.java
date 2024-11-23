package com.example.gyakorlatbeadando;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SutiRepository extends CrudRepository<Suti, Long> {

}
