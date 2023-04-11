package com.example.musicP3.controller;

import com.example.musicP3.entity.music;
import com.example.musicP3.form.CreateMusicForm;
import com.example.musicP3.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MusicController {

    @Autowired
    private MusicRepository musicRepository;
    @RequestMapping("/")
    public String displayHome(){
        return "index";
    }

    @RequestMapping("/list")
    public @ModelAttribute("musics") List<music> displayList() {
        List<music> musics = musicRepository.list();
        return musics;
    }
    @GetMapping("/create-music")
    public String displayAdd(@ModelAttribute CreateMusicForm createMusicForm) {
        return "create-music";
    }



    @GetMapping("/view-music/{id}")

    public String displayMusicDetails(@PathVariable("id") long number, Model model) {
        music music = musicRepository.findById(number);


        model.addAttribute("music", music);

        return "view-music";

    }
    @PostMapping("/createMusic")
    public String createMusic(@ModelAttribute CreateMusicForm createMusicForm){
        music music = new music();
        music.setTitle(createMusicForm.getTitle());
        music.setDescription(createMusicForm.getDescription());
        musicRepository.add(music);
        return "successForm";

    }

    @GetMapping("/edit-music/{id}")
    public String displayUpdateMusicForm(@PathVariable("id") long number, Model model) {

        music music = musicRepository.findById(number);
        System.out.println("music object: " + music);
        CreateMusicForm createMusicForm = new CreateMusicForm(); // initialiser l'objet CreateMusicForm

        createMusicForm.setTitle(music.getTitle());
        createMusicForm.setDescription(music.getDescription());
        model.addAttribute("createMusicForm", music);
        return "edit-music";
    }


    @PostMapping("/updateMusic/{id}")
    public String updateMusic(@PathVariable("id") long number, @ModelAttribute CreateMusicForm createMusicForm) {

        music music = musicRepository.findById(number);

        music.setTitle(createMusicForm.getTitle());
        music.setDescription(createMusicForm.getDescription());
        musicRepository.update(music);
        return "successFormEdit";
    }
    @PostMapping("/deleteMusic/{id}")
    public String deleteMusic(@PathVariable Long id) {
        musicRepository.deleteById(id);
        return "successDeleteForm";
    }

}
