package cn.mldn.dibmp.web.action.back;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.dibmp.service.ISaleService;
import cn.mldn.util.action.abs.AbstractAction;
import cn.mldn.web.helper.SplitPageHelper;

@Controller
@RequestMapping("/pages/back/admin/goods/*")
public class GoodsActionBack extends AbstractAction {
	
    private static final String TITLE = "商品";
	private Logger logger = LoggerFactory.getLogger(GoodsActionBack.class);
	
	@Resource
	private ISaleService goodsService;
	@RequestMapping("list") 
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(super.getPage("goods.list.page"));
		String defaultColumn = "商品名称:name|商品价格:price";
		SplitPageHelper sph = new SplitPageHelper(request, super.getPage("goods.list.action"),defaultColumn);
		Map<String, Object> map = this.goodsService.list(sph.getColumn(), sph.getKeyWord(), sph.getCurrentPage(), sph.getLineSize());
		mav.addAllObjects(map);
		return mav;
	}
}
