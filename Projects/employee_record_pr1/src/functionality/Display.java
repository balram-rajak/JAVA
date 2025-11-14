package functionality;

import java.util.List;
import java.util.function.Predicate;

import com.Data;

/**
 * Functional interface for displaying filtered employee data.
 * This interface demonstrates custom functional interface implementation in Java 8.
 * 
 * @author Balram Rajak
 */
public interface Display {
	
	/**
	 * Displays employees that match the given predicate condition.
	 * 
	 * @param p Predicate to filter employees
	 * @param l List of employee data
	 */
	void display(Predicate<Data> p,List<Data> l);
}
