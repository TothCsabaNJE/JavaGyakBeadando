package com.example.gyakorlatbeadando;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface KapcsolatRepository extends CrudRepository<Kapcsolat, Long> {

    @Query("select k from Kapcsolat k order by k.date desc")
    Collection<Kapcsolat> findAllBackwards();
}
