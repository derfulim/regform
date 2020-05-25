package model.entity;

    public class User {
        private int id;
        private String login;
        private Role role;
        private String nameUa;
        private String nameEng;
        private String surnameUa;
        private String surnameEng;
        private String email;
        private String password;
        private String hash;

        public User() {}

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public Role getRole() {
            return role;
        }

        public void setRole(Role role) {
            this.role = role;
        }

        public String getNameUa() {
            return nameUa;
        }

        public void setNameUa(String nameUa) {
            this.nameUa = nameUa;
        }

        public String getNameEng() {
            return nameEng;
        }

        public void setNameEng(String nameEng) {
            this.nameEng = nameEng;
        }

        public String getSurnameUa() {
            return surnameUa;
        }

        public void setSurnameUa(String surnameUa) {
            this.surnameUa = surnameUa;
        }

        public String getSurnameEng() {
            return surnameEng;
        }

        public void setSurnameEng(String surnameEng) {
            this.surnameEng = surnameEng;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", login='" + login + '\'' +
                    ", role='" + role + '\'' +
                    ", nameUa='" + nameUa + '\'' +
                    ", nameEng='" + nameEng + '\'' +
                    ", surnameUa='" + surnameUa + '\'' +
                    ", surnameEng='" + surnameEng + '\'' +
                    '}';
        }
    }


