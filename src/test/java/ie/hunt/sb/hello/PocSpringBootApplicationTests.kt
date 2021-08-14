package ie.hunt.sb.hello

import org.assertj.core.api.Assertions
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

/**
 * Unit tests, following the patterns outlined in the Spring documentation
 * https://spring.io/guides/gs/testing-web/
 */
@SpringBootTest
@AutoConfigureMockMvc
class PocSpringBootApplicationTests {
    @Autowired
    private val controller: HelloController? = null

    @Autowired
    private val mvc: MockMvc? = null

    @Test
    @Throws(Exception::class)
    fun contextLoads() {
        Assertions.assertThat(controller).isNotNull
    }

    @Test
    @Throws(Exception::class)
    fun verifyHello() {
        mvc!!.perform(MockMvcRequestBuilders.get("/"))
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful)
            .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Hello World")))
    }

    @Test
    @Throws(Exception::class)
    fun givenBadArguments_whenGetSpecificException_thenBadRequest() {
        val name = "dave"
        mvc!!.perform(
            MockMvcRequestBuilders.get(
                "/hello/{name}",
                name
            )
        )
            .andExpect(MockMvcResultMatchers.status().is2xxSuccessful)
            .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Hello $name")))
    }
}