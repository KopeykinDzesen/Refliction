import java.lang.reflect.*;
import com.dzesen.SomeClassTest;

public class Main {

    public static void main(String[] args) throws Exception{

        SomeClass someClass = new SomeClass();
        Class clss = someClass.getClass();
        SomeClassTest someClassTest = new SomeClassTest();
        Class clss1 = someClassTest.getClass();
        Class clss2 = Class.forName("com.dzesen.SomeClassTest");
        System.out.println(clss1.getName());

        System.out.println(clss.getName());

        System.out.println();
        System.out.println("Declared Constructors:");
        Constructor[] constructors = clss.getDeclaredConstructors();
        showConstructors(constructors);

        System.out.println();
        System.out.println("Undeclared Constructors:");
        Constructor[] constructors1 = clss.getConstructors();
        showConstructors(constructors1);

        System.out.println();
        System.out.println("Declared Fields:");
        Field[] fields = clss.getDeclaredFields();
        showFields(fields);

        System.out.println();
        System.out.println("Undeclared Fields:");
        Field[] fields1 = clss.getFields();
        showFields(fields1);

        System.out.println();
        System.out.println("Declared Methods:");
        Method[] methods = clss.getDeclaredMethods();
        showMethods(methods);

        System.out.println();
        System.out.println("Undeclared Methods:");
        Method[] methods1 = clss.getMethods();
        showMethods(methods1);

    }

    private static void showConstructors(Constructor[] constructors){
        for (Constructor constructor : constructors){
            System.out.print(Modifier.toString(constructor.getModifiers()) + " ");
            System.out.print(constructor.getName() + " (");
            Class[] parameters = constructor.getParameterTypes();
            showParameters(parameters);
            System.out.println();
        }
    }

    private static void showFields(Field[] fields){
        for (Field field : fields){
            System.out.print(Modifier.toString(field.getModifiers()) + " ");
            System.out.print(field.getType().getSimpleName() + " ");
            System.out.print(field.getName() + " ");
            System.out.println();
        }
    }

    private static void showMethods(Method[] methods){
        for (Method method : methods){
            System.out.print(Modifier.toString(method.getModifiers()) + " ");
            System.out.print(method.getReturnType().getName() + " ");
            System.out.print(method.getName() + " (");
            Class[] parameters = method.getParameterTypes();
            showParameters(parameters);
            System.out.println();
        }
    }

    private static void showParameters(Class[] parameters){
        if(parameters.length == 0){
            System.out.print(")");
        }else{
            for (int i = 0; i < parameters.length; i++) {
                System.out.print(parameters[i].getSimpleName());
                if (i == parameters.length - 1) {
                    System.out.print(")");
                } else {
                    System.out.print(", ");
                }
            }
        }
    }

}

class SomeClass{
    private int i;
    public transient String s;
    transient Object o;

    public SomeClass() {
    }

    public SomeClass(int i, String s, Object o) {
        this.i = i;
        this.s = s;
        this.o = o;
    }

    private void someMethod(){
        System.out.println("sar;ouhv");
    }

    public int someMethod1(String s, double d){
        return 100;
    }
}
