package message;
import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Block;
import model.Position;

class MoveSnakeMessageTest {
	KeyPressed key  = KeyPressed.LEFT;
	KeyPressed key1  = KeyPressed.RIGHT;
	KeyPressed key2  = KeyPressed.UP;
	KeyPressed key3  = KeyPressed.DOWN;
	@Test
	void testGetKey() {
		assertEquals(key, KeyPressed.valueOf("LEFT"));
		assertEquals(key1, KeyPressed.valueOf("RIGHT"));
		assertEquals(key2, KeyPressed.valueOf("UP"));
		assertEquals(key3, KeyPressed.valueOf("DOWN"));
	}

	@Test
	void testSetKey(){
		KeyPressed key  = KeyPressed.LEFT;
		assertEquals(key, KeyPressed.valueOf("LEFT"));
	}

}
