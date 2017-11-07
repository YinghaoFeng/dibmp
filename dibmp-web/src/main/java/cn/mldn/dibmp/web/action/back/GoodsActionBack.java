package cn.mldn.dibmp.web.action.back;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.dibmp.service.ISaleService;
import cn.mldn.dibmp.vo.GoodsNum;
import cn.mldn.util.action.abs.AbstractAction;
import cn.mldn.web.helper.SplitPageHelper;
import cn.mldn.web.util.RedisUtil;
import cn.mldn.web.util.WebUtil;

@Controller
@RequestMapping("/pages/back/admin/goods/*")
public class GoodsActionBack extends AbstractAction {
	
    @SuppressWarnings("unused")
	private static final String TITLE = "商品";
	private Logger logger = LoggerFactory.getLogger(GoodsActionBack.class);
	
    @Resource
    private ISaleService saleServicess;
    
    @RequestMapping("list") 
    public ModelAndView list(HttpServletRequest request) {
	    ModelAndView mav = new ModelAndView(super.getPage("goods.list.page"));
        String defaultColumn = "商品名称:name|商品价格:price";
        SplitPageHelper sph = new SplitPageHelper(request, super.getPage("goods.list.action"),defaultColumn);
	    Map<String, Object> map = this.saleServicess.list(sph.getColumn(), sph.getKeyWord(), sph.getCurrentPage(), sph.getLineSize());
	    mav.addAllObjects(map);
	    return mav;
     }
    
    
    @RequestMapping("show") 
    public ModelAndView show(Long gid) {
    	ModelAndView mav = new ModelAndView(super.getPage("goods.show.page"));
        mav.addAllObjects(this.saleServicess.findGoodsDetailsById(gid));
	    return mav;
     }
    
    @RequestMapping("detailSstorage") 
    public void Details(HttpServletResponse response,Long gid) {
    	WebUtil.writeJSON(response, this.saleServicess.findAllGoodsStorageDetails(gid));
    	System.err.println(this.saleServicess.findAllGoodsStorageDetails(gid));
     }
    
    @RequestMapping("storageDetails") 
    public void storageDetails(HttpServletResponse response,Long gid) {
    	WebUtil.writeJSON(response, this.saleServicess.findGoodsStorageDetails(gid));
     }
    
    @RequestMapping("unStorage") 
    public void unStorage(HttpServletRequest request,HttpServletResponse response,GoodsNum goodsNum) {
        String name = (String) request.getSession().getAttribute("name");
        try {
            if(RedisUtil.get(name)!=null) {
	          RedisUtil.update(name, goodsNum.toString());
	          logger.info("销售姓名"+name + "缓存商品数据" + RedisUtil.get(name));
	          WebUtil.writeJSON(response, "true");
            }else {
              RedisUtil.put(name,goodsNum.toString());
              WebUtil.writeJSON(response, "true");
            }
        }catch(Exception e) {
        	logger.error("缓存出现错误了", e);
        	 WebUtil.writeJSON(response, "false");
        }
     }
    
    @RequestMapping("unStorageGoods") 
    public void unStorageGoods(HttpServletRequest request) {
       
     
    }

}
