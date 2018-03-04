import org.junit.Assert;
import org.junit.Test;

import java.util.Dictionary;

public class ValidadorCustomPredicateTest {

    @Test
    public void garantirQueCustomPredicateNaoDeveRetornarInconsistenciasQuandoVerdadeiro() {
        Validador validador = new Validador();
        final Integer n = 5;
        final String nome = "mauro";
        final String sobreNome = "leal";
        ICustomPredicate<String, String, Integer> predicado = (String s1, String s2, Integer i) -> s1 != null && s2 != null && s1.length() >= i && s1.length() > s2.length();
        Dictionary<String, String> resultado = validador
                .garantirQue(predicado,nome, sobreNome, n, Mensagem.semIdentificador("Teste", "Valor inválido"))
                .obterResultado();

        Assert.assertTrue(resultado.isEmpty());
    }

    @Test
    public void garantirQueCustomPredicateDeveRetornarInconsistenciasQuandoFalso() {
        Validador validador = new Validador();
        final Integer n = 5;
        final String nome = "mauro";
        final String sobreNome = "silva";
        ICustomPredicate<String, String, Integer> predicado = (String s1, String s2, Integer i) -> s1 != null && s2 != null && s1.length() >= i && s1.length() > s2.length();
        Dictionary<String, String> resultado = validador
                .garantirQue(predicado,nome, sobreNome, n, Mensagem.semIdentificador("Teste", "Valor inválido"))
                .obterResultado();

        Assert.assertNotNull(resultado.get("Teste"));
    }

    @Test
    public void naoPermitirQueCustomPredicateNaoDeveRetornarInconsistenciasQuandoVerdadeiro() {
        Validador validador = new Validador();

        final Integer n = 5;
        final String nome = "mauro";
        final String sobreNome = "leal";
        ICustomPredicate<String, String, Integer> predicado = (String s1, String s2, Integer i) -> s1 == null || s2 == null || s1.length() < i || s1.length() <= s2.length();
        Dictionary<String, String> resultado = validador
                .naoPermitirQue(predicado,nome, sobreNome, n, Mensagem.semIdentificador("Teste", "Valor inválido"))
                .obterResultado();

        Assert.assertTrue(resultado.isEmpty());
    }

    @Test
    public void naoPermitirQueCustomPredicateDeveRetornarInconsistenciasQuandoFalso() {
        Validador validador = new Validador();

        final Integer n = 5;
        final String nome = "mauro";
        final String sobreNome = "silva";
        ICustomPredicate<String, String, Integer> predicado = (String s1, String s2, Integer i) -> s1 == null || s2 == null || s1.length() < i || s1.length() <= s2.length();
        Dictionary<String, String> resultado = validador
                .naoPermitirQue(predicado,nome, sobreNome, n, Mensagem.semIdentificador("Teste", "Valor inválido"))
                .obterResultado();

        Assert.assertNotNull(resultado.get("Teste"));
    }
}
