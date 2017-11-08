package cn.mldn.dibmp.web.action.back;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.dibmp.wt.service.IStorgeApplyService;
import cn.mldn.dibmp.wt.service.IStorgeInputService;
import cn.mldn.util.action.abs.AbstractAction;
import cn.mldn.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/manage/*")
public class ManageActionBack extends AbstractAction {
	private static final String TITLE = "仓库管理" ;
	@Resource
	private IStorgeInputService inputService;
	@Resource
	private IStorgeApplyService applyService;

	@RequestMapping("storage_input_pre")
	public ModelAndView storageInputPre() {
		ModelAndView mav = new ModelAndView(super.getPage("manage.storage.input.page"));
		return mav;
	}
	@RequestMapping("storage_input")
	public ModelAndView storageInput() {
		//		super.getPage("forward.page")
		ModelAndView mav = new ModelAndView(super.getPage("manage.storage.page"));
		long said = Long.parseLong( super.getRequest().getParameter("sid"));
		System.out.println("当前输入的模糊查询数据 sid ==" + said);
		Map<String, Object> map = inputService.listInputBcke(said);
		if(map.isEmpty()) {
			super.setMsgAndUrl(mav, "manage.storage.input.page", "vo.inputfound.success", TITLE);
		}else {
			mav.addAllObjects(map);
			super.setMsgAndUrl(mav, "manage.storage.page", "vo.inputfound.failure", TITLE);
		}
		return mav;
	}
	@ResponseBody
	@RequestMapping("storage_shop")
	public Object storageShop() {
		long said = Long.parseLong(super.getRequest().getParameter("said"));
		return inputService.listInputBcke(said);
		
	}
	@RequestMapping("distribution_input_pre")
	public ModelAndView distributionInputPre() {
		ModelAndView mav = new ModelAndView(super.getPage("manage.distribution.input.page"));
		return mav;
	}
	@RequestMapping("distribution_input")
	public ModelAndView distributionInput() {
		ModelAndView mav = new ModelAndView(super.getPage("manage.distribution.page"));
		return mav;
	}
}
