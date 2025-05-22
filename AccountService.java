@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;

    public Account createAccount(Account acc) {
        return repository.save(acc);
    }

    public Account updateAccount(Long accountNo, Account updated) {
        Account existing = repository.findById(accountNo).orElseThrow();
        existing.setName(updated.getName());
        existing.setPolicy(updated.getPolicy());
        return repository.save(existing);
    }

    public Account viewPolicy(Long accountNo) {
        return repository.findById(accountNo).orElseThrow();
    }

    public void deletePolicy(Long accountNo) {
        repository.deleteById(accountNo);
    }
}
