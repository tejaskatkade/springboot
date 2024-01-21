
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;


public class Main {
    public static void main(String[] args){
        System.out.println("Project Started.....");

        Configuration cfg = new Configuration();
        try {
            cfg.configure();
        } catch (HibernateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SessionFactory factory = cfg.buildSessionFactory();

        System.out.println(factory);
        System.out.println(factory.isClosed());


    }
}
