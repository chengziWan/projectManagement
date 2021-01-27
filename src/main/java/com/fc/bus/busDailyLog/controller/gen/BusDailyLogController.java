package com.fc.bus.busDailyLog.controller.gen;

import com.fc.bus.busDailyLog.service.BusDailyLogService;
import com.fc.bus.model.auto.BusDailyLog;
import com.fc.v2.common.base.BaseController;
import com.fc.v2.common.domain.AjaxResult;
import com.fc.v2.common.domain.ResultTable;
import com.fc.v2.model.custom.Tablepar;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 施工日志表Controller
 * @ClassName: BusDailyLogController
 * @author cc
 * @date 2021-01-26 16:43:19
 */
@Api(value = "施工日志表")
@Controller
@RequestMapping("/BusDailyLogController")
public class BusDailyLogController extends BaseController{
	
	private String prefix = "admin/bus/busDailyLog";
	
	@Autowired
	private BusDailyLogService busDailyLogService;
	
	
	/**
	 * 施工日志表页面展示
	 * @param model
	 * @return String
	 * @author cc
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:busDailyLog:view")
    public String view(ModelMap model)
    {
        return prefix + "/list";
    }
	
	/**
	 * list集合
	 * @param tablepar
	 * @param busDailyLog
	 * @return
	 */
	//@Log(title = "施工日志表", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:busDailyLog:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar, BusDailyLog busDailyLog){
		PageInfo<BusDailyLog> page=busDailyLogService.list(tablepar,busDailyLog) ; 
		return pageTable(page.getList(),page.getTotal());
	}
	
	/**
     * 新增跳转
     */
	@ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
        return prefix + "/add";
    }
	
    /**
     * 新增保存
     * @param 
     * @return
     */
	//@Log(title = "施工日志表新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:busDailyLog:add")
	@ResponseBody
	public AjaxResult add(BusDailyLog busDailyLog){
		int b=busDailyLogService.insertSelective(busDailyLog);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 施工日志表删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "施工日志表删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:busDailyLog:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=busDailyLogService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	
	/**
	 * 修改跳转
	 * @param id
	 * @param map
	 * @return
	 */
	@ApiOperation(value = "修改跳转", notes = "修改跳转")
	@GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map)
    {
        map.put("BusDailyLog", busDailyLogService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "施工日志表修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:busDailyLog:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusDailyLog busDailyLog)
    {
        return toAjax(busDailyLogService.updateByPrimaryKeySelective(busDailyLog));
    }

	/**
	 * 导出
	 * @param ids
	 * @return
	 */
	@ApiOperation(value = "导出", notes = "导出")
	@GetMapping("/export")
	public String export(String ids, HttpServletRequest request, HttpServletResponse response)
	{
		String fileName = "wcc.png";// 文件名
		if (fileName != null) {
			//设置文件路径
			File file = new File("D://20210127104059.png");
			if (file.exists()) {
				response.setContentType("application/force-download");// 设置强制下载不打开
				response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
				byte[] buffer = new byte[1024];
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				try {
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					OutputStream os = response.getOutputStream();
					int i = bis.read(buffer);
					while (i != -1) {
						os.write(buffer, 0, i);
						i = bis.read(buffer);
					}
					return "下载成功";
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (bis != null) {
						try {
							bis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return "下载失败";
	}


	
}
