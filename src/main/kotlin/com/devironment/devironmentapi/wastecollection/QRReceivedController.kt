package com.devironment.devironmentapi.wastecollection

import com.devironment.devironmentapi.backoffice.WasteNotificationService
import com.devironment.devironmentapi.backoffice.Message
import com.devironment.devironmentapi.wastebag.WasteBag
import com.devironment.devironmentapi.wastebag.WasteBagService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("wastecollection")
class QRReceivedController @Autowired constructor(val wasteBagService: WasteBagService, val wasteNotificationService: WasteNotificationService) {

    /**
     * Endepunkt for registrering av QR-kode fra bildeleseren.
     *
     * @param qrkode
     * @return
     */
    @PutMapping("/qr")
    fun registrerQr(@RequestBody qrkode: String): HttpStatus {

        val wasteBag = wasteBagService.wasteBagRepository.findById(qrkode)
        if(wasteBag.isPresent) {
            val get = wasteBag.get()
            val wasteBag1 = WasteBag(get.bagId,
                    get.wasteCategory,
                    get.dateOfDisposal,
                    true,
                    get.user)
            wasteBagService.wasteBagRepository.save(wasteBag1)
        }

        wasteNotificationService.broadcast(Message("WASTECOLLECTION_PARSED_QR", qrkode))
        return HttpStatus.OK
    }
}