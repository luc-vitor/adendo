package org.study.processamentoplanilhas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.study.processamentoplanilhas.domain.DemaisBensSpreadsheetEntity;

@Repository
public interface DemaisBensSpreadsheetRepository extends CrudRepository<DemaisBensSpreadsheetEntity, Long> {
}
