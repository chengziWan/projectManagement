package com.fc.bus.busDailyLog.controller.gen;

import com.alibaba.fastjson.JSONObject;
import com.fc.bus.busDailyLog.service.BusDailyLogService;
import com.fc.bus.model.auto.BusDailyLog;
import com.fc.bus.util.ExportPOIUtil;
import com.fc.bus.util.WeatherUtil;
import com.fc.v2.common.base.BaseController;
import com.fc.v2.common.domain.AjaxResult;
import com.fc.v2.common.domain.ResultTable;
import com.fc.v2.common.support.ConvertUtil;
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
import java.util.List;
import java.util.Map;

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
		String month = busDailyLog.getRBRQ();
		int i=0;
		List<BusDailyLog> list = WeatherUtil.getWeatherByYearMonth(month);
		for(BusDailyLog log :list){
			log.setGCFZR(busDailyLog.getGCFZR());
			log.setJLR(busDailyLog.getJLR());
			int b=busDailyLogService.insertSelective(log);
			if(b>0){
				i++;
			}
		}
		if(i>0){
			return success("生成"+i+"条");
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
	@ResponseBody
	public void export(String ids, HttpServletRequest request, HttpServletResponse response)
	{
		ExportPOIUtil exportPOIUtil = new ExportPOIUtil();
		List<String> lista= ConvertUtil.toListStrArray(ids);
		List<Map<String,String>> contentMapList = busDailyLogService.queryListByIDs(lista);
		System.out.println(JSONObject.toJSONString(contentMapList));
		exportPOIUtil.getBuild("static/exportModel/dailyLog/dailyModel.doc",contentMapList,response);
		//return success("导出结束！");
	}


	
}
