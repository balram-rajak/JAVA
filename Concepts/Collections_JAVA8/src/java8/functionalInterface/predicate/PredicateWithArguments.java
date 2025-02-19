package java8.functionalInterface.predicate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class PredicateWithArguments {

	static Function<List<String>,Optional<String>> checkDublication(String name){
		
		return args -> {args.stream().map(t -> (Collections.frequency(args, name)>1 ? 
						name+" "+Collections.frequency(args, name): name )).
		forEach(System.out::println);
		return Optional.empty();
		};
		
	};
	
	public static void main(String[] args) {
		List<String> names=new ArrayList<>();
		names.add("Krishna");
		names.add("balram");
		names.add("Radhe");
		names.add("Krishna");
		
		for(String s:names)
		System.out.println(checkDublication(s).apply(names));
		
	}
	
	
	
}
