package com.v2g.webservice.domain.analysis.analysis;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnalysisRepository extends JpaRepository<Analysis, Long>, AnalysisCustom {

}