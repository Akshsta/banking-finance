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
