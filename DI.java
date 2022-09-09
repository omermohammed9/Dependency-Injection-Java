interface Injection {
    void run(String user, String pass);
}
class ServiceProvider implements Injection {
    @Override
    public void run(String user, String pass) {
        System.out.println(user + " " + " " +  pass);
    }
}
class Client {
    private Injection  service; // creating variable of type interface
    //creating constructor (Client) has injected argument of type interface (Inejction)
    public Client(Injection  service){
        this.service=service;
    }
    public void setService(Injection i){
        if (i == null){
            throw new RuntimeException("Please be more smart about it");
        }
        this.service = i;
    }
    //creating method that gives some stuff to the service class
    public void test(){
        service.run("user1", "pass1234");
    }
}
public class DI {
    public static void main(String[] args) {
        //create object from the interface that has instance of serviceprovider
        Injection a = new ServiceProvider();
        //creating object of type client that has injected object
        Client obj = new Client(a);
        obj.test();
       Injection b = new Injection() {
           @Override
           public void run(String user, String pass) {
            System.out.println("Hi user " + " "+ user +" " + pass);
           }
       };
       obj.setService(b);
       obj.test();
        /* if (){
            Injection newService = new NewA();
            obj.setService(newService);
        }*/
    }
}
