package com.v2g.webservice.domain.environment.userinfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserinfoRepository extends JpaRepository<Userinfo, Long>, UserinfoCustom {

}