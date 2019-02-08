package com.devironment.devironmentapi.wastebag

import com.devironment.devironmentapi.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class WasteBagService @Autowired
constructor(
        val wasteBagRepository: WasteBagRepository,
        val userRepository: UserRepository
) {

    fun createWasteBag(wasteBagRequest: WasteBagRequest): ResponseEntity<WasteBagResponse> {
        // TODO: Check if waste bag exists?
        println("Creating waste bag: $wasteBagRequest")
        val user = userRepository.findByUserId(wasteBagRequest.userId)

        user?.let {
            val wasteBag = wasteBagRepository.save(WasteBag(
                    bagId = wasteBagRequest.bagId,
                    wasteCategory = wasteBagRequest.wasteCategory,
                    dateOfDisposal = LocalDate.parse(wasteBagRequest.dateOfDisposal),
                    user = user,
                    delivered = false
            ))

            println("SUCCESS - Created waste bag: $wasteBag")
            return ResponseEntity.ok().body(WasteBagResponse(
                    bagId = wasteBag.bagId,
                    wasteCategory = wasteBag.wasteCategory,
                    dateOfDisposal = wasteBag.dateOfDisposal.toString(),
                    userId = wasteBag.user.userId,
                    delivered = false
            ))
        }

        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }
}