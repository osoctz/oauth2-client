package cn.metaq.oauth2.client.config;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
 
@Configuration
public class Oauth2ClientAutoConfiguration {
 
    @Bean
    public SecurityFilterChain authorizationClientSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests((authorize) -> authorize
//                        .anyRequest().authenticated()
//                ).logout(Customizer.withDefaults())
//                .sessionManagement(Customizer.withDefaults())
//                .oauth2Client(Customizer.withDefaults())
//                .oauth2Login(Customizer.withDefaults());

        http
                .authorizeHttpRequests()
                .anyRequest().authenticated()
                .and().logout()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .and().oauth2Client()
                .and().oauth2Login();
        return http.build();
    }
}
