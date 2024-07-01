
  package com.example.demo;
  
  import com.example.demo.controller.HomeController; import
  com.example.demo.entity.Operations; import
  com.example.demo.repository.OperationRepository; import
  org.junit.jupiter.api.Test; import org.mockito.Mockito; import
  org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; import
  org.springframework.boot.test.mock.mockito.MockBean; import
  org.springframework.test.web.servlet.MockMvc; import
  org.springframework.test.web.servlet.MvcResult; import
  org.springframework.test.web.servlet.request.MockMvcRequestBuilders; import
  org.springframework.test.web.servlet.result.MockMvcResultMatchers; import
  org.springframework.ui.Model; import org.springframework.ui.ConcurrentModel;
  
  import jakarta.servlet.http.HttpSession;
  
  import java.util.Arrays; import java.util.Optional;
  
  import static org.mockito.ArgumentMatchers.any; import static
  org.mockito.ArgumentMatchers.anyLong; import static org.mockito.Mockito.when;
  import static
  org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
  
  @WebMvcTest(HomeController.class) public class HomeControllerTest {
  
  @Autowired private MockMvc mockMvc;
  
  @MockBean private OperationRepository opeRepo;
  
  @Test public void testHome() throws Exception {
  when(opeRepo.findAll()).thenReturn(Arrays.asList(new Operations(), new
  Operations()));
  
  MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/"))
  .andExpect(MockMvcResultMatchers.status().isOk())
  .andExpect(MockMvcResultMatchers.view().name("index"))
  .andExpect(MockMvcResultMatchers.model().attributeExists("all_employees"))
  .andDo(print()) .andReturn(); }
  
  @Test public void testLoadForm() throws Exception {
  mockMvc.perform(MockMvcRequestBuilders.get("/load_form"))
  .andExpect(MockMvcResultMatchers.status().isOk())
  .andExpect(MockMvcResultMatchers.view().name("add")) .andDo(print()); }
  
  @Test public void testEditForm() throws Exception { Operations op = new
  Operations(); op.setId(1L);
  when(opeRepo.findById(anyLong())).thenReturn(Optional.of(op));
  
  mockMvc.perform(MockMvcRequestBuilders.get("/edit_form/1"))
  .andExpect(MockMvcResultMatchers.status().isOk())
  .andExpect(MockMvcResultMatchers.view().name("edit"))
  .andExpect(MockMvcResultMatchers.model().attributeExists("operation"))
  .andDo(print()); }
  
  @Test public void testSaveEmployee() throws Exception {
  mockMvc.perform(MockMvcRequestBuilders.post("/save_employee") .param("name",
  "Shankar") .param("CompanyName", "Eviden") .sessionAttr("msg",
  "Employee Added Sucessfully..."))
  .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
  .andExpect(MockMvcResultMatchers.redirectedUrl("/load_form"))
  .andDo(print());
  
  Mockito.verify(opeRepo, Mockito.times(1)).save(any(Operations.class)); }
  
  @Test public void testUpdateEmployee() throws Exception {
  mockMvc.perform(MockMvcRequestBuilders.post("/update_employee")
  .param("name", "Siva") .param("CompanyName", "Senior Developer")
  .sessionAttr("msg", "Updated Sucessfully..."))
  .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
  .andExpect(MockMvcResultMatchers.redirectedUrl("/")) .andDo(print());
  
  Mockito.verify(opeRepo, Mockito.times(1)).save(any(Operations.class)); }
  
  @Test public void testDeleteEmployee() throws Exception {
  mockMvc.perform(MockMvcRequestBuilders.get("/delete/1") .sessionAttr("msg",
  "Deleted Sucessfully..."))
  .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
  .andExpect(MockMvcResultMatchers.redirectedUrl("/")) .andDo(print());
  
  Mockito.verify(opeRepo, Mockito.times(1)).deleteById(1L); } }
 