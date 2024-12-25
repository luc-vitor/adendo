package org.study.processamentoplanilhas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.study.processamentoplanilhas.domain.NcrAtmEntity;

@Repository
public interface NcrAtmRepository extends CrudRepository <NcrAtmEntity, String> {

    //@Transactional
    //@Modifying
    //@Query(value = "truncate table tb_perto_atm", nativeQuery = true)
    //void truncate();

}
