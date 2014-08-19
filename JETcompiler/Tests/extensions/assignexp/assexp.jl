int main() {
  int x, y;

  x = (y = 3);
  printInt(x);
  printInt(y);

  x = (x = x + 1) + x;
  printInt(x);

  boolean b = true;
  while ((b = false) == true) {
    printString("nope");
  }

  if (b = !b) {
    printString("yay!");
  }
}