package com.hyon01.minishop.web.item;

import com.hyon01.minishop.domain.item.Item;
import lombok.Data;

@Data
public class ItemAddFormDto {
    private String itemCategory;
    private String itemName;
    private Integer itemPrice;
    private String itemInfo;
    private String itemImage;

    public static Item addFormDtoToItem(ItemAddFormDto itemAddFormDto){
        Item item = new Item();
        item.setItemCategory(itemAddFormDto.getItemCategory());
        item.setItemName(itemAddFormDto.getItemName());
        item.setItemPrice(itemAddFormDto.getItemPrice());
        item.setItemInfo(itemAddFormDto.getItemInfo());
        item.setItemImage(itemAddFormDto.getItemImage());
        return item;
    }
}

