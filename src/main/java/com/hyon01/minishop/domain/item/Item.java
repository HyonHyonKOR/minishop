package com.hyon01.minishop.domain.item;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter @Setter
public class Item {
    private Integer itemId;
    private String itemCategory;
    private String itemName;
    private Integer itemPrice;
    private String itemInfo;
    private Date itemUpdate;
    private String itemImage;
}
