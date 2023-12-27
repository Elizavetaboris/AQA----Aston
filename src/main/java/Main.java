public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Иван иванович","Бухгалтер","Ivan@g,ail.com","8-909-308-70-70",30000,31);
        employees[1] = new Employee("Куденова Ильвира Валерьевна","Директор","Kiki@g,ail.com","8-909-308-70-70",20000,21);
        employees[2] = new Employee("Иванов Аркадий иванович","Сандтехник","Ivanov@g,ail.com","8-909-308-70-70",40000,41);
        employees[3] = new Employee("Алексееев Иван Петрович","Менеджер","Ivan@g,ail.com","8-909-308-70-70",50000,51);
        employees[4] = new Employee("Рузина Анна Михайловна","Главный Бухгалтер","@g,ail.com","8-909-308-70-70",60000,41);

        for (Employee employee:employees) {
            employee.display();
        }

    }

    public static class Employee{
        public String name;
        public String job_title;
        public String email;
        public String phone;
        public int salary;
        public int age;
        public Employee(String name, String job_title, String email, String phone,  int salary, int age){
            this.name = name;
            this.job_title = job_title;
            this.email = email;
            this.phone = phone;
            this.salary = salary;
            this.age = age;

        }

        public void display(){
            System.out.println("ФИО: " + name );
            System.out.println("Должность: " + job_title);
            System.out.println("E-mail: " + email);
            System.out.println("Телефон: " + phone);
            System.out.println("Возраст: " + age);
            System.out.println("Зарплата: "+salary);


        }



    }
}
