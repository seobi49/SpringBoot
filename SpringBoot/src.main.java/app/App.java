package app;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@Import(AppConfig.class)
public class App {
	public static void main(String[] args) {
		try {
			ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
			
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter 2 number like 'a b' : ");
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			Calculator calculator = context.getBean(Calculator.class);
			int result = calculator.calc(a, b);
			System.out.println("result = " + result);
			
			
			System.out.print("Enter 2 number like 'a b' : ");
			ArgumentResolver argumentResolver = context.getBean(ArgumentResolver.class);
			Argument argument = argumentResolver.resolve(System.in);
			
			result = calculator.calc(argument.getA(), argument.getB());
			System.out.println("result = " + result);
			context.close();

		} catch (Exception e) {
			System.out.println("Exception = " + e);
		}
	}
}
