package fittibackendapp.exception

import fittibackendapp.common.exception.base.ResponseStatusReasonException
import org.springframework.http.HttpStatus

class NotFoundTargetPcfRatioException: ResponseStatusReasonException(
    statusCode = HttpStatus.NOT_FOUND,
    reasonName = "NOT_FOUND_TARGET_PCF_RATIO",
    reasonMessage = "해당 유저의 목표 탄단지 비율 정보를 찾을 수 없습니다.",
)
