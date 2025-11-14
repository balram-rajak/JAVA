package rough_work;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FloatprecisionTest {

private Floatprecision f1 = new Floatprecision();
private Precision precisionstub=new precisionstub();
private Floatprecision f2=new Floatprecision(precisionstub);
	

	@Test
	void precision_two_number() {
		assertEquals(2.047f, f1.floatprecision((float) (5.43 / 2.653)));

	}

	@Test
	void preciosn_of_0() {

		assertEquals(2.0f, f1.floatprecision(0));

}
	
	@Test
	void floatprecion_withstub() {
		assertEquals(3.594f, f2.floatprecision());;
		
	}

	@Test
	void floatprecision_mock1() {
		
		
	}
	
}

class precisionstub implements Precision{

	@Override
	public float getvalue() {
		
		return 3.5936473f;
	}
	
	
}






















