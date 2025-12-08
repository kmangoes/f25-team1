package com.example.demo.provider_cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class CafesController {
    
@Autowired
private CafeService cafeService;

@GetMapping("/cafes/createForm")
public Object showAddCafeForm(Model model) {
    model.addAttribute("title", "Insanity Check >:(");
    model.addAttribute("cafe", new Cafes());
    System.out.println("showAddCafeForm called"); //sanity check in terminal
    return "create_cafe_form"; //shows create_cafe_form.ftlh 
}
@PostMapping("/cafes")
public Object addCafe (Cafes cafe) {
    Cafes newCafe = cafeService.addCafe(cafe);
    System.out.println("New cafe received: " + newCafe.getCafeName()); //sanity check in terminal 
    return "redirect:/cafes";
}



@GetMapping("/cafes/updateForm/{cafeId}")
public Object showUpdateCafeForm(@PathVariable Long cafeId, Model model) {
    Cafes updatingCafe = cafeService.getCafeById(cafeId);
    model.addAttribute("cafe", updatingCafe);
    System.out.println("showUpdateCafeForm called for cafeId: " + cafeId); //sanity check in terminal
    return "update_cafe_form"; //returns update_cafe_form.ftlh 
}
@PostMapping("/cafes/update/{cafeId}")
public Object updateCafe(@PathVariable Long cafeId, Cafes updatedCafe) {
    cafeService.updateCafe(cafeId, updatedCafe);
    return "redirect:/cafes"; //redirects to cafe list after update
}



@GetMapping("/cafes")
public Object getAllCafes(Model model) {
    //return cafeService.getAllCafes();
    model.addAttribute("cafesList", cafeService.getAllCafes());
    return "cafe_dashboard"; //returns cafe_dashboard.ftlh 
}
@GetMapping("/cafes/delete/{cafeId}")
public Object deleteCafe(@PathVariable Long cafeId) {
    cafeService.deleteCafe(cafeId);
    return "redirect:/cafes";
}

@GetMapping("/cafes/id/{cafeId}")
public Object getCafeById(@PathVariable Long cafeId) {
    return cafeService.getCafeById(cafeId);
}
@GetMapping("/cafes/cafeName")
public Object getCafeByName(@RequestParam String cafeName) {
    if (cafeName != null) {
        return cafeService.getCafeByName(cafeName);
    } else {
        return cafeService.getAllCafes();
    }
}

}