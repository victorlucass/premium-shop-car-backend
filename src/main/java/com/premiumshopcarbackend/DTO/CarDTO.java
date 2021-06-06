package com.premiumshopcarbackend.DTO;

import com.premiumshopcarbackend.entities.Car;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CarDTO implements Serializable {
    public static final long serialVersionUID = 1L;


    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 70, message = "O tamanho deve ser entre 5 à 70 caracteres.")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String modelo;

    private String descricao;

    private Integer ano;

    private Integer km;

    private Integer finalPlaca;

    private Integer valor;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String cor;


    private String imagem;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String cambio;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String localidade;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String combustivel;

    private Boolean garantiaFabrica;

    private Boolean unicoDono;

    private Boolean ipvaPago;

    private Boolean licenciado;

    public CarDTO(Car car){
        this.id = car.getId();
        this.nome = car.getNome();
        this.modelo = car.getModelo();
        this.descricao = car.getDescricao();
        this.ano = car.getAno();
        this.km = car.getKm();
        this.finalPlaca = car.getFinalPlaca();
        this.valor = car.getValor();
        this.cor = car.getCor();
        this.imagem = car.getImagem();
        this.cambio = car.getCambio();
        this.localidade = car.getLocalidade();
        this.combustivel = car.getCombustivel();
        this.garantiaFabrica = car.getGarantiaFabrica();
        this.unicoDono = car.getUnicoDono();
        this.ipvaPago = car.getIpvaPago();
        this.licenciado = car.getLicenciado();
    }
}
