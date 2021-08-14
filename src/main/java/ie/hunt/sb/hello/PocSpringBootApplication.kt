package ie.hunt.sb.hello

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import java.util.*

@SpringBootApplication
open class PocSpringBootApplication {

    val logger = LoggerFactory.getLogger(PocSpringBootApplication::class.java)

    @Bean
    open fun commandLineRunner(ctx: ApplicationContext): CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->


            //TODO : make this into a proper reduce function for printing out the
            //the invoked arguments.
//            val argslist  = args.reduce { acc, s -> "endres" }

//            logger.info("Your application started with option names : $argslist")
//            println("Let's inspect the beans provided by Spring Boot:")
//            val beanNames = ctx.beanDefinitionNames
//            Arrays.sort(beanNames)
//            for (beanName in beanNames) {
//                println(beanName)
//            }
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(PocSpringBootApplication::class.java, *args)
        }
    }
}