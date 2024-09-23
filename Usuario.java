package julioapm.ex1_biblioteca;

public class Usuario {
    private int id;
    private String nome;
    private int anoNascimento;

    public Usuario(int id, String nome, int anoNascimento) {
        this.id = id;
        this.nome = nome;
        this.anoNascimento = anoNascimento;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", anoNascimento=" + anoNascimento + "]";
    }
}
