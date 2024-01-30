package com.fms.smartbutler.controller.admin;

/**
* @author 엄다빈
* @editDate 2024-01-30 ~ 2024-02-03
*/

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.dto.BuildDTO;
import com.fms.smartbutler.dto.CostDTO;
import com.fms.smartbutler.service.BuildService;
import com.fms.smartbutler.service.CostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin/buildings")
@RequiredArgsConstructor
public class CostController {
	
	private final CostService costService;
	private final BuildService buildService;
	
	// 관리비 목록
	@GetMapping("/{buildId}/costs")
	public String getCostList(@PathVariable Long buildId, Model model) {
		List<CostDTO> costs = costService.findAll();
		model.addAttribute("costs", costs);
		model.addAttribute("buildId", buildId);
		
		return "admin/cost/cost-list";
	}
	
	// 관리비 입력
	@GetMapping("/{buildId}/costs/add")
	public String gerAddCost(@PathVariable Long buildId, @ModelAttribute CostDTO costDTO, Model model) {
		BuildDTO buildDTO = buildService.findById(buildId);
		
		model.addAttribute("build", buildDTO);
		
		return "admin/cost/cost-add";
	}
	
	// 관리비 저장
	@PostMapping("/{buildId}/costs/add")
	public String postAddCost(@PathVariable Long buildId, @ModelAttribute CostDTO costDTO) {
		costDTO.setBuildId(buildId);
		costService.save(costDTO);
		
		return "redirect:/admin/buildings/{buildId}/costs";
	}
}
