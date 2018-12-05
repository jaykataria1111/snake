/**
 * 
 */
package Model;


import Controller.ValveResponse;
import message.Message;
/**
 * @author jay
 *
 */
public interface Valve {

	/** performs certain action in response to message
	* */
	public ValveResponse execute(Message message);
}
