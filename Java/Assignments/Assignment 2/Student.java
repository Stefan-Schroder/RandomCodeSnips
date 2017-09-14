class Student{
        private String firstName;
        private String middleName;
        private String lastName;
        
        void Student(){
        
        }
        
        public void setNames(String first,String middle,String last){
                firstName = first;
                middleName = middle;
                lastName = last;
        }
        
        public String getFullName(){
                return firstName+" "+middleName.charAt(0)+". "+lastName;
        }
}