package com.wineemporium.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wineemporium.entity.Wine;
import com.wineemporium.repository.WineRepository;
import com.wineemporium.utils.Validate;
import com.wineemporium.utils.ValidationException;

@Service
public class WineService {

    @Autowired
    WineRepository winerepo;

    public List<Wine> listAll() {
        return winerepo.findAll();
    }

    public void save(Wine wine) throws ValidationException {
        Validate validation = wine.validate();
        if (!validation.isValid()) {
            throw new ValidationException(validation);
        }

        winerepo.save(wine);
    }
}
