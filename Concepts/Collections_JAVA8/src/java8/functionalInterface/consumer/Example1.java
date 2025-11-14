package java8.functionalInterface.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Example1 {

	static Consumer<String> print=t -> System.out.println(t);
	
	static Consumer<List<Movie>> printMovieObjects=t -> t.stream().
			map(object -> object.toString()).
			forEach(System.out::println); ; 
	
			static Consumer<List<Movie>> populate= list ->{
				
				list.add(new Movie("Krishna","Radhe"));
				list.add(new Movie("Jagganath","Subhadra"));
				list.add(new Movie("Ram","Sita"));
				list.add(new Movie("Sri Chaitanya","Radhe"));
				list.add(new Movie("Krishna","All"));
				
			};
			
	public static void main(String[] args) {
		List<Movie> movies=new ArrayList<>();
		populate.accept(movies);
		print.accept("Krishna");
		printMovieObjects.accept(movies);
	}


	
	

}
class Movie{
	
	public Movie(String hero, String heroine) {
		super();
		Hero = hero;
		Heroine = heroine;
	}
	private String Hero;
	private String Heroine;
	public String getHero() {
		return Hero;
	}
	public String getHeroine() {
		return Heroine;
	}
	@Override
	public String toString() {
		return this.hashCode()+" [Hero=" + Hero + ", Heroine=" + Heroine + "]";
	}
	
	
	
	
}