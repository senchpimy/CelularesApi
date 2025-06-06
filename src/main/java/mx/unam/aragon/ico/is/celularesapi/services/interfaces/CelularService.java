package mx.unam.aragon.ico.is.celularesapi.services.interfaces;

import mx.unam.aragon.ico.is.celularesapi.entitys.Celular;

import java.util.Optional;

public interface CelularService {
    public abstract Celular crear (Celular celular);
    public Iterable<Celular> listarTodas();
    public Optional<Celular> buscarPorId(Integer clave);
    public Celular actualizar(Integer clave, Celular celular);
    public void eliminar(Integer clave);
}
