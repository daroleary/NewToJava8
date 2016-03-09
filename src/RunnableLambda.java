public class RunnableLambda {

    public static void main(String[] args) throws InterruptedException {

//	Runnable runnable = new Runnable() {
//
//	    @Override
//	    public void run() {
//
//		for (int i = 0; i < 3; i++) {
//		    System.out.println(
//			    "Hello world from thread [" +
//			    Thread.currentThread().getName() +
//			    "]");
//		}
//	    }
//	};

	Runnable runnableLamda = () -> {

		for (int i = 0; i < 3; i++) {
		    System.out.println(
			    "Hello world from thread [" +
			    Thread.currentThread().getName() +
			    "]");
		}
	    };

	Thread thread = new Thread(runnableLamda);
	thread.start();
	thread.join();
    }
}
