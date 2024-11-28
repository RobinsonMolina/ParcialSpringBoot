    package co.edu.uptc.entityes;

    import jakarta.persistence.*;

    import java.time.LocalDate;
    import java.util.List;

    @Entity
    public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO )
        private Integer id;

        @Column(nullable = false, length = 30)
        private String name;
        @Column(nullable = false)
        private LocalDate birthday;
        @Column(nullable = false)
        private String email;
        @Column(nullable = false)
        private String phone;
        @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
        private List<Sale> sales;

        public List<Sale> getSales() {
            return sales;
        }

        public void setSales(List<Sale> sales) {
            this.sales = sales;
        }

        public Customer (){

        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalDate getBirthday() {
            return birthday;
        }

        public void setBirthday(LocalDate birthday) {
            this.birthday = birthday;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
