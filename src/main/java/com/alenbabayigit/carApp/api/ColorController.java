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
    public Color createColor(@RequestBody CreateColorRequest createColorRequest) {

        return colorService.create(createColorRequest);
    }

    // Get all Colors
    @GetMapping
    public List<Color> getAllColors() {
        return colorService.getAll();
    }

    // Get Color by ID
    @GetMapping("/{colorID}")
    public Color getColorById(@PathVariable String colorID) {
        return colorService.getColorByID(colorID);
    }

    // Update Color by ID
    @PutMapping("/")
    public Color updateColor(@RequestParam int colorId, @RequestBody UpdateColorRequest updatedColorRequest) {
        return colorService.update(colorId, updatedColorRequest);
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
        colorService.deleteById(colorID);
    }







}
