package org.study.processamentoplanilhas.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.study.processamentoplanilhas.domain.ComodatoAtmEntity;
import org.study.processamentoplanilhas.domain.PertoAtmEntity;
import org.study.processamentoplanilhas.domain.ProcessStatus;
import org.study.processamentoplanilhas.domain.ProcessStatusReturnDto;
import org.study.processamentoplanilhas.repository.ComodatoAtmRepository;
import org.study.processamentoplanilhas.repository.PertoAtmRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
@Service
public class ProcessSpreadsheetServiceComodato {

    private final ComodatoAtmRepository comodatoAtmRepository;
    private ProcessStatus processStatus = ProcessStatus.FINISHED;

    public ProcessSpreadsheetServiceComodato(ComodatoAtmRepository comodatoAtmRepository) {
        this.comodatoAtmRepository = comodatoAtmRepository;
    }

    public ProcessStatusReturnDto getProcessStatus() {
        return new ProcessStatusReturnDto(processStatus);
    }

    public void getSpreadsheet() {

        log.info("Get spreadsheet FROM database");
      Iterable<ComodatoAtmEntity> comodatoAtmList = comodatoAtmRepository.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("ComodatoAtm");
        HSSFRow row = sheet.createRow(0);

        row.createCell(0).setCellValue("nro_univ");
        row.createCell(1).setCellValue("nome_do_contrato");
        row.createCell(2).setCellValue("fornecedor");
        row.createCell(3).setCellValue("prf_insl");
        row.createCell(4).setCellValue("sag_inls");
        row.createCell(5).setCellValue("dependencia");
        row.createCell(6).setCellValue("municipio");
        row.createCell(7).setCellValue("codmunicipio");
        row.createCell(8).setCellValue("uf");
        row.createCell(9).setCellValue("cat");
        row.createCell(10).setCellValue("cat_resp");
        row.createCell(11).setCellValue("regional");
        row.createCell(12).setCellValue("dist");
        row.createCell(13).setCellValue("distanciabb");
        row.createCell(14).setCellValue("criticidade");
        row.createCell(15).setCellValue("semat");
        row.createCell(16).setCellValue("vlr_parceiros");
//        row.createCell(17).setCellValue("PRF-SB");
        row.createCell(17).setCellValue("endereco");
        row.createCell(18).setCellValue("bairro");
        row.createCell(19).setCellValue("cep");
        row.createCell(20).setCellValue("telefone");
        row.createCell(21).setCellValue("cnpj");
        row.createCell(22).setCellValue("tempo_aquisicao");
        row.createCell(23).setCellValue("lote");
        row.createCell(24).setCellValue("valor_residual");
        row.createCell(25).setCellValue("valor_aquisicao");

        log.info("Preenchendo a planilha");

        int rowNum = 1;
        for (ComodatoAtmEntity comodatoAtmEntity : comodatoAtmList) {
            HSSFRow dataRow = sheet.createRow(rowNum);
            dataRow.createCell(0).setCellValue(comodatoAtmEntity.getNroUniv());
            dataRow.createCell(1).setCellValue(comodatoAtmEntity.getNomeDoContrato());
            dataRow.createCell(2).setCellValue(comodatoAtmEntity.getFornecedor());
            dataRow.createCell(3).setCellValue(comodatoAtmEntity.getPrfInsl());
            dataRow.createCell(4).setCellValue(comodatoAtmEntity.getSagInsl());
            dataRow.createCell(5).setCellValue(comodatoAtmEntity.getDependencia());
            dataRow.createCell(6).setCellValue(comodatoAtmEntity.getMunicipio());
            dataRow.createCell(7).setCellValue(comodatoAtmEntity.getCodMunicipio());
            dataRow.createCell(8).setCellValue(comodatoAtmEntity.getUf());
            dataRow.createCell(9).setCellValue(comodatoAtmEntity.getCat());
            dataRow.createCell(10).setCellValue(comodatoAtmEntity.getCatResp());
            dataRow.createCell(11).setCellValue(comodatoAtmEntity.getRegional());
            dataRow.createCell(12).setCellValue(comodatoAtmEntity.getDist());
            dataRow.createCell(13).setCellValue(comodatoAtmEntity.getDistanciabb());
            dataRow.createCell(14).setCellValue(comodatoAtmEntity.getCriticidade());
            dataRow.createCell(15).setCellValue(comodatoAtmEntity.getSemat());
            dataRow.createCell(16).setCellValue(comodatoAtmEntity.getVlrParceiros());
            //dataRow.createCell(17).setCellValue(comodatoAtmEntity.getPrfSb);
            dataRow.createCell(18).setCellValue(comodatoAtmEntity.getEndereco());
            dataRow.createCell(19).setCellValue(comodatoAtmEntity.getBairro());
            dataRow.createCell(20).setCellValue(comodatoAtmEntity.getCep());
            dataRow.createCell(21).setCellValue(comodatoAtmEntity.getTelefone());
            dataRow.createCell(22).setCellValue(comodatoAtmEntity.getCnpj());
            dataRow.createCell(23).setCellValue(comodatoAtmEntity.getTempoAquisicao());
            dataRow.createCell(24).setCellValue(comodatoAtmEntity.getLote());
            dataRow.createCell(25).setCellValue(comodatoAtmEntity.getValorResidual());
            dataRow.createCell(26).setCellValue(comodatoAtmEntity.getValorAquisicao());
            rowNum = rowNum + 1;
        }

        log.info("AutoSizing colunas");
        for (int i = 0; i < 27; i++) {
            sheet.autoSizeColumn(i);
        }

        log.info("Creating file");
        File currentDir = new File(".");
        String currentDirPath = currentDir.getAbsolutePath();
        String fileLocation = currentDirPath.substring(0, currentDirPath.length()-1) + "ComodatoAtm.xls";

        try {
            FileOutputStream fos = new FileOutputStream(fileLocation);
            workbook.write(fos);
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
