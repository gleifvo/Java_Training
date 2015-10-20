package se02.task7;

import java.lang.annotation.Annotation;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {

		Class<?> cl = Class.forName("se02.task7.AtomicBoat");

		if (!(cl.isAnnotationPresent(AtomicInfo.class))) {
			System.out.println("no annotations");
			return;
		}
		
		Annotation [] ann = cl.getAnnotations();
		
		AtomicBoat atomicBoat = new AtomicBoat();

		System.out.println(atomicBoat.runAtomicBoat() +"\n"+ ann[0]);

	}

}
