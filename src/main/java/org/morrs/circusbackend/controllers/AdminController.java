package org.morrs.circusbackend.controllers;

import lombok.AllArgsConstructor;
import org.morrs.circusbackend.models.Artist;
import org.morrs.circusbackend.services.ArtistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/123")
    public String create(@ModelAttribute("artist") Artist artist) {
        artist.setArtistNum(100);
        artistsService.save(artist);
        return "admin/index-admin";
    }


}
