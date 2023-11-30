package api.systemfreebox.domain.cliente;


public record DadosDetalhadosCliente(
 Long id,

        String email,

        String nome,

        String telefone,

        String cpf
) {
    public DadosDetalhadosCliente(Cliente cliente){
        this(cliente.getId(), cliente.getEmail(), cliente.getNome(), cliente.getTelefone(), cliente.getCpf());
    }   

}
