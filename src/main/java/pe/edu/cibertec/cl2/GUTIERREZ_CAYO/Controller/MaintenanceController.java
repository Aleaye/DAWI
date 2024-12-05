package pe.edu.cibertec.cl2.GUTIERREZ_CAYO.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.cl2.GUTIERREZ_CAYO.dto.FilmDto;
import pe.edu.cibertec.cl2.GUTIERREZ_CAYO.service.MaintenanceService;
import pe.edu.cibertec.cl2.GUTIERREZ_CAYO.dto.FilmDetailDto;

import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping("/start")
    private String start(Model model) {

        List<FilmDto> films = maintenanceService.findAllFilms();
        model.addAttribute("films", films);
        return "maintenance";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findFilmById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance_detail";
    }

    @PostMapping("/edit-confirm")
    public String editConfirm(@ModelAttribute FilmDetailDto filmDetailDto) {
        maintenanceService.updateFilm(filmDetailDto);
        return "redirect:/maintenance/start";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findFilmById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance_edit";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        maintenanceService.deleteFilm(id);
        return "redirect:/maintenance/start";
    }

    @GetMapping("/new")
    public String newFilm(Model model) {
        FilmDetailDto filmDetailDto = new FilmDetailDto(null, "", "",
                null, null,
                "", null,
                null, null,
                null, "",
                "", null);
        model.addAttribute("film", filmDetailDto);
        return "maintenance_new";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute FilmDetailDto filmDetailDto) {
        maintenanceService.createFilm(filmDetailDto);
        return "redirect:/maintenance/start";
    }
}


