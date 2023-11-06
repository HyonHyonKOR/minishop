package com.hyon01.minishop.web.item;

import com.hyon01.minishop.domain.item.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Slf4j
@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/item/add")
    public String goToItemAddPage(){
        return "items/itemAddForm";
    }

    @PostMapping("/item/add")
    public String addItem(@ModelAttribute ItemAddFormDto itemAddFormDto,
                          @RequestParam MultipartFile file,
                          RedirectAttributes redirectAttributes){

        itemService.enrollItem(ItemAddFormDto.addFormDtoToItem(itemAddFormDto));
        redirectAttributes.addFlashAttribute("itemAddSuccess", "상품 등록에 성공했습니다.");
        return  "redirect:/item/add";
    }

    @GetMapping("/items/outers")
    public String goToOuterPage(){
        return "items/outer";
    }
    @GetMapping("/items/inners")
    public String goToInnerPage(){
        return "items/inner";
    }

    @GetMapping("/items/pants")
    public String goToPantsPage(){
        return "items/pants";
    }

    @GetMapping("/items/accessories")
    public String goToAccessoriesPage(){
        return "items/accessories";
    }
}
