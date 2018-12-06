/**
 * 
 */
package Model;


import Controller.ValveResponse;
import message.Message;
/**
 * @author jay
 *The following valves help one to perform certain events.
 */
public interface Valve {

	/** performs certain action in response to message
	* */
	public ValveResponse execute(Message message);
}
