package streams;

import java.io.ObjectInputStream.GetField;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import streams.Auto.Marke;

/*
 * 
 * Übung Streams
 * Verwende map, reduce, filter, distinct, 
 * 
 * 
 */

public class UEStreams {
	
	public static boolean von200(Auto a) {
		return a.getGeschwindigkeit() >= 200;
	}
	
	public static Auto speedCar(Auto a1, Auto a2) {
		return a1.getGeschwindigkeit() > a2.getGeschwindigkeit() ?a1:a2;
	}

	public static void main(String[] args) {
		
		List<Auto> list= Arrays.asList(
				new Auto(200, "grün", Marke.BMW),
				new Auto(200, "grün", Marke.BMW),
				new Auto(190, "blau", Marke.MERCEDES),
				new Auto(190, "blau", Marke.MERCEDES),
				new Auto(180, "gelb", Marke.FORD),
				new Auto(180, "gelb", Marke.BMW),
				new Auto(130, "gelb", Marke.ENTE),
				new Auto(130, "braun", Marke.ENTE)
				
		);
		
		
		System.out.println("das schnellste Auto(ein Auto-objekt), erste option: ");
		Stream<Auto> stream1 = list.stream();
		Auto speedCar = stream1.reduce(UEStreams:: speedCar).get(); // reduce
		System.out.println(speedCar);
		
		System.out.println("das schnellste Auto, zweite option: ");
		Auto max = list.stream().max(Comparator.comparing(String::valueOf)).get();
		System.out.println(max);
		
		
		
		
		System.out.println("eine Liste mit allen Farben (keine doppelten):");
		List<String> farben = list.stream().map(a -> a.getFarbe()).distinct().collect(Collectors.toList()); //oder  .forEach(System.out::println);
		System.out.println(farben);
		
		
		
		System.out.println("alle Autos mit einer Geschwindigkeit ab 200, erste option: ");
		list.stream().
			filter(UEStreams::von200). // oder (new UEStreams::von200), falls von200() ist nicht static
			collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("alle Autos mit einer Geschwindigkeit ab 200, zweite option: ");
		list.stream().filter(a -> a.getGeschwindigkeit() >= 200).forEach(System.out::println);
		
		
		
		
		
		// nach geschwindigkeit sortierte (Stream-Sort) Liste (kleinste zuerst, keine doppelten)
		System.out.println("nach geschwindigkeit sortierte Liste (kleinste zuerst):");
		Stream<Auto> stream4 = list.stream();
		stream4.sorted( (a1, a2) -> a1.getGeschwindigkeit() - a2.getGeschwindigkeit() ).distinct();
		
		
		
		
		//Marken-Liste aller gelben Autos, die unter 200 fahren (nur Marken in der Liste) List<Marke>
		System.out.println("Marken-Liste aller gelben Autos, die unter 200 fahren (nur Marken in der Liste), erste option:");
		Stream<Auto> stream5 = list.stream().filter(a -> a.getGeschwindigkeit() < 200 && a.getFarbe().equals("gelb"));
		System.out.println(stream5.map(Auto::getMarke).collect(Collectors.toList()));
//		System.out.println(stream5.map(a -> a.getMarke()).collect(Collectors.toList())); // Macht gleiche wie oben
		
		System.out.println("Marken-Liste aller gelben Autos, die unter 200 fahren (nur Marken in der Liste), zweite option:");
		Stream<Auto> stream6 = list.stream();
		List<Marke> markList = stream6.filter(a -> a.getGeschwindigkeit() < 200).
										filter(a -> a.getFarbe().equals("gelb")).
										map(a -> a.getMarke()).
										collect(Collectors.toList());
		System.out.println(markList);

		
		

		
//----------- vergleiche die Ausgabe --------------------------------------
//			das schnellste Auto:
//			Auto [geschwindigkeit=220, farbe=gelb, marke=BMW]
//			eine Liste mit allen Farben (keine doppelten):
//			[grün, blau, gelb, braun]
//			alle Autos mit einer Geschwindigkeit ab 200:
//			Auto [geschwindigkeit=200, farbe=grün, marke=BMW]
//			Auto [geschwindigkeit=200, farbe=grün, marke=BMW]
//			Auto [geschwindigkeit=210, farbe=blau, marke=MERCEDES]
//			Auto [geschwindigkeit=212, farbe=blau, marke=MERCEDES]
//			Auto [geschwindigkeit=220, farbe=gelb, marke=BMW]
//			nach geschwindigkeit sortierte Liste (kleinste zuerst):
//			Auto [geschwindigkeit=130, farbe=gelb, marke=ENTE]
//			Auto [geschwindigkeit=130, farbe=braun, marke=ENTE]
//			Auto [geschwindigkeit=180, farbe=gelb, marke=FORD]
//			Auto [geschwindigkeit=200, farbe=grün, marke=BMW]
//			Auto [geschwindigkeit=210, farbe=blau, marke=MERCEDES]
//			Auto [geschwindigkeit=212, farbe=blau, marke=MERCEDES]
//			Auto [geschwindigkeit=220, farbe=gelb, marke=BMW]
//			Marken-Liste aller gelben Autos, die unter 200 fahren (nur Marken in der Liste):
//			[FORD, ENTE]

		
	
	}

}
