int main() {

  // arbitrary assignments in update
  for (int i = 2; i <= 1000 ; i = times(2,i)) {
    printInt(i);
  }

}

int times(int x, int y) {
  return x * y;
}