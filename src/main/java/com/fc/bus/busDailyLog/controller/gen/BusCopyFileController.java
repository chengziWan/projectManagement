package com.fc.bus.busDailyLog.controller.gen;

import com.fc.bus.busDailyLog.service.BusCopyFileService;
import com.fc.bus.model.auto.BusCopyFile;
import com.fc.v2.common.base.BaseController;
import com.fc.v2.common.domain.AjaxResult;
import com.fc.v2.common.domain.ResultTable;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.util.StringUtils;
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

/**
 * 施工日志拷贝Controller
 * @ClassName: BusCopyFileController
 * @author fuce
 * @date 2021-07-22 10:41:06
 */
@Api(value = "施工日志拷贝")
@Controller
@RequestMapping("/BusCopyFileController")
public class BusCopyFileController extends BaseController{
	
	private String prefix = "admin/bus/busCopyFile";
	
	@Autowired
	private BusCopyFileService busCopyFileService;
	
	
	/**
	 * 施工日志拷贝页面展示
	 * @param model
	 * @return String
	 * @author fuce
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:busCopyFile:view")
    public String view(ModelMap model)
    {
        return prefix + "/list";
    }
	
	/**
	 * list集合
	 * @param tablepar
	 * @return
	 */
	//@Log(title = "施工日志拷贝", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:busCopyFile:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar, BusCopyFile busCopyFile){
		PageInfo<BusCopyFile> page=busCopyFileService.list(tablepar,busCopyFile) ; 
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
	//@Log(title = "施工日志拷贝新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:busCopyFile:add")
	@ResponseBody
	public AjaxResult add(BusCopyFile busCopyFile){
		// ADD-WCC: 处理文件   [WanCC 2021/7/22  10:54]
		//busCopyFileService.copyFile(busCopyFile,response);
		int b=busCopyFileService.insertSelective(busCopyFile);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * 施工日志拷贝删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "施工日志拷贝删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:busCopyFile:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=busCopyFileService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	
	/**
	 * 修改跳转
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "修改跳转", notes = "修改跳转")
	@GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map)
    {
        map.put("BusCopyFile", busCopyFileService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "施工日志拷贝修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:busCopyFile:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusCopyFile busCopyFile){
		// ADD-WCC: 处理文件   [WanCC 2021/7/22  10:54]
		//busCopyFileService.copyFile(busCopyFile,response);
        return toAjax(busCopyFileService.updateByPrimaryKeySelective(busCopyFile));
    }

	/**
	 * 导出
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "导出", notes = "导出")
	@GetMapping("/export")
	@ResponseBody
	public void export(String id, HttpServletRequest request, HttpServletResponse response)
	{
		BusCopyFile busCopyFile = busCopyFileService.selectByPrimaryKey(id);
		String tQ_Area = busCopyFile.gettQ_Area();
		if(StringUtils.isEmpty(tQ_Area)){
			tQ_Area = "jinan";
		}
		busCopyFileService.copyFile(busCopyFile,tQ_Area,response);
		//return success("导出结束！");
	}

    
    

	
}
