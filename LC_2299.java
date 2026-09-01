class Solution {
    public boolean strongPasswordCheckerII(String password) {
        if(password.length()<8) return false;
        boolean pass1=false;
        boolean pass2=false;
        boolean pass3=false;
        boolean pass4=false;

        String specialChars="!@#$%^&*()_-+=`~";

        for(int i=0;i<password.length();i++){
            char ch=password.charAt(i);

            if(Character.isUpperCase(ch)){
                pass1=true;
            }
            if(Character.isLowerCase(ch)){
                pass2=true;
            }
            if(Character.isDigit(ch)){
                pass3=true;
            }
            if(specialChars.indexOf(ch)!=-1){
                pass4=true;
            }

            if (i > 0 && password.charAt(i) == password.charAt(i - 1)) {
                return false;
            }

        }
        return pass1 && pass2 && pass3 && pass4;
    }
}
