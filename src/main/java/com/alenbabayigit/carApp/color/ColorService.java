package com.alenbabayigit.carApp.color;


import com.alenbabayigit.carApp.color.model.request.CreateColorRequest;
import com.alenbabayigit.carApp.color.model.request.UpdateColorRequest;
import com.alenbabayigit.carApp.color.model.response.ColorGetByIdResponse;
import org.springframework.http.ResponseEntity;

public interface ColorService {
    Color create(CreateColorRequest createColorRequest);

    ColorGetByIdResponse getById(Integer id);

    ResponseEntity<?> getAll();

    Color update(Integer id, UpdateColorRequest updateColorRequest);

    Color getColorById(Integer id);

    void delete(Integer id);
}
