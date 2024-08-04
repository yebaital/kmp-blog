package code.yousef.blog.api

import code.yousef.blog.data.MongoDB
import code.yousef.blog.models.User
import code.yousef.blog.models.UserDTO
import com.varabyte.kobweb.api.Api
import com.varabyte.kobweb.api.ApiContext
import com.varabyte.kobweb.api.data.getValue
import com.varabyte.kobweb.api.http.setBodyText
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.nio.charset.StandardCharsets
import java.security.MessageDigest

@Api(routeOverride = "usercheck")
suspend fun userCheck(context: ApiContext) {
    try {
        val userRequest = context.req.body?.decodeToString()?.let { Json.decodeFromString<User>(it) }
        val user = userRequest?.let {
            context.data.getValue<MongoDB>()
                .checkUserExists(User(username = it.username, password = hashPassword(it.password)))
        }
        if (user != null) {
            context.res.setBodyText(Json.encodeToString<UserDTO>(UserDTO(id = user.id, username = user.username)))
        } else {
            context.res.setBodyText(Json.encodeToString("User does not exist"))
        }
    } catch (e: Exception) {
        context.res.setBodyText(Json.encodeToString(e.message))
    }
}

private fun hashPassword(password: String): String {
    val messageDigest = MessageDigest.getInstance("SHA-256")
    val hashBytes = messageDigest.digest(password.toByteArray(StandardCharsets.UTF_8))
    val hexString = StringBuffer()

    for (byte in hashBytes) {
        hexString.append(String.format("%02x", byte))
    }
    println(hexString.toString())
    return hexString.toString()
}