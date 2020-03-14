package com.dewhy;

import com.dewhy.webservice.SpringWebserviceApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringWebserviceApplication.class})
class SpringWebserviceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
