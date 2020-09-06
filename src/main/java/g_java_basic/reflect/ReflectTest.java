package g_java_basic.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program: swordofferjava
 * @description: 反射
 * @author: Jin Hongjian
 * @create: 2020-07-15
 **/
public class ReflectTest {

    public static void main(String[] args) {

        //获取类
        Class<?> clazz = BinaryTreeNode.class;
        try {
            //创建对象
            BinaryTreeNode binaryTreeNode = (BinaryTreeNode) clazz.newInstance();
            binaryTreeNode.setValue(12);
            binaryTreeNode.setName("Node Name");
            System.out.println(binaryTreeNode);

            Constructor<?> constructor = clazz.getConstructor(int.class, String.class);
            BinaryTreeNode binaryTreeNode1 = (BinaryTreeNode) constructor.newInstance(32, "constructor");
            System.out.println(binaryTreeNode1);

            //通过类对象获取方法对象
            Method method = clazz.getMethod("getName");
            System.out.println((String) method.invoke(binaryTreeNode));
            //通过类对象获取对象属性值
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                System.out.println(declaredField.get(binaryTreeNode)); //注意，通过反射是可以拿到 private 属性的值的
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
