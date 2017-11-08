package cn.mldn.dibmp.web.action.back;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import cn.mldn.dibmp.wt.service.IStorgeApplyDetailsService;
import cn.mldn.dibmp.wt.service.IStorgeApplyService;
import cn.mldn.dibmp.wt.service.IStorgeRecordService;
import cn.mldn.util.action.abs.AbstractAction;
import cn.mldn.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/storageaudit/*")
public class StorageAuditActionBack extends AbstractAction {
	private static final String TITLE = "入库审核" ;
	@Resource
	private IStorgeApplyService applyService;
	@Resource
	private IStorgeRecordService recordService;
	@Resource
	private IStorgeApplyDetailsService applyDetailsService;
	@RequestMapping("list_prepare") 
	public ModelAndView listDetails(HttpServletRequest request) {
		SplitPageUtil spu = new SplitPageUtil("申请标题:title",super.getPage("storage.audit.list.prepare.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("storage.audit.list.prepare.page"));	
		mav.addAllObjects(applyService.listSplitFont(spu.getColumn(), spu.getKeyWord(), spu.getCurrentPage(), spu.getLineSize()));
		return mav;
	}
	@RequestMapping("edit_pre") 
	public ModelAndView editPre(Long sid) {
		ModelAndView mav = new ModelAndView(super.getPage("storage.audit.edit.page"));
		Map<String, Object> map = applyDetailsService.listGoodsBack(sid);
		mav.addAllObjects(map);
		return mav;
	}
	@RequestMapping("list_history") 
	public ModelAndView listMyself() {
		SplitPageUtil spu = new SplitPageUtil("申请标题:title",super.getPage("storage.audit.list.history.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("storage.audit.list.history.page"));
		mav.addAllObjects(recordService.listRecord(spu.getColumn(), spu.getColumn(), spu.getCurrentPage(), spu.getLineSize()));
		return mav;
	}
	@RequestMapping("edit")
	public ModelAndView editRecord() {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		Integer auditInt =Integer.parseInt(super.getRequest().getParameter("audit"));
		Long said = Long.parseLong(super.getRequest().getParameter("said"));
		System.err.println("audit--" + auditInt);
		System.err.println("said --" + said);
		if(auditInt ==5) { //通过
			if(applyDetailsService.editSaid(said,auditInt)) {
				super.setMsgAndUrl(mav, "storage.audit.list.prepare.action", "vo.editpass.success", TITLE); 		
			}
		}else if( auditInt ==3) {//拒绝
			if(applyDetailsService.editSaid(said,auditInt)) {
				super.setMsgAndUrl(mav, "storage.audit.list.prepare.action", "vo.editpass.failure", TITLE); 		
			}
		}else {
			super.setMsgAndUrl(mav, "storage.audit.list.prepare.action", "vo.editpass.failure", TITLE); 
		}
		return mav;
	}
	
	@ResponseBody
	@RequestMapping("edit_num")
	public Object editNum() {	
		String said = super.getRequest().getParameter("said");
		Map<String, Object> nums = applyDetailsService.listEditNum(Long.parseLong(said));
		return nums;
	}
	@ResponseBody
	@RequestMapping("according_to")
	public Object accordingTo() { //当点击审核申请标题的时候显示数据,显示审核页面的所有点击页面
		long said = Long.parseLong(super.getRequest().getParameter("said"));
		return applyService.getWarehouseGoodsBySaid(said);
	}
	@ResponseBody
	@RequestMapping("stock_to")	//当点击仓库的时候显示仓库的信息
	public Object stock() {	//根据wid 获取仓库信息
		long wid = Long.parseLong(super.getRequest().getParameter("wid"));
		return applyDetailsService;
		
		
	}
	
}
