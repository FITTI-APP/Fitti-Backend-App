package fittibackendapp.common.configuration

import fittibackendapp.domain.auth.entity.LoginType
import fittibackendapp.domain.auth.entity.Role
import fittibackendapp.domain.auth.repository.LoginTypeRepository
import fittibackendapp.domain.auth.repository.RoleRepository
import fittibackendapp.domain.exercise.entity.ExerciseKind
import fittibackendapp.domain.exercise.entity.ExerciseSaveType
import fittibackendapp.domain.exercise.repository.ExerciseKindRepository
import fittibackendapp.domain.exercise.repository.ExerciseSaveTypeRepository
import org.springframework.boot.context.event.ApplicationStartingEvent
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.event.TransactionalEventListener

@Configuration
class DataInitConfiguration(
    private val roleRepository: RoleRepository,
    private val exerciseKindRepository: ExerciseKindRepository,
    private val exerciseSaveTypeRepository: ExerciseSaveTypeRepository,
    private val loginTypeRepository: LoginTypeRepository,
) {
    @Bean
    @Transactional
    @TransactionalEventListener(ApplicationStartingEvent::class)
    @EventListener(ApplicationStartingEvent::class)
    fun initEnumData() {
        if (roleRepository.findByName(Role.ROLE_USER) == null)
            roleRepository.save(Role(name = Role.ROLE_USER))
        if (roleRepository.findByName(Role.ROLE_ADMIN) == null)
            roleRepository.save(Role(name = Role.ROLE_ADMIN))

        if (loginTypeRepository.findByName("GOOGLE") == null)
            loginTypeRepository.save(LoginType(name = LoginType.GOOGLE))
        if (loginTypeRepository.findByName("KAKAO") == null)
            loginTypeRepository.save(LoginType(name = LoginType.KAKAO))
        if (loginTypeRepository.findByName("NAVER") == null)
            loginTypeRepository.save(LoginType(name = LoginType.NAVER))
        if (loginTypeRepository.findByName("FACEBOOK") == null)
            loginTypeRepository.save(LoginType(name = LoginType.FACEBOOK))
        if (loginTypeRepository.findByName("EMAIL") == null)
            loginTypeRepository.save(LoginType(name = LoginType.EMAIL))
    }

    @Bean
    @Transactional
    @TransactionalEventListener(ApplicationStartingEvent::class)
    @EventListener(ApplicationStartingEvent::class)
    fun initExerciseSaveType() {
        if (exerciseSaveTypeRepository.findByName("확정") == null) {
            exerciseSaveTypeRepository.save(
                ExerciseSaveType(
                    name = "확정",
                ),
            )
        }
        if (exerciseSaveTypeRepository.findByName("미확정") == null) {
            exerciseSaveTypeRepository.save(
                ExerciseSaveType(
                    name = "미확정",
                ),
            )
        }
    }

    @Bean
    @Transactional
    @TransactionalEventListener(ApplicationStartingEvent::class)
    @EventListener(ApplicationStartingEvent::class)
    fun initExerciseKindData() {
        val exercises = listOf(
            "하체",
            "복근",
            "가슴",
            "어깨",
            "등",
            "팔",
        )
        val exerciseKinds = exerciseKindRepository.findAll()

        val shouldDeleteExerciseKinds = exerciseKinds.filter { exerciseKind ->
            !exercises.contains(exerciseKind.name)
        }
        exerciseKindRepository.deleteAll(shouldDeleteExerciseKinds)

        val shouldAddExercises = exercises.filter { exercise ->
            exerciseKinds.none { exerciseKind ->
                exerciseKind.name == exercise
            }
        }
        exerciseKindRepository.saveAll(
            shouldAddExercises.map { exercise ->
                ExerciseKind(
                    name = exercise,
                )
            },
        )
    }
}
