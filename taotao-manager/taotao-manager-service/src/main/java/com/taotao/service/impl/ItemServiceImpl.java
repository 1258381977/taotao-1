package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper tbItemMapper;

    @Override
    public TbItem getItemById(Long itemId) {
        return tbItemMapper.findItemById(itemId);
    }

    @Override
    public EasyUIResult getItemList(int page, int rows) {
        //初始化分页设置 他的底层原理是 自动拼接limit语句
        PageHelper.startPage(page, rows);
        //查询所有商品信息
        List<TbItem> items = tbItemMapper.findItemAll();
        //取分页信息
        PageInfo<TbItem> pageInfo = new PageInfo<>(items);
        //ctrl+alt+L  整理代码
        EasyUIResult result = new EasyUIResult();
        //使用插件得到总记录条数
        result.setTotal(pageInfo.getTotal());
        //被分页插件处理以后得到的结果集了集合对象
        result.setRows(items);
        return result;
    }

    @Override
    public TaotaoResult deleteItems(Integer[] ids) {
        int i = tbItemMapper.deleteItems(ids);
        if (i != 0) {
            return TaotaoResult.ok();
        }
        return null;
    }
}
