package mx.unam.aragon.ico.is.celularesapi.services;

import mx.unam.aragon.ico.is.celularesapi.entitys.Celular;
import mx.unam.aragon.ico.is.celularesapi.repositories.CelularesRepository;
import mx.unam.aragon.ico.is.celularesapi.services.interfaces.CelularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CelularServiceImpl implements CelularService {

    @Autowired
    private CelularesRepository celularesRepository;

    @Override
    public Celular crear(Celular celular) {
        return celularesRepository.save(celular);
    }

    @Override
    public Iterable<Celular> listarTodas() {
        return celularesRepository.findAll();
    }

    @Override
    public Optional<Celular> buscarPorId(Integer clave) {
        return celularesRepository.findById(clave);
    }

    @Override
    public Celular actualizar(Integer clave, Celular celular) {
        Optional<Celular> celularActual = celularesRepository.findById(clave);
        if (celularActual.isPresent()) {

            Celular tmp = celularActual.get();
            tmp.setModelo(celular.getModelo());
            tmp.setClave(celular.getClave());
            tmp.setFoto(celular.getFoto());
            tmp.setMarca(celular.getMarca());
            tmp.setPrecio(celular.getPrecio());
            return celularesRepository.save(tmp);
        } else {
            return null;
        }
    }

    @Override
    public void eliminar(Integer clave) {
        celularesRepository.deleteById(clave);
    }


}
