package loansystem;

import loansystem.entities.Loan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class LoanSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LoanSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Loan loan1 = new Loan(null,2000.00, new Date());
		Loan loan2 = new Loan(null,2000.00, new Date());
		Loan loan3 = new Loan(null,2000.00, new Date());
	}
}
