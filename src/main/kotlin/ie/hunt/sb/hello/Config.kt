package ie.hunt.sb.hello

import org.springframework.stereotype.Component

interface IConfig {
//    fun getBuildId(): String
}

@Component
class EnvConfig : IConfig {
//    private val DB_HOST = System.getenv("DB_HOST") ?: "BUILD_ID_NOT_SET"
//
//    override fun getBuildId() : String { return  buildId }
}