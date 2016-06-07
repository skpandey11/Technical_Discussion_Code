package com.modern.singleton;

/**
 * The drawback is that the enum type is somewhat inflexible. for examole, it dose not allow lazy initialization
 * @author Sunil
 *
 */
public enum SingletonEnum {
	INSTANCE;
	 public void doStuff(){
	     System.out.println("Singleton using Enum");
	 }
}
