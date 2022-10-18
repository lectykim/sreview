package com.sreviewonly.board.controller;

import com.sreviewonly.board.dto.ProductDTO;
import com.sreviewonly.board.dto.ReviewDTO;
import com.sreviewonly.board.dto.UserDTO;
import com.sreviewonly.board.entites.enums.PREFERSEX;
import com.sreviewonly.board.repositories.ReviewRepository;
import com.sreviewonly.board.service.MainPageService;
import com.sreviewonly.board.service.ReviewListPageService;
import com.sreviewonly.board.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class MainPageController {

    @Autowired
    private MainPageService mainPageService;



    @Autowired
    private ReviewListPageService reviewListPageService;

    @Autowired
    private Pagination pagination;


    @RequestMapping(value = "/review_main",method = RequestMethod.GET)
    public String getReviewMain(@RequestParam(value = "prefersex") String sex,@RequestParam(value = "page")int page, Model model){
        PREFERSEX prefersex = PREFERSEX.changeStringToPreferSex(sex);

        Map<String,Integer> map = pagination.findPageInformation(15,prefersex);
        List<ReviewDTO> reviewDTOList = reviewListPageService.findReviewByPreferSex(prefersex,map,page);

        model.addAttribute("pageSize",map.get("pageSize"));
        model.addAttribute("currPage",page);
        model.addAttribute("firstPage",page/10*10+1);
        model.addAttribute("reviews",reviewDTOList);
        model.addAttribute("preferSex",sex);

        return "review_main";
    }



    @RequestMapping(value = "review_view",method = RequestMethod.GET)
    public String GetReviewView(@RequestParam(value = "id") long id, Model model){
        ReviewDTO reviewDTO = reviewListPageService.findReviewById(id);

        if(reviewDTO.getProductDTO()!=null)
            model.addAttribute("product",reviewDTO.getProductDTO());
        if(reviewDTO.getCommentDTO()!=null)
            model.addAttribute("comment",reviewDTO.getCommentDTO());

        model.addAttribute("review",reviewDTO);

        return "review_view";
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMain(Model model){
        List<UserDTO> userDTOList = mainPageService.findTop5User();
        List<ProductDTO> productDTOList = mainPageService.findTop5Product();

        model.addAttribute("users",userDTOList);
        model.addAttribute("products",productDTOList);

        return "index";
    }




}
