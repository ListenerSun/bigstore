package com.sqt.picture;

import com.alibaba.fastjson.JSON;
import com.sqt.goods.config.PictureConfig;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**图片上传类
 * @Description:
 * @author: sqt(男，未婚) 微信:810548252
 * @Date: Created in 2019-01-01  10:58
 */
@RestController
@RequestMapping("pic")
public class PictureUpController {

    @Autowired
    private PictureConfig pictureConfig;
    //@RequestMapping("/pic/upload")
    @RequestMapping(value="/upload"/*,produces= MediaType.IMAGE_JPEG_VALUE+";charset=utf-8"*/)
    public String uploadImage( @RequestParam(value = "file" , required = true) MultipartFile uploadFile,HttpServletRequest request) {
        try {

            // 图片新名字
            String newName = UUID.randomUUID().toString();
            // 图片原完整名字
            String oldName = uploadFile.getOriginalFilename();
            // 后缀名
            String exeName = oldName.substring(oldName.lastIndexOf("."));
//            oldName = oldName.substring(0,oldName.lastIndexOf("."));
            String pic = pictureConfig.getLocation() +newName+exeName; //图片绝对路径
            File picFile = new File(pic);// 保存到本地tomcat服务器images文件夹下
            // 保存图片到本地磁盘
            uploadFile.transferTo(picFile);
            String url = pictureConfig.getWeburl() + newName + exeName;// 返回给前端的url
            Map<String, Object> map = new HashMap<>();
            map.put("code",200);
            map.put("url", url);
            map.put("pic",pic);
            // 6.返回map
            return JSON.toJSONString(map);
        } catch (Exception e) {
            // 5.失败时，设置map
            Map<String, Object> map = new HashMap<>();
            map.put("code", 500);
            map.put("message", "上传失败");
            return JSON.toJSONString(map);
        }
    }

    public static void main(String[] args) {
        String name = "超短裤.jpg";
        String s = name.substring(0, name.lastIndexOf("."));
        System.out.println(s);
    }
}