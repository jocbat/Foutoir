import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException 
	{
		// TODO Auto-generated method stub
		AsynchronousServerSocketChannel server =
			    AsynchronousServerSocketChannel.open().bind(null);
		
		Future<AsynchronousSocketChannel> acceptFuture = server.accept();
		
		AsynchronousSocketChannel worker = acceptFuture .get();
		
		AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
	    client.connect(server.getLocalAddress()).get();
	    
	 // send a message to the server
	    ByteBuffer message = ByteBuffer.wrap("ping".getBytes());
	    client.write(message).get();

	    // read a message from the client
	    worker.read(readBuffer).get(10, TimeUnit.SECONDS);
	    System.out.println("Message: " + new String(readBuffer.array()));
	}

}
