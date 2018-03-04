import org.junit.Assert;
import org.junit.Test;

import java.util.Dictionary;

public class ValidadorPredicateTest {

    @Test
    public void garantirQuePredicateNaoDeveRetornarInconsistenciasQuandoVerdadeiro() {
        Validador validador = new Validador();
        Integer n = 10;
        Dictionary<String, String> resultado = validador
                .garantirQue((Integer i) -> i >= 10, n, Mensagem.semIdentificador("Teste", "Valor inválido"))
                .obterResultado();

        Assert.assertTrue(resultado.isEmpty());
    }

    @Test
    public void garantirQuePredicateDeveRetornarInconsistenciasQuandoFalso() {
        Validador validador = new Validador();
        Integer n = 9;
        Dictionary<String, String> resultado = validador
                .garantirQue((Integer i) -> i >= 10, n, Mensagem.semIdentificador("Teste", "Valor inválido"))
                .obterResultado();

        Assert.assertNotNull(resultado.get("Teste"));
    }

    @Test
    public void naoPermitirQuePredicateNaoDeveRetornarInconsistenciasQuandoVerdadeiro() {
        Validador validador = new Validador();
        Integer n = 10;
        Dictionary<String, String> resultado = validador
                .naoPermitirQue((Integer i) -> i < 10, n, Mensagem.semIdentificador("Teste", "Valor inválido"))
                .obterResultado();

        Assert.assertTrue(resultado.isEmpty());
    }

    @Test
    public void naoPermitirQuePredicateDeveRetornarInconsistenciasQuandoFalso() {
        Validador validador = new Validador();
        Integer n = 9;
        Dictionary<String, String> resultado = validador
                .naoPermitirQue((Integer i) -> i < 10, n, Mensagem.semIdentificador("Teste", "Valor inválido"))
                .obterResultado();

        Assert.assertNotNull(resultado.get("Teste"));
    }
}
