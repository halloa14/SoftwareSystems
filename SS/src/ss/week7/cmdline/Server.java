
package ss.week7.cmdline;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Server. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Server {
	
	
    private static final String USAGE
        = "usage: " + Server.class.getName() + " <name> <port>";

    /** Starts a Server-application. */
    public static void main(String[] args) {
    	if (args.length != 2) {
    		System.out.println(USAGE);
    	}
    	
        try {
            int port = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println(USAGE);
            System.out.println("ERROR: port " + args[2]
            		           + " is not an integer");
            System.exit(0);
        }
    		
    	try {
            Peer server = new Peer(args[0], new ServerSocket(Integer.parseInt(args[1])).accept());
            Thread streamInputHandler = new Thread(server);
            streamInputHandler.start();
            server.handleTerminalInput();
            server.shutDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    }

} // end of class Server
