package ua.ozaycev.logistic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.ozaycev.logistic.entity.ProductCategory;
import ua.ozaycev.logistic.services.ProductCategoryService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ozaycev on 29.05.2016.
 */
@Controller
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping(value = "/productCategory-all", method = RequestMethod.GET)
    public String openProductCategory(Model model){
        List<ProductCategory> productCategoryAll = productCategoryService.findAll();
        model.addAttribute("productCategoryAll", productCategoryAll);
        return "productCategory-all";
    }

    @RequestMapping(value = "/productCategory-new", method = RequestMethod.GET)
    public String newProductCategory(Model model){
//        model.addAttribute("productCategorynew", new ProductCategory());
        return "productCategory-new";
    }

    @RequestMapping(value = "/createProductCategory", method = RequestMethod.POST)
    private String createProductCategory(@RequestParam(value = "name") String name, @RequestParam(value = "parentProductCategory") long parentProductCategory, @RequestParam(value = "Categoryid") long Categoryid){
       if(Categoryid!=0){
           ProductCategory parrentOdject = productCategoryService.findById(parentProductCategory);
           if(parrentOdject==null){
               productCategoryService.edit(Categoryid, name, null);
           }else {
               productCategoryService.edit(Categoryid, name, parrentOdject);
           }

       }else {
           ProductCategory parrentOdject = productCategoryService.findById(parentProductCategory);
           if(parrentOdject==null){
               productCategoryService.add(name);
           }else {
               productCategoryService.add(name, parrentOdject);
           }
       }
        return "redirect:/productCategory-all";
    }

    @RequestMapping(value = "/productCategoryDelete={orderId}", method = RequestMethod.GET)
    public String productCategoryDelete(@PathVariable("orderId") long id, Model model){
        productCategoryService.delete(id);
        return "redirect:/productCategory-all";
    }

    @RequestMapping(value = "/productCategoryEdit={orderId}", method = RequestMethod.GET)
    public String productCategoryEdit(@PathVariable("orderId") long id, Model model){
        ProductCategory productCategory = productCategoryService.findById(id);
        return "redirect:/productCategory-all";
    }

    @RequestMapping(value = "/productCategory-search", method = RequestMethod.GET)
    public String searchProductCategory(@RequestParam(value = "search") String search, @RequestParam(value = "selectedAtribut") String selectedAtribut, Model model){

        List<ProductCategory> listCategory = new ArrayList<ProductCategory>();
        ProductCategory productCategory = null;
        if(selectedAtribut.equals("id")){
            try {
                productCategory = productCategoryService.findById(Long.parseLong(search));
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
            if(productCategory!=null){
                listCategory.add(productCategory);
            }
            model.addAttribute("productCategoryAll", listCategory);

        }else if(selectedAtribut.equals("name")){
            listCategory = productCategoryService.findByName(search);
            model.addAttribute("productCategoryAll", listCategory);
        }else if(selectedAtribut.equals("parrent")) {
            try {
                listCategory = productCategoryService.findByIdParrent(Long.parseLong(search));
            }catch (NumberFormatException e){
                e.printStackTrace();
            }

            model.addAttribute("productCategoryAll", listCategory);
        }
        return "productCategory-all";
    }

}
