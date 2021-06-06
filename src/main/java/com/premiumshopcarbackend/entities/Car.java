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


}
