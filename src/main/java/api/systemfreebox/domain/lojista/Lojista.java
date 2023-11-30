package api.systemfreebox.domain.lojista;

import api.systemfreebox.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;



@Table(name = "lojistas")
@Entity(name = "lojista")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Lojista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String nome;

    private String telefone;

    private String cnpj;

    private boolean ativo;


    public Lojista(DadosCadastroLojista dados) {

        this.email = dados.email();
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.cnpj = dados.cnpj();
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizaLojista dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }if (dados.email() != null){
            this.email = dados.email();;
        }

    }

    public void  excluir(){
        this.ativo = false;
    }

}