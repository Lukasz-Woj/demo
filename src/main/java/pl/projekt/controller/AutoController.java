package pl.projekt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.projekt.model.Auto;
import pl.projekt.model.Comment;
import pl.projekt.service.AutoService;
import pl.projekt.service.CategoryService;
import pl.projekt.service.CommentService;

@Controller
public class AutoController {
    private AutoService autoService;
    private CategoryService categoryService;
    private CommentService commentService;

    @Autowired
    public AutoController(AutoService autoService, CategoryService categoryService, CommentService commentService) {

        this.autoService = autoService;
        this.categoryService = categoryService;
        this.commentService = commentService;
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) String q){
        if (q == null){
            model.addAttribute("auta", autoService.getAuta());
            model.addAttribute("oferAuto", autoService.getOfertaDnia());
        }
        return "home";
    }

    @GetMapping("/wszystkie")
    public String wszystkie(Model model, @RequestParam(required = false) String q){
        if (q == null){
            model.addAttribute("allAuta", autoService.getAllAuta());
        }
        else{
            model.addAttribute("allAuta", autoService.findAuto(q));
        }
        return "wszystkie";
    }

    @GetMapping("/auto/{name}")
    public String details(Model model, @PathVariable String name, @RequestParam(required = false) Long q){
        Auto auto = autoService.findAutoByName(name);
        model.addAttribute("auto", auto);
        if (q != null){
            model.addAttribute("comments", commentService.getCommentsById(q));
        }
        Comment comment = new Comment();
        model.addAttribute("comment", comment);




        return "auto-details";
    }

    @PostMapping("/auto/{name}/createComment")
    public String addComment(@ModelAttribute Comment comment, @PathVariable String name) {
        Auto auto = autoService.findAutoByName(name);
        comment.setAutoId(auto.getId());
        commentService.createComment(comment);
        return "redirect:/auto/{name}";
    }

    @GetMapping("/auto/{name}/deleteComment")
    public String deleteComment(@RequestParam(required = false) Long q) {
        commentService.deleteComment(q);
        return "redirect:/auto/{name}";
    }

    @PostMapping("/auto/{name}")
    public String changeTag(@ModelAttribute Auto auto) {
        autoService.updateAuto(auto);
        return "redirect:/auto/{name}";
    }

    @GetMapping("/auto/{name}/obserwowane")
    public String toggleObs(@PathVariable String name, @RequestParam(required = false, defaultValue = "") String r) {
        Auto auto = autoService.findAutoByName(name);
        autoService.toggleObserwowane(auto);
        if (r.equals("details")) {
            return "redirect:/auto/{name}";
        } else if (r.equals("obserwowane")) {
            return "redirect:/obserwowane";
        } else {
            return "redirect:/wszystkie";
        }
    }

    @GetMapping("/obserwowane")
    public String obserwowane(Model model, @RequestParam(required = false) String q){
        if (q == null){
            model.addAttribute("allAuta", autoService.findObserwowane());
        }
        else{
            model.addAttribute("allAuta", autoService.findAutoInObserwowane(q));
        }
        return "obserwowane";
    }

    @GetMapping("/kategorie")
    public String getCategories(Model model, @RequestParam(required = false) String q){
        if ( q == null){
            model.addAttribute("kategorie", categoryService.findCategories());
        }
        else if(q != null){
            model.addAttribute("kategorie", categoryService.findCategories());
            model.addAttribute("auta", autoService.findAutaInCategory(q));
        }


        return "kategorie";
    }
}
