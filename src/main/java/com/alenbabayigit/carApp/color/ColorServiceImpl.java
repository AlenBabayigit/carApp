package com.alenbabayigit.carApp.color;

import com.alenbabayigit.carApp.color.model.request.CreateColorRequest;
import com.alenbabayigit.carApp.color.model.request.UpdateColorRequest;
import com.alenbabayigit.carApp.color.model.response.ColorGetAllResponse;
import com.alenbabayigit.carApp.color.model.response.ColorGetByIdResponse;
import com.alenbabayigit.carApp.exception.BusinessException;
import com.alenbabayigit.carApp.util.ResponseBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {

    private final ColorRepository colorRepository;

    public ColorServiceImpl(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @Override
    public Color create(CreateColorRequest createColorRequest) {
        Color color = new Color();
        color.setName(createColorRequest.name());
        return colorRepository.save(color);
    }

    @Override
    public ColorGetByIdResponse getById(Integer id) {
        Color color = getColorById(id);
        return new ColorGetByIdResponse(color.getName());
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<ColorGetAllResponse> list = colorRepository.findAll().stream().map(color -> new ColorGetAllResponse(color.getId(), color.getName())).toList();
        return ResponseBuilder.success("Data listed successfully", list);
    }

    @Override
    public Color update(Integer id, UpdateColorRequest updateColorRequest) {
        Color color = getColorById(id);
        color.setName(updateColorRequest.name());
        return colorRepository.save(color);

    }

    @Override
    public Color getColorById(Integer id) {
        return colorRepository.findById(id).orElseThrow(() -> new BusinessException("There is no color with following id: " + id));
    }

    @Override
    public void delete(Integer id) {
        getColorById(id);
        colorRepository.deleteById(id);
    }

}
