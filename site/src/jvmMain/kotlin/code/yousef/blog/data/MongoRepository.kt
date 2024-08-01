package code.yousef.blog.data

import code.yousef.blog.models.User

interface MongoRepository {

    suspend fun checkUserExists(user: User): User?

}