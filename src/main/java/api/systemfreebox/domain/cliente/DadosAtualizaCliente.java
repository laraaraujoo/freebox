package api.systemfreebox.domain.cliente;

public record DadosAtualizaCliente(
  
    Long id,
    String nome,
    String cpf, 
    String email,
    String telefone
){
} 