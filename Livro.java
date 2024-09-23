package julioapm.ex1_biblioteca;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int ano;
    private boolean emprestado;
    private Usuario usuarioEmprestado;

    public Livro(int id, String titulo, String autor, int ano) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.emprestado = false; // Por padrão, o livro não está emprestado
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public Usuario getUsuarioEmprestado() {
        return usuarioEmprestado;
    }

    public void emprestar(Usuario usuario) {
        this.emprestado = true;
        this.usuarioEmprestado = usuario;
    }

    public void devolver() {
        this.emprestado = false;
        this.usuarioEmprestado = null;
    }

    @Override
    public String toString() {
        return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", ano=" + ano + 
               ", emprestado=" + emprestado + ", usuarioEmprestado=" + (usuarioEmprestado != null ? usuarioEmprestado.getNome() : "Nenhum") + "]";
    }
}
