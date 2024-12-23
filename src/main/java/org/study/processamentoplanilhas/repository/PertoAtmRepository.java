package org.study.processamentoplanilhas.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.study.processamentoplanilhas.domain.PertoAtmEntity;

@Repository
public interface PertoAtmRepository extends CrudRepository <PertoAtmEntity, String> {

    //@Transactional
    //@Modifying
    //@Query(value = "truncate table tb_perto_atm", nativeQuery = true)
    //void truncate();

}
