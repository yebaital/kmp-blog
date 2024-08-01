package code.yousef.blog.data

import code.yousef.blog.models.User
import code.yousef.blog.utils.Constants.DATABASE_NAME
import com.mongodb.client.model.Filters
import com.mongodb.kotlin.client.coroutine.MongoClient
import com.varabyte.kobweb.api.data.add
import com.varabyte.kobweb.api.init.InitApi
import com.varabyte.kobweb.api.init.InitApiContext
import kotlinx.coroutines.flow.firstOrNull

@InitApi
fun initMongoDB(context: InitApiContext) {
//    System.setProperty(
//        "org.litote.mongo.test.mapping.service",
//        "org.litote.kmongo.serialization.SerializationClassMappingTypeService"
//    )
    context.data.add(MongoDB(context))
}

class MongoDB(private val context: InitApiContext) : MongoRepository {

    private val client = MongoClient.create()
    private val database = client.getDatabase(DATABASE_NAME)
    private val userCollection = database.getCollection<User>("user")

    override suspend fun checkUserExists(user: User): User? {
        return try {
            userCollection.find(
                Filters.and(
                    Filters.eq(User::username.name, user.username),
                    Filters.eq(User::password.name, user.password)
                )
            ).firstOrNull()
        } catch (e: Exception) {
            context.logger.error(e.message.toString())
            null
        }
    }
}