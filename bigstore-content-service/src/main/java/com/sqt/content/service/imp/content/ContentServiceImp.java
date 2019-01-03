package com.sqt.content.service.imp.content;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sqt.content.ContentService;
import com.sqt.content.dao.DaoSupport;
import com.sqt.content.utils.RedisUtil;
import com.sqt.entity.PageData;
import com.sqt.pojo.TbContent;
import java.io.File;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description: 广告内容服务实现类
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2018-12-26  17:10
 */
@Service
@Component
public class ContentServiceImp implements ContentService {

    private Logger logger = LoggerFactory.getLogger(ContentServiceImp.class);

    @Autowired
    private RedisTemplate redisTemplate;
    @Resource
    private RedisUtil redisUtil;

    @Resource(name = "daoSupport")
    private DaoSupport dao;

    @Override
    public List<TbContent> findAll() throws Exception {
        List<TbContent> list = null;
        if(redisUtil.exists("contentList")){
            list = (List<TbContent>)redisUtil.get("contentList");
            logger.info("==============>从缓存中取出");
        }else{
            list = (List<TbContent>) dao.findForList("ContentMapper.findAll", null);
            redisUtil.set("contentList",list);
            logger.info("==============>从数据库中取出");
        }
        return list;
    }

    @Override
    public PageData findPage(int pageNum, int pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);//分页
        List list = (List<TbContent>)dao.findForList("ContentMapper.findAll", null);
        Page<TbContent> page = (Page<TbContent>) list;
        return new PageData(page.getResult(),page.getTotal());
    }

    @Override
    public void add(TbContent content) throws Exception {
        dao.save("ContentMapper.add",content);
    }

    @Override
    public void update(TbContent content) throws Exception {
        dao.update("ContentMapper.edit",content);
    }

    @Override
    public TbContent findOne(Long id) throws Exception {
        return (TbContent) dao.findForObject("ContentMapper.findById",id);
    }

    @Override
    public void delete(Long[] ids) throws Exception {
        for (Long id : ids) {
            TbContent content = (TbContent) dao.findForObject("ContentMapper.findById", id);
            File pictureFile = new File(content.getPic());
            if(pictureFile.exists()){
                pictureFile.delete();//删除本地图片
            }
            dao.delete("ContentMapper.delete",id);
        }
    }

    @Override
    public PageData findPage(TbContent content, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public List<TbContent> findByCategoryId(Long categoryId) throws Exception {
        return (List<TbContent>) dao.findForList("ContentMapper.findByCategoryId",categoryId);
    }
}
