@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package code.yousef.blog.models

import com.benasher44.uuid.Uuid

data class User (
    val id: Uuid,
    val username: String,
    val password: String,
)

data class UserDTO (
    val id: String,
    val username: String,
)