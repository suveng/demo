package com.my.qs.esdemo.controller;

import com.my.qs.esdemo.service.EsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EsController {

    @Autowired
    private EsService esService;

    @GetMapping("/index")
    public String index(@RequestParam String name) {
        return esService.index(name);
    }

    @GetMapping("/update")
    public String update(@RequestParam String name, @RequestParam String updateName) {
        return esService.update(name, updateName);
    }

    @GetMapping("/search")
    public String search(@RequestParam String name) {
        return esService.search(name);
    }

    @GetMapping("/delete")
    public String delete(@RequestParam String name) {
        return esService.delete(name);
    }

    @GetMapping("/analyze")
    public String analyze(@RequestParam String text) {
        return esService.analyze(text);
    }

    @GetMapping("/autocomplete")
    @ResponseBody
    public List<String> autoComplete(@RequestParam String prefix) {
        return esService.autoCompletion(prefix);
    }
}
