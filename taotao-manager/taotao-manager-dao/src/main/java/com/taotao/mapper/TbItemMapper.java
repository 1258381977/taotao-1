package com.taotao.mapper;

import com.taotao.pojo.TbItem;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbItemMapper {
    @Select("SELECT * FROM tbitem WHERE id = #{id}")
    TbItem findItemById(Long itemId);
    @Select("SELECT * FROM tbitem")
    List<TbItem> findItemAll();
}