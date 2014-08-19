class Test
{

	int Pole1, Pole2;

	Test(){}

	void testuj(int nowe_pole1, int nowe_pole2)
	{
		Pole1 = nowe_pole1;
		Pole2 = nowe_pole2;
		return;
	}
}

int main()
{
	Test t = new Test();
	t.testuj(10,23);
	return 0;
}
