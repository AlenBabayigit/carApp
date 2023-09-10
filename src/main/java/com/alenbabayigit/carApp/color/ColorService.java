package com.alenbabayigit.carApp.color;


import com.alenbabayigit.carApp.color.model.request.CreateColorRequest;
import com.alenbabayigit.carApp.color.model.request.UpdateColorRequest;
import com.alenbabayigit.carApp.color.model.response.ColorGetByIdResponse;
import org.springframework.http.ResponseEntity;

public interface ColorService {
    ResponseEntity<?> create(CreateColorRequest createColorRequest);

    ResponseEntity<?> getById(Integer id);

    ResponseEntity<?> getAll();

    ResponseEntity<?> update(Integer id, UpdateColorRequest updateColorRequest);

    Color getColorById(Integer id);

    ResponseEntity<?> delete(Integer id);
}
