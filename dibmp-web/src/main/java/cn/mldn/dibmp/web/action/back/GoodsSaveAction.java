package cn.mldn.dibmp.web.action.back;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.dibmp.ccc.service.ICityService;
import cn.mldn.dibmp.ccc.service.IWitemService;
import cn.mldn.dibmp.fyh.service.IWarehouseService;
import cn.mldn.dibmp.yaojia.service.ISaleService;
import cn.mldn.util.action.abs.AbstractAction;

@Controller
@RequestMapping("/pages/back/admin/storage/*")
public class GoodsSaveAction extends AbstractAction {
	private static final String TITLE = "商品入库" ;
	@Resource
	private ISaleService saleService;
	@Resource
	private ICityService cityService;
	@Resource
	private IWitemService witemService;
	@Resource
	private IWarehouseService warehouseService;

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
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		super.setMsgAndUrl(mav, "storage.add.action", "vo.add.success", TITLE);
		return mav;
	}
}
