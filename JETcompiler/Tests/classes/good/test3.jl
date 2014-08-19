class Wewnatrz
{
	Wewnatrz(){}
	Wewnatrz(boolean x)
	{
		Bzdura = x;
	}

	boolean Bzdura;
}

class Test
{

	int Pole1, Pole2;
	Wewnatrz Pole3;

	Test(){}

	void testuj(int nowe_pole1, int nowe_pole2)
	{
		Pole1 = nowe_pole1;
		Pole2 = nowe_pole2;
		return;
	}

	boolean getBzdura()
	{
		Pole3 = new Wewnatrz(true);
		return Pole3.Bzdura;
	}
}

int main()
{
	boolean d;
	Test t = new Test();
	Test g;
	t.testuj(10,23);
	d = t.getBzdura();
	return 0;
}
