package ua.ozaycev.logistic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.ozaycev.logistic.entity.ProductCategory;
import ua.ozaycev.logistic.entity.Products;
import ua.ozaycev.logistic.services.ProductCategoryService;
import ua.ozaycev.logistic.services.ProductsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ozaycev on 29.05.2016.
 */
@Controller
public class ProductController {

    @Autowired
    private ProductsService productService;
    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping(value = "/products-all", method = RequestMethod.GET)
    public String openProduct(Model model){
        List<Products> productsAll = productService.findAll();
        model.addAttribute("productsAll", productsAll);
        return "products-all";
    }

    @RequestMapping(value = "/products-new", method = RequestMethod.GET)
    public String newProduct(Model model){
//        model.addAttribute("productCategorynew", new ProductCategory());
        return "products-new";
    }

    @RequestMapping(value = "/createProducts", method = RequestMethod.POST)
    public String createProducts(@RequestParam(value = "Categoryid") long Categoryid, @RequestParam(value = "name") String name, @RequestParam(value = "articul") String articul, @RequestParam(value = "category") String category){

        long idCategory = 0;
        if(category!=""){
            idCategory = Long.parseLong(category);
        }

        if(Categoryid!=0){
            ProductCategory categoryOdject = productCategoryService.findById(idCategory);
           if(categoryOdject==null){
               productService.edit(Categoryid, name, articul, null);
           }else {
               productService.edit(Categoryid, name, articul, categoryOdject);
           }

       }else {
            ProductCategory categoryOdject = productCategoryService.findById(idCategory);
           if(categoryOdject==null){
               productService.add(name, articul, null);
           }else {
               productService.add(name, articul, categoryOdject);
           }
       }
        return "redirect:/products-all";
    }

    @RequestMapping(value = "/productsDelete={orderId}", method = RequestMethod.GET)
    public String productsDelete(@PathVariable("orderId") long id, Model model){
        productService.delete(id);
        return "redirect:/products-all";
    }

    @RequestMapping(value = "/productsEdit={orderId}", method = RequestMethod.GET)
    public String productsEdit(@PathVariable("orderId") long id, Model model){
        Products product = productService.findById(id);
        return "redirect:/products-all";
    }

    @RequestMapping(value = "/products-search", method = RequestMethod.GET)
    public String searchProduct(@RequestParam(value = "search") String search, @RequestParam(value = "selectedAtribut") String selectedAtribut, Model model){

        List<Products> productsList = new ArrayList<Products>();
        Products product = null;
        if(selectedAtribut.equals("id")){
            try {
                product = productService.findById(Long.parseLong(search));
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
            if(product!=null){
                productsList.add(product);
            }
            model.addAttribute("productsAll", productsList);

        }else if(selectedAtribut.equals("name")){
            productsList = productService.findByName(search);
            model.addAttribute("productsAll", productsList);
        }else if(selectedAtribut.equals("articul")){
            productsList = productService.findByArticul(search);
            model.addAttribute("productsAll", productsList);
        }else if(selectedAtribut.equals("category")) {
            try {
                productsList = productService.findByIdCategory(Long.parseLong(search));
            }catch (NumberFormatException e){
                e.printStackTrace();
            }

            model.addAttribute("productsAll", productsList);
        }
        return "products-all";
    }

}
