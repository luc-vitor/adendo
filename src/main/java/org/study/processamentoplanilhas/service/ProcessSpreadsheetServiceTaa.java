package org.study.processamentoplanilhas.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.study.processamentoplanilhas.domain.TaaSpreadsheetEntity;
import org.study.processamentoplanilhas.repository.TaaSpreadsheetRepository;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Service
public class ProcessSpreadsheetServiceTaa {

    private final TaaSpreadsheetRepository taaSpreadsheetRepository;

    public ProcessSpreadsheetServiceTaa(TaaSpreadsheetRepository taaSpreadsheetRepository) {
        this.taaSpreadsheetRepository = taaSpreadsheetRepository;
    }

    public List<TaaSpreadsheetEntity> processExcelFile(MultipartFile file) throws IOException {
        List<TaaSpreadsheetEntity> entities = new ArrayList<>();
        Instant start = Instant.now();

        log.info("Processando Planilha Taa...");
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
                final Long idAdendo = getLongCellValue(row.getCell(0));
                final String nroUniv = getStringNotacaoCientifica(row.getCell(1));
                final String tpoPbms = getStringCellValue(row.getCell(2));
                final String clsPbms = getStringCellValue(row.getCell(3));
                final String sclPbms = getStringCellValue(row.getCell(4));
                final String seqPbms = getStringCellValue(row.getCell(5));
                final String nomeDoContrato = getStringCellValue(row.getCell(6));
                final String prfInls = getStringCellValue(row.getCell(7));
                final String sagInls = getStringNotacaoCientifica(row.getCell(8));
                final String nome = getStringCellValue(row.getCell(9));
                final String municipio = getStringCellValue(row.getCell(10));
                final String uf = getStringCellValue(row.getCell(11));
                final Double valor = getDoubleCellValue(row.getCell(12));
                final Long criticidade = getLongCellValue(row.getCell(13));
                final String fornecedor = getStringCellValue(row.getCell(14));
                final String modelo = getStringCellValue(row.getCell(15));
                final String tipoDependencia = getStringCellValue(row.getCell(16));
                final String semat = getStringCellValue(row.getCell(17));
                final String supridora = getStringCellValue(row.getCell(18));
                final String nomeSupridora = getStringCellValue(row.getCell(19));
                final Long distancia = getLongCellValue(row.getCell(20));
                final String funcao = getStringCellValue(row.getCell(21));
                final String tempoDeAquisicao = getStringCellValue(row.getCell(22));
                final String codConfig = getStringCellValue(row.getCell(23));
                final String ctrAqsc = getStringCellValue(row.getCell(24));
                final String competencia = getStringCellValue(row.getCell(25));
                final String vlrAquisicao = getStringCellValue(row.getCell(26));
                final String vlrResidual = getStringCellValue(row.getCell(27));
                final String seret = getStringCellValue(row.getCell(28));
                final String nomeSeret = getStringCellValue(row.getCell(29));
                final String distanciaSeret = getStringCellValue(row.getCell(30));


                // Valida se a linha ta preenchida

                final boolean hasIdAdendo = idAdendo != null;
                final boolean hasNroUniv = nroUniv != null && !nroUniv.isEmpty();
                final boolean hasTpoPbms = tpoPbms != null && !tpoPbms.isEmpty();
                final boolean hasClsPbms = clsPbms != null && !clsPbms.isEmpty();
                final boolean hasSclPbms = sclPbms != null && !sclPbms.isEmpty();
                final boolean hasSeqPbms = seqPbms != null && !seqPbms.isEmpty();
                final boolean hasNomeDoContrato = nomeDoContrato != null && !nome.isEmpty();
                final boolean hasPrfInls = prfInls != null && !prfInls.isEmpty();
                final boolean hasSagInls = sagInls != null && !sagInls.isEmpty();
                final boolean hasNome = nome != null && !nome.isEmpty();
                final boolean hasMunicipio = municipio != null && !municipio.isEmpty();
                final boolean hasUf = uf != null && !uf.isEmpty();
                final boolean hasValor = valor != null;
                final boolean hasCriticidade = criticidade != null;
                final boolean hasFornecedor = fornecedor != null && !fornecedor.isEmpty();
                final boolean hasModelo = modelo != null && !modelo.isEmpty();
                final boolean hasTipoDependencia = tipoDependencia != null && !tipoDependencia.isEmpty();
                final boolean hasSemat = semat != null && !semat.isEmpty();
                final boolean hasSupridora = supridora != null && !supridora.isEmpty();
                final boolean hasNomeSupridora = nomeSupridora != null && !nomeSupridora.isEmpty();
                final boolean hasDistancia = distancia != null;
                final boolean hasFuncao = funcao != null && !funcao.isEmpty();
                final boolean hasTempoDeAquisicao = tempoDeAquisicao != null && !tempoDeAquisicao.isEmpty();
                final boolean hasCodConfig = codConfig != null && !codConfig.isEmpty();
                final boolean hasCtrAqsc = ctrAqsc != null && !ctrAqsc.isEmpty();
                final boolean hasCompetencia = competencia != null && !competencia.isEmpty();
                final boolean hasVlrAquisicao = vlrAquisicao != null && !vlrAquisicao.isEmpty();
                final boolean hasVlrResidual = vlrResidual != null && !vlrResidual.isEmpty();
                final boolean hasSeret = seret != null && !seret.isEmpty();
                final boolean hasNomeSeret = nomeSeret != null && !nomeSeret.isEmpty();
                final boolean hasDistanciaSeret = distanciaSeret != null && !distanciaSeret.isEmpty();

                // Setas os valores da LINHA em um objeto

                if (hasIdAdendo || hasNroUniv || hasTpoPbms || hasClsPbms || hasSclPbms || hasSeqPbms || hasNomeDoContrato || hasPrfInls || hasSagInls || hasNome || hasMunicipio || hasUf || hasValor || hasCriticidade || hasFornecedor || hasModelo || hasTipoDependencia || hasSemat || hasSupridora || hasNomeSupridora || hasDistancia || hasFuncao || hasTempoDeAquisicao || hasCodConfig || hasCtrAqsc || hasCompetencia || hasVlrAquisicao || hasVlrResidual || hasSeret || hasNomeSeret || hasDistanciaSeret) {
                    TaaSpreadsheetEntity entity = new TaaSpreadsheetEntity();
                    entity.setIdAdendo(idAdendo);
                    entity.setNroUniv(nroUniv);
                    entity.setTpoPbms(tpoPbms);
                    entity.setClsPbms(clsPbms);
                    entity.setSclPbms(sclPbms);
                    entity.setSeqPbms(seqPbms);
                    entity.setNomeDoContrato(nomeDoContrato);
                    entity.setPrfInls(prfInls);
                    entity.setSagInls(sagInls);
                    entity.setNome(nome);
                    entity.setMunicipio(municipio);
                    entity.setUf(uf);
                    entity.setValor(valor);
                    entity.setCriticidade(criticidade);
                    entity.setFornecedor(fornecedor);
                    entity.setModelo(modelo);
                    entity.setTipoDependencia(tipoDependencia);
                    entity.setSemat(semat);
                    entity.setSupridora(supridora);
                    entity.setNomeSupridora(nomeSupridora);
                    entity.setDistancia(distancia);
                    entity.setFuncao(funcao);
                    entity.setTempoDeAquisicao(tempoDeAquisicao);
                    entity.setCodConfig(codConfig);
                    entity.setCtrAqsc(ctrAqsc);
                    entity.setCompetencia(competencia);
                    entity.setVlrAquisicao(vlrAquisicao);
                    entity.setVlrResidual(vlrResidual);
                    entity.setSeret(seret);
                    entity.setNomeSeret(nomeSeret);
                    entity.setDistanciaSeret(distanciaSeret);
                    entities.add(entity);
                }
            }
        }

        log.info("Planilha Taa salvando no banco... | qtdLinhas: {}", entities.size());
        log.info("Planilha Taa processada com sucesso!");
        taaSpreadsheetRepository.saveAll(entities);
        log.info("Planilha Taa salva no banco | qtdLinhas: {}", entities.size());
        Instant finish = Instant.now();
        Duration duration = Duration.between(start, finish);
        log.info("Tempo de processamento: Segundos={} | Minutos={} | Horas={}",duration.toSeconds(),duration.toMinutes(),duration.toHours());
        return entities;
    }

    private Long getLongCellValue(Cell cell) {
        if (cell == null || cell.getCellType() != CellType.NUMERIC) {
            return null;
        }
        return Double.valueOf(cell.getNumericCellValue()).longValue();
    }

    private Double getDoubleCellValue(Cell cell) {
        if (cell == null || cell.getCellType() != CellType.NUMERIC) {
            return null;
        }
        return cell.getNumericCellValue();
    }

    private String getStringNotacaoCientifica(Cell cell) {
        Double cellValue = getDoubleCellValue(cell);
        if(cellValue == null) {
            return null;
        }
        return String.format("%.0f", cellValue);
    }

    private String getStringCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        return cell.getCellType() == CellType.STRING ? cell.getStringCellValue() : cell.toString();
    }

}

