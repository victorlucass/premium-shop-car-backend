package com.premiumshopcarbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    private String modelo;

    private String descricao;

    private Integer ano;

    private Integer km;

    private Integer finalPlaca;

    private Integer valor;

    private String cor;

    private String imagem;

    private String cambio;

    private String localidade;

    private String combustivel;

    private Boolean garantiaFabrica;

    private Boolean unicoDono;

    private Boolean ipvaPago;

    private Boolean licenciado;

    public static Car converter(Car car){
        var car1 = new Car();
        car1.setId(car.getId());
        car1.setNome(car.getNome());
        car1.setModelo(car.getModelo());
        car1.setDescricao(car.getDescricao());
        car1.setAno(car.getAno());
        car1.setKm(car.getKm());
        car1.setFinalPlaca(car.getFinalPlaca());
        car1.setValor(car.getValor());
        car1.setCor(car.getCor());
        car1.setImagem(car.getImagem());
        car1.setCambio(car.getCambio());
        car1.setLocalidade(car.getLocalidade());
        car1.setCombustivel(car.getCombustivel());
        car1.setGarantiaFabrica(car.getGarantiaFabrica());
        car1.setUnicoDono(car.getUnicoDono());
        car1.setIpvaPago(car.getIpvaPago());
        car1.setLicenciado(car.getLicenciado());
        return car1;
    }


}
