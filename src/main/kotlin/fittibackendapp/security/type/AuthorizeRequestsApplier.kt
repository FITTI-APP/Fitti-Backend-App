package fittibackendapp.common.security.type

import org.springframework.security.config.annotation.web.builders.HttpSecurity

typealias AuthorizeRequestsApplier = (HttpSecurity) -> (Unit)

