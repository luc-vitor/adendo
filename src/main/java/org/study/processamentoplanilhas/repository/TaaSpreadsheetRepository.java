package org.study.processamentoplanilhas.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.study.processamentoplanilhas.domain.TaaSpreadsheetEntity;

@Repository
public interface TaaSpreadsheetRepository extends CrudRepository<TaaSpreadsheetEntity, Long> {

    @Modifying
    @Query(value = "truncate table adendo50", nativeQuery = true)
    void truncate();
}
