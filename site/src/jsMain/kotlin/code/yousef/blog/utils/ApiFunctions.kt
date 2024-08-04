package code.yousef.blog.utils

import code.yousef.blog.models.User
import code.yousef.blog.models.UserDTO
import com.varabyte.kobweb.browser.api
import kotlinx.browser.window
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


suspend fun checkUserExists(user: User): UserDTO? {
    return try {
        val result = window.api.tryPost(
            apiPath = "usercheck",
            body = Json.encodeToString(user).encodeToByteArray()
        )
        result?.decodeToString()?.let { Json.decodeFromString<UserDTO>(it) }
    } catch (e:Exception) {
        println(e.message)
        null
    }
}