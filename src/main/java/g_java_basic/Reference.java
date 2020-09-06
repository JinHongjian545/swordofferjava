package g_java_basic;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Reference {
    public static void main(String[] args) {
        //强引用
        String str = "abc";
        List<String> list = new ArrayList<String>();
        list.add(str);

        //软引用
        String s1 = new String("test");
        SoftReference<String> softReference = new SoftReference<>(s1);
        s1 = null;
        if (softReference.get() != null) {
            System.out.println("s=" + softReference.get());
        }


        //弱引用
        String s2 = new String("test");
        WeakReference<String> weakReference = new WeakReference<>(s2);
        s2 = null;
        System.out.println("isEnQueued " + weakReference.isEnqueued());
        if (weakReference.get() != null) {
            System.out.println("s=" + weakReference.get());
        }

        //虚引用
        String s3 = new String("test");
        PhantomReference<String> phantomReference = new PhantomReference<>(s3, null);
        s3 = null;
        System.out.println("isEnQueued " + phantomReference.isEnqueued());
        //必定为false
        System.out.println(phantomReference.get());

    }
}
