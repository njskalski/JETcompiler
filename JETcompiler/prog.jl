class xx
{
	int pole;
	xx(){}

	int suma(int a)
	{
		return a+ pole;
	}
}

int main()
{	

	xx[] xy = new xx[4];

	int i;

	for(i = 0 ; i < 4; ++i)
	{
		xy[i] = new xx();
		xy[i].pole = 2*i;
		printInt(xy[i].suma(i));
	}
	
	return 0;
}


