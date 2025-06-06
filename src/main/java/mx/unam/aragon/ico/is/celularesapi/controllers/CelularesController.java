package mx.unam.aragon.ico.is.celularesapi.controllers;

import jakarta.validation.Valid;
import mx.unam.aragon.ico.is.celularesapi.entitys.Celular;
import mx.unam.aragon.ico.is.celularesapi.services.interfaces.CelularService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/celulares")
public class CelularesController {
    @Autowired
    private CelularService celularService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Celular>> getCelulares() {
        return ResponseEntity.ok().body(celularService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Celular> getCelulares(@PathVariable Integer id) {
        return ResponseEntity.ok(celularService.buscarPorId(id).orElse(null));
    }

    @PostMapping("/")
    public ResponseEntity<Celular> createCelulares(@Valid @RequestBody Celular celular) throws URISyntaxException {
        return ResponseEntity.created(new URI("http://localhost:8080")).body(celularService.crear(celular));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Celular> updateCelular(@PathVariable Integer id, @RequestBody Celular celular) throws URISyntaxException {
        return ResponseEntity.ok(celularService.actualizar(id,celular));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Celular> patchCelular(@PathVariable Integer id, @RequestBody Celular celular) throws URISyntaxException {
        Optional<Celular> tmp = celularService.buscarPorId(id);
        if (tmp.isPresent()) {
            LoggerFactory.getLogger(CelularesController.class).info("Celular atualizado: " + celular);
            Celular actual = tmp.get();
            if(celular.getModelo() != null) actual.setModelo(celular.getModelo());
            if(celular.getMarca() != null) actual.setMarca(celular.getMarca());
            if(celular.getPrecio() != null) actual.setPrecio(celular.getPrecio());
            if (celular.getFoto() != null) actual.setFoto(celular.getFoto());
            return ResponseEntity.ok(celularService.actualizar(id,actual));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCelular(@PathVariable Integer id) {
        celularService.eliminar(id);
    }
}
