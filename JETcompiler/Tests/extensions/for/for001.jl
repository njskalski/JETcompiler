int main() {

 // standard Java form, declare variable in initializer
 for (int i = 0; i < 10; i++) {
   printInt(i);
 }

 // check scope of i
 int i = 45;
 printInt(i);

}