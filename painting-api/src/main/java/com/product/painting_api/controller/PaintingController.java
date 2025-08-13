package com.product.painting_api.controller;

import com.product.painting_api.entity.Painting;
import com.product.painting_api.service.PaintingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PaintingController {

    private PaintingService paintingService;

    public PaintingController(PaintingService paintingService){
        this.paintingService = paintingService;
    }

    @GetMapping("/paintings")
    public ResponseEntity<List<Painting>> getAllPaintings(){
        return  new ResponseEntity<>(paintingService.getAllPaintings(), HttpStatus.OK);
    }

    @GetMapping("painting/{id}")
    public ResponseEntity<Painting> getPaintingById(@PathVariable int id){
        return new ResponseEntity<>(paintingService.getPaintingById(id),HttpStatus.OK);
    }

    @PostMapping("/painting")
    public ResponseEntity<Painting> addPainting(@RequestBody Painting painting){
        Painting painting1  = paintingService.addPainting(painting);
        if(painting1 != null){
            return new ResponseEntity<>(painting1, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/painting/{id}")
    public ResponseEntity<String> updatePaintingById( @PathVariable int id, @RequestBody Painting painting){
        Painting painting1 = paintingService.getPaintingById(id);

        if(painting1 != null){
            paintingService.updatePainting(id, painting);
            return new ResponseEntity<>("Painting updated", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Error", HttpStatus.OK);
        }
    }

    @DeleteMapping("/painting/{id}")
    public ResponseEntity<String> deletePaintingById(@PathVariable int id){
        Painting painting = paintingService.getPaintingById(id);

        if(painting != null){
            paintingService.deletePaintingById(id);
            return new ResponseEntity<>("Painting deleted",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Error something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}
