package fittibackendapp.domain.diet.service

import fittibackendapp.domain.diet.repository.TargetPcfRatioRepository
import fittibackendapp.dto.PcfRatioDto
import fittibackendapp.dto.mapstruct.TargetPcfRatioMapStruct
import fittibackendapp.exception.NotFoundTargetPcfRatioException
import org.springframework.stereotype.Service

@Service
class TargetPcfRatioService(
    private val targetPcfRatioRepository: TargetPcfRatioRepository,
    private val targetPcfRatioMapStruct: TargetPcfRatioMapStruct
) {
    fun findByUserId(userId: Long): PcfRatioDto {
        val targetPcfRatio = targetPcfRatioRepository.findByUserId(userId) ?: throw NotFoundTargetPcfRatioException()
        return targetPcfRatioMapStruct.toDto(targetPcfRatio)
    }
}
