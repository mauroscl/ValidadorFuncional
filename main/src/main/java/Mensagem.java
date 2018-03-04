public class Mensagem {
    private String grupo;
    private String descricao;
    private String identificador;

    public String getGrupo() {
        return grupo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getIdentificador() {
        return identificador;
    }

    private Mensagem(String grupo, String descricao, String identificador) {
        this.grupo = grupo;
        this.descricao = descricao;
        this.identificador = identificador;
    }

    private Mensagem(String grupo, String descricao) {
        this.grupo = grupo;
        this.descricao = descricao;
    }

    public static Mensagem semIdentificador(String grupo, String descricao){
        return new Mensagem(grupo, descricao);
    }

    public static Mensagem comIdentificador(String grupo, String descricao, String identificador){
        return new Mensagem(grupo, descricao, identificador);
    }
}
