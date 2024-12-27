package org.study.processamentoplanilhas.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FormatterTest {

    @Test
    public void quandoValor100ComPontoRetornar0100(){
      String valorFormatado = Formatter.getStringRemoveChars("100.0", 4);
        Assertions.assertThat(valorFormatado).isEqualTo("0100");
    }

    @Test
    public void quandoValor1Retornar01(){
        String valorFormatado = Formatter.getStringRemoveChars("1", 2);
        Assertions.assertThat(valorFormatado).isEqualTo("01");
    }

    @Test
    public void quandoValor100ComPontoE001Retornar0100(){
        String valorFormatado = Formatter.getStringRemoveChars("100.001", 4);
        Assertions.assertThat(valorFormatado).isEqualTo("0100");
    }

    @Test
    public void quandoValor1000Retornar1000(){
        String valorFormatado = Formatter.getStringRemoveChars("1000", 4);
        Assertions.assertThat(valorFormatado).isEqualTo("1000");
    }

}
