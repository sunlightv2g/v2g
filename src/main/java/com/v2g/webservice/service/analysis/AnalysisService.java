package com.v2g.webservice.service.analysis;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.v2g.webservice.domain.analysis.analysis.AnalysisRepository;
import com.v2g.webservice.dto.analysis.analysis.AnalysisResponseDto;
import com.v2g.webservice.dto.analysis.analysis.AnalysisSearchRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AnalysisService {
	
    private AnalysisRepository analysisRepository;

    @Transactional(readOnly = true)
    public List<AnalysisResponseDto> getAnalysisList(AnalysisSearchRequestDto analysisSearchRequestDto) {
        return analysisRepository.getAnalysisList(analysisSearchRequestDto);
    }
    
}