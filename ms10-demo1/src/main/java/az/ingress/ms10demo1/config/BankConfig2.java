package az.ingress.ms10demo1.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Data
@Configuration
@ConfigurationProperties(prefix = "bank")
public class BankConfig2 {

    private String name;

    private Long opened;

    private List<String> offices;

    private List<Contact> contacts;

    private Map<String, String> addresses;

    private Map<Integer, Branch> branches;
}
