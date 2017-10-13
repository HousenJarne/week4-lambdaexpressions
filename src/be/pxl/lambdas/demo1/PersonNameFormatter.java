package be.pxl.lambdas.demo1;

@FunctionalInterface //zorgt ervoor dat er maar 1 methoda kan inzitten
public interface PersonNameFormatter {
	String formatName(Person person);
}
