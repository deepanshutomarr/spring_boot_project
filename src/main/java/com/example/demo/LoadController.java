package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private LoadService loadService;

    @PostMapping
    public ResponseEntity<String> createLoad(@RequestBody Load load) {
        loadService.saveLoad(load);
        return ResponseEntity.ok("Load details added successfully");
    }

    @GetMapping
    public List<Load> getLoadsByShipperId(@RequestParam String shipperId) {
        return loadService.getLoadsByShipperId(shipperId);
    }

    @GetMapping("/{loadId}")
    public Load getLoadById(@PathVariable UUID loadId) {
        return loadService.getLoadById(loadId);
    }

    @PutMapping("/{loadId}")
    public Load updateLoad(@PathVariable UUID loadId, @RequestBody Load load) {
        return loadService.updateLoad(loadId, load);
    }

    @DeleteMapping("/{loadId}")
    public ResponseEntity<String> deleteLoad(@PathVariable UUID loadId) {
        loadService.deleteLoad(loadId);
        return ResponseEntity.ok("Load deleted successfully");
    }
}

