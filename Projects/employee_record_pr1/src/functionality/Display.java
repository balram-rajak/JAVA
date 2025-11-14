package functionality;

import java.util.List;
import java.util.function.Predicate;

import com.Data;
public interface Display {

	void display(Predicate<Data> p,List<Data> l);
}
