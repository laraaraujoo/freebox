package api.systemfreebox.domain.lojista;

public record DadosListagemLojista(

        Long id,
        String nome,
        String cnpj

){

    public DadosListagemLojista(Lojista lojista){
            this(lojista.getId(), lojista.getNome(), lojista.getCnpj());
        }
}
