import java.util.List;
import java.util.stream.Collectors;

public class JavaStream{



    public static void main(String[] args) {
        List<Persona> personas=getPersonas();
        //Sort
        List<Persona> mujeres =personas.stream()
                .filter(persona -> persona.getGenero().equals(Genero.MUJER))
                .collect(Collectors.toList());

        mujeres.forEach(System.out::println);
    }



    public static class Persona{

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