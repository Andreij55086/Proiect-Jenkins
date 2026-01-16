import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class invatareStreamuri {
    public static void main(String[] args) {
        String sentence = "Ana are mere, ana are pere si mere.";

        Map<String, Long> wordCounts = Arrays.stream(
                        sentence.toLowerCase()          // facem totul lowercase
                                .replaceAll("[^a-zăâîșț0-9 ]", " ") // scoatem semnele de punctuație
                                .split("\\s+")           // împărțim după spații
                )
                .filter(word -> !word.isEmpty())     // ignorăm string-urile goale
                .collect(Collectors.groupingBy(
                        Function.identity(),         // cheia: cuvântul
                        Collectors.counting()        // valoarea: numărul de apariții
                ));

        System.out.println(wordCounts);


        // să păstrezi doar numele cu lungime > 4
        //să le transformi în litere mari
        //să le sortezi alfabetic
        //să le pui într-o listă

        List<String> nume = Arrays.asList("Andrei", "Ana", "Mircea");

        List<String> rezultat = nume.stream()
                .filter(x -> x.length() > 4)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(rezultat);


        //să împarți în cuvinte
        //
        //să păstrezi doar cuvintele distincte
        //
        //să le sortezi alfabetic
        //
        //să le afișezi


        String sentence2 = "Ana are mere multe si pere si pere si pere si Ana";

        List<String> splituit = Arrays.stream(
                sentence2.toLowerCase()
                        .replaceAll("","")
                        .split("\\s+"))
                        .distinct()
                        .sorted()
                        .collect(Collectors.toList());

        System.out.println("aici e ex333" + splituit);


        class Person {
            String name;
            int age;
            String city;

            public Person(String name, int age, String city) {
                this.name = name;
                this.age = age;
                this.city = city;
            }

            public String getName() { return name; }
            public int getAge() { return age; }
            public String getCity() { return city; }
        }




//
//    Map<String,String> ceva = Arrays.stream(
//            sentence2.toLowerCase()
//                    .replaceAll("[^a-zăâîșț0-9 ]", " ")
//                    .split("\\s+"))
//            .filter(x->x.isEmpty())
//        //    .filter(x->x.length()>18))
//        .



    String sentence3 = "ceva o propozitie pentru un exercitiu nuj";

        List<String> exercitiu5 = Arrays.stream(
               sentence3.toLowerCase()
                        .replaceAll("[^a-zăâîșț0-9 ]", " ")
                        .split("\\s+"))
                        .filter(x->x.length()>3)
                        .distinct()
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());

        System.out.println("aici e ex3" + exercitiu5);


    String sentence10 ="Salut 123 Java8 este super tare!!! Dar streamURILE sunt si mai tari123";

    List<String> ceva2 = Arrays.stream(
            sentence10.toLowerCase()
                    .replaceAll("[^a-zăâîșț0-9 ]", " ")
                    .split("\\s+"))
            .filter(x->!x.isEmpty())
            .filter(x->x.matches("[a-zăâîșț]+"))
            .filter(x->x.length()>4)
            .distinct()
            .sorted(Comparator
                    .comparingInt(String::length).reversed()
                    .thenComparing(Comparator.naturalOrder())
            )
            .collect(Collectors.toList());

        System.out.println(ceva2+"aici e ceva2");


        String sentence11 = "Programarea este super tare!!! Streamurile pot fi foarte utile, dar uneori fooocusul poate strica tot";

        List<String> rezolvare = Arrays.stream(
                sentence11.toLowerCase()
                        .replaceAll("[^a-zăâîșț0-9 ]", " ")
                        .split("\\s+"))
                .filter(x->!x.isEmpty())
                .filter(x->x.length()>5)
                .filter(x->!x.matches(".*([a-zăâîșț])\\1+.*"))
                .distinct()
                .sorted(Comparator.
                        comparing((String s)->s.charAt(0))
                        .thenComparing(String::length))
                .collect(Collectors.toList());

        System.out.println(rezolvare + "aici e ex11");






        List<String>ceva = Arrays.stream(
               sentence2.toLowerCase()
                       .replaceAll("[^a-zăâîșț0-9 ]", " ")
                       .split("\\s+"))
                .filter(s -> !s.isEmpty())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("aici e ex3" + ceva);



      //  să numeri de câte ori apare fiecare cuvânt (ca ce am făcut noi)
      //  să afișezi primele 3 cuvinte cele mai frecvente, ordonate descrescător după count.


        Map<String,Long> frecventa = Arrays.stream(
                sentence2.toLowerCase()
                        .replaceAll("[^a-zăâîșț0-9 ]", " ")
                        .split("\\s+")
        )
                .filter(w ->!w.isEmpty())
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        frecventa.entrySet().stream()
                .sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                .limit(3)
                .forEach(entry -> System.out.println("aici e ex4" + entry.getKey()+ "=" + entry.getValue()));












        //  să numeri de câte ori apare fiecare cuvânt (ca ce am făcut noi)
        //  să afișezi primele 3 cuvinte cele mai frecvente, ordonate descrescător după count.


        Map<String,Long>frecventa2 = Arrays.stream(
                sentence2.toLowerCase()
                        .replaceAll("","")
                        .split("\\s+")
        )
                .filter(x->!x.isEmpty())
                .collect(Collectors.groupingBy(
                      Function.identity(),
                        Collectors.counting()


                ));
        frecventa2.entrySet().stream()
                .sorted(Map.Entry.<String,Long>comparingByValue())
                .limit(3)
                .forEach(entry -> System.out.println(entry.getKey()+entry.getValue()));




        String text = "Programarea in Java este foarte interesanta si educativa";

        List<String> rezultat12 = Arrays.stream(
                text.toLowerCase()
                        .replaceAll("[^a-zăâîșț0-9 ]", " ")
                        .split("\\s+"))
                .filter(x->x.length()>5)
                .filter(x->{
                    String vocale = x.replaceAll("[^aeiouăâî]", "");
                    long numar = vocale.chars().distinct().count();
                    return numar >=2;
                })
                .distinct()
                .sorted(Comparator.<String>comparingInt(s->s.replaceAll("[^aeiouăâî]", "").length()).reversed()
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());

        System.out.println(rezultat12 +"aici e 12");



        String text111 = "Programarea este foarte utila, iar cooperarea eficienta este esentiala";

             List<String> rezultat200 = Arrays.stream(
                     text.toLowerCase()
                             .replaceAll("[^a-zăâîșț0-9 ]", " ")
                             .split("\\s+"))
                     .filter(x->!x.isEmpty())
                     .filter(x->x.length()>6)
                     .filter(x->!x.matches(".*([aeiou])*."))
                     .distinct()
                     .sorted(Comparator.<String>comparingInt(s->s.replaceAll("[aeiou]", " ").length()).reversed()
                             .thenComparing(Comparator.naturalOrder()))
                     .collect(Collectors.toList());


    }
}