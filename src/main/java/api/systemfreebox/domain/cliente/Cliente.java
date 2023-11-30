package api.systemfreebox.domain.cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "clientes")
@Entity(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")



public class Cliente {
       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private boolean ativo;
   // private String endereco;

    public Cliente(DadosCadastroCliente dados ){
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.email = dados.email();
        this.telefone= dados.telefone();
        this.ativo = true;
        //this.endereco= dados.endereco();
    }
    /**
     * @param dados
     */
    public void atualizarInformacoes(DadosAtualizaCliente dados) {
        if (dados.nome () != null) {
            this.nome =  dados.nome();
        }if (dados.cpf () != null){
            this.cpf =  dados.cpf ();
        }if (dados.email () != null) {
            this.email =  dados.email();
        }if (dados.telefone () != null) {
            this.telefone = dados.telefone();
        } /*if (dados.endereco () != null){
            this.endereco = dados.endereco();;
        }*/

       
    }
 public void  excluir(){
            this.ativo = false; }
    
 }


