package api.systemfreebox.domain.lojista;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface LojistaRepository extends JpaRepository<Lojista, Long> {

    Page<Lojista> findAllByAtivoTrue(Pageable paginacao);
}
