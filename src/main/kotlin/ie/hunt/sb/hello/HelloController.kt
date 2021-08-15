package ie.hunt.sb.hello

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(var config: IConfig) {

    @GetMapping("/", produces = ["text/plain"])
    @ResponseBody
    fun index(): String {
        return "Hello World" + "\nSupported endpoints: " + "\n/hello/{name}"
    }

    /**
     * Map the path variable {{name}} and use it in the response
     * https://www.baeldung.com/spring-pathvariable#specifying-the-request-parameter-name
     */
    @GetMapping("/hello/{name}", produces = ["text/plain"])
    @ResponseBody
    fun greet(@PathVariable("name") name: String): String {
        return "Hello $name"
    }


    @GetMapping("/git_sha", produces = ["text/plain"])
    @ResponseBody
    fun version () : String {
        return GVersion.GIT_SHA

    }
}
