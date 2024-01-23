package com.fms.smartbutler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fms.smartbutler.dto.Build;
import com.fms.smartbutler.repository.BuildRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BuildService {
	
	private final BuildRepository buildRepository;
	
	public void insert(Build build) {
		buildRepository.save(build);
	}
	
	public Optional<Build> findById(Long buildId) {
		return buildRepository.findById(buildId);
	}
	
	public List<Build> findAll() {
		return buildRepository.findAll();
	}
}
