package com.premiumshopcarbackend.services;

import com.premiumshopcarbackend.DTO.CarDTO;
 import com.premiumshopcarbackend.entities.Car;
import com.premiumshopcarbackend.repositories.CarRespository;
import com.premiumshopcarbackend.services.exceptions.ObjectNotFoundException;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServices implements BaseResourceService<Car, CarDTO> {

    @Autowired
    private CarRespository repo;

    @Override
    public List<Car> findAll() {
        return repo.findAll();
    }

    @Override
    public Car findById(Integer id) {
        Optional<Car> carSelect = repo.findById(id);
        return carSelect.orElseThrow(
                () -> new ObjectNotFoundException("Carro não encontrado! Talvez o id " + id + " não exista."));
    }

    /*Pesquisa por nome*/
    public List<Car> findByName(String name){
        return repo.findByNomeContains(name).stream().map(Car::converter).collect(Collectors.toList());
    }

    /*Paginação*/
    public Page<Car> findByPage(Integer page, Integer linesPerPage, String direction, String orderBy){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    @Override
    public Car save(CarDTO dto) {
        Car car = fromObject(new Car(), dto);
        car.setId(null);
        return repo.save(car);
    }

    @Override
    public Car update(CarDTO dto) {
        Car carSelect = findById(dto.getId());
        fromObject(carSelect, dto);
        return repo.save(carSelect);
    }

    @Override
    public void delete(Integer id) {
        Car carDelete = findById(id);
        repo.delete(carDelete);
    }

    public byte[] addPhoto(@PathVariable Integer id, @RequestParam("foto") Part arquivo){
        Optional<Car> car = repo.findById(id);
        return car.map( c -> {
            try{
                InputStream is = arquivo.getInputStream();
                byte[] bytes = new byte[(int) arquivo.getSize()];
                IOUtils.readFully(is, bytes);
                c.setImagem(bytes);
                repo.save(c);
                is.close();
                return bytes;
            }catch (IOException e){
                return null;
            }
        }).orElseThrow(() -> new ObjectNotFoundException("Erro ao enviar foto!"));
    }

    private Car fromObject(Car car, CarDTO dto) {
        car.setId(dto.getId());
        car.setNome((dto.getNome() != null) ? dto.getNome() : car.getNome());
        car.setModelo((dto.getModelo() != null) ? dto.getModelo() : car.getModelo());
        car.setDescricao((dto.getDescricao() != null) ? dto.getDescricao() : car.getDescricao());
        car.setAno((dto.getAno() != null) ? dto.getAno() : car.getAno());
        car.setKm((dto.getKm() != null) ? dto.getKm() : car.getKm());
        car.setFinalPlaca((dto.getFinalPlaca() != null) ? dto.getFinalPlaca() : car.getFinalPlaca());
        car.setValor((dto.getValor() != null) ? dto.getValor() : car.getValor());
        car.setCor((dto.getCor() != null) ? dto.getCor() : car.getCor());
        car.setImagem((dto.getImagem() != null) ? dto.getImagem() : car.getImagem());
        car.setCambio((dto.getCambio() != null) ? dto.getCambio() : car.getCambio());
        car.setLocalidade((dto.getLocalidade() != null) ? dto.getLocalidade() : car.getLocalidade());
        car.setCombustivel((dto.getCombustivel() != null) ? dto.getCombustivel() : car.getCombustivel());
        car.setGarantiaFabrica((dto.getGarantiaFabrica() != null) ? dto.getGarantiaFabrica() : car.getGarantiaFabrica());
        car.setUnicoDono((dto.getUnicoDono() != null) ? dto.getUnicoDono() : car.getUnicoDono());
        car.setIpvaPago((dto.getIpvaPago() != null) ? dto.getIpvaPago() : car.getIpvaPago());
        car.setLicenciado((dto.getLicenciado() != null) ? dto.getLicenciado() : car.getLicenciado());
        return car;
    }
}
