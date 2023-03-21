import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecuterService {
	public static void main(String[] args) {

		System.out.println("Started");
		ExecutorService es = Executors.newSingleThreadExecutor();

		Runnable rn = () -> {
			System.out.println("RUNNING - " + Thread.currentThread().getName());
		};

		es.execute(rn);
		es.submit(rn);
		System.out.println("Ended");

		/*
		 * Java Concurrency API defines the following three executor interfaces that
		 * covers everything that is needed for creating and managing threads -
		 * 
		 * Executor - A simple interface that contains a method called execute() to
		 * launch a task specified by a Runnable object.
		 * 
		 * ExecutorService - A sub-interface of Executor that adds functionality to
		 * manage the lifecycle of the tasks. It also provides a submit() method whose
		 * overloaded versions can accept a Runnable as well as a Callable object.
		 * Callable objects are similar to Runnable except that the task specified by a
		 * Callable object can also return a value. We’ll learn about Callable in more
		 * detail, in the next blog post.
		 * 
		 * ScheduledExecutorService - A sub-interface of ExecutorService. It adds
		 * functionality to schedule the execution of the tasks.
		 * 
		 * Apart from the above three interfaces, The API also provides an Executors
		 * class that contains factory methods for creating different kinds of executor
		 * services.
		 */
	}
}
