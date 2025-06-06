package mx.unam.aragon.ico.is.celularesapi.repositories;


import mx.unam.aragon.ico.is.celularesapi.entitys.Celular;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CelularesRepository extends JpaRepository<Celular, Integer> {

    public Celular findCelularByClave(Integer clave);
        public Celular deleteByClave(Integer clave);
}
