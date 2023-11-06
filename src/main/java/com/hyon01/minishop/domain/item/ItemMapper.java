package com.hyon01.minishop.domain.item;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper {
    void save(Item item);
}
