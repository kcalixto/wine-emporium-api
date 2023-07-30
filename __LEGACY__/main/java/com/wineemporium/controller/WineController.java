package com.wineemporium.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wineemporium.entity.Wine;
import com.wineemporium.service.WineService;
import com.wineemporium.utils.ValidationException;

@RestController
@RequestMapping("/wine")
public class WineController {

    @Autowired
    private WineService svc;

    @GetMapping("")
    public ResponseEntity<List<Wine>> getAll() {
        return ResponseEntity.ok(svc.listAll());
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<Wine> getWine(@PathVariable Integer id) {
    // Wine wine = wineService.findById(id).get();

    // if (wine == null) {
    // return ResponseEntity.notFound().build();
    // }

    // return ResponseEntity.ok(wine);
    // }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Wine wine) {
        try {
            svc.save(wine);
            return ResponseEntity.ok().build();
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    // @PutMapping("/save/{id}")
    // public ResponseEntity<String> updateWine(@PathVariable Integer id,
    // @RequestBody Wine wine) {
    // Wine wineToUpdate = wineRepository.findById(id).get();

    // if (wineToUpdate == null) {
    // return ResponseEntity.notFound().build();
    // }

    // // todo validate empty inputs
    // wineToUpdate.setName(wine.getName());
    // wineToUpdate.setDocument(wine.getDocument());
    // wineToUpdate.setEmail(wine.getEmail());
    // wineToUpdate.setPhoneDomain(wine.getPhoneDomain());
    // wineToUpdate.setPhoneNumber(wine.getPhoneNumber());

    // wineRepository.save(wineToUpdate);

    // return ResponseEntity.ok().build();

    // }

}
