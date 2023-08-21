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

    @PostMapping
    public Color create(@RequestBody CreateColorRequest createColorRequest) {
        return colorService.create(createColorRequest);
    }

    @GetMapping
    public List<Color> getAll() {
        return colorService.getAll();
    }

    @GetMapping("/{id}")
    public Color getById(@PathVariable Integer id) {
        return colorService.getById(id);
    }

    @PutMapping("/")
    public Color update(@RequestParam Integer id, @RequestBody UpdateColorRequest updatedColorRequest) {
        return colorService.update(id, updatedColorRequest);
    }


    // Delete Color by ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        colorService.delete(id);
    }


}
