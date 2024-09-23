package julioapm.ex1_biblioteca;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/biblioteca")
public class Controller {
    private final AcervoRepository acervo;

    public Controller(AcervoRepository acervo) {
        this.acervo = acervo;
    }

    @GetMapping
    public String mensagemDeBemVindo() {
        return "Bem vindo à biblioteca central!";
    }

    @GetMapping("/livros")
    public List<Livro> getLivros() {
        return acervo.getAll();
    }

    @GetMapping("/livrosautor")
    public List<Livro> getLivrosDoAutor(@RequestParam String autor) {
        return acervo.getLivrosDoAutor(autor);
    }

    @GetMapping("/livrostitulo/{titulo}")
    public ResponseEntity<List<Livro>> getLivrosPorTitulo(@PathVariable String titulo) {
        var resultado = acervo.getLivrosTitulo(titulo);
        if (resultado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(resultado);
    }

    @GetMapping("/autores")
    public List<String> getAutores() {
        return acervo.getAutores();
    }

    @GetMapping("titulos")
    public List<String> getTitulos() {
        return acervo.getTitulos();
    }

    @PostMapping("/novolivro")
    public boolean cadastraLivroNovo(@RequestBody final Livro livro) {
        return acervo.cadastraLivroNovo(livro);
    }

    @PostMapping("/emprestarlivro/{codigo}")
    public ResponseEntity<String> emprestarLivro(@PathVariable int codigo, @RequestBody Usuario usuario) {
        boolean resultado = acervo.emprestarLivro(codigo, usuario);
        if (resultado) {
            return ResponseEntity.status(HttpStatus.OK).body("Livro emprestado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível emprestar o livro.");
        }
    }

    @PostMapping("/devolverlivro/{codigo}")
    public ResponseEntity<String> devolverLivro(@PathVariable int codigo) {
        boolean resultado = acervo.devolverLivro(codigo);
        if (resultado) {
            return ResponseEntity.status(HttpStatus.OK).body("Livro devolvido com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível devolver o livro.");
        }
    }

    @GetMapping("/livrosemprestados")
    public List<Livro> getLivrosEmprestados() {
        return acervo.getLivrosEmprestados();
    }

    @GetMapping("/livrosdisponiveis")
    public List<Livro> getLivrosDisponiveis() {
        return acervo.getLivrosDisponiveis();
    }

    @GetMapping("/livrosemprestadosusuario")
    public List<Livro> getLivrosEmprestadosPorUsuario(@RequestBody Usuario usuario) {
        return acervo.getLivrosEmprestadosPorUsuario(usuario);
    }
}
