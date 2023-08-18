package com.alenbabayigit.carApp.service;

import com.alenbabayigit.carApp.dao.ColorRepository;
import com.alenbabayigit.carApp.entity.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorServiceImpl implements ColorService {

    private final ColorRepository colorRepository;

    @Autowired
    public ColorServiceImpl(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    // Create Color
    public Color createColor(Color color) {
        return colorRepository.save(color);
    }

    // Get Color by ID
    public Color getColorByID(String colorID) {
        Optional<Color> optionalColor = colorRepository.findById(colorID);
        return optionalColor.isPresent() ? optionalColor.get() : null;
    }

    // Get all Colors
    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    // Update Color
        public Color updateColor(String colorID, Color updatedColor) {
        Color color = getColorByID(colorID);
        if (color != null) {
            color.setId(updatedColor.getId());
            color.setName(updatedColor.getName());
            return colorRepository.save(color);
        }
        return null;
    }

    // Delete Color by ID
    public void deleteBrandByID(String colorID) {
        colorRepository.deleteById(colorID);
    }

    // Delete All Colors
    public void deleteAllBrands() {
        colorRepository.deleteAll();
    }
}
