@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package code.yousef.blog.models

expect class User {
    val id: String
    val username: String
    val password: String
}

expect class UserDTO {
    val id: String
    val username: String
}