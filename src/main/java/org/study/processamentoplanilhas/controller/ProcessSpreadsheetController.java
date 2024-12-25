package org.study.processamentoplanilhas.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.study.processamentoplanilhas.domain.AnexoBbSpreadsheetEntity;
import org.study.processamentoplanilhas.domain.DemaisBensSpreadsheetEntity;
import org.study.processamentoplanilhas.domain.ProcessStatusReturnDto;
import org.study.processamentoplanilhas.service.*;

import java.io.ByteArrayOutputStream;
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
    private final ProcessSpreadsheetServiceAnexoBb52 processSpreadsheetServiceAnexoBb52;
    private final ProcessSpreadsheetServicePerto processSpreadsheetServicePerto;
    private final ProcessSpreadsheetServiceNcr processSpreadsheetServiceNcr;
    private final ProcessSpreadsheetServiceDiebold processSpreadsheetServiceDiebold;
    private final ProcessSpreadsheetServiceComodato processSpreadsheetServiceComodato;

    public ProcessSpreadsheetController(final ProcessSpreadsheetServiceDemaisBens processSpreadsheetServiceDemaisBens, final ProcessSpreadsheetServiceTaa processSpreadsheetServiceTaa, final ProcessSpreadsheetServiceAnexoBb processSpreadsheetServiceAnexoBb, final ProcessSpreadsheetServiceAnexoBb52 processSpreadsheetServiceAnexoBb52, final ProcessSpreadsheetServicePerto processSpreadsheetServicePerto, final ProcessSpreadsheetServiceNcr processSpreadsheetServiceNcr, final ProcessSpreadsheetServiceDiebold processSpreadsheetServiceDiebold, final ProcessSpreadsheetServiceComodato processSpreadsheetServiceComodato) {
        this.processSpreadsheetServiceDemaisBens = processSpreadsheetServiceDemaisBens;
        this.processSpreadsheetServiceTaa = processSpreadsheetServiceTaa;
        this.processSpreadsheetServiceAnexoBb = processSpreadsheetServiceAnexoBb;
        this.processSpreadsheetServiceAnexoBb52 = processSpreadsheetServiceAnexoBb52;
        this.processSpreadsheetServicePerto = processSpreadsheetServicePerto;
        this.processSpreadsheetServiceNcr = processSpreadsheetServiceNcr;
        this.processSpreadsheetServiceDiebold = processSpreadsheetServiceDiebold;
        this.processSpreadsheetServiceComodato = processSpreadsheetServiceComodato;
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

    @PostMapping("/anexo-bb52")
    public void processAnexoBb52(@RequestParam("spreadsheet") MultipartFile file) {
        log.info("Receiving new spreadsheets. File name: {} | File ContentType: {}", file.getOriginalFilename(), file.getContentType());

        String filename = file.getOriginalFilename();

        if (!filename.endsWith(".xlsx") && !filename.endsWith(".xls")) {
            throw new UnsupportedOperationException("Spreadsheet file extension is not supported");
        }

        processSpreadsheetServiceAnexoBb52.processExcelFile(file);
    }

    @GetMapping("/anexo-bb52/status")
    public ProcessStatusReturnDto processStatusAnexoBb52() {
        return processSpreadsheetServiceAnexoBb52.getProcessStatus();
    }

    @GetMapping("/perto-atm")
    public ResponseEntity<byte[]> obterPertoAtm() {
        try(HSSFWorkbook wb = processSpreadsheetServicePerto.getSpreadsheet()) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            wb.write(baos);
            byte[] content = baos.toByteArray();

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=pertoAtm.xls")
                    .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                    .body(content);


        } catch (IOException e) {
            log.warn("Falha ao obter planilha pertoAtm", e);
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/ncr-atm")
    public void obterNcrAtm() {
        processSpreadsheetServiceNcr.getSpreadsheet();
    }

    @GetMapping("/diebold-atm")
    public void obterDieboldAtm() {
        processSpreadsheetServiceDiebold.getSpreadsheet();
    }

    @GetMapping("/comodato-atm")
    public void obterComodatodAtm() {
        processSpreadsheetServiceComodato.getSpreadsheet();
    }

}



