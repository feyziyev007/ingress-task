package az.ingress.ms10demo1.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
public class BankConfig {

    @Value("${bank.name}")
    private String bankName;

    @Value("${bank.opened}")
    private Long bankOpened;

   // @Value("${bank.offices}") Homework
    private List<String> offices;
}
