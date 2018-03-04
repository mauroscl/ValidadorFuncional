import org.junit.Assert;
import org.junit.Test;

import java.util.Dictionary;
import java.util.function.BiPredicate;

public class ValidadorCombinadoTest {

    @Test
    public void devePermitirCombinarVariosTiposDeValidadores() {
        Validador validador = new Validador();
        ICustomPredicate<String, Integer, String> predicate = (String s1, Integer n, String s2) -> s1.length() > s2.length() && s1.length() > n && s2.length() > n;
        Dictionary<String, String> resultado = validador
                .garantirQue((Integer i) -> i > 10, 11,Mensagem.semIdentificador("Teste", "número inválido"))
                .naoPermitirQue((Integer i) -> i <= 10, 11,Mensagem.semIdentificador("Teste", "número inválido"))
                .garantirQue((String s) -> s.length() > 10 , "mauro",Mensagem.semIdentificador("StringTamanho", "Nome inválido"))
                .garantirQue((String s, Integer n) -> s.length() < n, "teste", 11,Mensagem.semIdentificador("StringTamanho", "Nome inválido"))
                .garantirQue(predicate, "mauro", 5, "leal",Mensagem.semIdentificador("CustomPredicate", "parâmetros inválidos"))
                .obterResultado();

        Assert.assertEquals(2, resultado.size());
        Assert.assertNotNull(resultado.get("StringTamanho"));
        Assert.assertNotNull(resultado.get("CustomPredicate"));
    }
}
