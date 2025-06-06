package mx.unam.aragon.ico.is.celularesapi;

import mx.unam.aragon.ico.is.celularesapi.entitys.Celular;
import mx.unam.aragon.ico.is.celularesapi.repositories.CelularesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CelularesApiApplicationTests {

	@Autowired
	private CelularesRepository celularesRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void insertarCelulares() {
		Celular celular = new Celular(5, "Huawei", "Pura 30",null,10000.0f);
		celularesRepository.save(celular);
		System.out.println(celular);
	}

	@Test
	void leerCelularPorClave() {
		Integer claveTmp = 1;
		Celular tmp =  celularesRepository.findCelularByClave(claveTmp);
		System.out.println(tmp);
	}

	@Test
	public void eliminarCelular() {
		Integer claveTmp = 2;
		celularesRepository.deleteById(claveTmp);
		System.out.println(celularesRepository.findCelularByClave(claveTmp));
	}

	@Test
	public void actualizarComputadora() {
		Integer claveTmp = 3;
		Celular tmp =  celularesRepository.findCelularByClave(claveTmp);
		tmp.setModelo("S24+");
		celularesRepository.save(celularesRepository.findCelularByClave(claveTmp));
	}

}
