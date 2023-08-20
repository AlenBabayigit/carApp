package com.alenbabayigit.carApp.controller;

import com.alenbabayigit.carApp.entity.Color;
import com.alenbabayigit.carApp.service.ColorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colors")
public class ColorController {

    private final ColorServiceImpl colorService;

    @Autowired
    public ColorController(ColorServiceImpl colorService) {
        this.colorService = colorService;
    }

    // Create a new Color
    @PostMapping
    public Color createColor(@RequestBody Color color) {
        return colorService.createColor(color);
    }

    // Get all Colors
    @GetMapping
    public List<Color> getAllColors() {
        return colorService.getAllColors();
    }

    // Get Color by ID
    @GetMapping("/{colorID}")
    public Color getColorById(@PathVariable String colorID) {
        return colorService.getColorByID(colorID);
    }

    // Update Color by ID
    @PutMapping("/{colorID}")
    public Color updateColor(@PathVariable String colorID, @RequestBody Color updatedColor) {
        return colorService.updateColor(colorID, updatedColor);
    }

    // Delete all Colors
    @DeleteMapping
    public String deleteAllColors() {
        colorService.deleteAllColors();
        return "All colors have been deleted successfully.";
    }

    // Delete Color by ID
    @DeleteMapping("/{colorID}")
    public void deleteColor(@PathVariable String colorID) {
        colorService.deleteColorByID(colorID);
    }







}
