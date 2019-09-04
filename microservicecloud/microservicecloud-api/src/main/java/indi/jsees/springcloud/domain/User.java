package indi.jsees.springcloud.domain;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String username;
	private String password;
	private int age;
	private int gender;
	private String hobby;
	private String db_source;

}
