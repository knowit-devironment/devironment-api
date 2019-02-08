package com.devironment.devironmentapi.wastebag

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/waste-bags")
class WasteBagController @Autowired
constructor(val service: WasteBagService){

    @PostMapping("")
    fun createWasteBag(@RequestBody wasteBagRequest: WasteBagRequest): ResponseEntity<WasteBagResponse> {
        return service.createWasteBag(wasteBagRequest)
    }

    @InitBinder
    fun initbBinder(webDataBinder: WebDataBinder) {
        webDataBinder.registerCustomEditor(WasteCategory::class.java, WasteCategoryConverter())
    }
}

