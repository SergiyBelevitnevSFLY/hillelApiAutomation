package dataEntity.users;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsersPostRequestPayload{

	@JsonProperty("name")
	private String name;

	@JsonProperty("job")
	private String job;

	public UsersPostRequestPayload(String name, String job) {
		setName(name);
		setJob(job);
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setJob(String job){
		this.job = job;
	}

	public String getJob(){
		return job;
	}
}