import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

/**
 * Created by professor on 14/06/2016.
 */
public class ProgramaPrincipal {

    public static final String TRIANGULO = "Triangulos";
    public static final String CIRCUNFERENCIA = "Circunferencias";
    private  static Map<String,List<? extends FiguraGeometrica>>mapFiguraGeometrica = new HashMap<>();
    //public static final List<Circumferencia> CIRCUMFERENCIA_LIST = new ArrayList<>();
   // public static final List<Triangulo> TRIANGULO_LIST = new ArrayList<>();
    //public static final List<Rectangulo> RECTANGULO_LIST = new ArrayList<>();

    public static final String RECTANGULO  ="Rectangulos";






    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        List<FiguraGeometrica> arrayList = new ArrayList<>();
        System.out.println("Introduce el numero de  figuras geometricas para cada tipo:  ");
        int numero = sc.nextInt();


        ObtenerCircunferencia(sc, arrayList, numero);
        ObtenerTriangulos(sc, arrayList, numero);

        ObteenrRectangulos(sc, arrayList, numero);

        ProcesarFiguraGeometricas(arrayList, numero);

       mostrarFiguras();
        mapFiguraGeometrica.get(RECTANGULO);
        consultarMapFigurasGeometricas(CIRCUNFERENCIA);
    }

    private static void consultarMapFigurasGeometricas(String tipoFiguras) {
        List<FiguraGeometrica> figuraGeometricaList = (List<FiguraGeometrica>) mapFiguraGeometrica.get(tipoFiguras);
        System.out.println("La lista de"+tipoFiguras+"es: ");
        System.out.println(figuraGeometricaList);
        //System.out.println(mapFiguraGeometrica.get(CIRCUMFERENCIA_LIST));
    }

    private static void mostrarFiguras() {
        System.out.println("Map figuras");

        System.out.println(mapFiguraGeometrica);

    }

    private static void ProcesarFiguraGeometricas(List<FiguraGeometrica> arrayList, int numero) {
        FiguraGeometrica max= null;
        double totalArea = 0.0;
        for(FiguraGeometrica figuraGeometrica : arrayList) // recorremos el array
        {
            double areaActual = figuraGeometrica.calculaArea();
            double perimetro = figuraGeometrica.calculaPerimetro();
            System.out.println("El area de la figura geometrica " + figuraGeometrica.getId() + " es = " + areaActual);
            //System.out.println("El perimetro de la figura geometrica " + " es =" + perimetro);
            totalArea = totalArea + areaActual;//suma areas de todas las figuras geometricas

            if(figuraGeometrica instanceof Circumferencia) {
                Circumferencia circumferencia = (Circumferencia ) figuraGeometrica;
                double diametro= circumferencia.calculaDiametro();
                System.out.println("El diametro es : " +diametro );

            }



            if (max == null)
            {
                max = figuraGeometrica;
            }
            else
            {
                if (areaActual > max.calculaArea())
                {
                    max = figuraGeometrica;
                }
            }
        }
        double media = totalArea/(numero*3);
        System.out.println("La figura geometrica de area maxima es: " + max);
        System.out.println("La media de todas las figuras geometricas es : " + media);
    }

    private static void ObteenrRectangulos(Scanner sc, List<FiguraGeometrica> arrayList, int numero) {

        List<Rectangulo>  rectanguloList = new ArrayList<>();
        for(int i=1; i<=numero; i++)
        {
            System.out.println("Introduce los datos del rectangulo "+i);
            System.out.println("Introduce la base:");
            double base = sc.nextDouble();
            System.out.println("Introduce la altura:");
            double altura = sc.nextDouble();


            Rectangulo rectangulo = new Rectangulo(base,altura,i+numero*2);
            arrayList.add(rectangulo);
            rectanguloList.add(rectangulo);

        }
        mapFiguraGeometrica.put(RECTANGULO, rectanguloList);
    }

    private static void ObtenerTriangulos(Scanner sc, List<FiguraGeometrica> arrayList, int numero) {
        List<Triangulo> trianguloList = new ArrayList<>();
        for(int i=1; i<=numero; i++)
        {
            System.out.println("Introduce los datos del triangulo "+i);
            System.out.println("Introduce la base:");
            double base = sc.nextDouble();
            System.out.println("Introduce la altura:");
            double altura = sc.nextDouble();
            System.out.println("Introduce el lado1:");
            double lado1 = sc.nextDouble();
            System.out.println("Introduce el lado2:");
            double lado2 = sc.nextDouble();

            Triangulo triangulo = new Triangulo(base,altura,lado1, lado2, i+numero);
            arrayList.add(triangulo);
            trianguloList.add(triangulo);



        }
        mapFiguraGeometrica.put(TRIANGULO, trianguloList);
    }

    private static void ObtenerCircunferencia(Scanner sc, List<FiguraGeometrica> arrayList, int numero) {
        List<Circumferencia> circumferenciaList = new ArrayList<>();
        for(int i=1; i<=numero; i++)

        {
            System.out.println("Introduce los datos de la circumferencia "+i);
            System.out.println("Introduce el radio:");
            double radio = sc.nextDouble();

            Circumferencia circumferencia=new Circumferencia(radio,i);
            arrayList.add(circumferencia);
           circumferenciaList.add(circumferencia);


        }
        mapFiguraGeometrica.put(CIRCUNFERENCIA, circumferenciaList);


    }


}
