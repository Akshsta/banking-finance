@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping("/createAccount")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return new ResponseEntity<>(service.createAccount(account), HttpStatus.CREATED);
    }

    @PutMapping("/updateAccount/{accountNo}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long accountNo, @RequestBody Account account) {
        return ResponseEntity.ok(service.updateAccount(accountNo, account));
    }

    @GetMapping("/viewPolicy/{accountNo}")
    public ResponseEntity<Account> viewPolicy(@PathVariable Long accountNo) {
        return ResponseEntity.ok(service.viewPolicy(accountNo));
    }

    @DeleteMapping("/deletePolicy/{accountNo}")
    public ResponseEntity<Void> deletePolicy(@PathVariable Long accountNo) {
        service.deletePolicy(accountNo);
        return ResponseEntity.noContent().build();
    }
}

root@akshata:/home/ubuntu# ls
 Account.java                 AccountService.java   README.md                    deploy-dev.yml                hosts.ini              spring.yaml
 AccountController.java       Dockerfile            ansible-playbook.yml        'eval "$(ssh-agent -s)"'       main.tf                star-agile-banking-finance
 AccountControllerTest.java   J1.pem                application.yml             'eval "$(ssh-agent -s)".pub'   minikube-linux-amd64   target
 AccountRepository.java       Jenkinsfile           banking-0.0.1-SNAPSHOT.jar   get-docker.sh                 pom.xml                testng.xml
root@akshata:/home/ubuntu# cat AccountControllerTest.java
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

root@akshata:/home/ubuntu# ls
 Account.java                 AccountService.java   README.md                    deploy-dev.yml                hosts.ini              spring.yaml
 AccountController.java       Dockerfile            ansible-playbook.yml        'eval "$(ssh-agent -s)"'       main.tf                star-agile-banking-finance
 AccountControllerTest.java   J1.pem                application.yml             'eval "$(ssh-agent -s)".pub'   minikube-linux-amd64   target
 AccountRepository.java       Jenkinsfile           banking-0.0.1-SNAPSHOT.jar   get-docker.sh                 pom.xml                testng.xml
root@akshata:/home/ubuntu# cat  AccountRepository.java 
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
