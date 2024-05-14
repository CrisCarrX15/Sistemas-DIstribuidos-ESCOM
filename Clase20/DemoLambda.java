import java.util.ArrayList; // import the ArrayList class
import java.util.function.*; // Para poder crear predicados es necesaria
import java.util.stream.Collectors;
import java.util.List; //Incluir para que acepte List

class DemoLambda {
    public static void main(String args[]) {
        //Ordena a los alumnos a partir de un ArrayList en orden de numero
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        listaAlumnos.add(new Alumno(1, "1717213183", "Javier Ignacio", "Molina Cano", "Java 8", 7, 28));
        listaAlumnos.add(new Alumno(2, "1717456218", "Lillian Eugenia", "Gómez Álvarez", "Java 8", 10, 33));
        listaAlumnos.add(new Alumno(3, "1717328901", "Sixto Naranjoe", "Marín", "Java 8", 8.6, 15));
        listaAlumnos.add(new Alumno(4, "1717567128", "Gerardo Emilio", "Duque Gutiérrez", "Java 8", 10, 13));
        listaAlumnos.add(new Alumno(5, "1717902145", "Jhony Alberto", "Sáenz Hurtado", "Java 8", 9.5, 15));
        listaAlumnos.add(new Alumno(6, "1717678456", "Germán Antonio", "Lotero Upegui", "Java 8", 8, 34));
        listaAlumnos.add(new Alumno(7, "1102156732", "Oscar Darío", "Murillo González", "Java 8", 8, 32));
        listaAlumnos.add(new Alumno(8, "1103421907", "Augusto Osorno", "Palacio Martínez", "PHP", 9.5, 17));
        listaAlumnos.add(new Alumno(9, "1717297015", "César Oswaldo", "Alzate Agudelo", "Java 8", 8, 26));
        listaAlumnos.add(new Alumno(10, "1717912056", "Gloria Amparo", "González Castaño", "PHP", 10, 28));
        listaAlumnos.add(new Alumno(11, "1717912058", "Jorge León", "Ruiz Ruiz", "Python", 8, 22));
        listaAlumnos.add(new Alumno(12, "1717912985", "John Jairo", "Duque García", "Java Script", 9.4, 32));
        listaAlumnos.add(new Alumno(13, "1717913851", "Julio Cesar", "González Castaño", "C Sharp", 10, 22));
        listaAlumnos.add(new Alumno(14, "1717986531", "Gloria Amparo", "Rodas Monsalve", "Ruby", 7, 18));
        listaAlumnos.add(new Alumno(15, "1717975232", "Gabriel Jaime", "Jiménez Gómez", "Java Script", 10, 18));
        //En esta parte se imprime la lista de orden en que se ingreso
        System.out.println("*** Lista de Alumnos Forma 1 ***");
        //Aqui Lambda hace una confirmacion de la lista y si esta validacion es verdadera se imprime
        listaAlumnos.stream().forEach(a -> System.out.println(a));
        System.out.println("*** Lista de Alumnos Forma 2 ***");
        listaAlumnos.stream().filter(a -> true).forEach(a -> System.out.println(a));
        //Si la validacion es correcta entonces Lambda imprimira los nombres que empiezen con los caracteres L u G
        System.out.println("\n*** Alumnos cuyo nombre empiezan con el caracter L u G ***");
        listaAlumnos.stream().filter(c -> c.getApellidos().charAt(0) == 'L' || c.getApellidos().charAt(0) == 'G')
                .forEach(c -> System.out.println(c));
        //En esta parte del codigo se muestra la lista de alumnos que hay a partir del ArrayList        
        System.out.println("\n**** Número de Alumnos *** = " + listaAlumnos.size());
        System.out.println(listaAlumnos.stream().count());
        //En esta parte se hace un filtro donde de la lista se ira validando aquellos alumnos que tengan una nota mayor a 9, ahora si esta pasa tambien
        //Se valida que sean del curso de PHP
        System.out.println("\n**** Alumnos con nota mayor a 9 y que sean del curso PHP ***");
        listaAlumnos.stream().filter(a -> a.getNota() > 9 && a.getNombreCurso().equals("PHP"))
                .forEach(p -> System.out.println(p));
        //Aqui el Lambda hara la validacion de que se imrpima solo a los dos primero de la lista
        System.out.println("\n**** Imprimir los 2 primeros Alumnos de la lista ***");
        listaAlumnos.stream().limit(2).forEach(a -> System.out.println(a));
        //Aqui se tendran dos parametros los cuales cada uno haran una busqueda para ver cual es alumno con menor edad y asi poder validar e imrpimirlo
        System.out.println("\n**** Imprimir el alumno con menor edad ***");
        System.out.println(listaAlumnos.stream().min((a1, a2) -> a1.getEdad() - a2.getEdad()));
         //Aqui se tendran dos parametros los cuales cada uno haran una busqueda para ver cual es alumno con mayor edad y asi poder validar e imrpimirlo
        System.out.println("\n**** Imprimir el alumno con mayor edad ***");
        System.out.println(listaAlumnos.stream().max((a1, a2) -> a1.getEdad() - a2.getEdad()));
        //En esta parte se usa un funcion para buscar quien es el primer alumno en la lista
        System.out.println("\n**** Encontrar el primer Alumno***");
        System.out.println(listaAlumnos.stream().findFirst());
        //Se realiza una busqueda en la lista para buscar los nommbres de los cursos donde el Lambda lo que hace es validar que termine con la letra t
        System.out.println("\n**** Alumnos en los  que los nombres de los cursos (lenguajes) que terminan en t ***");
        listaAlumnos.stream().filter(a -> a.getNombreCurso().endsWith("t")).forEach(System.out::println);
        //Aqui el parametro de Lambda lo que hace es que imprima a los alumno contengan la letra A en su nombre
        System.out.println("\n**** Alumnos que tienen un curso en el que el nombre contienen la A ***");
        listaAlumnos.stream().filter(a -> a.getNombreCurso().contains("a")).forEach(System.out::println);
         //Aqui el parametro de Lambda lo que hace es que imprima a los alumno contengan la letra A en su nombre
        System.out.println("\n**** Alumnos que tienen un curso en el que el nombre contienen la A ***");
        listaAlumnos.stream().filter(a -> a.getNombreCurso().contains("a")).forEach(System.out::println);
        //Se realiza una comparicon con el tamño del nombre del alumno donde si este es mayor a 10 entonces se imrpime y si no, no se imrpimira
        System.out.println("\n**** Alumnos en que su tamaño de su nombre es mayor a 10 caracteres ***");
        listaAlumnos.stream().filter(a -> a.getNombres().length() > 10).forEach(System.out::println);
        //En esta parte del codigo Lambda hace una combinacion en donde 
        System.out.println("\n**** Combinación de predicados ***");
        Predicate<Alumno> empiezaConP = a -> a.getNombreCurso().startsWith("P");
        Predicate<Alumno> longitud = a -> a.getNombreCurso().length() <= 6;
        listaAlumnos.stream().filter(empiezaConP.and(longitud)).forEach(System.out::println);
        System.out.println("\n**** Asignar una consulta a una nueva lista ***");
        List<Alumno> nuevaLista = listaAlumnos.stream().filter(a -> a.getNombreCurso().contains("a"))
                .collect(Collectors.toList());
        nuevaLista.forEach(System.out::println);
    }
}
