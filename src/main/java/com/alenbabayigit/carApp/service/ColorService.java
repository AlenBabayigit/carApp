package com.alenbabayigit.carApp.service;

import com.alenbabayigit.carApp.entity.Color;

import java.util.List;

public interface ColorService {
    Color createColor(Color color);
    Color getColorByID(String colorID);
    List<Color> getAllColors();
    Color updateColor(String colorID, Color updatedColor);
    void deleteBrandByID(String colorID);
    void deleteAllBrands();
}
