package fittibackendapp.domain.diet.service

import fittibackendapp.domain.diet.repository.DietRepository
import fittibackendapp.dto.DietDto
import fittibackendapp.dto.mapstruct.DietMapStruct
import fittibackendapp.exception.NotFoundDietException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class DietService(
    private val dietRepository: DietRepository,
    private val dietMapStruct: DietMapStruct
){
    fun findById(id: Long): DietDto {
        val diet = dietRepository.findByIdOrNull(id) ?: throw NotFoundDietException()
        return dietMapStruct.toDto(diet)
    }

    fun findAllById(ids: List<Long>): List<DietDto> {
        val diets = dietRepository.findAllById(ids)
        return dietMapStruct.toDtos(diets)
    }
}
