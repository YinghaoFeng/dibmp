package cn.mldn.dibmp.web.action.back;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.dibmp.storage.service.IStorgeApplyDetailsService;
import cn.mldn.dibmp.storage.service.IStorgeApplyService;
import cn.mldn.util.action.abs.AbstractAction;
import cn.mldn.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/storageaudit/*")
public class StorageAuditActionBack extends AbstractAction {
	private static final String TITLE = "入库审核" ;
	@Resource
	private IStorgeApplyService applyService;
	@Resource
	private IStorgeApplyDetailsService applyDetailsService;
	@RequestMapping("list_prepare") 
	public ModelAndView listDetails(HttpServletRequest request) {
		SplitPageUtil spu = new SplitPageUtil("申请标题:title",super.getPage("storage.audit.list.prepare.action")) ;
		//request.setAttribute("handleUrl",super.getPage("storage.audit.list.prepare.action"));
		System.err.println("handleUrl--" + request.getAttribute("handleUrl"));
		ModelAndView mav = new ModelAndView(super.getPage("storage.audit.list.prepare.page"));
		System.err.println("路径 ==== " + applyService.listSplitFont(spu.getColumn(), spu.getKeyWord(), spu.getCurrentPage(), spu.getLineSize()));
		mav.addAllObjects(applyService.listSplitFont(spu.getColumn(), spu.getKeyWord(), spu.getCurrentPage(), spu.getLineSize()));
		return mav;
	}
	@RequestMapping("edit_pre") 
	public ModelAndView editPre(Long sid) {
		System.err.println("sid --" + sid);
		ModelAndView mav = new ModelAndView(super.getPage("storage.audit.edit.page"));
		mav.addAllObjects(applyDetailsService.listGoodsBack(sid));
		return mav;
	}
	@RequestMapping("list_history") 
	public ModelAndView listMyself() {
		SplitPageUtil spu = new SplitPageUtil("申请标题:title",super.getPage("storage.audit.list.history.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("storage.audit.list.history.page"));
		
		return mav;
	}
}
