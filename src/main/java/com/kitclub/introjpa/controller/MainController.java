package com.kitclub.introjpa.controller;

import com.kitclub.introjpa.entity.CaPhe;
import com.kitclub.introjpa.entity.Hang;
import com.kitclub.introjpa.repository.CaPheRepository;
import com.kitclub.introjpa.repository.HangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    private HangRepository hangRepository;

    @Autowired
    private CaPheRepository caPheRepository;

    @PostMapping("hang")
    public ResponseEntity<Object> createHang(@RequestBody Hang hang) {
        return ResponseEntity.ok(hangRepository.save(hang));
    }

    @GetMapping("hang")
    public ResponseEntity<Object> allHang() {
        return ResponseEntity.ok(hangRepository.findAll());
    }

    @GetMapping("hang/search")
    public ResponseEntity<Object> getHangById(
            @RequestParam(value = "id") Integer id,
            @RequestParam(value = "name") String name) {
        return ResponseEntity.ok(hangRepository.findHangByIdOrNameContains(id, name));
    }



    @PostMapping("caphe")
    public ResponseEntity<Object> createCaPhe(@RequestBody CaPhe caphe) {
        return ResponseEntity.ok(caPheRepository.save(caphe));
    }

    @GetMapping("caphe/hang")
    public ResponseEntity<Object> getCaPheTheoHang(@RequestParam String capheName,
                                                   @RequestParam(required = false) Integer hangId) {
        return ResponseEntity.ok(caPheRepository.customQuery(capheName, hangId));
    }

}
