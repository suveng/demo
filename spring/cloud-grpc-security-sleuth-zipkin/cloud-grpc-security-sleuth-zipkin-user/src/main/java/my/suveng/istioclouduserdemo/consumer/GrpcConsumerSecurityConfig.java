package my.suveng.istioclouduserdemo.consumer;

import io.grpc.CallCredentials;
import net.devh.boot.grpc.client.security.CallCredentialsHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author suwenguang
 **/
@Configuration
public class GrpcConsumerSecurityConfig {
	//
	//private String username = "user" ;
	//
	//@Bean
	//	// Create credentials for username + password.
	//CallCredentials grpcCredentials() {
	//	return CallCredentialsHelper.basicAuth(this.username, this.username + "Password");
	//}

	// This token will usually be created by a login endpoint (e.g. from Keycloak).
	private final String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1OTU1MjI2NDQsInVzZXJfbmFtZSI6IjM2OTgiLCJhdXRob3JpdGllcyI6WyJ0ZXN0LXVwZGF0ZSIsIlJPTEVfaDIiLCJST0xFX2gxIl0sImp0aSI6IjY2ZDFjNDZkLTFkN2MtNDZhZS04OGViLTU2ODU1YTJkNTNlNyIsImNsaWVudF9pZCI6ImNsaWVudCIsInNjb3BlIjpbImFwcCJdfQ.LuN0SDTwjOYyUqRV3I9BjN0c2r4aB6bDGG7RLeswN6AUp_iB1PcxdYxJX7cgQ7iTR7qAN4mfwfPfAyyZxB-r77YyndcS4giYKlDs3gkGvYB8V82oCFNVV5WYTmclF-8PRiIcrjVJAlSXlSwuMuboLUelboOt2FZAh19cK2duWK2Ax_3ofg-_UsXWyFu55bf-qRws8xjlc2gXM9_O05KIyAMArr5AE7-wiWZVZj99HeFM44zQwt4hPlSi0lx0W_4sBbF4BTzB95ZUDNJr0sQKuM4TuMwLJYp4uoRpR-QjqctsJ3zUP5g7P7MwKJNH93sD5tE86vSTG6qAkP99d5UgWg";

	@Bean
		// Create credentials bearer Token
	CallCredentials grpcCredentials() {
		return CallCredentialsHelper.bearerAuth(this.token);
	}

}
