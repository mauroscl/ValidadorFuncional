import org.junit.Assert;
import org.junit.Test;

import java.util.Dictionary;

public class ValidadorBiPredicateTest {

    @Test
    public void garantirQueBiPredicateNaoDeveRetornarInconsistenciasQuandoVerdadeiro() {
        Validador validador = new Validador();
        final Integer n = 5;
        final String nome = "mauro";
        Dictionary<String, String> resultado = validador
                .garantirQue((String s, Integer i) ->  s != null && s.length() >= i, nome, n, Mensagem.semIdentificador("Teste", "Valor inválido"))
                .obterResultado();

        Assert.assertTrue(resultado.isEmpty());
    }

    @Test
    public void garantirQueBiPredicateDeveRetornarInconsistenciasQuandoFalso() {
        Validador validador = new Validador();
        final Integer n = 5;
        final String nome = "joao";
        Dictionary<String, String> resultado = validador
                .garantirQue((String s, Integer i) ->  s != null && s.length() >= i, nome, n, Mensagem.semIdentificador("Teste", "Valor inválido"))
                .obterResultado();

        Assert.assertNotNull(resultado.get("Teste"));
    }

    @Test
    public void naoPermitirQueBiPredicateNaoDeveRetornarInconsistenciasQuandoVerdadeiro() {
        Validador validador = new Validador();
        final Integer n = 5;
        final String nome = "mauro";
        Dictionary<String, String> resultado = validador
                .naoPermitirQue((String s, Integer i) ->  s == null || s.length() < i, nome, n, Mensagem.semIdentificador("Teste", "Valor inválido"))
                .obterResultado();

        Assert.assertTrue(resultado.isEmpty());
    }

    @Test
    public void naoPermitirQueBiPredicateDeveRetornarInconsistenciasQuandoFalso() {
        Validador validador = new Validador();
        final Integer n = 5;
        final String nome = "joao";
        Dictionary<String, String> resultado = validador
                .naoPermitirQue((String s, Integer i) ->  s == null || s.length() < i, nome, n, Mensagem.semIdentificador("Teste", "Valor inválido"))
                .obterResultado();

        Assert.assertNotNull(resultado.get("Teste"));
    }
}
