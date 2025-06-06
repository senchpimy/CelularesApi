package mx.unam.aragon.ico.is.celularesapi.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "celulares")
public class Celular {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clave;

    @Column (name = "marca_celular", nullable = false, length = 50)
    private String marca;

    @Column (name = "modelo_celular", columnDefinition = "VARCHAR(50) not null")
    @NotBlank(message =  "El campo no debe tener solo espacios en blanco")
    @NotNull(message = "No debe ser nulo")
    private String modelo;

    @Column(name = "url_foto", nullable = true, insertable = true,
            columnDefinition = "VARCHAR(500) DEFAULT 'https://cdn1.iconfinder.com/data/icons/image-manipulations/100/13-512.png'")
    private String foto;

    @Column (name = "precio_pesos", nullable = true)
    private Float precio;


    @Override
    public String toString() {
        return "Celular{" +
                "clave=" + clave +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", foto='" + foto + '\'' +
                ", precio=" + precio +
                '}';
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Celular(int clave, String marca, String modelo, String foto, Float precio) {
        this.clave = clave;
        this.marca = marca;
        this.modelo = modelo;
        this.foto = foto;
        this.precio = precio;
    }

    public Celular() {
    }
}
