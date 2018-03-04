import java.util.Dictionary;
import java.util.Hashtable;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Validador {

    private final Dictionary<String, String> inconsistencias;

    public Validador() {
        this.inconsistencias = new Hashtable<>();
    }

    public <T> Validador garantirQue(Predicate<T> predicado, T t, Mensagem mensagem) {
        if(!predicado.test(t)) {
            this.inconsistencias.put(mensagem.getGrupo(), mensagem.getDescricao());
        }
        return this;
    }

    public <T> Validador naoPermitirQue(Predicate<T> predicado, T t, Mensagem mensagem) {
        if(predicado.test(t)) {
            this.inconsistencias.put(mensagem.getGrupo(), mensagem.getDescricao());
        }
        return this;
    }

    public <T, U> Validador garantirQue(BiPredicate<T, U> predicado, T t, U u, Mensagem mensagem) {
        if(!predicado.test(t, u)) {
            this.inconsistencias.put(mensagem.getGrupo(), mensagem.getDescricao());
        }
        return this;
    }

    public <T, U> Validador naoPermitirQue(BiPredicate<T, U> predicado, T t, U u, Mensagem mensagem) {
        if(predicado.test(t, u)) {
            this.inconsistencias.put(mensagem.getGrupo(), mensagem.getDescricao());
        }
        return this;
    }

    public <T, U, V> Validador garantirQue(ICustomPredicate<T, U, V> predicado, T t, U u, V v, Mensagem mensagem) {
        if(!predicado.test(t, u, v)) {
            this.inconsistencias.put(mensagem.getGrupo(), mensagem.getDescricao());
        }
        return this;
    }

    public <T, U, V> Validador naoPermitirQue(ICustomPredicate<T, U, V> predicado, T t, U u, V v, Mensagem mensagem) {
        if(predicado.test(t, u, v)) {
            this.inconsistencias.put(mensagem.getGrupo(), mensagem.getDescricao());
        }
        return this;
    }

    public Dictionary<String, String> obterResultado() {
        return this.inconsistencias;
    }
}
