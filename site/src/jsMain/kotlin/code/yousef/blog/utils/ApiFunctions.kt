package code.yousef.blog.utils


//suspend fun checkUserExists(user: User): UserDTO? {
//    return try {
//        val result = window.api.tryPost(
//            apiPath = "usercheck",
//            body = Json.encodeToString(user).encodeToByteArray()
//        )
//        result?.decodeToString()?.let { Json.decodeFromString<UserDTO>(it) }
//    } catch (e:Exception) {
//        println(e.message)
//        null
//    }
//}