package com.alenbabayigit.carApp.color;


import com.alenbabayigit.carApp.color.model.request.CreateColorRequest;
import com.alenbabayigit.carApp.color.model.request.UpdateColorRequest;

import java.util.List;

public interface ColorService {
    Color create(CreateColorRequest createColorRequest);
    Color getById(Integer id);
    List<Color> getAll();
    Color update(Integer id, UpdateColorRequest updateColorRequest);
    void delete(Integer id);
}
