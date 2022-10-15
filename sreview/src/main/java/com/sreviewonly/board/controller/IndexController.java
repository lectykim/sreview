package com.sreviewonly.board.controller;

import com.sreviewonly.board.entites.Comment;
import com.sreviewonly.board.entites.Product;
import com.sreviewonly.board.entites.Review;
import com.sreviewonly.board.entites.User;
import com.sreviewonly.board.entites.enums.PREFERSEX;
import com.sreviewonly.board.service.ArrangeService;
import com.sreviewonly.board.service.IndexService;
import com.sreviewonly.board.service.ReviewCrudService;
import com.sreviewonly.board.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {




    @Autowired
    private IndexService indexService;



    @Autowired
    private ArrangeService arrangeService;


    @Autowired
    private ReviewCrudService reviewCrudService;

    @Autowired
    private Pagination pagination;


    //특정 mapping에 도착하면, return값으로 templates의 절대 경로를 돌려줌.

    @RequestMapping(value = "signin",method = RequestMethod.GET)
    public String goSignin(HttpServletRequest request){
        return "signin";
    }

    @RequestMapping(value = "sign_in_part_1",method = RequestMethod.GET)
    public String goSigninPart1(HttpServletRequest request){
        return "sign_in_part_1";
    }



    @RequestMapping(value = "review_main",method = RequestMethod.GET)
    public String mainReview(@RequestParam(value = "prefersex") String sex,@RequestParam(value = "page")int page, Model model){
        PREFERSEX prefersex = PREFERSEX.changeStringToPreferSex(sex);

        Map<String,Integer> map = pagination.findPageInformation(15,prefersex);
        List<Review> reviewList = arrangeService.findReviewByPreferSexLimitPaging(prefersex,map,page);



        model.addAttribute("pageSize",map.get("pageSize"));
        model.addAttribute("currPage",page);
        model.addAttribute("firstPage",page/10*10+1);
        model.addAttribute("reviews",reviewList);
        model.addAttribute("preferSex",sex);



        return "review_main";
    }

    @RequestMapping(value = "review_view",method = RequestMethod.GET)
    public String goReviewView(@RequestParam(value = "id") Long id, Model model){

        Review review = reviewCrudService.findReview(id);

        Product product = review.getProduct();
        User user = review.getUser();
        if(review.getComment()!=null){
            model.addAttribute("comment",review.getComment());
            if(review.getComment().getUser()!=null){
                model.addAttribute("replyUser",review.getComment().getUser());
            }
        }




        model.addAttribute("review",review);
        model.addAttribute("product",product);
        model.addAttribute("user",user);

        return "review_view";

    }

    @RequestMapping(value = "review_write_page",method = RequestMethod.GET)
    public String goReviewWritePage(HttpServletRequest request){
        return "review_write_page";
    }

    @RequestMapping(value = "congratulation",method = RequestMethod.GET)
    public String goCongratulation(HttpServletRequest request){
        return "congratulation";
    }

    @RequestMapping(value = "counsel_page",method = RequestMethod.GET)
    public String goCounsel(HttpServletRequest request){
        return "counsel_page";
    }


    @RequestMapping(value = "counsel_management_page",method = RequestMethod.GET)
    public String goCounselManage(HttpServletRequest request){
        return "counsel_management_page";
    }


    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String goIndex(Model model){

        // 인플루언서 랭킹을 받아오는 서비스.

        List<User> users = indexService.getUserMain();

        List<Product> products = indexService.getProductMain();


        model.addAttribute("users",users);
        model.addAttribute("products",products);

        return "index";
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String goAll(HttpServletRequest request){
        //리다이렉트
        return "redirect:/index";


    }



}
