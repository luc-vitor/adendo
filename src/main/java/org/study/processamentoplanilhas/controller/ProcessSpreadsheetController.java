package org.study.processamentoplanilhas.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.study.processamentoplanilhas.domain.AnexoBbSpreadsheetEntity;
import org.study.processamentoplanilhas.domain.DemaisBensSpreadsheetEntity;
import org.study.processamentoplanilhas.domain.ProcessStatusReturnDto;
import org.study.processamentoplanilhas.service.ProcessSpreadsheetServiceAnexoBb;
import org.study.processamentoplanilhas.service.ProcessSpreadsheetServiceDemaisBens;
import org.study.processamentoplanilhas.service.ProcessSpreadsheetServiceTaa;

import java.io.IOException;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/v1/process")
public class ProcessSpreadsheetController {

    private final ProcessSpreadsheetServiceDemaisBens processSpreadsheetServiceDemaisBens;
    private final ProcessSpreadsheetServiceTaa processSpreadsheetServiceTaa;
    private final ProcessSpreadsheetServiceAnexoBb processSpreadsheetServiceAnexoBb;

    public ProcessSpreadsheetController(final ProcessSpreadsheetServiceDemaisBens processSpreadsheetServiceDemaisBens, final ProcessSpreadsheetServiceTaa processSpreadsheetServiceTaa, final ProcessSpreadsheetServiceAnexoBb processSpreadsheetServiceAnexoBb) {
        this.processSpreadsheetServiceDemaisBens = processSpreadsheetServiceDemaisBens;
        this.processSpreadsheetServiceTaa = processSpreadsheetServiceTaa;
        this.processSpreadsheetServiceAnexoBb = processSpreadsheetServiceAnexoBb;
    }

    @PostMapping("/demais-bens")
    public void processDemaisBens(@RequestParam("spreadsheet") MultipartFile file) throws IOException {
        log.info("Receiving new spreadsheets. File name: {} | File ContentType: {}", file.getOriginalFilename(), file.getContentType());

        String filename = file.getOriginalFilename();

        List<DemaisBensSpreadsheetEntity> dtos;

        if (!filename.endsWith(".xlsx") && !filename.endsWith(".xls")) {
            throw new UnsupportedOperationException("Spreadsheet file extension is not supported");
        }
        processSpreadsheetServiceDemaisBens.processExcelFile(file);
    }

    @GetMapping("/demais-bens/status")
    public ProcessStatusReturnDto processStatusDemaisBens() {
        return processSpreadsheetServiceTaa.getProcessStatus();
    }

    @PostMapping("/taa")
    public void processTaa(@RequestParam("spreadsheet") MultipartFile file) {
        log.info("Receiving new spreadsheets. File name: {} | File ContentType: {}", file.getOriginalFilename(), file.getContentType());

        String filename = file.getOriginalFilename();

        if (!filename.endsWith(".xlsx") && !filename.endsWith(".xls")) {
            throw new UnsupportedOperationException("Spreadsheet file extension is not supported");
        }
        processSpreadsheetServiceTaa.processExcelFile(file);
    }

    @GetMapping("/taa/status")
    public ProcessStatusReturnDto processStatusTaa() {
        return processSpreadsheetServiceTaa.getProcessStatus();
    }

    @PostMapping("/anexo-bb")
    public void processAnexoBb(@RequestParam("spreadsheet") MultipartFile file) {
        log.info("Receiving new spreadsheets. File name: {} | File ContentType: {}", file.getOriginalFilename(), file.getContentType());

        String filename = file.getOriginalFilename();

        if (!filename.endsWith(".xlsx") && !filename.endsWith(".xls")) {
            throw new UnsupportedOperationException("Spreadsheet file extension is not supported");
        }

        processSpreadsheetServiceAnexoBb.processExcelFile(file);
    }

    @GetMapping("/anexo-bb/status")
    public ProcessStatusReturnDto processStatusAnexoBb() {
        return processSpreadsheetServiceAnexoBb.getProcessStatus();
        }
}



