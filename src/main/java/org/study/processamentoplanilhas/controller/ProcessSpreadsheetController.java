package org.study.processamentoplanilhas.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.study.processamentoplanilhas.domain.CarroSpreadsheet;
import org.study.processamentoplanilhas.domain.DemaisBensSpreadsheet;
import org.study.processamentoplanilhas.domain.TaaSpreadsheetEntity;
import org.study.processamentoplanilhas.service.ProcessSpreadsheetService;
import org.study.processamentoplanilhas.service.ProcessSpreadsheetServiceDemaisBens;
import org.study.processamentoplanilhas.service.ProcessSpreadsheetServiceTaa;

import java.io.IOException;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/v1/process")
public class ProcessSpreadsheetController {

    private final ProcessSpreadsheetService processSpreadsheetService;
    private final ProcessSpreadsheetServiceDemaisBens processSpreadsheetServiceDemaisBens;
    private final ProcessSpreadsheetServiceTaa processSpreadsheetServiceTaa;


    public ProcessSpreadsheetController(final ProcessSpreadsheetService processSpreadsheetService, final ProcessSpreadsheetServiceDemaisBens processSpreadsheetServiceDemaisBens, final ProcessSpreadsheetServiceTaa processSpreadsheetServiceTaa) {
        this.processSpreadsheetService = processSpreadsheetService;
        this.processSpreadsheetServiceDemaisBens = processSpreadsheetServiceDemaisBens;
        this.processSpreadsheetServiceTaa = processSpreadsheetServiceTaa;
    }

    @PostMapping("/car")
    public void process(@RequestParam("spreadsheet") MultipartFile file) throws IOException {
        log.info("Receiving new spreadsheets. File name: {} | File ContentType: {}", file.getOriginalFilename(), file.getContentType());

        String filename = file.getOriginalFilename();

        List<CarroSpreadsheet> dtos;

        if (!filename.endsWith(".xlsx") && !filename.endsWith(".xls")) {
            throw new UnsupportedOperationException("Spreadsheet file extension is not supported");
        }

        dtos = processSpreadsheetService.processExcelFile(file);
        log.info(dtos.toString());
    }

    @PostMapping("/demais-bens")
    public void processDemaisBens(@RequestParam("spreadsheet") MultipartFile file) throws IOException {
        log.info("Receiving new spreadsheets. File name: {} | File ContentType: {}", file.getOriginalFilename(), file.getContentType());

        String filename = file.getOriginalFilename();

        List<DemaisBensSpreadsheet> dtos;

        if (!filename.endsWith(".xlsx") && !filename.endsWith(".xls") && !filename.endsWith(".xlsb")) {
            throw new UnsupportedOperationException("Spreadsheet file extension is not supported");
        }

        dtos = processSpreadsheetServiceDemaisBens.processExcelFile(file);
        log.info(dtos.toString());
    }

    @PostMapping("/taa")
    public void processTaa(@RequestParam("spreadsheet") MultipartFile file) throws IOException {
        log.info("Receiving new spreadsheets. File name: {} | File ContentType: {}", file.getOriginalFilename(), file.getContentType());

        String filename = file.getOriginalFilename();

        List<TaaSpreadsheetEntity> dtos;

        if (!filename.endsWith(".xlsx") && !filename.endsWith(".xls")) {
            throw new UnsupportedOperationException("Spreadsheet file extension is not supported");
        }

        dtos = processSpreadsheetServiceTaa.processExcelFile(file);
    }
}



