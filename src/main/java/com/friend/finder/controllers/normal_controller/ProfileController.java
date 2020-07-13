package com.friend.finder.controllers.normal_controller;

import com.friend.finder.models.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {
    private static Profile profile = new Profile();

    @GetMapping("/timeline-about")
    public String showTimelinePage(Model model){
        String date = "2020-12-1";
        profile.setAddress("Hà Nội");
        profile.setInterest("Book");
        profile.setJob("Worker");
        profile.setRelation("Single");
        profile.setInformation("Logic, Hướng nội, Vững chắc");
        profile.setFirstName("Steven");
        profile.setLastName("Lee");
        profile.setPhone("016758498");
        profile.setBirthDay(date);
        profile.setAvatar("https://miro.medium.com/max/720/1*W35QUSvGpcLuxPo3SRTH4w.png");
        profile.setCover("https://www.gocbao.com/wp-content/uploads/2020/04/anh-bia-phong-canh-dep-13.jpg");
        profile.setGender("Male");
        model.addAttribute("profile",profile);
        return "timeline-about";
    }

    @GetMapping("/timeline-edit")
    public ModelAndView editInfoPage(){
        ModelAndView modelAndView = new ModelAndView("edit-timeline-about");
        modelAndView.addObject("profile",profile);
        return modelAndView;
    }
    @PostMapping("/timeline-edit")
    public ModelAndView saveProfile(@ModelAttribute Profile profiles){
        profile = profiles;
        ModelAndView modelAndView = new ModelAndView("timeline-about");
        modelAndView.addObject("profile",profile);
        return modelAndView;
    }
}
