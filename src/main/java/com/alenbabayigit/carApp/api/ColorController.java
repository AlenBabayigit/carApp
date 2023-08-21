package com.alenbabayigit.carApp.api;

import com.alenbabayigit.carApp.color.Color;
import com.alenbabayigit.carApp.color.ColorServiceImpl;
import java.util.List;

import com.alenbabayigit.carApp.color.model.request.CreateColorRequest;
import com.alenbabayigit.carApp.color.model.request.UpdateColorRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colors")
public class ColorController {

    private final ColorServiceImpl colorService;
    
    public ColorController(ColorServiceImpl colorService) {
        this.colorService = colorService;
    }

    // Create a new Color
    @PostMapping
    public Color create(@RequestBody CreateColorRequest createColorRequest) {
        return colorService.create(createColorRequest);
    }

    // Get all Colors
    @GetMapping
    public List<Color> getAll() {
        return colorService.getAll();
    }

    // Get Color by ID
    @GetMapping("/{id}")
    public Color getById(@PathVariable Integer id) {
        return colorService.getById(id);
    }

    // Update Color by ID
    @PutMapping("/")
    public Color update(@RequestParam Integer id, @RequestBody UpdateColorRequest updatedColorRequest) {
        return colorService.update(id, updatedColorRequest);
    }


    // Delete Color by ID
    @DeleteMapping("/{id}")
    public void deleteColor(@PathVariable Integer id) {
        colorService.delete(id);
    }


}
