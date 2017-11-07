package cn.mldn.dibmp.web.action.back;
import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.dibmp.ccc.service.ICityService;
import cn.mldn.dibmp.ccc.service.IWitemService;
import cn.mldn.dibmp.fyh.service.IWarehouseService;
import cn.mldn.dibmp.storage.service.IStorgeApplyService;
import cn.mldn.dibmp.vo.StorageApply;
import cn.mldn.dibmp.yaojia.service.ISaleService;
import cn.mldn.util.action.abs.AbstractAction;
import cn.mldn.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/storage/*")
public class StorageActionBack extends AbstractAction {
	private static final String TITLE = "商品入库" ;
	@Resource
	private ISaleService saleService;
	@Resource
	private ICityService cityService;
	@Resource
	private IWitemService witemService;
	@Resource
	private IWarehouseService warehouseService;
	@Resource
	private IStorgeApplyService storageApplyService;	
	
	@RequestMapping("add_pre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getPage("storage.add.page"));
		mav.addAllObjects(saleService.getAddPre());
		mav.addObject("allWitem",witemService.list());
		return mav;
	}
	@RequestMapping("listCity")
	@ResponseBody
	public Object listCity(long pid) {
		return cityService.listByProvince(pid);
	}
	@RequestMapping("listWarehouse")
	@ResponseBody
	public Object listWarehouse(long wiid) {
		return warehouseService.listByWitem(wiid);
	}
	@RequestMapping("add")
	public ModelAndView add(StorageApply vo) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		if(storageApplyService.add(vo, (String)SecurityUtils.getSubject().getSession().getAttribute("mid"))) {
			super.setMsgAndUrl(mav, "storage.add.action", "vo.add.success", TITLE);
		}else {
			super.setMsgAndUrl(mav, "storage.add.action", "vo.add.failure", TITLE);
		}
		return mav;
	}
	@RequestMapping("edit_pre")
	public ModelAndView editPre() {
		ModelAndView mav = new ModelAndView(super.getPage("storage.edit.page"));
		return mav;
	}
	@RequestMapping("edit")
	public ModelAndView edit() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "storage.list.action", "vo.edit.success", TITLE);
		return mav;
	}
	@RequestMapping("list_details") 
	public ModelAndView listDetails() {
		ModelAndView mav = new ModelAndView(super.getPage("storage.list.details.page"));

		return mav;
	}
	@RequestMapping("list_myself") 
	public ModelAndView listMyself() {
		SplitPageUtil spu = new SplitPageUtil("申请标题:title", "customer.list.myself.action") ;
		ModelAndView mav = new ModelAndView(super.getPage("storage.list.myself.page"));

		return mav;
	}
}
