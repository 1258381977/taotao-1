package com.taotao.service;

import com.taotao.common.pojo.EasyUIResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
    TbItem getItemById(Long itemId);

    EasyUIResult getItemList(int page, int rows);

    TaotaoResult deleteItems(Integer[] ids);
}
