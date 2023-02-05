package niffler.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseUsers{

	@JsonProperty("user")
	private List<User> user;

	public List<User> getUser(){
		return user;
	}

	@Override
	public String toString() {
		return "ResponseUsers{" +
				"user=" + user +
				'}';
	}
}