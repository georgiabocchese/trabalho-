package julioapm.ex1_biblioteca;

import java.util.List;

public interface AcervoRepository {
    List<Livro> getAll();
    List<String> getAutores();
    List<String> getTitulos();
    List<Livro> getLivrosDoAutor(String autor);
    List<Livro> getLivrosTitulo(String titulo);
    boolean cadastraLivroNovo(Livro livro);
    boolean removeLivro(int codigo);
    boolean emprestarLivro(int codigo, Usuario usuario);
    boolean devolverLivro(int codigo);
    List<Livro> getLivrosEmprestados();
    List<Livro> getLivrosDisponiveis();
    List<Livro> getLivrosEmprestadosPorUsuario(Usuario usuario);
}
