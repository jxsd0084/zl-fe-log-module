package com.zhisland.fe.log.manager;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BootstrapApplicationTest {

	@Autowired
	private MockMvc mvc;


	@Test
	public void exampleTest() throws Exception {
		this.mvc.perform(get("/fe/log").param("logInfo", "1234asdf"))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World"));
	}



	private String DOMAIN = "http://localhost:9100";

	private String URL = DOMAIN + "/fe/log";

	@Test
	public void test() throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		URIBuilder builder = new URIBuilder(URL);
		builder.setParameter("logInfo", "1234asdf");
		HttpGet httpGet = new HttpGet(builder.build());
		doExec(httpClient, httpGet);
	}

	private void doExec(CloseableHttpClient httpClient, HttpGet httpGet) {
		try {
			CloseableHttpResponse response = httpClient.execute(httpGet);
			log.info("-> ", response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close(); // 释放资源
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
