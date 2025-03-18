package java8.functionalInterface.primitiveType;

import java.util.function.ObjLongConsumer;

public class ObjTypeConsumer {

	static ObjLongConsumer<Integer> getMultiplier=(t, value) -> 
	System.out.println(t*value);

}
