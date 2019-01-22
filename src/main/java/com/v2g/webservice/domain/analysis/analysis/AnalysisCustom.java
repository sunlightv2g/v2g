package com.v2g.webservice.domain.analysis.analysis;

import java.util.List;

import com.v2g.webservice.dto.analysis.analysis.AnalysisResponseDto;
import com.v2g.webservice.dto.analysis.analysis.AnalysisSearchRequestDto;

public interface AnalysisCustom {
    List<AnalysisResponseDto> getAnalysisList(AnalysisSearchRequestDto analysisSearchRequestDto);
}