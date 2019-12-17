public class Attendance {

    Customer firstQueue;

    public void insert(Customer customer) {
        if(firstQueue == null) {
            firstQueue = customer;
        } else {
            Customer current = firstQueue;
            Customer previous = null;

            boolean inserted = false;
        
            while(current != null) {
                if(customer.getAge() > current.getAge()) {
                    customer.setNext(current);
                    inserted = true;
                    if(previous == null) {
                        firstQueue = customer;
                    }else {
                        previous.setNext(customer);
                    }
                    break;
                }
                previous = current;
                current = current.getNext();
            }

            if(!inserted) {
                previous.setNext(customer);
            }
        }

        //print();
    }

    public void remove() {
        if(firstQueue != null) {
            System.out.println(firstQueue.getName() + ", " + firstQueue.getAge());
            firstQueue = firstQueue.getNext();
            return;
        }
        System.out.println("Fila vazia!");
    }

    public void print() {
        //Imprimindo status atual da fila
        Customer current = firstQueue;
        while(current != null) {
            System.out.print(current.getNameAge() + " - ");
            current = current.getNext();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Attendance algorithm = new Attendance();

        //Chegada de clientes
        algorithm.insert(new Customer("João", 22)); 
        algorithm.insert(new Customer("Maria", 30)); 
        algorithm.insert(new Customer("José", 25));
        algorithm.insert(new Customer("Alice", 22));
        algorithm.insert(new Customer("Pedro", 30)); 
        algorithm.insert(new Customer("Carlos", 25));
        algorithm.insert(new Customer("Natália", 28));
        algorithm.insert(new Customer("Marcos", 60)); 
        algorithm.insert(new Customer("Miguel", 25));
        algorithm.insert(new Customer("Joana", 10));

        //Chamada de clientes
        algorithm.remove();
        algorithm.remove();
        algorithm.remove();
        algorithm.remove();
        algorithm.remove();
        algorithm.remove();
        algorithm.remove();
        algorithm.remove();
        algorithm.remove();
        algorithm.remove();
    }
}

class Customer {

    private String name;
    private int age;
    private Customer next;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNameAge() {
        return name + "(" + age + ")";
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setNext(Customer next) {
        this.next = next;
    }

    public Customer getNext() {
        return next;
    }
}