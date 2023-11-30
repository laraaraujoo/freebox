package api.systemfreebox.domain.lojista;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaLojista(

        @NotNull
        Long id,
        String nome,
        String email,
        String telefone
) {
}
