package joes.kotlin.spring.example

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.startsWith
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@WebMvcTest(JoesKotlinSpringController::class)
class JoesKotlinSpringControllerTests {

    @Autowired
    private val mockMvc: MockMvc? = null

    @Test
    @Throws(Exception::class)
    fun shouldReturnGreeting() {
        this.mockMvc!!.perform(get("/hello/Rod"))
                .andExpect(status().isOk)
                .andExpect(content().string(equalTo<String>("Hello Rod!")))
    }

    @Test
    @Throws(Exception::class)
    fun shouldReturnHello() {
        this.mockMvc!!.perform(get("/"))
                .andExpect(status().isOk)
                .andExpect(content().string(startsWith("Hello")))
    }

    @Test
    @Throws(Exception::class)
    fun shouldNotFindGreetingElsewhere() {
        this.mockMvc!!.perform(get("/hey/man"))
                .andExpect(status().isNotFound)
    }

}

