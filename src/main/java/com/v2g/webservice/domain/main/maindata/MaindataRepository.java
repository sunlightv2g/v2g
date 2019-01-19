package com.v2g.webservice.domain.main.maindata;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MaindataRepository extends JpaRepository<Maindata, Long>, MaindataCustom {

}