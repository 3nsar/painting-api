package com.product.painting_api.service;

import com.product.painting_api.entity.Painting;
import com.product.painting_api.repository.PaintingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaintingService {

    private final PaintingRepository paintingRepository;

    public PaintingService(PaintingRepository paintingRepository){
        this.paintingRepository = paintingRepository;
    }

    public List<Painting> getAllPaintings(){
        return paintingRepository.findAll();
    }

    public Painting getPaintingById(int id){
        return paintingRepository.findById(id).orElse(null);
    }

    public Painting addPainting(Painting painting){
        return paintingRepository.save(painting);
    }

    public Painting updatePainting(int id, Painting painting){
        if(paintingRepository.existsById(id)){
            painting.setId(id);
            return paintingRepository.save(painting);
        }else{
            return null;
        }
    }

    public void deletePaintingById(int id){
        paintingRepository.deleteById(id);
    }


}
