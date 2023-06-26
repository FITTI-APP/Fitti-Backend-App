package fittybackendapp.common.security.component

import fittybackendapp.common.util.HexUtil.toHexString
import fittybackendapp.common.util.PasswordEncryptionUtil
import org.springframework.security.crypto.password.PasswordEncoder

class CustomPasswordEncoder : PasswordEncoder {
    override fun encode(rawPassword: CharSequence?): String {
        return PasswordEncryptionUtil.encrypt(rawPassword.toString()).toHexString()
    }

    override fun matches(rawPassword: CharSequence?, encodedPassword: String?): Boolean {
        return encode(rawPassword) == encodedPassword || rawPassword == encodedPassword
    }
}
