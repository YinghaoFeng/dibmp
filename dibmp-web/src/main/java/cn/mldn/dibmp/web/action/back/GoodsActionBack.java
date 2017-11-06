package cn.mldn.dibmp.web.action.back;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.dibmp.ccc.service.IGoodsService;
import cn.mldn.dibmp.ccc.service.ISubtypeService;
import cn.mldn.dibmp.ccc.service.IWitemService;
import cn.mldn.dibmp.vo.Goods;
import cn.mldn.util.action.abs.AbstractAction;
import cn.mldn.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/goods/*")
public class GoodsActionBack extends AbstractAction {
	private static final String TITLE = "商品" ;
	@Resource
	private IWitemService witemService;
	@Resource
	private ISubtypeService subtypeService;
	@Resource
	private IGoodsService goodsService;
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("goods.add.page"));
		mav.addObject("allWitem",witemService.list());
		return mav;
	}
	@RequestMapping("listSubtype")
	@ResponseBody
	public Object findByWiid(long wiid) {
		return subtypeService.findByWiid(wiid);
	}
	@RequestMapping("add")
	public ModelAndView add(Goods goods, MultipartFile pic) {
		
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		if(pic==null||pic.isEmpty()) {
			goods.setPhoto("nophoto.jpg");
		}else {
			String fileExt = pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf("."));
			String fileName = UUID.randomUUID()+ fileExt;
			String filePath = super.getRequest().getServletContext().getRealPath("/upload/goods/") + UUID.randomUUID() + fileExt;
			try {
				pic.transferTo(new File(filePath));
				goods.setPhoto(fileName);
				if(goodsService.add(goods, (String)SecurityUtils.getSubject().getSession().getAttribute("mid"))) {
					super.setMsgAndUrl(mav, "goods.add.action", "vo.add.success", TITLE);
				}else {
					super.setMsgAndUrl(mav, "goods.add.action", "vo.add.failure", TITLE);
				}
			} catch (Exception e) {
				e.printStackTrace();
				super.setMsgAndUrl(mav, "goods.add.action", "vo.add.failure", TITLE);
			} // 进行文件转存
		}
		return mav;
	} 
	@RequestMapping("show")
	public ModelAndView show() { 
		ModelAndView mav = new ModelAndView(super.getPage("goods.show.page"));
		return mav;
	}
	@RequestMapping("edit_pre")
	public ModelAndView editPre() { 
		ModelAndView mav = new ModelAndView(super.getPage("goods.edit.page"));
		return mav;
	} 
	@RequestMapping("edit")
	public ModelAndView edit() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "goods.list.action", "vo.edit.success", TITLE);
		return mav;
	}
	@RequestMapping("list") 
	public ModelAndView list() {
		
		SplitPageUtil spu = new SplitPageUtil("商品编号:gid|商品名称:name|录入员工:recorder",super.getPage("goods.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("goods.list.page"));
		mav.addAllObjects(goodsService.list(spu.getColumn(), spu.getKeyWord(), spu.getCurrentPage(), spu.getLineSize()));
		return mav;
	}
}
