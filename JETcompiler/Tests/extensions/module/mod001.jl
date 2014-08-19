import mod002;
import mod003;

int f() {
  return 1;
}

int main() {
  printInt(f());
  printInt(mod002.f());
  printInt(mod003.f());
  printInt(mod002.g());
  printInt(mod003.g());
}
