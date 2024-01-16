package fittibackendapp.domain.diet.graphql.query

import fittibackendapp.domain.diet.facade.DietRecordQueryFacade
import fittibackendapp.dto.PcfAmountInGramsDto
import fittibackendapp.dto.PcfRatioDto
import fittibackendapp.security.component.ArgumentResolver
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class DietQueryMapper(
    private val dietRecordQueryFacade: DietRecordQueryFacade,
    private val argumentResolver: ArgumentResolver
) {
    @QueryMapping
    fun getPcfAmountInGramsBetweenDays(
        @Argument
        fromDate: LocalDate,
        @Argument
        toDate: LocalDate
    ): PcfAmountInGramsDto {
        val userId = argumentResolver.getUserId()

        return dietRecordQueryFacade.getPcfAmountInGramsBetweenDays(userId, fromDate, toDate)
    }

    @QueryMapping
    fun getPcfRatioInGramsBetweenDays(
        @Argument
        fromDate: LocalDate,
        @Argument
        toDate: LocalDate
    ): PcfRatioDto {
        val userId = argumentResolver.getUserId()

        return dietRecordQueryFacade.getPcfRatioInGramsBetweenDays(userId, fromDate, toDate)
    }
}
