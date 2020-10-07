import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class JavaStream{



    public static void main(String[] args) {
        List<Persona> personas=getPersonas();
        //Filter
        System.out.println("\nFilter");
        List<Persona> mujeres =personas.stream()
                .filter(persona -> persona.getGenero().equals(Genero.MUJER))
                .collect(Collectors.toList());

        mujeres.forEach(System.out::println);

        //Sort
        System.out.println("\nSort");
        personas.stream()
                .sorted(Comparator.comparing(Persona::getEdad))
                .forEach(System.out::println);

        //AllMatch
        System.out.println("\nAllMatch");
        boolean allMatch=personas.stream().allMatch(persona -> persona.getEdad()<50);
        System.out.println(allMatch);

        //AnyMatch
        System.out.println("\nAnyMatch");
        boolean anyMatch=personas.stream().anyMatch(persona -> persona.getGenero().equals(Genero.HOMBRE));
        System.out.println(anyMatch);

        //NoneMatch
        System.out.println("\nNoneMatch");
        boolean noMatch=personas.stream().anyMatch(persona -> persona.getNombre().equals("Antonieta"));
        System.out.println(anyMatch);

        //Max
        System.out.println("\nMax");
        personas.stream()
                .max(Comparator.comparing(Persona::getEdad))
                .ifPresent(System.out::println);
        //Min
        System.out.println("\nMin");
        personas.stream()
                .min(Comparator.comparing(Persona::getEdad))
                .ifPresent(System.out::println);
        //Group
        System.out.println("\nGroupBy");
        personas.stream().collect(Collectors.groupingBy(Persona::getGenero))
                .forEach((genero, personas1) ->{
                    System.out.println(genero);
                    personas1.forEach(System.out::println);

                } );



    }


    //Class
    private static class Persona{

        private String nombre;
        private int edad;
        private Genero genero;

        public Persona(String nombre,int edad, Genero genero){
            this.nombre=nombre;
            this.edad=edad;
            this.genero=genero;
        }
        public String getNombre(){
            return nombre;
        }
        public int getEdad(){
            return edad;
        }
        public Genero getGenero(){
            return genero;
        }

        @Override
        public String toString() {
            return "Persona{" +
                    "nombre='" + nombre + '\'' +
                    ", edad=" + edad +
                    ", genero=" + genero +
                    '}';
        }
    }

    public enum Genero{HOMBRE,MUJER}
    //data
    private static List<Persona> getPersonas(){
        return List.of(
                new Persona("Michael",35,Genero.HOMBRE),
                new Persona("Leo",15,Genero.HOMBRE),
                new Persona("Hulo",65,Genero.HOMBRE),
                new Persona("Ismael",10,Genero.HOMBRE),
                new Persona("Alicia",40,Genero.MUJER),
                new Persona("Carolina",25,Genero.MUJER),
                new Persona("Vicenta",72,Genero.MUJER)
        );
    }
}