package org.study.processamentoplanilhas.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.study.processamentoplanilhas.domain.DemaisBensSpreadsheet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Service
public class ProcessSpreadsheetServiceDemaisBens {

    public List<DemaisBensSpreadsheet> processExcelFile(MultipartFile file) throws IOException {
        List<DemaisBensSpreadsheet> dtos = new ArrayList<>();

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


                // Pega valores da planilha, na linha
                final String numeroDoBem = getStringCellValue(row.getCell(0));
                final String mes = getStringCellValue(row.getCell(1));
                final String tpoPbms = getStringCellValue(row.getCell(2));
                final String clsPbms = getStringCellValue(row.getCell(3));
                final String sclPbms = getStringCellValue(row.getCell(4));
                final String seqPbms = getStringCellValue(row.getCell(5));
                final String pbms = getStringCellValue(row.getCell(6));
                final String cdCfgBem = getStringCellValue(row.getCell(7));
                final String nomeNoContrato = getStringCellValue(row.getCell(8));
                final String vl = getStringCellValue(row.getCell(9));
                final String critcidade52 = getStringCellValue(row.getCell(10));
                final String modelo = getStringCellValue(row.getCell(11));
                final String grupo = getStringCellValue(row.getCell(12));
                final String fornecedor = getStringCellValue(row.getCell(13));
                final String cdOurInls = getStringCellValue(row.getCell(14));
                final String prfDepeInls = getStringCellValue(row.getCell(15));
                final String sagInls = getStringCellValue(row.getCell(16));
                final String nomeOurInstalacao = getStringCellValue(row.getCell(17));
                final String municipioAtualizado = getStringCellValue(row.getCell(18));
                final String ufAtualizada = getStringCellValue(row.getCell(19));
                final String tipoDeDependenciaAtualizada = getStringCellValue(row.getCell(20));
                final String lote = getStringCellValue(row.getCell(21));

                // Valida se a linha ta preenchida

                final boolean hasNumeroDoBem = numeroDoBem != null && !numeroDoBem.isEmpty();
                final boolean hasMes = mes != null && !mes.isEmpty();
                final boolean hasTpoPbms = tpoPbms != null && !tpoPbms.isEmpty();
                final boolean hasClsPbms = clsPbms != null && !clsPbms.isEmpty();
                final boolean hasSclPbms = sclPbms != null && !sclPbms.isEmpty();
                final boolean hasSeqPbms = seqPbms != null && !seqPbms.isEmpty();
                final boolean hasPbms = pbms != null && !pbms.isEmpty();
                final boolean hasCdCfgBem = cdCfgBem != null && !cdCfgBem.isEmpty();
                final boolean hasNomeNoContrato = nomeNoContrato != null && !nomeNoContrato.isEmpty();
                final boolean hasVl = vl != null && !vl.isEmpty();
                final boolean hasCritcidade52 = critcidade52 != null && !critcidade52.isEmpty();
                final boolean hasModelo = modelo != null && !modelo.isEmpty();
                final boolean hasGrupo = grupo != null && !grupo.isEmpty();
                final boolean hasFornecedor = fornecedor != null && !fornecedor.isEmpty();
                final boolean hasCdOurInls = cdOurInls != null && !cdOurInls.isEmpty();
                final boolean hasPrfDepeInls = prfDepeInls != null && !prfDepeInls.isEmpty();
                final boolean hasSagInls = sagInls != null && !sagInls.isEmpty();
                final boolean hasNomeOurInstalacao = nomeOurInstalacao != null && !nomeOurInstalacao.isEmpty();
                final boolean hasMunicipioAtualizado = municipioAtualizado != null && !municipioAtualizado.isEmpty();
                final boolean hasUfAtualizada = ufAtualizada != null && !ufAtualizada.isEmpty();
                final boolean hasTipoDeDependenciaAtualizada = tipoDeDependenciaAtualizada != null && !tipoDeDependenciaAtualizada.isEmpty();
                final boolean hasLote = lote != null && !lote.isEmpty();

                // Setas os valores da LINHA em um objeto

                if (hasNumeroDoBem || hasMes || hasTpoPbms || hasClsPbms || hasSclPbms || hasSeqPbms || hasPbms || hasCdCfgBem || hasNomeNoContrato || hasVl || hasCritcidade52 || hasModelo || hasGrupo || hasFornecedor || hasCdOurInls || hasPrfDepeInls || hasSagInls || hasNomeOurInstalacao || hasMunicipioAtualizado || hasUfAtualizada || hasTipoDeDependenciaAtualizada || hasLote) {
                    DemaisBensSpreadsheet dto = new DemaisBensSpreadsheet();
                    dto.setNumeroDoBem(numeroDoBem);
                    dto.setMes(mes);
                    dto.setTpoPbms(tpoPbms);
                    dto.setClsPbms(clsPbms);
                    dto.setSclPbms(sclPbms);
                    dto.setSeqPbms(seqPbms);
                    dto.setPbms(pbms);
                    dto.setCdCfgBem(cdCfgBem);
                    dto.setNomeNoContrato(nomeNoContrato);
                    dto.setVl(vl);
                    dto.setCriticidade52(critcidade52);
                    dto.setModelo(modelo);
                    dto.setGrupo(grupo);
                    dto.setFornecedor(fornecedor);
                    dto.setCdOurInsl(cdOurInls);
                    dto.setPrfDepeInsl(prfDepeInls);
                    dto.setSagInsl(sagInls);
                    dto.setNomeOurInstalacao(nomeOurInstalacao);
                    dto.setMunicipioAtualizado(municipioAtualizado);
                    dto.setUfAtualizada(ufAtualizada);
                    dto.setTipoDeDependeciaAtualizada(tipoDeDependenciaAtualizada);
                    dto.setLote(lote);

                }
                }
            }

        return dtos;
    }

    private String getStringCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        return cell.getCellType() == CellType.STRING ? cell.getStringCellValue() : cell.toString();
    }

}
