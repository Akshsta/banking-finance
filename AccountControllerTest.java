@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateAccount() throws Exception {
        String json = "{\"accountNo\":1, \"name\":\"Akshata\", \"policy\":\"Life\"}";
        mockMvc.perform(post("/api/createAccount")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
    }
}
