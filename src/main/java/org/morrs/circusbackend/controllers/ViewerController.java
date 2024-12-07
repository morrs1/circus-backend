package org.morrs.circusbackend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/viewer")
public class ViewerController {

    @GetMapping("")
    public String viewer() {
        return "viewer/index-viewer";
    }

}
