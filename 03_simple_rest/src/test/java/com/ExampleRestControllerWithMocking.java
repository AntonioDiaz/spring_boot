package com;

import com.controller.ExampleRestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ExampleRestController.class)
public class ExampleRestControllerWithMocking {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void autoWiredTest() {
		assertNotNull(mockMvc);
	}
	@Test
	public void notFoundTest() throws Exception {
		ResultActions perform = mockMvc.perform(get("/hitsongss"));
		perform.andExpect(status().isNotFound());
	}	
	
	@Test
	public void getSongTest() throws Exception {
		
		ResultActions perform = mockMvc.perform(
				get("/hitsong").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		//perform.andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON));
//		perform.andExpect(status().isOk());
//		RequestMatcher contentType = content().contentType(MediaType.APPLICATION_JSON);
//		perform.andExpect(contentType);
	}
	
}
