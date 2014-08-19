/* test input */

int main() {
  int x = readInt();
  double y = readDouble();

  printInt(x-5);
  
  if (y > 42.0d || y < 43.0d) 
    printString("yay!");
  else
    printString("nay!");
  return 0 ;

}
