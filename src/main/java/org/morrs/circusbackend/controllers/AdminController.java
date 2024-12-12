package org.morrs.circusbackend.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.morrs.circusbackend.models.Artist;
import org.morrs.circusbackend.repo.TicketsReportRepository;
import org.morrs.circusbackend.services.ArtistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AdminController {

    private ArtistsService artistsService;
    private TicketsReportRepository ticketsReportRepository;

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
    public String update( @PathVariable UUID id, @ModelAttribute("artist") @Valid Artist artist, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/edit";
        }
        artistsService.update(artist, id);
        return "admin/index-admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") UUID id) {
        artistsService.delete(id);
        return "admin/index-admin";
    }

    @GetMapping("/tickets-report")
    public String ticketsReport(Model model) {
        model.addAttribute("tickets", ticketsReportRepository.getReport());
        return "admin/tickets-report";
    }
}
