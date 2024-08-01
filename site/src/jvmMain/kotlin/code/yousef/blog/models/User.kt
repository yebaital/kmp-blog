@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package code.yousef.blog.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.bson.codecs.ObjectIdGenerator

@Serializable
actual data class User(
    @SerialName(value = "_id")
    actual val id: String = ObjectIdGenerator().generate().toString(),
    actual val username: String = "",
    actual val password: String = ""
)

@Serializable
actual data class UserDTO(
    @SerialName(value = "_id")
    actual val id: String = ObjectIdGenerator().generate().toString(),
    actual val username: String = "",
)