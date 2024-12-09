package org.morrs.circusbackend.controllers;

import lombok.AllArgsConstructor;
import org.morrs.circusbackend.models.TicketsSale;
import org.morrs.circusbackend.repo.ArtistReportRepository;
import org.morrs.circusbackend.repo.PerformanceReportRepository;
import org.morrs.circusbackend.repo.TicketsRepository;
import org.morrs.circusbackend.services.TicketsSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/viewer")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ViewerController {

    private ArtistReportRepository artistReportRepository;
    private PerformanceReportRepository performanceReportRepository;
    private TicketsRepository ticketsRepository;
    private TicketsSaleService ticketsSaleService;

    @GetMapping("")
    public String viewer() {
        return "viewer/index-viewer";
    }

    @GetMapping("artist-report")
    public String artistReport(Model model) {
        model.addAttribute("artistsReport", artistReportRepository.getReport());
        return "viewer/artists-report";
    }

    @GetMapping("/performance-report")
    public String performanceReport(Model model) {
        model.addAttribute("performancesReport", performanceReportRepository.getPerformances());
        return "viewer/performance-report";
    }

    @GetMapping("/{id}/tickets")
    public String tickets(@PathVariable("id") int id, Model model) {
        model.addAttribute("freeTickets", ticketsRepository.findAllFreeTickets(id));
        return "viewer/buy-ticket";
    }

    @PostMapping("/buy-ticket/{id}")
    public String buyTicket(@PathVariable("id") int ticketId, @ModelAttribute("ticket")TicketsSale ticketsSale) {
        ticketsSaleService.save(ticketsSale, ticketId);
        return "viewer/index-viewer";
    }


}
