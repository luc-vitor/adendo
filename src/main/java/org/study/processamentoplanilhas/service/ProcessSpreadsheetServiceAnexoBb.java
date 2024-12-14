package org.study.processamentoplanilhas.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.study.processamentoplanilhas.domain.AnexobbSpreadsheetEntity;
import org.study.processamentoplanilhas.repository.AnexoBbSpreadsheetRepository;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Service
public class ProcessSpreadsheetServiceAnexoBb {

    private final AnexoBbSpreadsheetRepository anexoBbSpreadsheetRepository;


    public ProcessSpreadsheetServiceAnexoBb(AnexoBbSpreadsheetRepository anexoBbSpreadsheetRepository) {
        this.anexoBbSpreadsheetRepository = anexoBbSpreadsheetRepository;
    }

    public List<AnexobbSpreadsheetEntity> processExcelFile(MultipartFile file) throws IOException {
        List<AnexobbSpreadsheetEntity> entities = new ArrayList<>();
        Instant start = Instant.now();

        log.info("Processando Planilha Anexo Banco do Brasil...");
        try (InputStream is = file.getInputStream()) {
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            boolean isFirstRow = true;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                if (isFirstRow) {
                    isFirstRow = false; // Skip header row
                    continue;
                }
            }
        }
        return entities;
    }
}