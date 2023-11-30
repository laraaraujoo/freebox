package api.systemfreebox.domain.lojista;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/lojistas")
@CrossOrigin("http://localhost:8081")
public class LojistaController {

    @Autowired
    private LojistaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroLojista dados, UriComponentsBuilder uriBuilder){
        var lojista = new Lojista(dados);
        repository.save(lojista);
        var uri = uriBuilder.path("/lojistas/{id}").buildAndExpand(lojista.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhadosLojista(lojista));
    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemLojista>>listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemLojista::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaLojista dados){
        var lojista  = repository.getReferenceById(dados.id());
        lojista.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhadosLojista(lojista));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        var lojista = repository.getReferenceById(id);
        lojista.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var lojista = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhadosLojista(lojista));
    }
}
