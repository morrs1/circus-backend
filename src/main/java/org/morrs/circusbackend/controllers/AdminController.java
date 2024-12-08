package org.morrs.circusbackend.controllers;

import lombok.AllArgsConstructor;
import org.morrs.circusbackend.models.Artist;
import org.morrs.circusbackend.services.ArtistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AdminController {

    private ArtistsService artistsService;

    @GetMapping("")
    public String index() {
        return "admin/index-admin";
    }

    @GetMapping("/create")
    public String createPage(@ModelAttribute("artist") Artist artist) {
        return "admin/create";
    }

    @PostMapping("")
    public String create(@ModelAttribute("artist") Artist artist) {
        artistsService.save(artist);
        return "admin/index-admin";
    }

    @GetMapping("read-all")
    public String readAll(Model model) {
        model.addAttribute("artists", artistsService.readAll());
        return "admin/read-all";
    }

    @GetMapping("/{id}/edit")
    public String updatePage(Model model, @PathVariable UUID id) {
        var artist = artistsService.read(id);
        model.addAttribute("artist", artist);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedBirthDate = artist.getBirthDate() != null ? artist.getBirthDate().format(formatter) : "";
        model.addAttribute("formattedBirthDate", formattedBirthDate);
        System.out.println(formattedBirthDate);
        return "admin/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("artist") Artist artist, @PathVariable UUID id) {
        artistsService.update(artist, id);
        return "admin/index-admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") UUID id) {
        artistsService.delete(id);
        return "admin/index-admin";
    }

}
