package com.alenbabayigit.carApp.api;

import com.alenbabayigit.carApp.color.Color;
import com.alenbabayigit.carApp.color.ColorServiceImpl;
import java.util.List;

import com.alenbabayigit.carApp.color.model.request.CreateColorRequest;
import com.alenbabayigit.carApp.color.model.request.UpdateColorRequest;
import com.alenbabayigit.carApp.color.model.response.ColorGetByIdResponse;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getAll() {
        return colorService.getAll();
    }

    @GetMapping("/{id}")
    public ColorGetByIdResponse getById(@PathVariable Integer id) {
        return colorService.getById(id);
    }

    @PutMapping("/")
    public Color update(@RequestParam Integer id, @RequestBody UpdateColorRequest updateColorRequest) {
        return colorService.update(id, updateColorRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        colorService.delete(id);
    }
}
