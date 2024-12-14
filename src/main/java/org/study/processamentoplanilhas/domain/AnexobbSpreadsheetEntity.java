package org.study.processamentoplanilhas.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "anexo_banco_do_brasil")
public class AnexobbSpreadsheetEntity {

        // Colunas da tabela
        @Id
        @Column(name = "referencia")
        private String referencia;

        @Column(name = "numerobem")
        private Long numeroBem;

        @Column(name = "nomenocontrato")
        private String nomeNoContrato;

        @Column(name = "grupo")
        private String grupo;

        @Column(name = "modelo")
        private String modelo;

        @Column(name = "fornecedor")
        private String fornecedor;

        @Column(name = "contrato")
        private String contrato;

        @Column(name = "criticidade")
        private Long criticidade;

        @Column(name = "valor")
        private String valor;

        @Column(name = "vlr_parceiros")
        private String vlrParceiros;

        @Column(name = "agencia")
        private String agencia;

        @Column(name = "sag")
        private String sag;

        @Column(name = "lat")
        private String lat;

        @Column(name = "cat_faturamento")
        private String catFaturamento;

        @Column(name = "cat_atendimento")
        private String catAtendimento;

        @Column(name = "lat_servico")
        private String latServico;

        @Column(name = "semat")
        private String semat;

        @Column(name = "configuracao")
        private String configuracao;

        @Column(name = "componentedobem")
        private String componenteDoBem;

        @Column(name = "proprietario")
        private String proprietario;

        @Column(name = "numeroserie")
        private String numeroserie;

        @Column(name = "quantidade")
        private String quantidade;

        @Column(name = "dataemservico")
        private String dataEmServico;

        @Column(name = "dataabsorcao")
        private String dataAbsorcao;

        @Column(name = "empregado")
        private String empregado;

        @Column(name = "timerecurso")
        private String timeRecurso;

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Long getNumeroBem() {
        return numeroBem;
    }

    public void setNumeroBem(Long numeroBem) {
        this.numeroBem = numeroBem;
    }

    public String getNomeNoContrato() {
        return nomeNoContrato;
    }

    public void setNomeNoContrato(String nomeNoContrato) {
        this.nomeNoContrato = nomeNoContrato;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public Long getCriticidade() {
        return criticidade;
    }

    public void setCriticidade(Long criticidade) {
        this.criticidade = criticidade;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getVlrParceiros() {
        return vlrParceiros;
    }

    public void setVlrParceiros(String vlrParceiros) {
        this.vlrParceiros = vlrParceiros;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getSag() {
        return sag;
    }

    public void setSag(String sag) {
        this.sag = sag;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getCatFaturamento() {
        return catFaturamento;
    }

    public void setCatFaturamento(String catFaturamento) {
        this.catFaturamento = catFaturamento;
    }

    public String getCatAtendimento() {
        return catAtendimento;
    }

    public void setCatAtendimento(String catAtendimento) {
        this.catAtendimento = catAtendimento;
    }

    public String getLatServico() {
        return latServico;
    }

    public void setLatServico(String latServico) {
        this.latServico = latServico;
    }

    public String getSemat() {
        return semat;
    }

    public void setSemat(String semat) {
        this.semat = semat;
    }

    public String getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(String configuracao) {
        this.configuracao = configuracao;
    }

    public String getComponenteDoBem() {
        return componenteDoBem;
    }

    public void setComponenteDoBem(String componenteDoBem) {
        this.componenteDoBem = componenteDoBem;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getNumeroserie() {
        return numeroserie;
    }

    public void setNumeroserie(String numeroserie) {
        this.numeroserie = numeroserie;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getDataEmServico() {
        return dataEmServico;
    }

    public void setDataEmServico(String dataEmServico) {
        this.dataEmServico = dataEmServico;
    }

    public String getDataAbsorcao() {
        return dataAbsorcao;
    }

    public void setDataAbsorcao(String dataAbsorcao) {
        this.dataAbsorcao = dataAbsorcao;
    }

    public String getEmpregado() {
        return empregado;
    }

    public void setEmpregado(String empregado) {
        this.empregado = empregado;
    }

    public String getTimeRecurso() {
        return timeRecurso;
    }

    public void setTimeRecurso(String timeRecurso) {
        this.timeRecurso = timeRecurso;
    }

    @Override
    public String toString() {
        return "AnexobbSpreadsheetEntity{" +
                "referencia='" + referencia + '\'' +
                ", numeroBem=" + numeroBem +
                ", nomeContrato='" + nomeNoContrato + '\'' +
                ", grupo='" + grupo + '\'' +
                ", modelo='" + modelo + '\'' +
                ", fornecedor='" + fornecedor + '\'' +
                ", contrato='" + contrato + '\'' +
                ", criticidade=" + criticidade +
                ", valor='" + valor + '\'' +
                ", vlrParceiros='" + vlrParceiros + '\'' +
                ", agencia='" + agencia + '\'' +
                ", sag='" + sag + '\'' +
                ", lat='" + lat + '\'' +
                ", catFaturamento='" + catFaturamento + '\'' +
                ", catAtendimento='" + catAtendimento + '\'' +
                ", latServico='" + latServico + '\'' +
                ", semat='" + semat + '\'' +
                ", configuracao='" + configuracao + '\'' +
                ", componenteDoBem='" + componenteDoBem + '\'' +
                ", proprietario='" + proprietario + '\'' +
                ", numeroserie='" + numeroserie + '\'' +
                ", quantidade='" + quantidade + '\'' +
                ", dataEmServico='" + dataEmServico + '\'' +
                ", dataAbsorcao='" + dataAbsorcao + '\'' +
                ", empregado='" + empregado + '\'' +
                ", timeRecurso='" + timeRecurso + '\'' +
                '}';
    }
}
