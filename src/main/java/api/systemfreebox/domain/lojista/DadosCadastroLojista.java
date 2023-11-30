package api.systemfreebox.domain.lojista;


import jakarta.validation.constraints.NotBlank;

public record DadosCadastroLojista(
        @NotBlank
        String email,

        @NotBlank
        String nome,

        @NotBlank
        String telefone,

        @NotBlank
        String cnpj
) {
}
