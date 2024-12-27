package org.study.processamentoplanilhas.util;

public class Formatter {
    public static String getStringRemoveChars(String stringValue, int tamanhoMinimo) {
        String valueSemPonto = stringValue.split("\\.", 2)[0];
        int valorSemPontoTamanho = valueSemPonto.length();
        int tamanhoFaltando = tamanhoMinimo - valorSemPontoTamanho;
        String prefixoZeros = "0".repeat(tamanhoFaltando);

        return prefixoZeros + valueSemPonto;
    }


}
