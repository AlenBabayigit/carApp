package com.alenbabayigit.carApp.color;

import java.util.List;
import java.util.Optional;

import com.alenbabayigit.carApp.color.model.request.CreateColorRequest;
import com.alenbabayigit.carApp.color.model.request.UpdateColorRequest;
import org.springframework.stereotype.Service;

@Service
public class ColorServiceImpl implements ColorService {

    private final ColorRepository colorRepository;

    public ColorServiceImpl(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    // Create Color
    @Override
    public Color create(CreateColorRequest createColorRequest) {
        Color color = new Color();
        color.setName(createColorRequest.name());
        return colorRepository.save(color);
    }

    // Get Color by ID
    @Override
    public Color getById(Integer colorID) {
        Optional<Color> optionalColor = colorRepository.findById(colorID);
        return optionalColor.isPresent() ? optionalColor.get() : null;
    }

    // Get all Colors
    public List<Color> getAll() {
        return colorRepository.findAll();
    }

    // Update Color
        public Color update(Integer id, UpdateColorRequest updateColorRequest) {
        Color color = getColorById(id);
        color.setName(updateColorRequest.name());
        return colorRepository.save(color);

    }

    private Color getColorById(Integer id) {
        return colorRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no color with following id: " + id));
    }

    // Delete Color by ID
    public void delete(Integer id) {
        getColorById(id);
        colorRepository.deleteById(id);
    }


}
