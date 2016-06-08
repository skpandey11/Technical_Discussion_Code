package com.traditional.singleton;

/**
 * @author Sunil
 *
 */
public class Singleton {
	// Static member holds only one instance of the
	// Singleton class
	private static Singleton singletonInstance;
	//private static final Singleton singletonInstance = new Singleton();
	
	// Singleton prevents any other class from instantiating
	private Singleton() {
	}
	
	// Providing Global point of access
	/*public static Singleton getSingletonInstance() {
        if (null == singletonInstance) {
            singletonInstance = new Singleton();
            System.out.println("Creating new instance");
        }
        return singletonInstance;
    }*/
	
	 /**
	  * By using this synchronized keyword we prevent Thread2 or Thread3 to access the singleton instance 
	  * while Thread1 inside the method getSingletonInstance().
	  * @return
	 */
	/*public static synchronized Singleton getSingletonInstance() {
        if (null == singletonInstance) {
            singletonInstance = new Singleton();
             System.out.println("Creating new instance");
        }
        return singletonInstance;
    }*/
	
	
	/**
	 * Double Checked Locking(DCL) so that the synchronization happens only during the first call and
	 *  we limit this expensive operation to happen only once
	 * @return singletonInstance
	 */
	public static  Singleton getSingletonInstance() {
		if (null == singletonInstance) {
			synchronized (Singleton.class){
				if (null == singletonInstance) {
					singletonInstance = new Singleton();
					System.out.println("Creating new instance");
				}
			}
		}
		return singletonInstance;
	}


	/**
	 * This is for early loading mechanism
	 * @return singletonInstance
	 */
	/*public static Singleton getSingletonInstance() {
       return singletonInstance;
    }*/

	public void printSingleton(){
		System.out.println("Inside print Singleton");
	}
}