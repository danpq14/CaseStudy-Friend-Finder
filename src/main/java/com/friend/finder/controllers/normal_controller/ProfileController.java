package com.friend.finder.controllers.normal_controller;

import com.friend.finder.models.Profile;
import com.friend.finder.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@Controller
public class ProfileController {


    @GetMapping("/timeline")
    public String showTimelinePage(Model model){
        Date date = new Date(2020-12-1);
        Profile profile = new Profile();
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

    @GetMapping("/timeline/edit")
    public ModelAndView editInfoPage(){
        ModelAndView modelAndView = new ModelAndView("edit-timeline-about");
        Date date = new Date(2020-12-1);
        Profile profile = new Profile();
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
        modelAndView.addObject("profile",profile);
        return modelAndView;
    }
}
