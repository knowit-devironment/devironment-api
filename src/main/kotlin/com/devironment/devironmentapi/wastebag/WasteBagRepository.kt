package com.devironment.devironmentapi.wastebag

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WasteBagRepository : JpaRepository<WasteBag, String> {

}