package org.study.processamentoplanilhas.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.study.processamentoplanilhas.domain.DemaisBensSpreadsheetEntity;

@Repository
public interface DemaisBensSpreadsheetRepository extends CrudRepository<DemaisBensSpreadsheetEntity, Long> {

//    @Transactional
//    @Modifying
//    @Query(value = "truncate table adendo52", nativeQuery = true)
//    void truncate();
}
