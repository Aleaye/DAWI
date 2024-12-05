package pe.edu.cibertec.cl2.GUTIERREZ_CAYO.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.edu.cibertec.cl2.GUTIERREZ_CAYO.dto.FilmDto;
import pe.edu.cibertec.cl2.GUTIERREZ_CAYO.service.MaintenanceService;

import java.util.List;

public class FilmController {

    private MaintenanceService maintenanceService;

    @GetMapping("/films")
    public String listFilms(Model model) {
        List<FilmDto> films = maintenanceService.findAllFilms();
        model.addAttribute("films", films);
        return "films"; // Nombre del template (films.html)
    }
}
