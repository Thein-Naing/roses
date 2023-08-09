package com.life.roses.controller;

import com.life.roses.exception.RoseNotFoundException;
import com.life.roses.model.Rose;
import com.life.roses.repository.RoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class RoseController {


    @Autowired


    private RoseRepository roseRepository;

    @PostMapping("/addRose")
    Rose newRose(@RequestBody Rose newRose) {
        return roseRepository.save(newRose);
    }

    @GetMapping("/allRoses")
    List<Rose> getALlRoses() {
        return roseRepository.findAll();
    }


    @GetMapping("/rose/{id}")
    Rose getRose(@PathVariable Long id) {
        return roseRepository.findById(id)
                .orElseThrow(() -> new RoseNotFoundException(id));
    }

    @PutMapping("/rose/{id}")
    Rose updateRose(@RequestBody Rose newRose, @PathVariable Long id) {
        return roseRepository.findById(id)
                .map(rose -> {
                    rose.setColor(newRose.getColor());
                    rose.setMeaning(newRose.getMeaning());
                    rose.setSymbol(newRose.getSymbol());
                    return roseRepository.save(rose);

                })
                .orElseThrow(() -> new RoseNotFoundException(id));
    }


    @DeleteMapping("/rose/{id}")
    String deleteRose(@PathVariable Long id) {
        if (!roseRepository.existsById(id)) {
            throw new RoseNotFoundException(id);

        }
        roseRepository.deleteById(id);
        return "Rose with given id " + id + " has been successfully deleted";


    }
}