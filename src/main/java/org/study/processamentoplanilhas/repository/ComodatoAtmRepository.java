package org.study.processamentoplanilhas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.study.processamentoplanilhas.domain.ComodatoAtmEntity;

@Repository
public interface ComodatoAtmRepository extends CrudRepository <ComodatoAtmEntity, String> {

    //@Transactional
    //@Modifying
    //@Query(value = "truncate table tb_perto_atm", nativeQuery = true)
    //void truncate();

}
