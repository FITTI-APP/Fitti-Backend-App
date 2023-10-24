package fittibackendapp.common.util

import java.security.MessageDigest

object PasswordEncryptionUtil {
    fun encrypt(password: String): ByteArray {
        val messageDigest: MessageDigest = MessageDigest.getInstance("SHA-256")
        messageDigest.update(password.toByteArray())
        return messageDigest.digest()
    }
}
