import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("*********************************************************************");
        System.out.println("Ejercicio 1");
        List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50);
        System.out.println("Lista de números: [10, 20, 30, 40, 50], busca el número mayor");

        numeros.stream()
                .max(Integer::compare)
                .ifPresent(System.out::println);

        System.out.println("*********************************************************************");
        System.out.println("Ejercicio 2");
        List<String> palavras = Arrays.asList("java", "stream", "lambda", "code", "aba");
        System.out.println("Lista de palabras String: [java, stream,lambda,code], agrupados por tamaño");

        Map<Integer, List<String>> listaNueva = palavras.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(listaNueva);

        System.out.println("*********************************************************************");
        System.out.println("Ejercicio 3");

        List<String> nomes = Arrays.asList("Alice", "Bob", "Charlie");
        System.out.println("Lista de nombres: [Alice,Bob,Charlie], concatenar con ,");
        nomes.stream()
                .collect(Collectors.joining(","));

        System.out.println(nomes);

        System.out.println("*********************************************************************");
        System.out.println("Ejercicio 4");

        List<Integer> numerosTodos = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("Lista de números: [1, 2, 3, 4, 5, 6], tomar los pares, obtener los cuadrados y sumarlos");
        List<Integer> listaCuadrado = Collections.singletonList(numerosTodos.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n * n)
                .sum());

        System.out.println(listaCuadrado);
        System.out.println("*********************************************************************");
        System.out.println("Ejercicio 5");

        List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("Lista de números pares: ");
        listaNumeros.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);


        List<Producto> productos = Arrays.asList(
                new Producto("Smartphone", 800.0, "Eletrônicos"),
                new Producto("Notebook", 1500.0, "Eletrônicos"),
                new Producto("Teclado", 200.0, "Eletrônicos"),
                new Producto("Cadeira", 300.0, "Móveis"),
                new Producto("Monitor", 900.0, "Eletrônicos"),
                new Producto("Mesa", 700.0, "Móveis")
        );

        System.out.println("*********************************************************************");
        System.out.println("Ejercicio 6");
        System.out.println("De acuedo a la clase de producto agrupar por CATEGORÍA");
        Map<String, List<Producto>> listaProducto = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria));
        System.out.println(listaProducto);

        System.out.println("*********************************************************************");
        System.out.println("Ejercicio 7");
        System.out.println("Dada la lista de producto indicar la cantidad de producto que existen por CATEGORIA");
        Map<String, Long> listaConteoCategoria = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria, Collectors.counting()));
        System.out.println(listaConteoCategoria);

        System.out.println("*********************************************************************");
        System.out.println("Ejercicio 8");
        System.out.println("Dada la lista de productos, calcular el producto más caro por categoría");
        Map<String, Optional<Producto>> listaProductoPrecioAlto = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria, Collectors.maxBy(Comparator.comparingDouble(Producto::getPreco))));
        System.out.println(listaProductoPrecioAlto);

        System.out.println("*********************************************************************");
        System.out.println("Ejercicio 9");
        System.out.println("Dada la lista de producto realizar la suma total de los productos por CATEGORIA");
        Map<String, Double> ListaSumaCategoria = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria, Collectors.summingDouble(Producto::getPreco)));

        System.out.println(ListaSumaCategoria);

    }
}