package st3_modul;

import st3.*;

public class Person {
	//data
	private String id;
	private String name;
	
	private IGet get;
	private IJob job;
	
	//constructor
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	//method
	public void get() {
		get.get();
	}
	public void job() {
		job.job();
	}
	public void print() {
		System.out.printf("\n(ID)%s \t (¿Ã∏ß)%s\t", id, name);
	}
	
	//setter
	public void setGet(IGet get) {
		this.get = get;
	}
	public void setJob(IJob job) {
		this.job = job;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public IGet getGet() {
		return get;
	}
	public IJob getJob() {
		return job;
	}
}
